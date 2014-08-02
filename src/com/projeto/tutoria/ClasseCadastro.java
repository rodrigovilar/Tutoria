package com.projeto.tutoria;

import java.util.List;

public class ClasseCadastro {

	private GestorAuxiliarParaSistema gestorAux = new GestorAuxiliarParaSistema();

	public void cadastraAluno(Aluno aluno) {
		this.gestorAux.cadastrarAluno(aluno);
	}

	public List<Aluno> getListaDeAlunosCriados() {
		// TODO Auto-generated method stub
		return this.gestorAux.getListaDeAlunosCadastrados();
	}

}
