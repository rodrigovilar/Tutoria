package com.projeto.tutoria;

import java.util.LinkedList;
import java.util.List;

public class CadastrosEGerenciaDosArquivosELivros {
	private List<Arquivos> arquivos = new LinkedList<Arquivos>();
	
	
	public void cadastrarArquivo(Arquivos arquivo){
		this.arquivos.add(arquivo);
	}

}
