package com.quiz.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Domanda")
public class Domanda {
	@Id
	private int id;
	
	@Column(nullable = false)
	private String testo;
	
	@Column(nullable = false)
	private int livelloDifficoltà;
	
	@Column(nullable = false)
	private List<String> opzioniRisposta;
	
	// Costruttore di default
	public Domanda() {
	    // Costruttore vuoto
	}

    // Costruttore
	public Domanda(int id, String testo, int livelloDifficoltà, List<String> opzioniRisposta) {
		this.id = id;
		this.testo = testo;
		this.livelloDifficoltà = livelloDifficoltà;
		this.opzioniRisposta = opzioniRisposta;
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

	public int getLivelloDifficoltà() {
		return livelloDifficoltà;
	}

	public void setLivelloDifficoltà(int livelloDifficoltà) {
		this.livelloDifficoltà = livelloDifficoltà;
	}

	public List<String> getOpzioniRisposta() {
		return opzioniRisposta;
	}

	public void setOpzioniRisposta(List<String> opzioniRisposta) {
		this.opzioniRisposta = opzioniRisposta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, livelloDifficoltà, opzioniRisposta, testo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Domanda other = (Domanda) obj;
		return id == other.id && livelloDifficoltà == other.livelloDifficoltà
				&& Objects.equals(opzioniRisposta, other.opzioniRisposta) && Objects.equals(testo, other.testo);
	}
	
	
}
