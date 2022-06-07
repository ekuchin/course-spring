package org.example.demojpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KittenRepository extends JpaRepository<Kitten, Long> {
}
