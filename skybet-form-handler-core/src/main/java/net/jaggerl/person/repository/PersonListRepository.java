package net.jaggerl.person.repository;

import net.jaggerl.person.io.PersonStore;
import net.jaggerl.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonListRepository implements PersonRepository {

    private final List<Person> people = new ArrayList<>();
    private final PersonStore personStore;

    @Autowired
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
    public void updatePerson(int personId, final Person person) {
        // TODO would also need to call the PersonStore to update the file since there's no database store.
        // At the moment a reboot would mean both the old and new update records would be in the file
        people.removeIf(storedPerson -> storedPerson.getId() == personId);
        store(person);
    }
}
