package com.softserve.academy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    public void mainH2Test() {
        //DataStorage storage = new SimpleDataStorage();
        DataStorage storage = new H2DataStorage();
        Person oldestMan = storage.findOldestPerson(Person.MAN);
        Person oldestWoman = storage.findOldestPerson(Person.WOMAN);
        System.out.println("Oldest Man:" + oldestMan);
        System.out.println("Oldest Woman:" + oldestWoman);
        System.out.println("----");
        storage.findAll(null).forEach(System.out::println);
    }

    @Test
    public void mainSipleTest() {
        //DataStorage storage = new SimpleDataStorage();
        DataStorage storage = new SimpleDataStorage();
        Person oldestMan = storage.findOldestPerson(Person.MAN);
        Person oldestWoman = storage.findOldestPerson(Person.WOMAN);
        System.out.println("Oldest Man:" + oldestMan);
        System.out.println("Oldest Woman:" + oldestWoman);
        System.out.println("----");
        storage.findAll(null).forEach(System.out::println);
    }
}