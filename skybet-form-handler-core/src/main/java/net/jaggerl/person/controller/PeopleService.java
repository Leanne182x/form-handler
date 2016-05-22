package net.jaggerl.person.controller;

import net.jaggerl.person.model.PeopleDao;
import net.jaggerl.person.model.PersonDto;
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

    public void savePeople(final List<PersonDto> people) {
        peopleDao.storePeople(people);
    }

    public List<PersonDto> getPeople() {
        return peopleDao.getPeople();
    }

    /**
     * @param personId the ID of the person to be updated
     * @param person the new person details the person should be updated with
     */
    public void updatePerson(int personId, final PersonDto person) {
        peopleDao.updatePerson(personId, person);
    }
}
