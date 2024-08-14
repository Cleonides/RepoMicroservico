package com.example.demo.resources;

import com.example.demo.models.Person;
import com.example.demo.repositories.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(path = "/persons")
public class PersonResource {

    private final PersonRepository personReposity;

    public PersonResource(PersonRepository personReposity){
        super();
        this.personReposity = personReposity;
    }

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person){
        personReposity.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAll(){
        List<Person> persons = new ArrayList<>();
        persons = personReposity.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Optional<Person>> getById(@PathVariable Integer id){
        Optional<Person> person;
        try{
            person = personReposity.findById(id);
            return new ResponseEntity<Optional<Person>>(person, HttpStatus.OK);
        }catch (NoSuchElementException nsee){
            return new ResponseEntity<Optional<Person>>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Optional<Person>> deleteById(@PathVariable Integer id) {
        try{
            personReposity.deleteById(id);
            return new ResponseEntity<Optional<Person>>(HttpStatus.OK);
        }catch (NoSuchElementException nsee){
            return new ResponseEntity<Optional<Person>>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Person> update(@PathVariable Integer id, @RequestBody Person newPerson){
        return personReposity.findById(id)
                .map(person -> {
                    person.setName(newPerson.getName());
                    person.setAge(newPerson.getAge());
                    Person personUpdate = personReposity.save(person);
                    return ResponseEntity.ok().body(personUpdate);
                }).orElse(ResponseEntity.notFound().build());
    }

}
