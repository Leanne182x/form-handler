package net.jaggerl.person;

public class PersonBuilder {

    private String firstname;
    private String surname;

    public PersonBuilder withFirstname(final String firstname) {
        this.firstname = firstname;
        return this;
    }

    public PersonBuilder withSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public Person build() {
        return new Person(firstname, surname);
    }
}
