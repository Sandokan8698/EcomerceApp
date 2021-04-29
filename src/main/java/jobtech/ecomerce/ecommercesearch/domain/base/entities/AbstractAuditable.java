package jobtech.ecomerce.ecommercesearch.domain.base.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class AbstractAuditable<T, K> {

    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
}
