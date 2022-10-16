package com.dmitrenko.simplegrpcclientserver.exception;

public class IntegrationException extends RuntimeException {

    public IntegrationException() {
        super();
    }

    public IntegrationException(String message) {
        super(message);
    }
}
