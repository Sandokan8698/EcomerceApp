package jobtech.ecomerce.ecommercesearch.domain.products.entities;



import jobtech.ecomerce.ecommercesearch.domain.base.entities.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ExtraDetailGroup extends BaseEntity {

    @NotBlank
    private String name;

    @Setter(value = AccessLevel.NONE)
    private List<ExtraDetail> extraDetails = new ArrayList<>();

}
