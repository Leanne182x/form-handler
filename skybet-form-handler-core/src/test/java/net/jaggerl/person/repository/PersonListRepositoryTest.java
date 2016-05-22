package net.jaggerl.person.repository;

import net.jaggerl.person.io.PersonStore;
import net.jaggerl.person.model.Person;
import net.jaggerl.person.TestPeople;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;

public class PersonListRepositoryTest {

    private PersonRepository personRepo;
    private PersonStore personStore;

    @Before
    public void setup() {
        personStore = Mockito.mock(PersonStore.class);
        personRepo = new PersonListRepository(personStore);
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
        verify(personStore).savePerson(defaultPerson);
    }

    @Test
    public void testGetPeopleReturnsAllPersonRecords() {
        // Arrange
        personRepo.store(TestPeople.aDefaultPerson().build());
        personRepo.store(TestPeople.aPersonForChris().build());
        personRepo.store(TestPeople.aPersonForAlex().build());

        // Act
        final List<Person> people = personRepo.getPeople();

        // Assert
        assertThat(people.size(), is(3));
    }

    @Test
    public void testThatUpdatePersonDoesNotAddANewRecord() {
        // Arrange
        personRepo.store(TestPeople.aDefaultPerson().build());

        // Act
        personRepo.updatePerson(TestPeople.aDefaultPersonWithANewSurname().build());

        // Assert
        assertThat(personRepo.getNumberOfPeople(), is(1));
    }
}
