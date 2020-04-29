package hr.java.vjezbe.iznimke;

/**
 * Exception koji se poziva ako nije moguce odrediti grupu osiguranja.
 * Oglas nije valjan ako grupa osiguranja kod vozila nije izracunata.
 * 
 * 
 * @author Sven
 *
 */

public class NemoguceOdreditiGrupuOsiguranjaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5670490140774623619L;

	public NemoguceOdreditiGrupuOsiguranjaException() {
		super("Nije moguce odrediti grupu osiguranja, pa oglas nije valjan.");
	}

	public NemoguceOdreditiGrupuOsiguranjaException(String message, Throwable cause) {
		super(message, cause);
	}

	public NemoguceOdreditiGrupuOsiguranjaException(String message) {
		super(message);
	}

	public NemoguceOdreditiGrupuOsiguranjaException(Throwable cause) {
		super(cause);
	}
	
}
