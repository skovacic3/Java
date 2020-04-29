package hr.java.vjezbe.enitet;

/**
 * Klasa koja nasljeduje abstraktnu klasu korisnik.
 * Sluzi za poslovne korisnike.
 * 
 * 
 * @author Sven
 *
 */

public class PoslovniKorisnik extends Korisnik{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1153350635593842692L;
	private String naziv;
	private String web;
	
	/**
	 * Inicijalizira podatke.
	 * 
	 * 
	 * @param email E-Mail poslovnog korisnika
	 * @param telefon telefon poslovnog korisnika
	 * @param naziv naziv poslovnog korisnika
	 * @param web web stranica poslovnog korisnika
	 * @param id 
	 */
	
	public PoslovniKorisnik(String email, String telefon, String naziv, String web, long id) {
		super(email, telefon, id);
		this.naziv = naziv;
		this.web = web;
	}


	public String getNaziv() {
		return naziv;
	}


	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}


	public String getWeb() {
		return web;
	}


	public void setWeb(String web) {
		this.web = web;
	}
	
	/**
	 * Metoda koja vraca kontaktne informacije poslovnog korisnika.
	 * 
	 * @return String
	 */
	
	@Override
	public String dohvatiKontakt() {
		return("Naziv tvrtke: " + this.getNaziv() + ", mail: " + this.getEmail() + ", tel: " + this.getTelefon() + ", web: " + this.getWeb());
	}
}
