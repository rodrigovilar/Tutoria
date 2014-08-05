package com.projeto.exception;

@SuppressWarnings("serial")
public class GrupoDiscursaoJaExisteException extends RuntimeException {
	public GrupoDiscursaoJaExisteException(String msn){
		super(msn);
	}

}
