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

    @Override
    public void store(final Person person) {
        people.add(person);
        personFileStore.savePersonToFile(person);
    }

    @Override
    public int getNumberOfPeople() {
        return people.size();
    }

    @Override
    public List<Person> getPeople() {
        return people;
    }

    @Override
    public void updatePerson(final Person person) {
        // TODO would need to remove from list in memory and replace and make sure to remove from file since there's no database filestore
    }
}
