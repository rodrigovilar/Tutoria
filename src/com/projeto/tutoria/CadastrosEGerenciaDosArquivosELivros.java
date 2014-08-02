package com.projeto.tutoria;

import java.util.LinkedList;
import java.util.List;

public class CadastrosEGerenciaDosArquivosELivros {
	private List<Arquivos> arquivos = new LinkedList<Arquivos>();
	private GestorAuxiliarParaSistema gestorAux = new GestorAuxiliarParaSistema();
	
	
	
	public void cadastrarArquivo(Arquivos arquivo){
		this.arquivos.add(arquivo);
	}
	
	public void removerAulaDoGrupoDiscursao(Aula a, GrupoDiscursao gd){
		this.gestorAux.removerAulaDoGrupoDiscursao(a, gd);
	}
	
	public List<Aula> getListaDeAulasCadastradas() {
		return this.gestorAux.getListaDeAulasCadastradas();
	}

}
