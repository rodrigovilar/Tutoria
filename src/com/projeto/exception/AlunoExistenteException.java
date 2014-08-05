package com.projeto.exception;

@SuppressWarnings("serial")
public class AlunoExistenteException extends RuntimeException {
	public AlunoExistenteException(String msn) {
		super(msn);
	}

}