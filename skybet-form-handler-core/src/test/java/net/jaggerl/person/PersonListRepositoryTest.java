package net.jaggerl.person;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonListRepositoryTest {

    private PersonRepository personRepo;

    @Before
    public void setup() {
        personRepo = new PersonListRepository();
    }

    @Test
    public void testPersonCanBeSaved() {
        // Arrange
        final Person defaultPerson = TestPeople.aDefaultPerson().build();

        // Act
        personRepo.store(defaultPerson);

        // Assert
        assertThat(personRepo.getNumberOfPeople(), is(1));
    }
}
