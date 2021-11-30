package com.softserve.academy;


import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

    private static final SimpleDateFormat sm = new SimpleDateFormat("dd-mm-yyyy");

    public static final String WOMAN = "F";
    public static final String MAN = "M";

    static int counter = 1;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int _id;
    @Column(name = "birthday")
    private Date _birthday;
    @Column(name = "name")
    private String _name;
    @Column(name = "sex")
    private String _sex;

    public Person() {

    }

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
