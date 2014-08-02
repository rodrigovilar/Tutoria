package exception;

@SuppressWarnings("serial")
public class AlunoExistenteException extends RuntimeException {
	public AlunoExistenteException(String msn3) {
		super(msn3);
	}

}