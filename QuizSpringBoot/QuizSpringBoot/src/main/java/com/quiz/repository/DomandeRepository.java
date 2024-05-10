package com.quiz.repository;

import com.quiz.entity.Domanda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DomandeRepository extends CrudRepository<Domanda, Integer> {

    Optional<Domanda> findById(int id);

    List<Domanda> findAll();
}
