package com.projeto.tutoria;

public class Aula {
	private String descrição;
	private String IdDevere;

	public Aula(String descrição, String idDevere) {
		super();
		this.descrição = descrição;
		IdDevere = idDevere;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public String getIdDevere() {
		return IdDevere;
	}

	public void setIdDevere(String idDevere) {
		IdDevere = idDevere;
	}

}
