package org.example;

public class DoBInputException extends InputDataException{
    private final String dOb;
    public DoBInputException(String message, String dOb) {
        super(message);
        this.dOb = dOb;
    }

    public String getdOb() {
        return dOb;
    }
}
