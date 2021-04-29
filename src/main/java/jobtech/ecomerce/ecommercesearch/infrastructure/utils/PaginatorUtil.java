package jobtech.ecomerce.ecommercesearch.infrastructure.utils;


import joptsimple.internal.Strings;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class PaginatorUtil {

    public Pageable createPaginator(Integer page, Integer limit, String sortField, boolean asc) {
        PageRequest value = null;
        if (page == null || limit == null) {
            page = 0;
            limit = 1000;
        }

        if (!Strings.isNullOrEmpty(sortField))
            value = PageRequest.of(page, limit, asc ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
        else
            value = PageRequest.of(page, limit);

        return value;
    }
}
