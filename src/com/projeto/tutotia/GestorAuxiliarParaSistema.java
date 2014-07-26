package com.projeto.tutotia;

import java.util.LinkedList;
import java.util.List;

public class GestorAuxiliarParaSistema {
	private List<Tutor> tutores = new LinkedList<Tutor>();
	private List<Aluno> alunos = new LinkedList<Aluno>();

	public boolean finalizou() {
		return false;
	}

	public void cadastraTutor(Tutor tut) throws Exception {
		boolean existe = false;
		for (Tutor tut1 : this.tutores) {
			if (tut1.getMatricula().equals(tut.getMatricula())) {
				existe = true;
				break;
			}
		}
		if (existe == false) {
			this.tutores.add(tut);
		} else {
			throw new TutorExistenteException("Tutor Existente");
		}
	}

	public List<Tutor> getListaDeTutor() {

		return this.tutores;
	}

	public Tutor pesquisarTutorPeloId(String id)
			throws TutorInexistenteException {
		for (Tutor t : this.tutores) {
			if (t.getMatricula().equals(id)) {
				return t;
			}
		}
		throw new TutorInexistenteException("Tutor Inexistente");
	}

	public void removeTutorPeloId(String id) throws TutorInexistenteException {
		boolean removeu = false;
		for (Tutor t : this.tutores) {
			if (t.getMatricula().equals(id)) {
				this.tutores.remove(t);
				removeu = true;
				break;
			}
		}
		if (removeu == false) {
			throw new TutorInexistenteException("Tutor não existe!");
		}

	}

	// Aluno
	public void cadastrarAluno(Aluno alunos) {
		boolean existe = false;
		for (Aluno aluno : this.alunos) {
			if (aluno.getMatricula().equals(aluno.getMatricula())) {
				existe = true;
				break;
			}
		}
		if (existe == false) {
			this.alunos.add(alunos);
		} else {
			throw new AlunoExistenteException("Aluno Existente!");
		}
	}

	public List<Aluno> getListaDeAlunosCriados() {

		return this.alunos;
	}

	public Aluno pesquisaAlunoPeloNome(String nome) throws AlunoInexistenteException {
		for (Aluno alu : this.alunos) {
			if (alu.getNome().equals(nome)) {
				return alu;
			}
		}
		throw new AlunoInexistenteException("Aluno Inexistente");
	}
}
