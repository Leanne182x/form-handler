package net.jaggerl.person.repository;

import net.jaggerl.person.io.PersonStore;
import net.jaggerl.person.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonListRepository implements PersonRepository {

    private final List<Person> people = new ArrayList<>();
    private PersonStore personStore;

    public PersonListRepository(final PersonStore personStore) {
        this.personStore = personStore;
    }

    @Override
    public void store(final Person person) {
        people.add(person);
        personStore.savePerson(person);
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
