package net.jaggerl.person.model;

import net.jaggerl.person.TestPeople;
import net.jaggerl.person.repository.PersonListRepository;
import net.jaggerl.person.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.mockito.Mockito.verify;

public class PeopleDaoTest {

    private PeopleDao peopleDao;
    private PersonRepository personRepositoryMock;

    @Before
    public void setUp() {
        personRepositoryMock = Mockito.mock(PersonListRepository.class);
        peopleDao = new PeopleDao(personRepositoryMock);
    }

    @Test
    public void testThatStorePeopleInteractsWithTheRepo() {
        // Arrange
        final Person person = TestPeople.aDefaultPerson().build();

        // Act
        peopleDao.storePeople(Collections.singletonList(person));

        // Assert
        verify(personRepositoryMock).store(person);
    }
}