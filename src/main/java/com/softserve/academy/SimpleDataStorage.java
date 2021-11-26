package com.softserve.academy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleDataStorage implements DataStorage {

    private List<Person> _persons;

    {
        _persons = DataUtils.generate();
    }


    @Override
    public Person findOldestPerson(String sex) {
        return _persons.stream()
            .filter(p -> sex == null || sex.equals(p.getSex()))
            .min(Comparator.comparing(Person::getBirthday))
            .orElse(null);
    }

    @Override
    public List<Person> findAll(String sex) {
        return _persons;
    }
}
