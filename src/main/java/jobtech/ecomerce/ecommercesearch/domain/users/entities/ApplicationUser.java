package jobtech.ecomerce.ecommercesearch.domain.users.entities;

import jobtech.ecomerce.ecommercesearch.domain.base.entities.BaseEntity;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
public class ApplicationUser extends BaseEntity {

    private String username;
    private String password;
}