package com.projeto.exception;

@SuppressWarnings("serial")
public class AulaInexistenteException extends RuntimeException {
	public AulaInexistenteException(String msn) {
		super(msn);
	}


}
