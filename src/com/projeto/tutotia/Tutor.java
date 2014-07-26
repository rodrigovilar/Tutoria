package com.projeto.tutotia;

public class Tutor extends Pessoa{
	
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

}
