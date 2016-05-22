package net.jaggerl.person.repository;

import net.jaggerl.person.model.Person;

import java.util.List;

public interface PersonRepository {

    void store(Person person);
    int getNumberOfPeople();
    List<Person> getPeople();
    void updatePerson(int personId, Person person);
}
