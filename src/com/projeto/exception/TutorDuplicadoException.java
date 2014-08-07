package com.projeto.Exception;

@SuppressWarnings("serial")
public class TutorDuplicadoException extends RuntimeException {
	public TutorDuplicadoException (String msn){
		super(msn);
	}

}
