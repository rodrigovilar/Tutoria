package com.projeto.facade;

public interface AssinaturaDosMetodos {
	void enviarMensagem();

	void cadastrarTutor();

	void pesquisarTutorPeloId();

	void removeTutorPeloId();

	void cadastrarAluno();

	void cadastrarAlunosParticipantes();

	void pesquisaAlunoPeloNome();

	void pesquisarAlunoPelaMatricula();

	void removerAlunoPelaMatricula();

	void cadastrarArquivos();

	void removerAulaDoGrupoDiscursao();

	void cadastrarGrupoDiscursao();

	void pesquisarGrupo();

	void adicionarAulaAoGrupo();

	void pesquisaAula();

	void removerAula();

	void removerArquivo();

	void removerArquivoPeloNome();

	void pesquisarArquivos();
}
