package org.example;

import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

public class Inputter {
    private String lastName;
    private String firstName;
    private String secondName;
    private String dateOfBirth;
    private String telNumber;
    private char gender;

    Scanner in = new Scanner(System.in);

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public char getGender() {
        return gender;
    }

    public void input() throws NameInputException, DoBInputException, TelNumInputException, GenderInputException {
        System.out.println("Введите ФИО (через пробел): ");
        String fio = in.nextLine().toUpperCase();
        try{
            String[] name = fio.split(" ");
            setLastName(name[0]);
            setFirstName(name[1]);
            setSecondName(name[2]);
        } catch (Exception e) {
            throw new NameInputException(String.format("Неверный формат ФИО - %s", fio));
        }
        System.out.println("Введите дату рождения (в формате дд.мм.гггг): ");
        String dOb = in.nextLine();
        try {
            String[] date = dOb.split("\\.");
            if (Integer.parseInt(date[0]) > 31) {
                throw new Exception();
            }
            if (Integer.parseInt(date[1]) > 12) {
                throw new Exception();
            }
            if (Integer.parseInt(date[2]) > 2023) {
                throw new Exception();
            }
            setDateOfBirth(dOb);
        }catch (Exception e) {
            throw new DoBInputException(String.format("Неверный формат даты рождения - %s", dOb), dOb);
        }
        System.out.println("Введите номер телефона (в одну строчку без пробела и доп. знаков): ");
        String telNum = in.nextLine();
        try{
            Long.parseLong(telNum);
            setTelNumber(telNum);
        }catch (NumberFormatException e){
            throw new TelNumInputException(String.format("Неверный формат номера - %s", telNum), telNum);
        }
        System.out.println("Введите пол (m/f): ");
        String gend = in.nextLine().toLowerCase();
        if (gend.charAt(0) == 'm' || gend.charAt(0) == 'f') {
            setGender(gend.charAt(0));
        }else {
            throw new GenderInputException("Неверный формат пола", gend.charAt(0));
        }
    }
    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    private void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    private void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    private void setGender(char gender) {
        this.gender = gender;
    }



}
