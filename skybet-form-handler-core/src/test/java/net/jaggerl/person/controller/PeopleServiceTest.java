package net.jaggerl.person.controller;

import net.jaggerl.person.TestPeople;
import net.jaggerl.person.model.PeopleDao;
import net.jaggerl.person.model.PersonDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        final PersonDto person = TestPeople.getDefaultPersonDto();
        final List<PersonDto> people = Collections.singletonList(person);

        // Act
        peopleService.savePeople(people);

        // Assert
        verify(peopleDao).storePeople(people);
    }

    @Test
    public void testThatGetPeopleReturnsPeopleFromTheDao() {
        // Arrange
        final PersonDto person = TestPeople.getDefaultPersonDto();
        when(peopleDao.getPeople()).thenReturn(Collections.singletonList(person));

        // Act
        final List<PersonDto> people = peopleService.getPeople();

        // Assert
        verify(peopleDao).getPeople();
        assertThat(people.size(), is(1));
    }

    @Test
    public void testThatUpdatePersonCallsDaoUpdatePerson() {
        // Arrange
        final PersonDto person = TestPeople.getDefaultPersonDto();

        // Act
        peopleService.updatePerson(person);

        // Assert
        verify(peopleDao).updatePerson(person);
    }
}
