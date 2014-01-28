package de.malte_bublitz.itc.vererbung;

import de.malte_bublitz.itc.vererbung.Gebaeude;

public class Wohnung extends Gebaeude {
	private int zimmerzahl;
	public int getZimmerzahl() {
		return this.zimmerzahl;
	}
	public void setZimmerzahl(int zimmerzahl) {
		this.zimmerzahl = zimmerzahl;
	}
	public int getMiete() {
		return this.flaeche*10;
	}
	public Wohnung(int flaeche, String adresse, int zimmerzahl) {
		super(flaeche, adresse);
		
		this.zimmerzahl = zimmerzahl;
	}
}
