package net.jaggerl.person.repository;

import net.jaggerl.person.io.PersonFileStore;
import net.jaggerl.person.model.Person;
import net.jaggerl.person.TestPeople;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;

public class PersonListRepositoryTest {

    private PersonRepository personRepo;
    private PersonFileStore personFileStore;

    @Before
    public void setup() {
        personFileStore = Mockito.mock(PersonFileStore.class);
        personRepo = new PersonListRepository(personFileStore);
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

    @Test
    public void testSavingAPersonCallsPersonFileStore() {
        // Arrange
        final Person defaultPerson = TestPeople.aDefaultPerson().build();

        // Act
        personRepo.store(defaultPerson);

        // Assert
        verify(personFileStore).savePersonToFile(defaultPerson);
    }
}
