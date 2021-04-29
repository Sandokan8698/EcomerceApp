package jobtech.ecomerce.ecommercesearch.infrastructure.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class General400Exception extends RuntimeException {

    public General400Exception(String exception) {
        super(exception);
    }
}

