package com.quiz.service;

import com.quiz.entity.Domanda;
import java.util.List;

public interface InterfaceDomandeService {

	Domanda aggiungiDomanda(int id, String testo, int livelloDifficoltà, List<String> opzioniRisposta);

	Domanda aggiungiDomanda(Domanda domanda);

	List<Domanda> stampaDomande();

	Domanda cercaDomandaPerId(int id);

	Domanda aggiornaDomanda(int id, String testo, int livelloDifficoltà, List<String> opzioniRisposta);

	void eliminaDomanda(int id);
}

