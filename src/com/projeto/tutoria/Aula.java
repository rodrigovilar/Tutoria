package com.projeto.tutoria;

public class Aula {
	private String descrição;
	private String IdAula;
	

	public Aula(String descrição, String idDevere) {
		super();
		this.descrição = descrição;
		IdAula = idDevere;
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

	public void setIdDevere(String idDevere) {
		IdAula = idDevere;
	}

}
