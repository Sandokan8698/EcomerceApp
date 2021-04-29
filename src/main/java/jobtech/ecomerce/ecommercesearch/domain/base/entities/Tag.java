package jobtech.ecomerce.ecommercesearch.domain.base.entities;

import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class Tag extends BaseEntity{

    private String name;
    private String description;
}
