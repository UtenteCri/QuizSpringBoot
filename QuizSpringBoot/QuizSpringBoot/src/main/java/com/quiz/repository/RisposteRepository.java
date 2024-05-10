package com.quiz.repository;

import com.quiz.entity.Risposta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RisposteRepository extends CrudRepository<Risposta, Integer> {

    Optional<Risposta> findById(int id);

    List<Risposta> findAll();
}
