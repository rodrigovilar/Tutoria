package com.projeto.tutoria;

import java.util.List;

public class CadastrosEGerenciaDosArquivosELivros {
	private GestorAuxiliarParaSistema gestorAux = new GestorAuxiliarParaSistema();
	
	
	
	
	
	public void removerAulaDoGrupoDiscursao(Aula a, GrupoDiscursao gd){
		this.gestorAux.removerAulaDoGrupoDiscursao(a, gd);
	}
	
	public List<Aula> getListaDeAulasCadastradas() {
		return this.gestorAux.getListaDeAulasCadastradas();
	}
	
	public List<GrupoDiscursao> getListaDeGruposNoForum(){
		return this.gestorAux.getListaDeGruposNoForum();
	}
	/*
	public List <Arquivo> getArquivos (){
		return this.gestorAux.getListaDeMateriais();
	}
	
	public void removerArquivos(String IdArquivo){
		this.gestorAux.r
	}
*/
}
