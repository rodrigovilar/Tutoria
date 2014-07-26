package com.projeto.tutotia;

@SuppressWarnings("serial")
public class AlunoInexistenteException extends RuntimeException {
	AlunoInexistenteException(String msg){
		super(msg);
	}
}