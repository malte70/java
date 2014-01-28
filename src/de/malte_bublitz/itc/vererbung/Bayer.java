package de.malte_bublitz.itc.vererbung;

public class Bayer extends Deutscher {
	private String lieblingsbier;
	
	public Bayer (String name)
	{ 
		super(name);
		setLieblingsbier("afri cola");
	}// Konstruktor

	public void setLieblingsbier(String bier)
	{ 
		lieblingsbier = bier;
	}// setLieblingsbier

	public String getGruss()
	{
		return "Gruess Gott. Hoast a " + lieblingsbier + "?";
	}// getGruss
}// class
