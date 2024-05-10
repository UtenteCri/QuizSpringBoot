package com.quiz.controller;

import com.quiz.entity.Giocatore;
import com.quiz.service.InterfaceGiocatoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GiocatoriController {

    @Autowired
    private InterfaceGiocatoriService giocatoriService;

    @PostMapping("/giocatori")
    public Giocatore aggiungiGiocatore(@RequestBody Giocatore giocatore) {
        return giocatoriService.aggiungiGiocatore(giocatore.getId(),giocatore.getNome(),giocatore.getPunteggio());
    }

    @GetMapping("/giocatori")
    public List<Giocatore> stampaGiocatori() {
        return giocatoriService.stampaGiocatori();
    }

    @GetMapping("/giocatori/{id}")
    public Giocatore cercaGiocatorePerId(@PathVariable int id) {
        return giocatoriService.cercaGiocatorePerId(id);
    }

    @PutMapping("/giocatori/{id}")
    public Giocatore aggiornaGiocatore(@PathVariable int id, @RequestBody Giocatore giocatore) {
        return giocatoriService.aggiornaGiocatore(id, giocatore.getNome(), giocatore.getPunteggio());
    }

    @DeleteMapping("/giocatori/{id}")
    public void eliminaGiocatore(@PathVariable int id) {
        giocatoriService.eliminaGiocatore(id);
    }
}
