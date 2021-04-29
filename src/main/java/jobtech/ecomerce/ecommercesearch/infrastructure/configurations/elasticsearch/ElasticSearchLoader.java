package jobtech.ecomerce.ecommercesearch.infrastructure.configurations.elasticsearch;



import jobtech.ecomerce.ecommercesearch.domain.products.entities.Product;
import jobtech.ecomerce.ecommercesearch.domain.products.repositorys.ProductRepository;
import org.elasticsearch.client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class ElasticSearchLoader {

    private final Logger logger	= LoggerFactory.getLogger(this.getClass().getName());


    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    Client elasticsearchClient;

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){

        logger.info("Executing indexs creation");

        // Iia
        elasticsearchTemplate.createIndex(Product.class);
        elasticsearchTemplate.putMapping(Product.class);
        elasticsearchTemplate.refresh(Product.class);

        productRepository.save(new Product());

        logger.info("Indexs successful created");

    }

}
