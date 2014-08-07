package com.projeto.facade;

import java.util.ArrayList;
import java.util.List;

import com.projeto.negocios.Aluno;
import com.projeto.negocios.Mensagem;

public class GestorAuxiliarParaSistema {

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
