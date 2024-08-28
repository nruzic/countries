package com.cavendish.countries;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CountriesNoRouteException extends RuntimeException {

    public CountriesNoRouteException(String message) {
        super(message);
    }
}
