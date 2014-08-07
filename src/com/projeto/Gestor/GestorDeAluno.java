package com.projeto.Gestor;

import java.util.LinkedList;
import java.util.List;

import com.projeto.Entidades.Aluno;
import com.projeto.Exception.AlunoDuplicadoException;
import com.projeto.Exception.AlunoExistenteException;
import com.projeto.Exception.AlunoInexistenteException;
import com.projeto.Exception.GrupoDiscurssaoJaExisteException;

public class GestorDeAluno {

	public boolean finalizou() {
		return false;
	}

	private List<Aluno> alunos;

	public GestorDeAluno() {

		alunos = new LinkedList<Aluno>();
	}

	public void cadastrarAluno(Aluno alunos)
			throws GrupoDiscurssaoJaExisteException {
		boolean existe = false;
		for (Aluno aluno : this.alunos) {

			if (aluno.getMatricula().equals(aluno.getMatricula())) {
				existe = true;
				throw new AlunoDuplicadoException();
			}
		}

		if (existe == false) {
			this.alunos.add(alunos);
		} else {
			throw new AlunoExistenteException("Aluno Existente!");
		}

	}

	public Aluno pesquisaAlunoPeloNome(String nome)
			throws AlunoInexistenteException {
		for (Aluno alu : this.alunos) {
			if (alu.getNome().equals(nome)) {
				return alu;
			}
		}
		throw new AlunoInexistenteException("Aluno Inexistente");
	}

	public Aluno pesquisarAlunoPelaMatricula(String matricula)
			throws AlunoInexistenteException {
		for (Aluno aluno1 : this.alunos) {
			if (aluno1.getMatricula().equals(matricula)) {
				return aluno1;
			}
		}
		throw new AlunoInexistenteException("Aluno Inexistente");
	}

	public void removerAlunoPelaMatricula(String matricula) {
		boolean removeu = false;
		for (Aluno a : this.alunos) {
			if (a.getMatricula().equals(matricula)) {
				this.alunos.remove(a);
				removeu = true;
				break;
			}
		}
		if (removeu == false) {
			throw new AlunoInexistenteException("Aluno não existe!");
		}

	}

	public void add(Aluno aluno) {
		alunos.add(aluno);
	}

	public List<Aluno> getAluno() {
		return alunos;
	}

	public List<Aluno> getListaDeAlunosCadastrados() {

		return alunos;
	}

}
