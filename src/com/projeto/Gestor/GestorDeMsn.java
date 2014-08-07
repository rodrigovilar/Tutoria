package com.projeto.Gestor;

import java.util.ArrayList;
import java.util.List;

import com.projeto.Entidades.Aluno;
import com.projeto.Negocios.Mensagem;

public class GestorDeMsn {

	private List<Mensagem> mensagens = new ArrayList<>();

	public void enviarMensagem(Aluno origem, Aluno destino, String texto) {

		Mensagem mensagem = new Mensagem();
		mensagem.setDestino(destino);
		mensagem.setOrigem(origem);
		mensagem.setTexto(texto);

		mensagens.add(mensagem);
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public boolean finalizou() {
		return false;
	}

}
