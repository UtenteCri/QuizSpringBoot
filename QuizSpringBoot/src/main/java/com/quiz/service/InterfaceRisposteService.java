package com.quiz.service;

import com.quiz.entity.Risposta;
import java.util.List;

public interface InterfaceRisposteService {

	Risposta aggiungiRisposta(int id, String testo, boolean corretta);

	Risposta aggiungiRisposta(Risposta risposta);

	List<Risposta> stampaRisposte();

	Risposta cercaRispostaPerId(int id);

	Risposta aggiornaRisposta(int id, String testo, boolean corretta);

	void eliminaRisposta(int id);
}