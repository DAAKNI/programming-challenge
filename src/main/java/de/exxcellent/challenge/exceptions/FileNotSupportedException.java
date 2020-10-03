package de.exxcellent.challenge.exceptions;

public class FileNotSupportedException extends Exception {
    public FileNotSupportedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
