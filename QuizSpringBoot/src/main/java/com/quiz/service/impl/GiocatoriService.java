package com.quiz.service.impl;

import com.quiz.entity.Giocatore;
import com.quiz.repository.GiocatoriRepository;
import com.quiz.service.InterfaceGiocatoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class GiocatoriService implements InterfaceGiocatoriService {

	private final static Logger LOGGER = Logger.getLogger(GiocatoriService.class.getName());

	@Autowired
	private GiocatoriRepository giocatoriRepository;

	@Override
	public Giocatore aggiungiGiocatore(int id, String nome, int punteggio) {
		Giocatore giocatore = new Giocatore(id,  nome,  punteggio);
		return aggiungiGiocatore(giocatore);
	}

	@Override
	public Giocatore aggiungiGiocatore(Giocatore giocatore) {
		LOGGER.info("Inserito giocatore: " + giocatore);
		return giocatoriRepository.save(giocatore);
	}

	@Override
	public List<Giocatore> stampaGiocatori() {
		return giocatoriRepository.findAll();
	}

	@Override
	public Giocatore cercaGiocatorePerId(int id) {
		Optional<Giocatore> opt = giocatoriRepository.findById(id);
		return opt.orElse(null);
	}

	@Override
	public Giocatore aggiornaGiocatore(int id, String nome, int punteggio) {
		Giocatore giocatore = cercaGiocatorePerId(id);
		if (giocatore != null) {
			giocatore.setNome(nome);
			LOGGER.info("Giocatore aggiornato: " + giocatore);
			return giocatoriRepository.save(giocatore);
		}
		return null;
	}

	@Override
	public void eliminaGiocatore(int id) {
		giocatoriRepository.deleteById(id);
	}
}
