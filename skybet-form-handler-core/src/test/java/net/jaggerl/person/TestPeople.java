package net.jaggerl.person;

import net.jaggerl.person.model.PersonBuilder;
import net.jaggerl.person.model.PersonDto;

/**
 * Object mother for creating test data for Person/PersonDto
 */
public class TestPeople {

    public static String DEFAULT_PERSON_FIRST_NAME = "Jeff";
    public static String DEFAULT_PERSON_SURNAME = "Stelling";

    public static PersonBuilder aDefaultPerson() {
        return new PersonBuilder().withFirstname(DEFAULT_PERSON_FIRST_NAME).withSurname(DEFAULT_PERSON_SURNAME);
    }

    public static PersonBuilder aDefaultPersonWithANewSurname() {
        return new PersonBuilder().withFirstname(DEFAULT_PERSON_FIRST_NAME).withSurname("Star");
    }

    public static PersonBuilder aPersonForChris() {
        return new PersonBuilder().withFirstname("Chris").withSurname("Kamara");
    }

    public static PersonBuilder aPersonForAlex() {
        return new PersonBuilder().withFirstname("Alex").withSurname("Hammond");
    }

    public static PersonDto getDefaultPersonDto() {
        return new PersonDto(DEFAULT_PERSON_FIRST_NAME,DEFAULT_PERSON_SURNAME);
    }
}
