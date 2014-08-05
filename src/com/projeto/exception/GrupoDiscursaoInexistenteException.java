package com.projeto.exception;

@SuppressWarnings("serial")
public class GrupoDiscursaoInexistenteException extends Exception {
	public GrupoDiscursaoInexistenteException(String ms){
		super(ms);
	}
}
