package org.hamsterlabs.cucumber_demo.entities;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BddContext {

    ResponseEntity<?> response;

    public HttpStatusCode getStatusCode() {
        return response.getStatusCode();
    }

    public <T> T getResponseBody(Class<T> clazz) {
        return (T) response.getBody();
    }

    public void setResponse(ResponseEntity<?> response) {
        this.response = response;
    }
}
