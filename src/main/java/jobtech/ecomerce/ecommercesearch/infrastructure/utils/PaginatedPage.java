package jobtech.ecomerce.ecommercesearch.infrastructure.utils;

import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedPage<T> {

    private int totalPage;
    private int currentPage;
    private int limit;
    private long totalElements;

    @Setter(value = AccessLevel.NONE)
    private List<T> content;

    public PaginatedPage(Page<T> page) {
        this.totalPage = page.getTotalPages();
        this.currentPage = page.getNumber();
        this.limit = page.getNumberOfElements();
        this.totalElements = page.getTotalElements();
        this.content = page.getContent();
    }
}
