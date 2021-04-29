package jobtech.ecomerce.ecommercesearch.domain.products.mapper;


import jobtech.ecomerce.ecommercesearch.domain.products.entities.Product;
import jobtech.ecomerce.ecommercesearch.domain.products.viewmodels.ProductVM;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    @Mappings({
            @Mapping(target = "createdBy", ignore = true),
            @Mapping(target = "lastModifiedBy", ignore = true),
            @Mapping(target = "createdDate", ignore = true),
            @Mapping(target = "lastModifiedDate", ignore = true),
            @Mapping(target = "id", ignore = true),
    })
    Product productVmToProduct(Product externalProduct);
    ProductVM productToProductVm(Product product);

    @InheritInverseConfiguration
    Product productVmToProduct(ProductVM productVm);

    List<ProductVM> productsToProductVms(List<Product> products);

}


