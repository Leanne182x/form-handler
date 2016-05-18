package net.jaggerl.person.repository;

import net.jaggerl.person.model.Person;

public interface PersonRepository {

    void store(Person person);
    int getNumberOfPeople();
}
