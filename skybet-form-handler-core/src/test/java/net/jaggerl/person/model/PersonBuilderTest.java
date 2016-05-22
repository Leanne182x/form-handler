package net.jaggerl.person.model;

import net.jaggerl.person.repository.PersonIdGenerator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PersonBuilderTest {

    private PersonIdGenerator personIdGenerator;
    private PersonBuilder personBuilder;

    @Before
    public void setUp() {
        personIdGenerator = Mockito.mock(PersonIdGenerator.class);
        personBuilder = new PersonBuilder(personIdGenerator);
    }

    @Test
    public void testPersonIsCreatedWithCorrectValues() {
        // Arrange
        final int personId = 1;
        final String firstName = "Leanne";
        final String surname = "Jagger";
        when(personIdGenerator.getNextSequence()).thenReturn(personId);

        // Act
        Person person = personBuilder.withFirstname(firstName).withSurname(surname).build();

        // Assert
        verify(personIdGenerator).getNextSequence();
        assertThat(person.getId(), is(personId));
        assertThat(person.getFirstname(), is(firstName));
        assertThat(person.getSurname(), is(surname));
    }
}
