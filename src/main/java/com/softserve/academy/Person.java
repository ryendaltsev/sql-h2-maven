package com.softserve.academy;


import java.text.SimpleDateFormat;
import java.sql.Date;

public class Person {

    private static final SimpleDateFormat sm = new SimpleDateFormat("dd-mm-yyyy");

    public static final String WOMAN = "F";
    public static final String MAN = "M";

    static int counter = 1;

    private final int _id;
    private final Date _birthday;
    private final String _name;
    private final String _sex;

    @Override
    public String toString() {
        return _id + " " + _name + " " + " (" + _sex + ") " + sm.format(_birthday);
    }


    public Person(int id, Date birthday, String name, String sex) {
        _id = id;
        _birthday = birthday;
        _name = name;
        _sex = sex;
    }

    public Person(Date birthday, String name, String sex) {
        this(counter++, birthday,name, sex);
    }

    public Date getBirthday() {
        return _birthday;
    }

    public String getSex() {
        return _sex;
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }
}
