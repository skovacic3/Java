package hr.java.vjezbe.enitet;

import java.time.LocalDate;

/**
 * Klasa koja sluzi za zapisivanje oglasa.
 * 
 * @author Sven
 *
 */

public class Prodaja extends Entitet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3256922321342165237L;
	private Artikl artikl;
	private Korisnik korisnik;
	private LocalDate datumObjave;
	
	/**
	 * Inicijalizira podatke.
	 * 
	 * 
	 * @param artikl artikl koji se prodaje tipa Artikl
	 * @param korisnik korisnik koji prodaje artikl tipa Korisnik
	 * @param datumObjave datum objave oglasa
	 * @param id 
	 */
	
	public Prodaja(Artikl artikl, Korisnik korisnik, LocalDate datumObjave, long id) {
		super(id);
		this.artikl = artikl;
		this.korisnik = korisnik;
		this.datumObjave = datumObjave;
	}

	public Artikl getArtikl() {
		return artikl;
	}

	public void setArtikl(Artikl artikl) {
		this.artikl = artikl;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public LocalDate getDatumObjave() {
		return datumObjave;
	}

	public void setDatumObjave(LocalDate datumObjave) {
		this.datumObjave = datumObjave;
	}
	
	
	
}
