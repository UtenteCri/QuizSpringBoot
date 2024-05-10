package com.quiz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Giocatore")
public class Giocatore {
	@Id
	int id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int punteggio;

	// Costruttore
	public Giocatore(int id, String nome, int punteggio) {
		this.id = id;
		this.nome = nome;
		this.punteggio = punteggio;
	}

	// Metodi getter e setter per gli attributi

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPunteggio() {
		return punteggio;
	}

	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
}
