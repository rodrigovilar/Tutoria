package com.projeto.Negocios;

import com.projeto.Entidades.Aluno;


public class Mensagem {

	private Aluno destino;
	private Aluno origem;
	private String texto;

	public void setDestino(Aluno destino) {
		this.destino = destino;
		
	}

	public void setOrigem(Aluno origem) {
		this.origem = origem;
		
	}

	public void setTexto(String texto) {
		this.texto = texto;
		
	}

	public Aluno getDestino() {
		return destino;
	}

	public Aluno getOrigem() {
		return origem;
	}

	public String getTexto() {
		return texto;
	}


}
