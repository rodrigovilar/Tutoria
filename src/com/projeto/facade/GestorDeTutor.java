package com.projeto.facade;

import java.util.LinkedList;
import java.util.List;

import com.projeto.exception.TutorDuplicadoException;
import com.projeto.exception.TutorExistenteException;
import com.projeto.exception.TutorInexistenteException;
import com.projeto.negocios.Tutor;

public class GestorDeTutor {

	public boolean finalizou() {
		return false;
	}

	private List<Tutor> tutores;

	public GestorDeTutor() {

		tutores = new LinkedList<Tutor>();
	}

	public void cadastrarTutor(Tutor tutorNovo) throws TutorExistenteException,
			TutorInexistenteException {
		boolean existe = false;
		for (Tutor tutorAntigo : this.tutores) {
			if (tutorAntigo.getMatricula().equals(tutorNovo.getMatricula())
					|| tutorAntigo.getNome().equals(tutorNovo.getNome())) {
				existe = true;
				throw new TutorDuplicadoException("TutorDuplicadoException");
			}
		}
		if (existe == false) {
			this.tutores.add(tutorNovo);
		} else {
			throw new TutorExistenteException("Tutor Existente");
		}
	}

	public void cadastraTutor(Tutor tut) {
		this.tutores.add(tut);

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

	public void removeTutorPeloId(String id) throws Exception {
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

	public List<Tutor> getListaDeTutores() {

		return tutores;
	}

}
