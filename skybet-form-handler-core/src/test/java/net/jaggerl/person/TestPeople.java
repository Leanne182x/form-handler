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

    public static PersonDto getDefaultPersonDto() {
        return new PersonDto(DEFAULT_PERSON_FIRST_NAME,DEFAULT_PERSON_SURNAME);
    }
}
