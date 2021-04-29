package jobtech.ecomerce.ecommercesearch.domain.products.entities;

import jobtech.ecomerce.ecommercesearch.domain.base.entities.BaseEntity;
import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@RequiredArgsConstructor
public class ExtraDetail extends BaseEntity {

    private ExtraDetailGroup group;
    private Set<Product> products = new HashSet<>();

}
