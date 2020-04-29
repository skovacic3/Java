package hr.java.vjezbe.enitet;

import java.math.BigDecimal;

import hr.java.vjezbe.iznimke.CijenaJePreniskaException;

/**
 * Klasa koja nasljeduje artikl te implementira sucelje nekretnina.
 * Sluzi za unos artikla tipa stan.
 * 
 * @see Artikl
 * 
 * @author Sven
 *
 */


public class Stan extends Artikl implements Nekretnina {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8068538100431977871L;
	private int kvadratura;
	
	/**
	 * Inicijalizira podatke.
	 * 
	 * 
	 * @param naslov naslov stana
	 * @param opis opis stana
	 * @param cijena cijena stana u kunama
	 * @param kvadratura kvadratura stana u metrima kvadratnim
	 * @param id 
	 */
	
	public Stan(String naslov, String opis, BigDecimal cijena, Stanje stanje, int kvadratura, long id) {
		super(naslov, opis, cijena, stanje, id);
		this.kvadratura = kvadratura;
	}

	public int getKvadratura() {
		return kvadratura;
	}

	public void setKvadratura(int kvadratura) {
		this.kvadratura = kvadratura;
	}
	
	/**
	 * Metoda koja sluzi za ispis teksta oglasa stana.
	 * 
	 * 
	 */

	@Override
	public String tekstOglasa() {
		try{
			return("Naslov stana: " + this.getNaslov() + 
				"\r\n" + 
				"Opis stana: " + this.getOpis() + 
				"\r\n" + 
				"Cijena stana:" + (this.getCijena()) + this.izracunajPorez(this.getCijena())) +
				"\r\n" +
				"Kvadratura stana : " + this.getKvadratura() +
				"\r\n" +
				"Stanje nekretnine : " + this.getStanje();
		}
		catch(CijenaJePreniskaException ex) {
			return("Naslov stana: " + this.getNaslov() + 
					"\r\n" + 
					"Opis stana: " + this.getOpis() + 
					"\r\n" + 
					"Cijena stana:" + (this.getCijena()) +
					"\r\n" +
					"Kvadratura stana : " + this.getKvadratura() +
					"\r\n" +
					ex.getMessage())+
					"\r\n" +
					"Stanje nekretnine : " + this.getStanje();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + kvadratura;
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
		Stan other = (Stan) obj;
		if (kvadratura != other.kvadratura)
			return false;
		return true;
	}
}
