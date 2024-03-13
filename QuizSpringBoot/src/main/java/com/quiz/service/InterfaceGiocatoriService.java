package com.quiz.service;

import com.quiz.entity.Giocatore;
import java.util.List;

public interface InterfaceGiocatoriService {
	
	Giocatore aggiungiGiocatore(int id, String nome, int punteggio);

	Giocatore aggiungiGiocatore(Giocatore giocatore);

	List<Giocatore> stampaGiocatori();

	Giocatore cercaGiocatorePerId(int id);

	Giocatore aggiornaGiocatore(int id, String nome, int punteggio);

	void eliminaGiocatore(int id);
	
}