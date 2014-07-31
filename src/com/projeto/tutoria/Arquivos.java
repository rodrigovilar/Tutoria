package com.projeto.tutoria;

public class Arquivos {

	private String nome;
	private String IdArquivo;
	private int qtdAdd;

	public Arquivos(String nome, String idArquivo, int qtdAdd) {
		super();
		this.nome = nome;
		IdArquivo = idArquivo;
		this.qtdAdd = qtdAdd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdArquivo() {
		return IdArquivo;
	}

	public void setIdArquivo(String idArquivo) {
		IdArquivo = idArquivo;
	}

	public int getQtdAdd() {
		return qtdAdd;
	}

	public void setQtdAdd(int qtdAdd) {
		this.qtdAdd = qtdAdd;
	}
}
