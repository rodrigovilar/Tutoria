package com.projeto.facade;

import java.util.LinkedList;
import java.util.List;

import com.projeto.exception.GrupoDiscurssaoJaExisteException;
import com.projeto.negocios.Aluno;
import com.projeto.negocios.Aula;
import com.projeto.negocios.GrupoDiscussao;

public class GestorDeGrupo {
	private List<GrupoDiscussao> gruposd = new LinkedList<GrupoDiscussao>();
	
	public boolean finalizou() {
		return false;
	}
	
	public List<GrupoDiscussao> getListaDeGruposCadastrados() {
		return this.gruposd;
	}

	public void cadastrarGrupoDiscursao(GrupoDiscussao grupod)
			throws GrupoDiscurssaoJaExisteException {
		boolean existe = false;

		for (GrupoDiscussao g : this.gruposd) {
			if (g.getiDGrupo().equals(grupod.getiDGrupo())) {
				throw new GrupoDiscurssaoJaExisteException("Grupo Existente");

			}
		}
		if (!existe) {
			this.gruposd.add(grupod);
		} else {
			throw new GrupoDiscurssaoJaExisteException("Grupo Existente");
		}
	}
	
	public GrupoDiscussao pesquisarGrupo(String iDcodigo)
			throws GrupoDiscurssaoJaExisteException {
		for (GrupoDiscussao g : this.gruposd) {
			if (g.getiDGrupo().equals(iDcodigo)) {
				return g;
			}
		}
		throw new GrupoDiscurssaoJaExisteException("Grupo Existente");

	}

	public void adicionarAulaAoGrupo(Aula aula, GrupoDiscussao gd) {
		gd.addAula(aula);

	}
	
	public void cadastrarAlunosParticipantes(Aluno al, GrupoDiscussao gd) {
		gd.cadastrarAlunosParticipantes(al);

	}


}
