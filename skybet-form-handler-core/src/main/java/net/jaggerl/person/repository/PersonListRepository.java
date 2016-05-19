package net.jaggerl.person.repository;

import net.jaggerl.person.io.PersonFileStore;
import net.jaggerl.person.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonListRepository implements PersonRepository {

    private final List<Person> people = new ArrayList<>();
    private PersonFileStore personFileStore;

    public PersonListRepository(final PersonFileStore personFileStore) {
        this.personFileStore = personFileStore;
    }

    public void store(final Person person) {
        people.add(person);
        personFileStore.savePersonToFile(person);
    }

    public int getNumberOfPeople() {
        return people.size();
    }
}
