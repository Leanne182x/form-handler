package net.jaggerl.person.io;

import net.jaggerl.person.model.Person;

public interface PersonFileStore {
    void savePersonToFile(Person person);
}
