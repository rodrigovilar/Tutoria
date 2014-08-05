package com.projeto.negocios;

import com.projeto.exception.ExcecaoIllegalArgumentException;

public class Aula {
	private String descrição;
	private String IdAula;

	public Aula(String descrição, String idAula) {
		super();
		this.descrição = descrição;
		IdAula = idAula;
		if (descrição == null && idAula == null) {
			throw new ExcecaoIllegalArgumentException("Aula não pode ser Nulo");
		}
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public String getIdAula() {
		return IdAula;
	}

	public void setIdAula(String idAula) {
		IdAula = idAula;
	}

}
