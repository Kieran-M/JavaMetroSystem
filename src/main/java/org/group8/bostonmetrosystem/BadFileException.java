package org.group8.bostonmetrosystem;

public class BadFileException extends Exception {

    private String error;

    BadFileException(String errorMessage) {
        error = errorMessage;
        System.out.println("Error: " + error);
    }
}
