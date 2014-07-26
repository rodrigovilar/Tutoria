package com.projeto.tutotia;

import static org.junit.Assert.assertFalse;

import org.junit.Before;

public class TestMainProject {

	private GestorAuxiliarParaSistema gestor;

	@Before
	public void iniciarTest() {
		this.gestor = new GestorAuxiliarParaSistema();
		assertFalse("O sistema de tutoria iniciou acabado", gestor.finalizou());
	}
}
