package com.linktic.microservice_reservations.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CustomErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == HttpStatus.NOT_FOUND.value()) {
            String errorMessage = "Resource not found at " + response.request().url();
            return new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        }
        return new Exception("Generic error");
    }
}
