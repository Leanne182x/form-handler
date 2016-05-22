package net.jaggerl.person.model;

public class Person {

    private final int id; // This would usually be an auto incrementing field e.g. when using a database store with JPA
    private final String firstname;
    private final String surname;

    /*package*/ Person(final int id, final String firstname, final String surname) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return id + ", " + firstname + ", " + surname;
    }
}
