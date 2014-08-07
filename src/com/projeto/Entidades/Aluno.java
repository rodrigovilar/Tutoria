package com.projeto.Entidades;

import com.projeto.Exception.ExcecaoIllegalArgumentException;

public class Aluno extends Pessoa {

	private String curso;

	public Aluno(String nome, String matricula) {
		super(nome, matricula);
		if (nome == null && matricula == null) {
			throw new ExcecaoIllegalArgumentException(
					"Aluno nao pode ser nulo!");
		}

	}

	public Aluno(String nome, String matricula, String curso) {
		super(nome, matricula);
		this.curso = curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
		// TODO Auto-generated method stub

	}

	public String getCurso() {
		return curso;
	}

}