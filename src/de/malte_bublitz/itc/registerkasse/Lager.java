package de.malte_bublitz.itc.registerkasse;

import java.util.HashMap;
import de.malte_bublitz.itc.registerkasse.Artikel;

public class Lager {
	private HashMap<Long, Artikel> artikelbestand;
	public Artikel getArtikel(long artikelnummer) {
		return this.artikelbestand.get(artikelnummer);
	}
	public void addArtikel(Artikel a) {
		this.artikelbestand.put(a.getArtikelnummer(), a);
	}
	public Lager() {
		this.artikelbestand = new HashMap<Long, Artikel>();
	}
}
