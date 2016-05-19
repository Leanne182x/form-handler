package net.jaggerl.person.controller;

import net.jaggerl.person.TestPeople;
import net.jaggerl.person.model.PeopleDao;
import net.jaggerl.person.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.verify;

public class PeopleServiceTest {

    private PeopleService peopleService;
    private PeopleDao peopleDao;

    @Before
    public void setup() {
        peopleDao = Mockito.mock(PeopleDao.class);
        peopleService = new PeopleService(peopleDao);
    }

    @Test
    public void testThatSavePeopleCallsDaoStorePeople() {
        // Arrange
        final Person person = TestPeople.aDefaultPerson().build();
        final List<Person> people = Collections.singletonList(person);

        // Act
        peopleService.savePeople(people);

        // Assert
        verify(peopleDao).storePeople(people);
    }
}
