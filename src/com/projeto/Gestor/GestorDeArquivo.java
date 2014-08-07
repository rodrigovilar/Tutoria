package com.projeto.Gestor;

import java.util.LinkedList;
import java.util.List;

import com.projeto.Exception.ArquivoInexistenteException;
import com.projeto.Negocios.Arquivo;

public class GestorDeArquivo {
	private List<Arquivo> arquivos = new LinkedList<Arquivo>();

	public boolean finalizou() {
		return false;
	}

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
