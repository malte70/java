package de.malte_bublitz.itc.vokabeltrainer;

import de.malte_bublitz.itc.vokabeltrainer.Wort;
import java.util.ArrayList;

public class Wortbestand {
	private ArrayList<Wort> bestand = new ArrayList<Wort>();
	private ArrayList<Integer[]> uebersetzungen = new ArrayList<Integer[]>();
	public void add(Wort w1, Wort w2) {
		this.bestand.add(w1);
		this.bestand.add(w2);
		Integer[] b = new Integer[2];
		b[0] = new Integer(this.bestand.indexOf(w1));
		b[1] = new Integer(this.bestand.indexOf(w2));
		this.uebersetzungen.add(b);
	}
	public ArrayList<Wort> getByLanguage(String language) {
		ArrayList<Wort> by_language = new ArrayList<Wort>();
		for (Wort w : this.bestand) {
			if (w.getLanguage().equals(language)) {
				by_language.add(w);
			}
		}
		return by_language;
	}
	public Wort getWortByInput(String input) {
		for (Wort w : this.bestand) {
			if (w.getName().equals(input))
				return w;
		}
		return new Wort();
	}
	public Wort getTranslationFor(Wort w) {
		Integer uebersetzung_id = 0;
		for (Integer[] uebersetzung : this.uebersetzungen) {
			if (uebersetzung[0] == this.bestand.indexOf(w))
				uebersetzung_id = uebersetzung[1];
		}
		return this.bestand.get(uebersetzung_id);
	}
	public Wortbestand() {}
}
