package ru.projectosnova.springlearnsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.projectosnova.springlearnsecurity.entity.Cat;

public interface CatRepository extends JpaRepository<Cat, Long> {
}
