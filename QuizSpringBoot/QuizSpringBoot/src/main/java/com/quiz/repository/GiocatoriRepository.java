package com.quiz.repository;

import com.quiz.entity.Giocatore;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GiocatoriRepository extends CrudRepository<Giocatore, Integer> {

    Optional<Giocatore> findById(int id);

    List<Giocatore> findAll();
}
