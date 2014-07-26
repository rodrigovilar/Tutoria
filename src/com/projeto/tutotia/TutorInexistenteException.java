package com.projeto.tutotia;

@SuppressWarnings("serial")
public class TutorInexistenteException extends RuntimeException {

	TutorInexistenteException(String msn2) {
		super(msn2);
	}

}