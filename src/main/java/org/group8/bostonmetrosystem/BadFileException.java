package org.group8.bostonmetrosystem;

public class BadFileException extends Exception {

    /**
     * Constructs a new instance of {@code BadFileException} with the error message.
     *
     * @param message Error message of exception
     */
    BadFileException(String message) {
        super(message);
    }
}
