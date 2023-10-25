package org.example;

public class Person {
    private String lastName;
    private String firstName;
    private String secondName;
    private String dateOfBirth;
    private String telNumber;
    private char gender;

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

    /**
     *
     * @param lastName
     * @param firstName
     * @param secondName
     * @param dateOfBirth
     * @param telNumber
     * @param gender
     * @return
     * @throws NameInputException  Неверный формат ФИО
     * @throws TelNumInputException  Номер не указан
     * @throws DoBInputException  Дата рождения не указана
     * @throws GenderInputException    Неверный формат пола
     */
    public static Person create(String lastName, String firstName, String secondName, String dateOfBirth, String telNumber, char gender) throws NameInputException, TelNumInputException, DoBInputException, GenderInputException {
        if(lastName == null || firstName == null || secondName == null){
            throw new NameInputException("Неверный формат ФИО");
        }
        if(telNumber == null){
            throw new TelNumInputException("Номер не указан", telNumber);
        }
        if (dateOfBirth == null){
            throw new DoBInputException("Дата рождения не указана", dateOfBirth);
        }
        if (gender != 'f' && gender != 'm'){
            throw new GenderInputException("Неверный формат пола", gender);
        }
        return new Person(lastName, firstName, secondName, dateOfBirth, telNumber, gender);
    }

    private Person(String lastName, String firstName, String secondName, String dateOfBirth, String telNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.telNumber = telNumber;
        this.gender = gender;
    }

}
