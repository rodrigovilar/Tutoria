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
		Tutor tut = new Tutor("Otaciso", "12345");
		gestor.cadastraTutor(tut);
		List<Tutor> listTut = gestor.getListaDeTutor();
		assertEquals(1, listTut.size());
	}

	@Test
	public void pesquisarTutorPeloIdTest() throws Exception {
		Tutor t = new Tutor("Otaciso", "12345");
		gestor.cadastraTutor(t);
		assertEquals(t, gestor.pesquisarTutorPeloId("12345"));
	}

	@Test
	public void removeTutorPeloIdTest() throws Exception {
		Tutor tutor = new Tutor("Otaciso", "12345");
		gestor.cadastraTutor(tutor);
		gestor.removeTutorPeloId("12345");
	}

	@Test(expected = ExcecaoTutorDuplicado.class)
	public void cadastrarMesmoTutorDuasVezes() throws Exception {
		Tutor tu1 = new Tutor("Otaciso", "123.456.789.01");
		Tutor tu2 = new Tutor("Otaciso", "123.456.789.01");
		gestor.cadastraTutor(tu1);
		gestor.cadastraTutor(tu2);
	}

	@Test(expected = ExcecaoTutorDuplicado.class)
	public void cadastrarTutorComMesmaMatriculaTest() throws Exception {
		Tutor t1 = new Tutor("Otaciso", "123.456");
		Tutor t2 = new Tutor("Daniel", "123.456");
		gestor.cadastraTutor(t1);
		gestor.cadastraTutor(t2);
	}
	
/*	@Test//(expected = ObjetoInexistenteException.class)
	public void removerTutorInexistente() throws Exception {
		GestorAuxiliarParaSistema g1= new GestorAuxiliarParaSistema();
		gestor.cadastraTutor(tut);
		Tutor novoJogo = new Tutor();
		Professor p2 = instanciarObjetoProfessor();
		p2.setNome("Joao");
		p2.setSenha("01013456");
		novoJogo.removerProfessor(p2);
	}
	*/



	// Aluno
	@Test
	public void cadastraAlunoNoGestorTest() throws Exception {
		Aluno alunos = new Aluno("Otaciso", "81011053");
		gestor.cadastrarAluno(alunos);
		List<Aluno> listAluno = gestor.getListaDeAlunosCriados();
		assertEquals(1, listAluno.size());

	}

	@Test
	public void pesquisarAlunoPeloNomeTest() throws Exception {
		Aluno aluno1 = new Aluno("Otaciso", "81011053");
		gestor.cadastrarAluno(aluno1);
		assertEquals(aluno1, gestor.pesquisaAlunoPeloNome("Otaciso"));
	}

	@Test
	public void pesquisarAlunoPelaMatriculaTest() throws Exception {
		Aluno aluno1 = new Aluno("Otaciso", "81011053");
		gestor.cadastrarAluno(aluno1);
		assertEquals(aluno1, gestor.pesquisarAlunoPelaMatricula("81011053"));
	}

	@Test
	public void removerAlunoPelaMatriculaTest() throws Exception {
		Aluno aluno = new Aluno("Otaciso", "81011053");
		gestor.cadastrarAluno(aluno);
		gestor.pesquisarAlunoPelaMatricula("81011053");
	}

	// Verificar com professor #########################
	@Test(expected = ExcecaoAlunoDuplicado.class)
	public void cadastroDoMesmoAlunoTest() {
		Aluno aluno1 = new Aluno("Otaciso", "81011053");
		Aluno aluno2 = new Aluno("Otaciso", "81011053");
		gestor.cadastrarAluno(aluno1);
		gestor.cadastrarAluno(aluno2);
	}

	@Test(expected = ExcecaoAlunoDuplicado.class)
	public void cadastroDeAlunoMesmaMatriculaTest() {
		Aluno al1 = new Aluno("Otaciso", "81011055");
		Aluno al2 = new Aluno("Daniel", "81011055");
		gestor.cadastrarAluno(al1);
		gestor.cadastrarAluno(al2);
	}
	
	@Test(expected = AlunoInexistenteException.class)
	public void removerAlunoInexistenteTest(){
		Aluno aluno = new Aluno ("Thiego", "12345");
		gestor.cadastrarAluno(aluno);
		gestor.removerAlunoPelaMatricula("54321");
	}

}
