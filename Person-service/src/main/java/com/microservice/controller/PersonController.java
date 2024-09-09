package com.microservice.controller;

import com.microservice.dto.PersonDto;
import com.microservice.model.Person;
import com.microservice.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/persons/{id}")
    public PersonDto getPerson(@PathVariable Long id){
        return personService.getPersonWithAdress(id);
    }

}