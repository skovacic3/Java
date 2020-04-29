package hr.java.vjezbe.enitet;

/**
 * Klasa koja nasljeduje abstraktnu klasu korisnik.
 * Sluzi za privatne korisnike.
 * 
 * @author Sven
 *
 */

public class PrivatniKorisnik extends Korisnik {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1335974933704929302L;
	private String ime;
	private String prezime;
	
	
	/**
	 * Inicijalizira podatke.
	 * 
	 * 
	 * @param email E-Mail privatnog korisnika
	 * @param telefon telefonski broj privatnog korisnika
	 * @param ime ime privatnog korisnika
	 * @param prezime prezime privatnog korisnika
	 * @param id 
	 */
	
	public PrivatniKorisnik(String email, String telefon, String ime, String prezime, long id) {
		super(email, telefon, id);
		this.ime = ime;
		this.prezime = prezime;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	/**
	 * Metoda koja vraca kontaktne informacije privatnog korisnika.
	 * 
	 * @return String
	 */
	
	@Override
	public String dohvatiKontakt() {
		return("Osobni podaci prodavatelja: " + this.getIme() + this.getPrezime() + ", mail: " + this.getEmail() + ", tel: " + this.getTelefon());
	}
	
}
