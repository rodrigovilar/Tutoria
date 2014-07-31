package com.projeto.tutoria;

@SuppressWarnings("serial")
public class AlunoInexistenteException extends RuntimeException {
	AlunoInexistenteException(String msg){
		super(msg);
	}
}