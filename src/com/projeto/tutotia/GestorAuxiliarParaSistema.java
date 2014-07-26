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
}
