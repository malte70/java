package de.malte_bublitz.itc.vererbung;

import de.malte_bublitz.itc.vererbung.Wohnung;
import de.malte_bublitz.itc.vererbung.Buero;
import de.malte_bublitz.util.ANSIConsole;

public class TestApp0 {
	public static void main(String[] args) {
		Buero b = new Buero(100, "42 Leet Street", 5);
		b.setBueroraeume(6);
		ANSIConsole c = new ANSIConsole();
		c.println("Büro:");
		c.println("Fläche: "+b.getFlaeche()+" m²");
		c.println("Adresse: "+b.getAdresse());
		c.println("Anzahl Büroräume: "+b.getBueroraeume());
		c.println("Miete: "+b.getMiete()+" € p.m.");
		
		Wohnung w = new Wohnung(60, "666 Satan Street", 3);
		c.println("Wohnung");
		c.println("Fläche: "+w.getFlaeche()+" m²");
		c.println("Adresse: "+w.getAdresse());
		c.println("Zimmerzahl: "+w.getZimmerzahl());
		c.println("Miete: "+w.getMiete()+" € p.m.");
	}
}
