package net.jaggerl.person.controller;

import net.jaggerl.person.model.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
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
}
