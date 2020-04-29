package hr.java.vjezbe.enitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.NemoguceOdreditiGrupuOsiguranjaException;

/**
 * Klasa koja nasljeduje abstraktnu klasu artikl, te implementira sucelje Vozilo.
 * 
 * @author Sven
 *
 */

public class Automobil extends Artikl implements Vozilo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7216146550421250499L;
	private BigDecimal snagaKs;
	
	/**
	 * Inicijijalizira podatke o klasi Automobil.
	 * 
	 * 
	 * @param naslov naslov automobila
	 * @param opis	opis automobila
	 * @param cijena cijena u kunama
	 * @param snagaKs broj konjskih snaga automobila
	 * @param id 
	 */

	public Automobil(String naslov, String opis, BigDecimal cijena, Stanje stanje, BigDecimal snagaKs, long id) {
		super(naslov, opis, cijena, stanje, id);
		this.snagaKs = snagaKs;
	}

	public BigDecimal getSnagaKs() {
		return snagaKs;
	}

	public void setSnagaKs(BigDecimal snagaKs) {
		this.snagaKs = snagaKs;
	}
	
	/**
	 * Metoda koja racuna grupu osiguranja vozila na temelju broja konjskih snaga.
	 * 
	 * @return BigDecimal
	 */
	
	public BigDecimal izracunajGrupuOsiguranja() throws NemoguceOdreditiGrupuOsiguranjaException {
		if(this.getSnagaKs().compareTo(new BigDecimal(50)) < 0) {
			return new BigDecimal(1);
		}
		else if(this.getSnagaKs().compareTo(new BigDecimal(100)) < 0) {
			return new BigDecimal(2);
		}
		else if(this.getSnagaKs().compareTo(new BigDecimal(200)) < 0) {
			return new BigDecimal(3);
		}
		else if(this.getSnagaKs().compareTo(new BigDecimal(300)) < 0) {
			return new BigDecimal(4);
		}
		else if(this.getSnagaKs().compareTo(new BigDecimal(400)) < 0) {
			return new BigDecimal(5);
		}
		else {
			throw new NemoguceOdreditiGrupuOsiguranjaException();
		}		
	}
	
	/**
	 * Metoda koja vraca tekst za ispis oglasa za automobile.
	 * 
	 * 
	 * @return String
	 */
	
	@Override
	public String tekstOglasa() {
		try{
			return("Naslov automobila: " + this.getNaslov() + 
				"\r\n" + 
				"Opis automobila: " + this.getOpis() + 
				"\r\n" + 
				"Snaga automobila: " + this.izracunajKw(this.getSnagaKs()) + 
				"\r\n" +
				"Stanje automobila: " + this.getStanje() +
				"\r\n" +
				"Izracun osiguranja automobila: " + this.izracunajCijenuOsiguranja() + 
				"\r\n" + 
				"Cijena automobila:" + this.getCijena());
		}
		catch(NemoguceOdreditiGrupuOsiguranjaException ex) {
			return("Naslov automobila: " + this.getNaslov() + 
					"\r\n" + 
					"Opis automobila: " + this.getOpis() + 
					"\r\n" + 
					"Snaga automobila: " + this.izracunajKw(this.getSnagaKs()) + 
					"\r\n" +
					"Stanje automobila: " + this.getStanje() +
					"\r\n" +
					"Cijena automobila:" + this.getCijena() + "\n" +
					ex.getMessage());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((snagaKs == null) ? 0 : snagaKs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Automobil other = (Automobil) obj;
		if (snagaKs == null) {
			if (other.snagaKs != null)
				return false;
		} else if (!snagaKs.equals(other.snagaKs))
			return false;
		return true;
	}
}
