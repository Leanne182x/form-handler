package net.jaggerl.person.model;

import net.jaggerl.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<PersonDto> getPeople() {
        final List<Person> people = personRepository.getPeople();
        return convertPersonListToPersonDtoList(people);
    }

    public void updatePerson(final PersonDto personDto) {
        personRepository.updatePerson(convertPersonDto(personDto));
    }

    private Person convertPersonDto(final PersonDto personDto) {
        return new PersonBuilder().withFirstname(personDto.getFirstname()).withSurname(personDto.getSurname()).build();
    }

    private List<PersonDto> convertPersonListToPersonDtoList(final List<Person> people) {
        return people.stream().map(this::convertPersonToDto).collect(Collectors.toList());
    }

    private PersonDto convertPersonToDto(final Person person) {
        return new PersonDto(person.getFirstname(), person.getSurname());
    }
}
