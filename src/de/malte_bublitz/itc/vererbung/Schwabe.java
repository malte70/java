package de.malte_bublitz.itc.vererbung;

public class Schwabe extends Deutscher {
	private int alter;
	
	public Schwabe (String name) { 
		super(name);
	}

	public String getGruss() {
		return "Leck mich am Arsch!";
	}
	public int getAlter() {
		return this.alter;
	}
}
