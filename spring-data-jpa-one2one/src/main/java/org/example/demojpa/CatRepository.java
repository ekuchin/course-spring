package org.example.demojpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CatRepository extends JpaRepository<Cat, Long> {

    List<Cat> findByBreed(String breed);

    @Query("select c from Cat c where breed='Манул'")
    List<Cat> findSomeManuls();

}
