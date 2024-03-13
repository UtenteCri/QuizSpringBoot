package com.quiz.controller;

import com.quiz.entity.Risposta;
import com.quiz.service.InterfaceRisposteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RisposteController {

    @Autowired
    private InterfaceRisposteService risposteService;

    @PostMapping("/risposte")
    public Risposta aggiungiRisposta(@RequestBody Risposta risposta) {
        return risposteService.aggiungiRisposta(risposta.getId(),risposta.getTesto(), risposta.getCorretta());
    }

    @GetMapping("/risposte")
    public List<Risposta> stampaRisposte() {
        return risposteService.stampaRisposte();
    }

    @GetMapping("/risposte/{id}")
    public Risposta cercaRispostaPerId(@PathVariable int id) {
        return risposteService.cercaRispostaPerId(id);
    }

    @PutMapping("/risposte/{id}")
    public Risposta aggiornaRisposta(@PathVariable int id, @RequestBody Risposta risposta) {
        return risposteService.aggiornaRisposta(id, risposta.getTesto(), risposta.getCorretta());
    }

    @DeleteMapping("/risposte/{id}")
    public void eliminaRisposta(@PathVariable int id) {
        risposteService.eliminaRisposta(id);
    }
}
