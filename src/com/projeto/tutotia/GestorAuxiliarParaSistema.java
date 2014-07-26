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

}
