package hr.java.vjezbe.enitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * Sucelje koje koriste artikli tipa automobil.
 * 
 * @author Sven
 *
 */

public interface Vozilo {
	
	/**
	 * Metoda koja preracunava konjske snage u kilowatte.
	 * 
	 * @param kSnaga konjske snage automobila
	 * @return BigDecimal
	 */
	
	public default BigDecimal izracunajKw(BigDecimal kSnaga) {
		//kW = KS * 1,341
		BigDecimal konst = new BigDecimal(0.745);
		BigDecimal rjesenje = kSnaga.multiply(konst);
		return rjesenje;
		
	}
	
	/**
	 * Abstraktna metoda koja sluzia za racunanje grupe osiguranja vozila.
	 * 
	 * @return BigDecimal
	 * @throws NemoguceOdreditiGrupuOsiguranjaException u slucaju da nije moguce odrediti grupu osiguranja, baca se ovaj exception
	 */
	
	public abstract BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException;
	
	/**
	 * Metoda koja racuna cijenu osiguranja na temelju grupe osiguranja u koje vozilo pripada.
	 * 
	 * 
	 * @return BigDecimal
	 * @throws NemoguceOdreditiGrupuOsiguranjaException u slucaju da nije moguce odrediti grupu osiguranja, baca se ovaj exception
	 */
	
	public default BigDecimal izracunajCijenuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
		switch(izracunajGrupuOsiguranja().intValue()) {
			case 1 : return new BigDecimal(100);
			case 2 : return new BigDecimal(200);
			case 3 : return new BigDecimal(300);
			case 4 : return new BigDecimal(400);
			case 5 : return new BigDecimal(500);
			default: return new BigDecimal(0);
		}
	}
}
