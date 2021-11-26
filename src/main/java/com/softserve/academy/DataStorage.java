package com.softserve.academy;

import java.util.List;

public interface DataStorage {

    Person findOldestPerson(String sex);

    List<Person> findAll(String sex);
}
