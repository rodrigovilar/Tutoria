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

	@Test
	public void pesquisarTutorPeloIdTest() throws Exception {
		Tutor t = new Tutor("Otaciso", "123.456.789.01");
		gestor.cadastraTutor(t);
		assertEquals(t, gestor.pesquisarTutorPeloId("123.456.789.01"));
	}

	@Test
	public void removeTutorPeloIdTest() throws Exception {
		Tutor tutor = new Tutor("Otaciso", "12345");
		gestor.cadastraTutor(tutor);
		gestor.removeTutorPeloId("12345");
	}

	// Aluno
	@Test
	public void cadastraAlunoNoGestorTest() throws Exception {
		Aluno alunos = new Aluno("Otaciso", "81011053");
		gestor.cadastrarAluno(alunos);
		List<Aluno> listAluno = gestor.getListaDeAlunosCriados();
		assertEquals(1, listAluno.size());

	}

}
