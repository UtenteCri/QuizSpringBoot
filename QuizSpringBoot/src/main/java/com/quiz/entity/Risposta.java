package com.quiz.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Risposta")
public class Risposta {
	@Id
	private int id;
	
	@Column(nullable = false)
	private String testo;
	
	@Column(nullable = false)
	private boolean corretta;

	// Costruttore
	public Risposta(int id, String testo, boolean corretta) {
		this.id = id;
		this.testo = testo;
		this.corretta = corretta;
	}

	// Metodi getter e setter per gli attributi

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}

	public boolean getCorretta() {
		return corretta;
	}

	public void setCorretta(boolean corretta) {
		this.corretta = corretta;
	}
}
