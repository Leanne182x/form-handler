package net.jaggerl.person.repository;

import net.jaggerl.person.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonListRepository implements PersonRepository {

    private final List<Person> people = new ArrayList<>();

    public void store(final Person person) {
        people.add(person);
    }

    public int getNumberOfPeople() {
        return people.size();
    }
}
