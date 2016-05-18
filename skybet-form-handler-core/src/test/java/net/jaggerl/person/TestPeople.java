package net.jaggerl.person;

/**
 * Object mother for creating test data with the PersonBuilder
 */
public class TestPeople {

    public static String DEFAULT_PERSON_FIRST_NAME = "Jeff";
    public static String DEFAULT_PERSON_SURNAME = "Stelling";

    public static PersonBuilder aDefaultPerson() {
        return new PersonBuilder().withFirstname(DEFAULT_PERSON_FIRST_NAME).withSurname(DEFAULT_PERSON_SURNAME);
    }
}
