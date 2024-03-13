package com.quiz.service.impl;

import com.quiz.entity.Risposta;
import com.quiz.repository.RisposteRepository;
import com.quiz.service.InterfaceRisposteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RisposteService implements InterfaceRisposteService {

    private final static Logger LOGGER = Logger.getLogger(RisposteService.class.getName());

    @Autowired
    private RisposteRepository risposteRepository;

    @Override
    public Risposta aggiungiRisposta(int id, String testo, boolean corretta) {
        Risposta risposta = new Risposta( id,  testo,  corretta);
        return aggiungiRisposta(risposta);
    }

    @Override
    public Risposta aggiungiRisposta(Risposta risposta) {
        LOGGER.info("Inserita risposta: " + risposta);
        return risposteRepository.save(risposta);
    }

    @Override
    public List<Risposta> stampaRisposte() {
        return risposteRepository.findAll();
    }

    @Override
    public Risposta cercaRispostaPerId(int id) {
        Optional<Risposta> opt = risposteRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Risposta aggiornaRisposta(int id, String testo, boolean corretta) {
        Risposta risposta = cercaRispostaPerId(id);
        if (risposta != null) {
            risposta.setTesto(testo);
            risposta.setCorretta(corretta);
            LOGGER.info("Risposta aggiornata: " + risposta);
            return risposteRepository.save(risposta);
        }
        return null;
    }

    @Override
    public void eliminaRisposta(int id) {
        risposteRepository.deleteById(id);
    }


}
