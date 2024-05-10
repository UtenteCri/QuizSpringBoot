package com.quiz.service.impl;

import com.quiz.entity.Domanda;
import com.quiz.repository.DomandeRepository;
import com.quiz.service.InterfaceDomandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DomandeService implements InterfaceDomandeService {

    private final static Logger LOGGER = Logger.getLogger(DomandeService.class.getName());

    @Autowired
    private DomandeRepository domandeRepository;

    @Override
    public Domanda aggiungiDomanda(int id,String testo, int livelloDifficoltà, List<String> opzioniRisposta) {
        Domanda domanda = new Domanda(id,testo, livelloDifficoltà, opzioniRisposta);
        return aggiungiDomanda(domanda);
    }

    @Override
    public Domanda aggiungiDomanda(Domanda domanda) {
        LOGGER.info("Inserita domanda: " + domanda);
        return domandeRepository.save(domanda);
    }

    @Override
    public List<Domanda> stampaDomande() {
        return domandeRepository.findAll();
    }

    @Override
    public Domanda cercaDomandaPerId(int id) {
        Optional<Domanda> opt = domandeRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public Domanda aggiornaDomanda(int id, String testo, int livelloDifficoltà, List<String> opzioniRisposta) {
        Domanda domanda = cercaDomandaPerId(id);
        if (domanda != null) {
            domanda.setTesto(testo);
            domanda.setLivelloDifficoltà(livelloDifficoltà);
            domanda.setOpzioniRisposta(opzioniRisposta);
            LOGGER.info("Domanda aggiornata: " + domanda);
            return domandeRepository.save(domanda);
        }
        return null;
    }

    @Override
    public void eliminaDomanda(int id) {
        domandeRepository.deleteById(id);
    }

	
}
