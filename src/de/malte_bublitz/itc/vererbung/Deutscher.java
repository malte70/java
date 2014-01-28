package de.malte_bublitz.itc.vererbung;

class Deutscher extends Person
{
	public Deutscher (String name)
	{ 
		super(name);
	}// Konstruktor

	public String getGruss()
	{ 
		return "Guten Tag";
	}// getGruss
}// class
