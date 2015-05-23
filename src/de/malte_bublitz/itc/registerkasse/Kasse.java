package de.malte_bublitz.itc.registerkasse;

import de.malte_bublitz.itc.registerkasse.Lager;
import de.malte_bublitz.itc.registerkasse.Bon;

public class Kasse {
	private Lager lager;
	private Bon aktueller_bon;
	
	public Lager getLager() {
		return this.lager;
	}
	public void setLager(Lager lager) {
		this.lager = lager;
	}
	public Bon getBon() {
		return this.aktueller_bon;
	}
	public void setBon(Bon aktueller_bon) {
		this.aktueller_bon = aktueller_bon;
	}
	public void scanArtikel(long artikelnummer) {
	}
	public Kasse() {
		this.lager = new Lager();
	}
}
