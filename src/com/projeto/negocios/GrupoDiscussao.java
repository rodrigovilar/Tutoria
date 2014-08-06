package com.projeto.negocios;

import java.util.LinkedList;
import java.util.List;

import com.projeto.exception.AlunoExistenteException;
import com.projeto.exception.ExcecaoIllegalArgumentException;

public class GrupoDiscussao {
	private List<Aula> aulas = new LinkedList<Aula>();
	private String iDGrupo;
	private List<Aluno> alunosParticipantes = new LinkedList<Aluno>();

	public GrupoDiscussao(Aula aula, String iDGrupo) {
		aulas.add(aula);
		this.iDGrupo = iDGrupo;
		if (aula == null && iDGrupo == null) {
			throw new ExcecaoIllegalArgumentException(
					"Aluno nao pode ser nulo!");
		}

	}

	public GrupoDiscussao(String iDGrupo) {
		aulas = new LinkedList<Aula>();
		this.iDGrupo = iDGrupo;
		this.alunosParticipantes = new LinkedList<Aluno>();
	}

	public void removerTarefa(Aula aul) {
		this.aulas.remove(aul);

	}

	public void addAula(Aula aula) {
		this.aulas.add(aula);

	}

	public String getiDGrupo() {
		return this.iDGrupo;
	}

	public void cadastrarAlunosParticipantes(Aluno adicionarAluno) {
		for (Aluno alun : this.alunosParticipantes) {
			if (alun.equals(adicionarAluno)) {
				throw new AlunoExistenteException("AlunoExistenteException!");
			}
		}
		this.alunosParticipantes.add(adicionarAluno);

	}

	public List<Aluno> alunosParticipa() {
		return this.alunosParticipantes;
	}

	public List<Aula> listAulas() {
		return this.aulas;
	}

	public Aluno pesquisaAlunosParticipantes(String ap) {
		for (Aluno a : this.alunosParticipantes) {
			if (a.getMatricula().equals(ap)) {
				return a;
			}
		}
		return null;
	}

	public List<Aluno> listaDeAlunosParticipantes() {
		return this.alunosParticipantes;
	}

	public Aula pesquisaAula(String pa) {
		for (Aula a : this.aulas) {
			if (a.toString().equalsIgnoreCase(pa)) {
				return a;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "GrupoDiscursao [aulas=" + aulas + ", iDGrupo=" + iDGrupo
				+ ", alunosParticipantes=" + alunosParticipantes + "]";
	}

	public void add(Aluno aluno) {
		this.alunosParticipantes.add(aluno);

	}

}
