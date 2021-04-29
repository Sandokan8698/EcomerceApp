package jobtech.ecomerce.ecommercesearch.infrastructure.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class General500Exception extends RuntimeException {

    public General500Exception(String exception) {
        super(exception);
    }
}

