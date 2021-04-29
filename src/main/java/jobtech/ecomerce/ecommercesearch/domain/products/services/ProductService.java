package jobtech.ecomerce.ecommercesearch.domain.products.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jobtech.ecomerce.ecommercesearch.domain.products.entities.Product;
import jobtech.ecomerce.ecommercesearch.domain.products.repositorys.ProductRepository;
import jobtech.ecomerce.ecommercesearch.infrastructure.utils.PaginatedPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public PaginatedPage<Product> all(Pageable page) {
        logger.info("Executing action all product with page {}", page);
        Page<Product> result = productRepository.findAll(page);
        return new PaginatedPage<>(result);
    }

    public boolean bulkInsert(List<Product> products) {
        logger.info("Executing action all bulkInsert with product {}", products);
        productRepository.saveAll(products);
        return true;
    }


    @JmsListener(destination = "ecm_massive_data_queue")
    public void createThumbnail(String requestJSON) throws JMSException, IOException {
        logger.info("Received message {}", requestJSON);
        ObjectMapper m = new ObjectMapper();
        m.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Product product = m.readValue(requestJSON, new TypeReference<Product>() {});
        productRepository.save(product);
    }


}
