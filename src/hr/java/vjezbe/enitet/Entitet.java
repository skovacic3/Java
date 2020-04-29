package hr.java.vjezbe.enitet;

import java.io.Serializable;

public abstract class Entitet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1611143272971905211L;
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Entitet(long id) {
		super();
		this.id = id;
	}
	
	
}
