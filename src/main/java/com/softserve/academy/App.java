package com.softserve.academy;

public class App {


    public static void main(String[] args) {
	    //DataStorage storage = new SimpleDataStorage();
        DataStorage storage = new H2DataStorage();
        Person oldestMan = storage.findOldestPerson(Person.MAN);
        Person oldestWoman = storage.findOldestPerson(Person.WOMAN);
        System.out.println("Oldest Man:" + oldestMan);
        System.out.println("Oldest Woman:" + oldestWoman);
        System.out.println("----");
        storage.findAll(null).forEach(System.out::println);
    }
}
