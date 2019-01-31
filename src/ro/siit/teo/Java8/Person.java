package ro.siit.teo.Java8;

import ro.siit.teo.Java8.Exceptions.NameValidationException;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Person {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;

    public Person(String firstName, String lastName, Date date) throws NameValidationException {
        validateName(firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public void validateName(String firstName, String lastName) throws NameValidationException {
        if (!firstName.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")) {
            throw new NameValidationException("The following first name " + '"' + firstName + '"' +
                    " read from the csv file is invalid. Please edit it and try again.");
        }
        if (!lastName.matches("[a-zA-z]+([ '-][a-zA-Z]+)*")) {
            throw new NameValidationException("The following last name " + '"' + lastName + '"' +
                    " read from the csv file is invalid. Please edit it and try again.");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }
}
