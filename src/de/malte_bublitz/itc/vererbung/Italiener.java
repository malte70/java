package de.malte_bublitz.itc.vererbung;

class Italiener extends Person {
	public Italiener (String name) { 
		super(name);
	}
	public String getGruss() { 
		return "Buon giorno!";
	}
}
