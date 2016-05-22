package net.jaggerl.person.model;

import net.jaggerl.person.repository.PersonIdGenerator;

public class PersonBuilder {

    private final PersonIdGenerator personIdGenerator;
    private String firstname;
    private String surname;

    public PersonBuilder() {
        personIdGenerator = PersonIdGenerator.getInstance();
    }

    public PersonBuilder(final PersonIdGenerator personIdGenerator) {
        this.personIdGenerator = personIdGenerator;
    }

    public PersonBuilder withFirstname(final String firstname) {
        this.firstname = firstname;
        return this;
    }

    public PersonBuilder withSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public Person build() {
        // Typically this ID generation would be handled by the datastore implementation, etc auto incrementing IDs in JPA
        return new Person(personIdGenerator.getNextSequence(), firstname, surname);
    }
}
