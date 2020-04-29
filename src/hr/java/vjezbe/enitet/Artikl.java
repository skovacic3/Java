package hr.java.vjezbe.enitet;

import java.math.BigDecimal;

/**
 * Abstraktna klasa koju nasljeduju svi tipovi artikla.
 * 
 * 
 * @author Sven
 *
 */

public abstract class Artikl extends Entitet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1951260487640031474L;
	private String naslov;
	private String opis;
	private BigDecimal cijena;
	private Stanje stanje;
	
	/**
	 * Inicijalizira podatke o artiklu.
	 * 
	 * 
	 * @param naslov podatak o naslovu artikla
	 * @param opis podatak o opisu artikla
	 * @param cijena podatak o cijeni artikla
	 * @param id 
	 */
	
	public Artikl(String naslov, String opis, BigDecimal cijena, Stanje stanje, long id) {
		super(id);
		this.naslov = naslov;
		this.opis = opis;
		this.cijena = cijena;
		this.stanje = stanje;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cijena == null) ? 0 : cijena.hashCode());
		result = prime * result + ((naslov == null) ? 0 : naslov.hashCode());
		result = prime * result + ((opis == null) ? 0 : opis.hashCode());
		result = prime * result + ((stanje == null) ? 0 : stanje.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikl other = (Artikl) obj;
		if (cijena == null) {
			if (other.cijena != null)
				return false;
		} else if (!cijena.equals(other.cijena))
			return false;
		if (naslov == null) {
			if (other.naslov != null)
				return false;
		} else if (!naslov.equals(other.naslov))
			return false;
		if (opis == null) {
			if (other.opis != null)
				return false;
		} else if (!opis.equals(other.opis))
			return false;
		if (stanje != other.stanje)
			return false;
		return true;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	/**
	 * Vraca cijenu.
	 * 
	 * @return cijena u kunama
	 */

	public BigDecimal getCijena() {
		return cijena;
	}

	public void setCijena(BigDecimal cijena) {
		this.cijena = cijena;
	}
	
	public abstract String tekstOglasa();

	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}
	
	
}
