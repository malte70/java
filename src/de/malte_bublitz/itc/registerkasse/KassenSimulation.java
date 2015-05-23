package de.malte_bublitz.itc.registerkasse;

import de.malte_bublitz.itc.registerkasse.Artikel;
import de.malte_bublitz.itc.registerkasse.Lager;
import de.malte_bublitz.itc.registerkasse.Kasse;
import de.malte_bublitz.itc.registerkasse.Bon;

public class KassenSimulation {
	public static void main(String[] args) {
		Kasse k = new Kasse();
		Lager l = k.getLager();
		Artikel a1 = new Artikel(
				"Seife",
				2.00,
				4.00,
				200,
				10,
				1
			);
		l.addArtikel(a1);
		Artikel a2 = new Artikel(
				"Energy Drink",
				0.70,
				3.00,
				40,
				5,
				2
			);
		l.addArtikel(a2);
		Artikel a3 = new Artikel(
				"MacBook Pro 13\"",
				800.0,
				1100.0,
				42,
				10,
				3
			);
		l.addArtikel(a3);
		k.setLager(l);
		
		//k.
		Bon b1 = new Bon();
		b1.setAdresse("William Boyd\n6318 Main Rd");
		b1.addArtikel(l.getArtikel(1));
		b1.addArtikel(l.getArtikel(1));
		b1.addArtikel(l.getArtikel(2));
		b1.addArtikel(l.getArtikel(2));
		b1.addArtikel(l.getArtikel(2));
		b1.addArtikel(l.getArtikel(2));
		b1.addArtikel(l.getArtikel(2));
		b1.druckeBon();
		
		Bon b2 = new Bon();
		b2.setAdresse("Antonio Pearson\n2888 Hogan St");
		b2.addArtikel(l.getArtikel(1));
		b2.addArtikel(l.getArtikel(3));
		b2.druckeBon();
	}
}
