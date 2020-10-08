package de.exxcellent.challenge.exceptions;

public class InvalidFileContentException extends Exception{
    public InvalidFileContentException(String errorMessage) {
        super(errorMessage);
    }
}
