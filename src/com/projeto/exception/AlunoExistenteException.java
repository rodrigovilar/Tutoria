package com.projeto.Exception;

@SuppressWarnings("serial")
public class AlunoExistenteException extends RuntimeException {
	public AlunoExistenteException(String msn) {
		super(msn);
	}

}