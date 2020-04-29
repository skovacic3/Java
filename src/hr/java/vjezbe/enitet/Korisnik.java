package hr.java.vjezbe.enitet;

/**
 * Abstraktna klasa koju nasljeduju sve druge klase korisnika.
 * 
 * 
 * @author Sven
 *
 */

public abstract class Korisnik extends Entitet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3248088866193900441L;
	private String email;
	private String telefon;
	
	public Korisnik(String email, String telefon, long id) {
		super(id);
		this.email = email;
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public abstract String dohvatiKontakt();
	
	
}
