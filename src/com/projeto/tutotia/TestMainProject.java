package com.projeto.tutotia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestMainProject {

	private GestorAuxiliarParaSistema gestor;

	@Before
	public void iniciarTest() {
		this.gestor = new GestorAuxiliarParaSistema();
		assertFalse("O sistema de tutoria iniciou acabado", gestor.finalizou());
	}
	
	// Tutor
	@Test
	public void cadastrarTutorNoSistemaTest() throws Exception {
		Tutor tut = new Tutor("Otaciso", "123.456.789.01");
		gestor.cadastraTutor(tut);
		List<Tutor> listTut = gestor.getListaDeTutor();
		assertEquals(1, listTut.size());
	}

}
