package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ContactManager {
    private Inputter inputter;

    public ContactManager() {
        this.inputter = new Inputter();
    }

    public void start(){
        try{
            inputter.input();
            Person person = Person.create(inputter.getLastName(), inputter.getFirstName(), inputter.getSecondName(), inputter.getDateOfBirth(), inputter.getTelNumber(), inputter.getGender());
            File file = new File(String.format("%s.txt", inputter.getLastName()));
            boolean exists = file.exists();
            try(FileWriter fw = new FileWriter(String.format("%s.txt", inputter.getLastName()), exists)){
                fw.write(String.format("<%s> <%s> <%s> <%s> <%s> <%c>\n", person.getLastName(), person.getFirstName(), person.getSecondName(), person.getDateOfBirth(), person.getTelNumber(), person.getGender()));
            }
        }catch (NameInputException e){
            System.out.println(e.getMessage());
        }catch (DoBInputException e){
            System.out.println(e.getMessage());
        }catch (TelNumInputException e){
            System.out.println(e.getMessage());
        }catch (GenderInputException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
    }
    public boolean checkContinue() throws IOException {
        System.out.println("Желаете продолжить? true/false:");
        Scanner in = new Scanner(System.in);
        try{
            return in.nextBoolean();
        } catch(RuntimeException e){
            throw new IOException("Сканер закрыт");
        }

    }
}
