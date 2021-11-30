package com.softserve.academy;

import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class DataUtils {

    public static List<Person> generate() {
        final Random random = new Random();
        return random.ints(2000, 365, 3650)
            .mapToObj(i -> new Person(randomDate(i), genName("PN", i), (i % 2 == 0 ? Person.MAN : Person.WOMAN)))
            .collect(Collectors.toList());

    }

    private static String genName(String prefix, int i) {
        return prefix + i;
    }

    private static Date randomDate(int daysBefore) {
        return new Date(System.currentTimeMillis() - (long) daysBefore * 1000 *60*60*24);
    }
}
