package org.example.exceptions;

public class DoesNotExistException extends Exception{
    public DoesNotExistException(String message) {
        super(message);
    }
}
