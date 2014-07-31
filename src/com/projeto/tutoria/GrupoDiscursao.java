package com.projeto.tutoria;

import java.util.LinkedList;
import java.util.List;

public class GrupoDiscursao {
	private List<Aula> aulas = new LinkedList<Aula>();
	private String iDGrupo;
	private List<Aluno> alunosParticipantes = new LinkedList<Aluno>();

	public GrupoDiscursao(Aula aula, String iDGrupo) {
		aulas.add(aula);
		this.iDGrupo = iDGrupo;

	}

	public GrupoDiscursao(String iDGrupo) {
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

	public void cadastrarAlunosParticipantes(Aluno a1) {
		for (Aluno a : this.alunosParticipantes) {
			if (a.equals(a1)) {
				throw new RuntimeException("ERRO!");
			}
		}
		this.alunosParticipantes.add(a1);

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


	
}
