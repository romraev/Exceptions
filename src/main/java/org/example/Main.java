package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        boolean cont = true;
        while (cont){
            ContactManager cm = new ContactManager();
            cm.start();
            try {
                cont = cm.checkContinue();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        
    }
}