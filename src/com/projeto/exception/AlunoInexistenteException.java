package com.projeto.Exception;

@SuppressWarnings("serial")
public class AlunoInexistenteException extends RuntimeException {
	public AlunoInexistenteException(String msg){
		super(msg);
	}
}