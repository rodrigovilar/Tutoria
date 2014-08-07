package com.projeto.facade;

import java.util.LinkedList;
import java.util.List;

import com.projeto.negocios.Aula;
import com.projeto.negocios.GrupoDiscussao;

public class GestorDeAula {

	private List<Aula> aulas = new LinkedList<Aula>();

	public boolean finalizou() {
		return false;
	}
	
	public void cadastrarAula(Aula aula) {
		this.aulas.add(aula);

	}

	public List<Aula> getListaDeAulasCadastradas() {

		return aulas;
	}
	
	public List<Aula> getListaDeAulasCadastradasPorGrupo(GrupoDiscussao gd1) {

		return aulas;
	}

	public void removerAulaDoGrupoDiscursao(Aula a1, GrupoDiscussao gd1) {
		this.aulas.remove(0).getIdAula();

	}
	public Aula pesquisaAula(String iDAul) {
		for (Aula aa : this.aulas) {
			if (aa.getIdAula().equals(iDAul)) {
				return aa;
			}
		}
		return null;
	}
	
	public void removerAula(String iDAula) {
		boolean removeu = false;
		for (Aula a : this.aulas) {
			if (a.getIdAula().equals(iDAula)) {
				this.aulas.remove(a);
				removeu = true;
				break;
			}
		}
		if (!removeu) {
			throw new RuntimeException("ERRO!");
		}
	}

	


}
