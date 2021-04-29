package jobtech.ecomerce.ecommercesearch.domain.base.entities;

import lombok.*;
import javax.validation.constraints.NotBlank;


@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Image {


    @NotBlank
    @NonNull
    @Setter(value = AccessLevel.NONE)
    private String relativePath;

    private String big;

    private String medium;

    private String small;
}
