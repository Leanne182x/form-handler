package net.jaggerl.person.controller;

import net.jaggerl.person.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/people")
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(final PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public void postPeople(@RequestBody ArrayList<PersonDto> people) {
        peopleService.savePeople(people);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<PersonDto> getPeople() {
        return peopleService.getPeople();
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.PUT)
    @ResponseBody
    public void updatePerson(@PathVariable("personId") int personId, @RequestBody PersonDto personDto) {
        peopleService.updatePerson(personId, personDto);
    }
}
