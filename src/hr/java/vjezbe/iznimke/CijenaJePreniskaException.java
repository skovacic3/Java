package hr.java.vjezbe.iznimke;

/**
 * Neoznaceni exception koji se baca u slucaju da je cijena preniska, te se zato ne racuna porez.
 * 
 * @author Sven
 *
 */

public class CijenaJePreniskaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7048026746132280704L;

	public CijenaJePreniskaException() {
		super("Cijena je preniska, te zato nema poreza.");
	}


	public CijenaJePreniskaException(String message, Throwable cause) {
		super(message, cause);
	}

	public CijenaJePreniskaException(String message) {
		super(message);
	}

	public CijenaJePreniskaException(Throwable cause) {
		super(cause);
	}
	
}
