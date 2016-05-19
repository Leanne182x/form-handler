package net.jaggerl.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PeopleController {

    private final PeopleService peopleService;

    @Autowired
    public PeopleController(final PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    @ResponseBody
    public void postPeople() {
        peopleService.savePeople(null);
    }
}
