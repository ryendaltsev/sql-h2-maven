package com.softserve.academy;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/all")
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @GetMapping("/oldest")
    public List<Person> getOldestPersons() {
        return Arrays.asList(
            personRepository.findOldestPerson(Person.WOMAN),
            personRepository.findOldestPerson(Person.MAN));
    }
}
