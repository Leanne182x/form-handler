package net.jaggerl.person.controller;

import net.jaggerl.person.model.PeopleDao;
import net.jaggerl.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeopleService {

    private final PeopleDao peopleDao;

    @Autowired
    public PeopleService(final PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }

    public void savePeople(List<Person> people) {
        peopleDao.storePeople(people);
    }
}