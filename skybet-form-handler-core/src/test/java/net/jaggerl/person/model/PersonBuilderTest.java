package net.jaggerl.person.model;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PersonBuilderTest {

    @Test
    public void testPersonIsCreatedWithCorrectValues() {
        // Arrange
        final String firstName = "Leanne";
        final String surname = "Jagger";

        // Act
        Person person = new PersonBuilder().withFirstname(firstName).withSurname(surname).build();

        // Assert
        assertThat(person.getFirstname(), is(firstName));
        assertThat(person.getSurname(), is(surname));
    }
}
