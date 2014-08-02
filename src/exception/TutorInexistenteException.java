package exception;

@SuppressWarnings("serial")
public class TutorInexistenteException extends RuntimeException {

	public TutorInexistenteException(String msn2) {
		super(msn2);
	}

}