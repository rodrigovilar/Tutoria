package com.projeto.Exception;

@SuppressWarnings("serial")
public class GrupoDiscurssaoJaExisteException extends RuntimeException {
	public GrupoDiscurssaoJaExisteException(String msn){
		super(msn);
	}

}
