package net.jaggerl.person.model;

import net.jaggerl.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeopleDao {

    private PersonRepository personRepository;

    @Autowired
    public PeopleDao(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void storePeople(final List<PersonDto> people) {
        people.stream().forEach(personDto -> personRepository.store(convertPersonDto(personDto)));
    }

    private Person convertPersonDto(final PersonDto personDto) {
        return new PersonBuilder().withFirstname(personDto.getFirstname()).withSurname(personDto.getSurname()).build();
    }
}
