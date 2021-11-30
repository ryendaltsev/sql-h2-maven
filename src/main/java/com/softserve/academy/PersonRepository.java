package com.softserve.academy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "SELECT * FROM person WHERE sex = :sex ORDER BY birthday DESC LIMIT 1"
        , nativeQuery = true)
    Person findOldestPerson(@Param("sex") String sex);
}
