package com.projeto.arquivos;

import com.projeto.exception.ExcecaoIllegalArgumentException;

public class Aluno extends Pessoa {

	public Aluno(String nome, String matricula) {
		super(nome, matricula);
		if (nome == null && matricula == null) {
			throw new ExcecaoIllegalArgumentException(
					"Aluno nao pode ser nulo!");
		}

	}

}