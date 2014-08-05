 package com.projeto.negocios;

import com.projeto.exception.ExcecaoIllegalArgumentException;


public class Tutor extends Pessoa {
	private String senha;

	public Tutor(String nome, String idTutor) {
		super(nome, idTutor);
		if (nome == null && idTutor == null) {
			throw new ExcecaoIllegalArgumentException("Tutor nao pode ser nulo!");
		}
	}

	public String getDescricao() {
		return "Nome: " + super.getNome() + " | idTutor: " + super.getMatricula();
	}

	@Override
	public String toString() {
		return "Tutor [getNome()=" + getNome() + ", getMatricula()="
				+ getMatricula() + "]";
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
