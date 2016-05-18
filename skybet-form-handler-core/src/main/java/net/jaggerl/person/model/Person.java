package net.jaggerl.person.model;

public class Person {

    private final String firstname;
    private final String surname;

    /*package*/ Person(final String firstname, final String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }
}
