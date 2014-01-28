package de.malte_bublitz.itc.vererbung;

abstract public class Gebaeude {
	protected int flaeche;
	protected String adresse;
	public int getFlaeche() {
		return this.flaeche;
	}
	public void setFlaeche(int flaeche) {
		this.flaeche = flaeche;
	}
	public String getAdresse() {
		return this.adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public abstract int getMiete();
	public Gebaeude(int flaeche, String adresse) {
		this.flaeche = flaeche;
		this.adresse = adresse;
	}
}
