package hr.java.vjezbe.enitet;

import java.math.BigDecimal;

/**
 * Klasa koja nasljeduje abstraktnu klasu Artikl.
 * Sluzi za unos artikla tipa usluga.
 * 
 * @see Artikl
 * 
 * @author Sven
 *
 */

public class Usluga extends Artikl {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3986661012841201648L;

	/**
	 * Inicijalizira podatke.
	 * 
	 * 
	 * @param naslov naslov usluge
	 * @param opis opis usluge
	 * @param cijena cijena usluge u kunama
	 * @param id 
	 */
	
	public Usluga(String naslov, String opis, BigDecimal cijena, Stanje stanje, long id) {
		super(naslov, opis, cijena, stanje, id);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	/**
	 * Metoda koja sluzi za ispis teksta oglasa za usluge.
	 */

	@Override
	public String tekstOglasa() {
		return("Naslov usluge: " + this.getNaslov() + 
				"\r\n" + 
				"Opis usluge: " + this.getOpis() + 
				"\r\n" + 
				"Cijena usluge: " + this.getCijena());
	}

	
}
