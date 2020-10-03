package de.exxcellent.challenge.exceptions;

public class InvalidCSVException extends InvalidFileContentException {

    public InvalidCSVException(String errorMessage) {
        super(errorMessage);
    }
}
