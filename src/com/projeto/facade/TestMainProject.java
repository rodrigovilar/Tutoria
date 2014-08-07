package com.projeto.facade;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.*;

import com.projeto.exception.*;
import com.projeto.negocios.*;

public class TestMainProject {
	private GestorAuxiliarParaSistema gestor;
	private GestorDeTutor gestort = new GestorDeTutor();

	@Before
	public void iniciarTest() {
		this.gestor = new GestorAuxiliarParaSistema();
		assertFalse("O sistema de tutoria iniciou acabado", gestor.finalizou());
	}

	// Tutor
	@Test(expected = ExcecaoIllegalArgumentException.class)
	public void naoCriarTutorNulo() {
		Tutor t = new Tutor(null, null);
		assertEquals(t, null);
	}

	@Test
	public void verificarListaDeTutorVaziaTest() {
		List<Tutor> listTutor = gestort.getListaDeTutores();
		assertEquals(0, listTutor.size());
	}

	@Test
	public void cadastrarTutorNoSistemaTest() throws Exception {
		Tutor tut = new Tutor("Otaciso", "12345");
		gestort.cadastrarTutor(tut);
		List<Tutor> listTut = gestort.getListaDeTutores();
		assertEquals(1, listTut.size());
	}

	@Test
	public void verificaTutorCadastradoNaLista() throws Exception {
		Tutor tut = new Tutor("Otaciso", "12345");
		gestort.cadastrarTutor(tut);
		List<Tutor> listTut = gestort.getListaDeTutores();
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
		gestort.cadastrarTutor(t);
		assertEquals(t, gestort.pesquisarTutorPeloId("12345"));
	}

	@Test
	public void removerTutorPeloIdTest() throws Exception {
		Tutor tutor = new Tutor("Otaciso", "12345");
		gestort.cadastrarTutor(tutor);
		gestort.removeTutorPeloId("12345");
	}

	@Test(expected = TutorDuplicadoException.class)
	public void cadastrarMesmoTutorTest() throws Exception {
		Tutor tu1 = new Tutor("Otaciso", "123.456.789.01");
		Tutor tu2 = new Tutor("Otaciso", "123.456.789.01");
		gestort.cadastrarTutor(tu1);
		gestort.cadastrarTutor(tu2);
	}

	@Test(expected = TutorDuplicadoException.class)
	public void cadastrarTutorComMesmaMatriculaTest() throws Exception {
		Tutor t1 = new Tutor("Otaciso", "123.456");
		Tutor t2 = new Tutor("Daniel", "123.456");
		gestort.cadastrarTutor(t1);
		gestort.cadastrarTutor(t2);
	}

	@Test(expected = TutorInexistenteException.class)
	public void removerTutorInexistenteTest() throws Exception {
		Tutor tutor = new Tutor("Thiego", "12345");
		gestort.cadastrarTutor(tutor);
		gestort.removeTutorPeloId("54321");
	}

	@Test
	public void verificarSizeListadeTutoresCadastradosTest() throws Exception {
		Tutor t1 = new Tutor("Mateus", "11111");
		Tutor t2 = new Tutor("Kaué", "22222");
		Tutor t3 = new Tutor("Otaciso", "333333");
		Tutor t4 = new Tutor("Thiego", "444444");
		Tutor t5 = new Tutor("Daniel", "555555");
		gestort.cadastrarTutor(t1);
		gestort.cadastrarTutor(t2);
		gestort.cadastrarTutor(t3);
		gestort.cadastrarTutor(t4);
		gestort.cadastrarTutor(t5);
		List<Tutor> listaTut = gestort.getListaDeTutores();
		assertEquals(5, listaTut.size());
	}

	@Test
	public void removerTutoresCadastrados() throws Exception {
		Tutor tI = new Tutor(" OtacisoEu1 ", "813011053");
		Tutor tII = new Tutor(" OtacisoTu2 ", " 813011054 ");
		Tutor tIII = new Tutor(" OtacisoNos3 ", " 813011055 ");
		Tutor tIV = new Tutor(" OtacisoVois4 ", " 813011056 ");
		Tutor tV = new Tutor(" OtacisoEles5 ", " 813011057 ");
		gestort.cadastrarTutor(tI);
		gestort.cadastrarTutor(tII);
		gestort.cadastrarTutor(tIII);
		gestort.cadastrarTutor(tIV);
		gestort.cadastrarTutor(tV);
		gestort.removeTutorPeloId(tI.getMatricula());
		gestort.removeTutorPeloId(tII.getMatricula());
		gestort.removeTutorPeloId(tIII.getMatricula());
		gestort.removeTutorPeloId(tIV.getMatricula());
		gestort.removeTutorPeloId(tV.getMatricula());
		List<Tutor> listaTut = gestort.getListaDeTutores();
		assertEquals(0, listaTut.size());

	}

	@Test(expected = TutorInexistenteException.class)
	public void pesquisarTutorInexistenteTest() throws Exception {
		Tutor t = new Tutor("Oscar", "12345");
		gestort.cadastrarTutor(t);
		gestort.pesquisarTutorPeloId("00000");
	}

	// Aluno 2
	@Test(expected = ExcecaoIllegalArgumentException.class)
	public void naoCriarAlunoNulo() {
		Aluno a = new Aluno(null, null);
		assertEquals(a, null);
	}

	@Test
	public void verificarListaDeAlunoVaziaTest() {
		List<Aluno> listAluno = gestor.getListaDeAlunosCadastrados();
		assertEquals(0, listAluno.size());
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
		assertEquals(0, alunosCadastrados.size());
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
		GrupoDiscussao g = new GrupoDiscussao(null, null);
		assertEquals(g, null);
	}

	@Test
	public void cadastrarGrupoTest() throws GrupoDiscurssaoJaExisteException,
			GrupoDiscurssaoJaExisteException {
		Aula aula = new Aula("Aula de Login do Tablet", "01");
		gestor.cadastrarAula(aula);
		GrupoDiscussao grupo = new GrupoDiscussao(aula, "A-01");
		gestor.cadastrarGrupoDiscursao(grupo);
		assertEquals(grupo, gestor.pesquisarGrupo("A-01"));
	}

	public void verificarListaGrupoDiscurssaoCadastradoVaziaTest() {
		List<GrupoDiscussao> listGrupo = gestor.getListaDeGruposCadastrados();
		assertEquals(0, listGrupo.size());
	}

	@Test
	public void verificaGrupoDiscurssaoCadastradoNaLista() throws Exception {
		Aula aula = new Aula("Aula de Instalação de App", "-01");
		gestor.cadastrarAula(aula);
		GrupoDiscussao grupo = new GrupoDiscussao(aula, "X-01");
		gestor.cadastrarGrupoDiscursao(grupo);
		List<GrupoDiscussao> listgd = gestor.getListaDeGruposCadastrados();
		assertEquals(grupo, listgd.get(0));
	}

	@Test(expected = GrupoDiscurssaoJaExisteException.class)
	public void cadastrarGrupoDiscursaoComMesmoCodigoTest()
			throws GrupoDiscurssaoJaExisteException {
		Aula aula = new Aula("Acessar a plataforma EAD pelo tablet", "02");
		gestor.cadastrarAula(aula);
		GrupoDiscussao grupod = new GrupoDiscussao(aula, "A-02");
		gestor.cadastrarGrupoDiscursao(grupod);
		Aula aulaII = new Aula("Enviar Exercio ao Modle", "03");
		gestor.cadastrarAula(aulaII);
		GrupoDiscussao grupod2 = new GrupoDiscussao(aula, "A-02");
		gestor.cadastrarGrupoDiscursao(grupod2);
	}

	@Test
	public void verificarQuantidadeDeGrupoDiscursaoPorAssuntoNoForumTest()
			throws GrupoDiscurssaoJaExisteException {
		Aula aI = new Aula("Acessar a plataforma EAD pelo tablet", "02");
		gestor.cadastrarAula(aI);
		GrupoDiscussao grupoD_I = new GrupoDiscussao(aI, "Grupo I");
		gestor.cadastrarGrupoDiscursao(grupoD_I);
		Aula aII = new Aula("Enviar Exercio ao Modle", "03");
		gestor.cadastrarAula(aII);
		GrupoDiscussao grupoD_II = new GrupoDiscussao(aII, "Grupo II");
		gestor.cadastrarGrupoDiscursao(grupoD_II);
		Aula aIII = new Aula("Aula de Login do Tablet", "01");
		gestor.cadastrarAula(aIII);
		GrupoDiscussao grupoD_III = new GrupoDiscussao(aIII, "Grupo III");
		gestor.cadastrarGrupoDiscursao(grupoD_III);
		Aula aIV = new Aula("Acessar aulas no moodle", "04");
		gestor.cadastrarAula(aIV);
		GrupoDiscussao grupoD_IV = new GrupoDiscussao(aIV, "Grupo IV");
		gestor.cadastrarGrupoDiscursao(grupoD_IV);
		List<GrupoDiscussao> qtdGrupoCadastrados = gestor
				.getListaDeGruposCadastrados();
		assertEquals(4, qtdGrupoCadastrados.size());
	}

	@Test
	public void cadastrarAlunoNoGrupoDiscurssaoTest() {
		Aula al = new Aula("Aula de Login do Tablet", "01");
		GrupoDiscussao gd = new GrupoDiscussao(al, " 05 ");
		gestor.cadastrarGrupoDiscursao(gd);
		Aluno aI = new Aluno(" Daniel ", " 011053 ");
		Aluno aII = new Aluno(" Thiego ", " 011054 ");
		gestor.cadastrarAlunosParticipantes(aI, gd);
		gestor.cadastrarAlunosParticipantes(aII, gd);
		List<Aluno> alunosParticipantes = gd.listaDeAlunosParticipantes();
		assertEquals(2, alunosParticipantes.size());
		assertEquals(aI, alunosParticipantes.get(0));
		assertEquals(aII, alunosParticipantes.get(1));
	}

	@Test(expected = AlunoDuplicadoException.class)
	public void cadastrarAlunoDuplicadoNoGrupoTest() {
		Aluno alI = new Aluno(" Otaciso ", " 81011053");
		Aluno alII = new Aluno(" Otaciso ", " 81011053");
		gestor.cadastrarAluno(alI);
		gestor.cadastrarAluno(alII);
		Aluno aII = gestor.pesquisaAlunoPeloNome(" Otaciso ");
		Aluno aIII = gestor.pesquisaAlunoPeloNome(" Otaciso ");
		Aula aulaI = new Aula("Aula de Login do Tablet com senha", " 02 ");
		Aula aulaII = new Aula("Aula de Login do Tablet com senha e nome",
				" 03 ");
		GrupoDiscussao gdI = new GrupoDiscussao(aulaI, " 02 ");
		GrupoDiscussao gdII = new GrupoDiscussao(aulaII, " 03 ");
		gestor.cadastrarAlunosParticipantes(aII, gdI);
		gestor.cadastrarAlunosParticipantes(aIII, gdII);
	}

	@Test
	public void trocarMensagensEntreAlunosnoGrupo() {
		Aula aula = new Aula("Aula de Login do Tablet", "01");
		gestor.cadastrarAula(aula);
		GrupoDiscussao grupo = new GrupoDiscussao(aula, "A-01");
		gestor.cadastrarGrupoDiscursao(grupo);
		assertEquals(grupo, gestor.pesquisarGrupo("A-01"));
		Aluno aluno1 = new Aluno(" Otaciso ", "81011053");
		Aluno aluno2 = new Aluno(" Thiego ", "81011052");
		gestor.enviarMensagem(aluno1, aluno2, "Quer tc?");
		List<Mensagem> resultado = gestor.getMensagens();
		Assert.assertEquals(1, resultado.size());
		Mensagem mensagemSalva = resultado.get(0);
		Assert.assertEquals(aluno1, mensagemSalva.getOrigem());
		Assert.assertEquals(aluno2, mensagemSalva.getDestino());
		Assert.assertEquals("Quer tc?", mensagemSalva.getTexto());
	}

	// Aula 4
	@Test(expected = ExcecaoIllegalArgumentException.class)
	public void naoCriarAulaNulo() {
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
	public void verificarListaDeAulaVaziaTest() {
		List<Aula> listAula = gestor.getListaDeAulasCadastradas();
		assertEquals(0, listAula.size());
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
			throws GrupoDiscurssaoJaExisteException {
		Aula a = new Aula("Enviar Exercio ao Modle", "03");
		gestor.cadastrarAula(a);
		GrupoDiscussao gd = new GrupoDiscussao(a, "A-03");
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
			throws GrupoDiscurssaoJaExisteException,
			GrupoDiscurssaoJaExisteException {
		Aula a = new Aula("Enviar Exercio ao Modle", "05");
		gestor.cadastrarAula(a);
		GrupoDiscussao gd = new GrupoDiscussao("0000-1");
		gestor.cadastrarGrupoDiscursao(gd);
		Aula a1 = gestor.pesquisaAula("05");
		GrupoDiscussao gd1 = gestor.pesquisarGrupo("0000-1");
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
	public void verificarListaDeArquivoVaziaTest() {
		List<Arquivo> listArquivo = gestor.getListaDeArquivos();
		assertEquals(0, listArquivo.size());
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