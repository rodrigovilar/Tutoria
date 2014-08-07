package com.projeto.facade;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.projeto.exception.*;
import com.projeto.negocios.*;

public class GestorAuxiliarParaSistema {

	private List<Arquivo> arquivos = new LinkedList<Arquivo>();
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

	/*public void cadastrarAlunosParticipantes(Aluno al, GrupoDiscussao gd) {
		gd.cadastrarAlunosParticipantes(al);

	}
*/
	public void cadastrarArquivos(Arquivo arquivo) {
		this.arquivos.add(arquivo);

	}

	public List<Arquivo> getListaDeArquivos() {

		return arquivos;
	}

	public void removerArquivo(String iDArquivo)
			throws ArquivoInexistenteException {
		boolean removeu = false;
		for (Arquivo a : this.arquivos) {
			if (a.getIdArquivo().equals(iDArquivo)) {
				this.arquivos.remove(a);
				removeu = true;
				break;
			}
		}
		if (!removeu) {
			throw new ArquivoInexistenteException("");
		}

	}

	public Arquivo removerArquivoPeloNome(String nome) {
		for (Arquivo a : this.arquivos) {
			if (a.getNome().equals(nome)) {
				return a;
			}
		}
		throw new ArquivoInexistenteException("Arquivo Nao Existe");
	}

	public Arquivo pesquisarArquivos(String iDArquivo)
			throws ArquivoInexistenteException {
		for (Arquivo arquivo : this.arquivos) {
			if (arquivo.getIdArquivo().equals(iDArquivo)) {
				return arquivo;
			}
		}
		throw new ArquivoInexistenteException("iDArquivo Inexistente");
	}

}
