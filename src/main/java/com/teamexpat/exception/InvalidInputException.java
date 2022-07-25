package com.teamexpat.exception;

public class InvalidInputException extends com.teamexpat.exception.ApplicationException {
    public InvalidInputException() {
        super("Invalid!");
    }

    public InvalidInputException(String message) {
        super(message);
    }

    public InvalidInputException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputException(Throwable cause) {
        super(cause);
    }
}
