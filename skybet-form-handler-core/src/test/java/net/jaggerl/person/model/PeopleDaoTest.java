package net.jaggerl.person.model;

import net.jaggerl.person.TestPeople;
import net.jaggerl.person.repository.PersonListRepository;
import net.jaggerl.person.repository.PersonRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PeopleDaoTest {

    private PeopleDao peopleDao;
    private PersonRepository personRepositoryMock;

    @Before
    public void setUp() {
        personRepositoryMock = Mockito.mock(PersonListRepository.class);
        peopleDao = new PeopleDao(personRepositoryMock);
    }

    @Test
    public void testThatStorePeopleStoresACorrectlyConvertedPersonInTheRepo() {
        // Arrange
        final PersonDto personDto = TestPeople.getDefaultPersonDto();
        final ArgumentCaptor<Person> personArgCaptor = ArgumentCaptor.forClass(Person.class);

        // Act
        peopleDao.storePeople(Collections.singletonList(personDto));

        // Assert
        verify(personRepositoryMock).store(personArgCaptor.capture());
        assertThat(personArgCaptor.getValue().getFirstname(), is(personDto.getFirstname()));
        assertThat(personArgCaptor.getValue().getSurname(), is(personDto.getSurname()));
    }

    @Test
    public void testThatGetPeopleReturnsCorrectlyConvertedPersonDtos() {
        // Arrange
        final Person defaultPerson = TestPeople.aDefaultPerson().build();
        final List<Person> peopleReturnedFromRepo = Collections.singletonList(defaultPerson);
        when(personRepositoryMock.getPeople()).thenReturn(peopleReturnedFromRepo);

        // Act
        final List<PersonDto> people = peopleDao.getPeople();

        // Assert
        verify(personRepositoryMock).getPeople();
        final PersonDto firstPersonResult = people.stream().findFirst().get();
        assertThat(firstPersonResult.getFirstname(), is(defaultPerson.getFirstname()));
        assertThat(firstPersonResult.getSurname(), is(defaultPerson.getSurname()));
    }

    @Test
    public void testThatUpdatePersonCallsRepoUpdate() {
        // Act
        peopleDao.updatePerson(TestPeople.getDefaultPersonDto());

        // Assert
        verify(personRepositoryMock).updatePerson(any(Person.class));
    }
}
