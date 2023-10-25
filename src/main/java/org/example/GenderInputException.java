package org.example;

public class GenderInputException extends InputDataException{
    private char gender;
    public GenderInputException(String message, char gender) {
        super(message);
        this.gender = gender;
    }
}
