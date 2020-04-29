package hr.java.vjezbe.enitet;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa s nazivom i arrayom artikala.
 * 
 * 
 * @author Sven
 *
 */

public class Kategorija <T extends Artikl> extends Entitet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 22579725792843837L;
	private String naziv;
	List<T> artikli;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
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
		Kategorija<?> other = (Kategorija<?>) obj;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}

	public Kategorija(String naziv, long id) {
		super(id);
		this.naziv = naziv;
		this.artikli =  new ArrayList<T>();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<T> getArtikli() {
		return artikli;
	}

	public void setArtikli(List<T> artikli) {
		this.artikli = artikli;
	}
	
	public void dodajArtikl(T artikl) {
		this.artikli.add(artikl);
	}
	
	public T dohvatiArtikl(int broj) {
		return this.artikli.get(broj);
	}
	
	public List<T> dohvatiListuArtikala(){
		return artikli;
	}
	
	
}
