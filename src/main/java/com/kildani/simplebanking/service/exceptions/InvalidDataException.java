package com.kildani.simplebanking.service.exceptions;

public class InvalidDataException extends Exception {

    public InvalidDataException() {
        super("All fields must be valid and not null.");
    }
}
