package dev.alexanghel.h2initsqlfile.repository;

import dev.alexanghel.h2initsqlfile.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

}
