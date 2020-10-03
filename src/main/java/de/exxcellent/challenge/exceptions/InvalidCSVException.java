package de.exxcellent.challenge.exceptions;

public class InvalidCSVException extends Exception {

    public InvalidCSVException(String errorMessage) {
        super(errorMessage);
    }

//    @Override
//    public String toString() {
//        return "Provided CSV ist not valid";
//    }
}
