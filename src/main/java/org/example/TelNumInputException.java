package org.example;

public class TelNumInputException extends InputDataException{
    private String telNum;

    public TelNumInputException(String message, String telNum) {
        super(message);
        this.telNum = telNum;
    }

    public String getTelNum() {
        return telNum;
    }
}
