package com.projeto.facade;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

import com.projeto.exception.*;
import com.projeto.negocios.*;

public class TestMainProject {
	private GestorAuxiliarParaSistema gestor;

	@Before
	public void iniciarTest() {
		this.gestor = new GestorAuxiliarParaSistema();
		assertFalse("O sistema de tutoria iniciou acabado", gestor.finalizou());
	}

	// Tutor 1

	/*
	 * @Test public void newArrayListHaveNoElements() { assertThat(new
	 * ArrayList().size(), is(0)); }
	 */

	@Test(expected = GrupoDiscursaoJaExisteException.class)
	public void naoCriarTutorNulo() {
		Tutor t = new Tutor(null, null);
		assertEquals(t, null);

	}

	@Test
	public void cadastrarTutorNoSistemaTest() throws Exception {
		Tutor tut = new Tutor("Otaciso", "12345");
		gestor.cadastraTutor(tut);
		List<Tutor> listTut = gestor.getListaDeTutores();
		assertEquals(1, listTut.size());
	}

	@Test
	public void verificaTutorCadastradoNaLista() throws Exception {
		Tutor tut = new Tutor("Otaciso", "12345");
		gestor.cadastraTutor(tut);
		List<Tutor> listTut = gestor.getListaDeTutores();
		assertEquals(tut, listTut.get(0));

	}

	@Test
	public void loginTutorTest() {
		final String loginNumber = ".Login21";
		LoginTutor LoginTutor = new LoginTutor();
		boolean login = LoginTutor.ValidaSenha(loginNumber);
		assertEquals(true, login);
	}

	@Test
	public void pesquisarTutorPeloIdTest() throws Exception {
		Tutor t = new Tutor("Otaciso", "12345");
		gestor.cadastraTutor(t);
		assertEquals(t, gestor.pesquisarTutorPeloId("12345"));
	}

	@Test
	public void removerTutorPeloIdTest() throws Exception {
		Tutor tutor = new Tutor("Otaciso", "12345");
		gestor.cadastraTutor(tutor);
		gestor.removeTutorPeloId("12345");
	}

	@Test(expected = TutorDuplicadoException.class)
	public void cadastrarMesmoTutorTest() throws Exception {
		Tutor tu1 = new Tutor("Otaciso", "123.456.789.01");
		Tutor tu2 = new Tutor("Otaciso", "123.456.789");
		gestor.cadastraTutor(tu1);
		gestor.cadastraTutor(tu2);
	}

	@Test(expected = TutorDuplicadoException.class)
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
	public void verificarSizeListadeTutoresCadastradosTest() throws Exception {
		Tutor t1 = new Tutor("Mateus", "11111");
		Tutor t2 = new Tutor("Kaué", "22222");
		Tutor t3 = new Tutor("Otaciso", "333333");
		Tutor t4 = new Tutor("Thiego", "444444");
		Tutor t5 = new Tutor("Daniel", "555555");
		gestor.cadastraTutor(t1);
		gestor.cadastraTutor(t2);
		gestor.cadastraTutor(t3);
		gestor.cadastraTutor(t4);
		gestor.cadastraTutor(t5);
		List<Tutor> listaCoord = gestor.getListaDeTutores();
		assertEquals(5, listaCoord.size());
	}

	@Test
	public void listaTutorVazia() {

	}

	@Test(expected = TutorInexistenteException.class)
	public void pesquisarTutorInexistenteTest() throws Exception {
		Tutor t = new Tutor("Oscar", "12345");
		gestor.cadastraTutor(t);
		gestor.pesquisarTutorPeloId("00000");
	}

	// Aluno 2

	@Test(expected = ExcecaoIllegalArgumentException.class)
	public void naoCriarAlunoNulo() {
		Aluno a = new Aluno(null, null);
		assertEquals(a, null);

	}

	@Test
	public void cadastraAlunoTest() throws Exception {
		Aluno alunos = new Aluno("Otaciso", "81011053");
		gestor.cadastrarAluno(alunos);
		List<Aluno> listAluno = gestor.getListaDeAlunosCadastrados();
		assertEquals(1, listAluno.size());

	}

	@Test
	public void verificaAlunoCadastradoNaLista() throws Exception {
		Aluno a = new Aluno("Otaciso", "12345");
		gestor.cadastrarAluno(a);
		List<Aluno> lista = gestor.getListaDeAlunosCadastrados();
		assertEquals(a, lista.get(0));

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

	@Test(expected = AlunoDuplicadoException.class)
	public void cadastrarMesmoAlunoTest() {
		Aluno aluno1 = new Aluno("Otaciso", "81011053");
		Aluno aluno2 = new Aluno("Otaciso", "81011053");
		gestor.cadastrarAluno(aluno1);
		gestor.cadastrarAluno(aluno2);
	}

	@Test(expected = AlunoDuplicadoException.class)
	public void cadastrarAlunoComMesmaMatriculaTest() {
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

	@Test(expected = AlunoDuplicadoException.class)
	public void removerTodosAlunosCadastradosTest() {
		Aluno aI = new Aluno(" OtacisoEu ", " 813011053 ");
		Aluno aII = new Aluno(" OtacisoTu ", " 813011054 ");
		Aluno aIII = new Aluno(" OtacisoNos ", " 813011055 ");
		Aluno aIV = new Aluno(" OtacisoVois ", " 813011056 ");
		Aluno aV = new Aluno(" OtacisoEles ", " 813011057 ");
		gestor.cadastrarAluno(aI);
		gestor.cadastrarAluno(aII);
		gestor.cadastrarAluno(aIII);
		gestor.cadastrarAluno(aIV);
		gestor.cadastrarAluno(aV);
		gestor.removerAlunoPelaMatricula(aI.getMatricula());
		gestor.removerAlunoPelaMatricula(aII.getMatricula());
		gestor.removerAlunoPelaMatricula(aIII.getMatricula());
		gestor.removerAlunoPelaMatricula(aIV.getMatricula());
		gestor.removerAlunoPelaMatricula(aV.getMatricula());
		List<Aluno> alunosCadastrados = gestor.getListaDeAlunosCadastrados();
		assertEquals(5, alunosCadastrados.size());
	}

	@Test(expected = AlunoDuplicadoException.class)
	public void verificarQuantidadedeAlunosCadastradosTest() {
		Aluno aI = new Aluno("Mateus", "11111");
		Aluno aII = new Aluno("Kaué", "22222");
		Aluno aIII = new Aluno("Otaciso", "333333");
		Aluno aIV = new Aluno("Thiego", "444444");
		Aluno aV = new Aluno("Daniel", "555555");
		gestor.cadastrarAluno(aI);
		gestor.cadastrarAluno(aII);
		gestor.cadastrarAluno(aIII);
		gestor.cadastrarAluno(aIV);
		gestor.cadastrarAluno(aV);
		List<Aluno> alunoCadastrados = gestor.getListaDeAlunosCadastrados();
		assertEquals(5, alunoCadastrados.size());
	}

	// Grupo 3

	@Test(expected = ExcecaoIllegalArgumentException.class)
	public void naoCriarGrupoNulo() {
		GrupoDiscursao g = new GrupoDiscursao(null, null);
		assertEquals(g, null);

	}

	@Test
	public void cadastrarGrupoTest() throws GrupoDiscursaoJaExisteException,
			GrupoDiscursaoJaExisteException {
		Aula aula = new Aula("Aula de Login do Tablet", "01");
		gestor.cadastrarAula(aula);
		GrupoDiscursao grupo = new GrupoDiscursao(aula, "A-01");
		gestor.cadastrarGrupoDiscursao(grupo);
		assertEquals(grupo, gestor.pesquisarGrupo("A-01"));
	}

	@Test
	public void verificaGrupoDiscursaoCadastradoNaLista() throws Exception {

		Aula aula = new Aula("Aula de Instalação de App", "-01");
		gestor.cadastrarAula(aula);
		GrupoDiscursao grupo = new GrupoDiscursao(aula, "X-01");
		gestor.cadastrarGrupoDiscursao(grupo);
		List<GrupoDiscursao> listgd = gestor.getListaDeGruposNoForum();
		assertEquals(grupo, listgd.get(0));

	}

	@Test(expected = GrupoDiscursaoJaExisteException.class)
	public void cadastrarGrupoDiscursaoComMesmoCodigoTest()
			throws GrupoDiscursaoJaExisteException {
		Aula aula = new Aula("Acessar a plataforma EAD pelo tablet", "02");
		gestor.cadastrarAula(aula);
		GrupoDiscursao grupod = new GrupoDiscursao(aula, "A-02");
		gestor.cadastrarGrupoDiscursao(grupod);
		Aula aulaII = new Aula("Enviar Exercio ao Modle", "03");
		gestor.cadastrarAula(aulaII);
		GrupoDiscursao grupod2 = new GrupoDiscursao(aula, "A-02");
		gestor.cadastrarGrupoDiscursao(grupod2);
	}

	@Test
	public void verificarQuantidadeDeGrupoDiscursaoPorAssuntoNoForumTest()
			throws GrupoDiscursaoJaExisteException {
		Aula aI = new Aula("Acessar a plataforma EAD pelo tablet", "02");
		gestor.cadastrarAula(aI);
		GrupoDiscursao grupoD_I = new GrupoDiscursao(aI, "Grupo I");
		gestor.cadastrarGrupoDiscursao(grupoD_I);
		Aula aII = new Aula("Enviar Exercio ao Modle", "03");
		gestor.cadastrarAula(aII);
		GrupoDiscursao grupoD_II = new GrupoDiscursao(aII, "Grupo II");
		gestor.cadastrarGrupoDiscursao(grupoD_II);
		Aula aIII = new Aula("Aula de Login do Tablet", "01");
		gestor.cadastrarAula(aIII);
		GrupoDiscursao grupoD_III = new GrupoDiscursao(aIII, "Grupo III");
		gestor.cadastrarGrupoDiscursao(grupoD_III);
		Aula aIV = new Aula("Acessar aulas no moodle", "04");
		gestor.cadastrarAula(aIV);
		GrupoDiscursao grupoD_IV = new GrupoDiscursao(aIV, "Grupo IV");
		gestor.cadastrarGrupoDiscursao(grupoD_IV);
		List<GrupoDiscursao> qtdGrupoCadastrados = gestor
				.getListaDeGruposNoForum();
		assertEquals(4, qtdGrupoCadastrados.size());
	}

	// Aula 4

	@Test(expected = ExcecaoIllegalArgumentException.class)
	public void naoCriarAulaNulo()  {
		Aula a = new Aula(null, null);
		assertEquals(a, null);
	}

	@Test
	public void cadastrarAulaTest() throws Exception {
		Aula aula = new Aula("Primeiro dia de aula", "0001");
		gestor.cadastrarAula(aula);
		List<Aula> listAula = gestor.getListaDeAulasCadastradas();
		assertEquals(1, listAula.size());
	}

	@Test
	public void verificaAulaCadastradaNaLista() throws Exception {
		Aula aula = new Aula("Primeiro dia de aula", "0001");
		gestor.cadastrarAula(aula);
		List<Aula> listAula = gestor.getListaDeAulasCadastradas();
		assertEquals(aula, listAula.get(0));
	}

	@Test
	public void adicionarAulaAoGrupoDiscursaoTest()
			throws GrupoDiscursaoJaExisteException {
		Aula a = new Aula("Enviar Exercio ao Modle", "03");
		gestor.cadastrarAula(a);
		GrupoDiscursao gd = new GrupoDiscursao(a, "A-03");
		gestor.cadastrarGrupoDiscursao(gd);
		gestor.adicionarAulaAoGrupo(a, gd);
		List<Aula> aulas = gestor.getListaDeAulasCadastradasPorGrupo(gd);
		assertEquals(1, aulas.size());
	}

	@Test
	public void pesquisarAulaTest() {
		Aula aula = new Aula("Enviar Exercio ao Modle", "05");
		gestor.cadastrarAula(aula);
		Aula aulap = gestor.pesquisaAula("05");
		assertEquals(aula, aulap);
	}

	@Test
	public void pesquisarAulaInexistenteTest() {
		Aula a = new Aula("Enviar Exercio ao Modle", "05");
		gestor.cadastrarAula(a);
		Aula aula = gestor.pesquisaAula("-1");
		assertNull(aula);
	}

	@Test
	public void verificarTamanhoDaListadeAulaTest() {
		Aula aI = new Aula("Pesquisar sobre a Ead", " P-01 ");
		gestor.cadastrarAula(aI);
		Aula aII = new Aula("Pesquisar sobre a Ead", " P-02 ");
		gestor.cadastrarAula(aII);
		Aula aIII = new Aula("Pesquisar sobre a Ead", " P-03 ");
		gestor.cadastrarAula(aIII);
		Aula aIV = new Aula("Pesquisar sobre a Ead", " P-04 ");
		gestor.cadastrarAula(aIV);
		Aula aV = new Aula("Pesquisar sobre a Ead", " P-05 ");
		gestor.cadastrarAula(aV);
		gestor.removerAula(" P-05 ");
		List<Aula> listTarefa = gestor.getListaDeAulasCadastradas();
		assertEquals(4, listTarefa.size());
	}

	public void removerAulaDoGrupoDiscursaoTest()
			throws GrupoDiscursaoJaExisteException, GrupoDiscursaoJaExisteException {
		Aula a = new Aula("Enviar Exercio ao Modle", "05");
		gestor.cadastrarAula(a);
		GrupoDiscursao gd = new GrupoDiscursao("0000-1");
		gestor.cadastrarGrupoDiscursao(gd);
		Aula a1 = gestor.pesquisaAula("05");
		GrupoDiscursao gd1 = gestor.pesquisarGrupo("0000-1");
		gestor.adicionarAulaAoGrupo(a1, gd1);
		gestor.removerAulaDoGrupoDiscursao(a1, gd1);
		List<Aula> aulas = gestor.getListaDeAulasCadastradasPorGrupo(gd1);
		assertEquals(0, aulas.size());
	}

	// Arquivo 5
	@Test(expected = ArquivoInexistenteException.class)
	public void naoCriarArquivoNulo() {
		Arquivo aq = new Arquivo(null, null);
		assertEquals(aq, null);
	}
	
	@Test
	public void cadastrarArquivoTest() throws Exception {
		Arquivo a = new Arquivo("Segundo dia de aula", "0002");
		gestor.cadastrarArquivos(a);
		List<Arquivo> listArquivos = gestor.getListaDeArquivos();
		assertEquals(1, listArquivos.size());
	}
	
	@Test
	public void verificaArquivoCadastradaNaLista() throws Exception {
		Arquivo a = new Arquivo("Primeiro dia de aula", "0001");
		gestor.cadastrarArquivos(a);
		List<Arquivo> listArquivos = gestor.getListaDeArquivos();
		assertEquals(a, listArquivos.get(0));
	}

	@Test
	public void removerArquivosTest() {
		Arquivo aq = new Arquivo("Tablets Nas Escolas Publicas.pdf",
				"MEC-19823-01");
		gestor.cadastrarArquivos(aq);
		gestor.removerArquivo("MEC-19823-01");
		List<Arquivo> lista = gestor.getListaDeArquivos();
		assertEquals(1, lista.size());
	}

	@Test
	public void pesquisarArquivosNoForumTest() {
		Arquivo aq = new Arquivo("Tablets Nas Escolas Publicas.pdf",
				"MEC-19823-01");
		gestor.cadastrarArquivos(aq);
		Arquivo arq = gestor.pesquisarArquivos("MEC-19823-01");
		assertEquals(aq, arq);
	}

	@Test(expected = ArquivoInexistenteException.class)
	public void removerArquivoInexistenteTest() {
		Arquivo aq = new Arquivo("Tablets Nas Escolas Publicas.pdf",
				"MEC-19823-01");
		gestor.cadastrarArquivos(aq);
		gestor.pesquisarArquivos("MEC-19823-01");
		gestor.removerArquivo("MEC-19823");

	}

	@Test(expected = ArquivoInexistenteException.class)
	public void pesquisarArquivoInexistenteNoGrupoTest() {
		Arquivo aq = new Arquivo(" Notebook.wma ", " MEC-00000-0 ");
		gestor.cadastrarArquivos(aq);
		gestor.pesquisarArquivos(" MEC-00000-00000 ");
	}

	@Test
	public void pesquisarArquivoCadastradoPeloNomeNoGrupo()
			throws ArquivoInexistenteException {
		Arquivo a = new Arquivo("Tablets Nas Escolas.pdf", "MEC-0988776-01");
		gestor.cadastrarArquivos(a);
		assertEquals(a,
				gestor.removerArquivoPeloNome("Tablets Nas Escolas.pdf"));
	}

}
// tagXIV