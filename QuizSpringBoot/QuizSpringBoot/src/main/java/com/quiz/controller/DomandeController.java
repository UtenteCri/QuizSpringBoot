package com.quiz.controller;

import com.quiz.entity.Domanda;
import com.quiz.service.InterfaceDomandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DomandeController {

    @Autowired
    private InterfaceDomandeService domandeService;

    @PostMapping("/domande")
    public Domanda aggiungiDomanda(@RequestBody Domanda domanda) {
        return domandeService.aggiungiDomanda(domanda.getId(),domanda.getTesto(), domanda.getLivelloDifficoltà(), domanda.getOpzioniRisposta());
    }

    @GetMapping("/domande")
    public List<Domanda> stampaDomande() {
        return domandeService.stampaDomande();
    }

    @GetMapping("/domande/{id}")
    public Domanda cercaDomandaPerId(@PathVariable int id) {
        return domandeService.cercaDomandaPerId(id);
    }

    @PutMapping("/domande/{id}")
    public Domanda aggiornaDomanda(@PathVariable int id, @RequestBody Domanda domanda) {
        return domandeService.aggiornaDomanda(id, domanda.getTesto(), domanda.getLivelloDifficoltà(), domanda.getOpzioniRisposta());
    }

    @DeleteMapping("/domande/{id}")
    public void eliminaDomanda(@PathVariable int id) {
        domandeService.eliminaDomanda(id);
    }
}
