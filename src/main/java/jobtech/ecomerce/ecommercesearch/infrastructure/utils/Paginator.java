package jobtech.ecomerce.ecommercesearch.infrastructure.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class Paginator {

    private int from;
    private int limit;
    private String sortField;
    private boolean desc;

    public Paginator(int from, int limit, String sortField, boolean desc) {
        this.from = from;
        this.limit = limit;
        this.sortField = sortField;
        this.desc = desc;
    }
}
