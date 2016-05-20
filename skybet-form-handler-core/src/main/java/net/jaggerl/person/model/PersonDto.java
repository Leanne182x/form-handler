package net.jaggerl.person.model;

public class PersonDto {
    private String firstname;
    private String surname;

    public PersonDto() {
        // Default constructor required for data binding from JSON request body
    }

    public PersonDto(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
