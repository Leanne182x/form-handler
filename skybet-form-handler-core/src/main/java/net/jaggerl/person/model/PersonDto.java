package net.jaggerl.person.model;

public class PersonDto {
    private String firstname;
    private String surname;

    public PersonDto() {
        // Default constructor required for data binding from JSON request body
    }

    public PersonDto(final String firstname, final String surname) {
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
