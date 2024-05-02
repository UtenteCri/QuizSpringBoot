package com.quiz.QuizSpringBoot;

import com.quiz.entity.Domanda;
import com.quiz.service.InterfaceDomandeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class QuizSpringBootApplicationTests {

	@Autowired
	private InterfaceDomandeService domandeService;

	@Test
	void testAggiungiDomanda() {
		Domanda domanda = new Domanda(1, "Test", 3, Arrays.asList("Opzione1", "Opzione2"));

		Domanda result = domandeService.aggiungiDomanda(domanda);
		
		//assertThat(result).isEqualTo(domanda);

		assertThat(result.getId()).isEqualTo(domanda.getId());
		assertThat(result.getTesto()).isEqualTo(domanda.getTesto());
		assertThat(result.getLivelloDifficoltà()).isEqualTo(domanda.getLivelloDifficoltà());
		assertThat(result.getOpzioniRisposta()).isEqualTo(domanda.getOpzioniRisposta());
	}

	@Test
	void testCercaDomandaPerId() {
		Domanda domanda = new Domanda(1, "Test", 1, Arrays.asList("Opzione1", "Opzione2"));
		domandeService.aggiungiDomanda(domanda);

		Domanda result = domandeService.cercaDomandaPerId(1);

		assertThat(result.getId()).isEqualTo(domanda.getId());
		assertThat(result.getTesto()).isEqualTo(domanda.getTesto());
		assertThat(result.getLivelloDifficoltà()).isEqualTo(domanda.getLivelloDifficoltà());
		assertThat(result.getOpzioniRisposta()).isEqualTo(domanda.getOpzioniRisposta());
	}

	@Test
	void testEliminaDomanda() {
		Domanda domanda = new Domanda(1, "Test", 3, Arrays.asList("Opzione1", "Opzione2"));
		domandeService.aggiungiDomanda(domanda);
		domandeService.eliminaDomanda(1);

		Domanda result = domandeService.cercaDomandaPerId(1); // cerca

		assertNull(result); // controllo che non ci sia più
	}

	
}
