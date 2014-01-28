package de.malte_bublitz.itc.vererbung;

import de.malte_bublitz.itc.vererbung.*;

public class Buero extends Gebaeude {
	private int bueroraeume;
	public int getBueroraeume() {
		return this.bueroraeume;
	}
	public void setBueroraeume(int bueroraeume) {
		this.bueroraeume = bueroraeume;
	}
	public int getMiete() {
		return this.flaeche * 20 + this.bueroraeume*30;
	}
	public Buero(int flaeche, String adresse, int bueroraeume) {
		super(flaeche, adresse);
		this.bueroraeume = bueroraeume;
	}
}
