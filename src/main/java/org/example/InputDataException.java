package org.example;

import java.io.IOException;

public abstract class InputDataException extends IOException {

    public InputDataException(String message) {
        super(message);
    }
}
