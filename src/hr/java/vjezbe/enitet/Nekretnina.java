package hr.java.vjezbe.enitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;

/**
 * Sucelje koje koriste klase koje spadaju pod nekretnine.
 * 
 * 
 * @author Sven
 *
 */

public interface Nekretnina {
	
	/**
	 * Metoda koja racuna porez ako je cijena veca od 10.000 kn
	 * 
	 * @param cijena cijena nekretnine u kunama
	 * @return BigDecimal
	 */
	
	public default BigDecimal izracunajPorez(BigDecimal cijena){
		BigDecimal rezultat = new BigDecimal(0);
		if(cijena.compareTo(new BigDecimal(10000)) < 0) {
			throw new CijenaJePreniskaException();
		}
		else {
			rezultat = cijena.multiply(new BigDecimal(0.03));
			return rezultat;
		}
		
	}
}
