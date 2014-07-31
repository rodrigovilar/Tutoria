package com.projeto.tutoria;

@SuppressWarnings("serial")
public class TutorInexistenteException extends RuntimeException {

	TutorInexistenteException(String msn2) {
		super(msn2);
	}

}