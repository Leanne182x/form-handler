package net.jaggerl.person.io;

import net.jaggerl.person.model.Person;

public interface PersonStore {
    void savePerson(Person person);
}
