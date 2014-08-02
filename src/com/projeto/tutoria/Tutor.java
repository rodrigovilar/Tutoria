package com.projeto.tutoria;

public class Tutor extends Pessoa {
	private String senha;

	public Tutor(String nome, String idTutor) {
		super(nome, idTutor);
	}

	public String getDescricao() {
		return "Nome: " + super.getNome() + " | SIAPE: " + super.getMatricula();
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
