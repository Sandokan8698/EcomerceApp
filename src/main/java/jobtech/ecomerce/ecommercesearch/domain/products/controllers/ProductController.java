package jobtech.ecomerce.ecommercesearch.domain.products.controllers;


import jobtech.ecomerce.ecommercesearch.domain.products.entities.Product;
import jobtech.ecomerce.ecommercesearch.domain.products.services.ProductService;
import jobtech.ecomerce.ecommercesearch.domain.products.viewmodels.ProductVM;
import jobtech.ecomerce.ecommercesearch.infrastructure.utils.PaginatedPage;
import jobtech.ecomerce.ecommercesearch.infrastructure.utils.PaginatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private ProductService productService;
    private PaginatorUtil paginatorUtil;

    @Autowired
    public ProductController(ProductService productService, PaginatorUtil paginatorUtil) {
        this.productService = productService;
        this.paginatorUtil = paginatorUtil;
    }

    @GetMapping
    public PaginatedPage<Product> all(@RequestParam(value = "page", required = false) Integer page,
                                        @RequestParam(value = "limit", required = false) Integer limit,
                                        @RequestParam(value = "sort_field", required = false) String sortField,
                                        @RequestParam(value = "asc", required = false, defaultValue = "false") boolean asc  ) {

        logger.info("Executing action all products with page {} limit {} sort_field {} asc {}", page,limit,sortField,asc);
        return productService.all(paginatorUtil.createPaginator(page,limit,sortField,asc));
    }

    @PostMapping
    public ResponseEntity bulkInsert(@RequestBody @Valid List<Product> products) throws Exception {
        logger.info("Executing action bulkInsert with products: {}", products);
        productService.bulkInsert(products);
        return ResponseEntity.ok().build();
    }

}


