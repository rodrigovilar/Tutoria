package com.projeto.tutotia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TestMainProject {

	private GestorAuxiliarParaSistema gestor;
	//private PlataformaDeGerenciaEad gestorAux = new PlataformaDeGerenciaEad();

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

	@Test(expected = TutorInexistenteException.class)
	public void removerTutorInexistenteTest() throws Exception {
		Tutor tutor = new Tutor("Thiego", "12345");
		gestor.cadastraTutor(tutor);
		gestor.removeTutorPeloId("54321");
	}

	@Test
	public void verificarTamanhoDaListadeTutoresTest() throws Exception {
		Tutor t1 = new Tutor("Mateus" , "11111");
		Tutor t2 = new Tutor("Kaué"   , "22222");
		Tutor t3 = new Tutor("Otaciso", "333333");
		Tutor t4 = new Tutor("Thiego" , "444444");
		Tutor t5 = new Tutor("Daniel" , "555555");
		gestor.cadastraTutor(t1);
		gestor.cadastraTutor(t2);
		gestor.cadastraTutor(t3);
		gestor.cadastraTutor(t4);
		gestor.cadastraTutor(t5);
		List<Tutor> listaCoord = gestor.getListaDeTutores();
		assertEquals(5, listaCoord.size());
	}

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
	public void removerAlunoInexistenteTest() {
		Aluno aluno = new Aluno("Thiego", "12345");
		gestor.cadastrarAluno(aluno);
		gestor.removerAlunoPelaMatricula("54321");
	}

}
