package exception;

@SuppressWarnings("serial")
public class TutorExistenteException extends RuntimeException {

	public TutorExistenteException(String msn) {
		super(msn);
	}

}