package de.malte_bublitz.itc.vokabeltrainer;

import de.malte_bublitz.itc.vokabeltrainer.Wortbestand;
import de.malte_bublitz.itc.vokabeltrainer.Wort;
import java.util.Scanner;
import java.util.ArrayList;

public class Vokabeltrainer {
	public static final void main(String[] args) {
		Wortbestand wb = new Wortbestand();
		wb.add(
				new Wort("Tag", "de"),
				new Wort("day", "en")
				);
		wb.add(
				new Wort("düster", "de"),
				new Wort("dark",   "en")
				);
		wb.add(
				new Wort("Benutzer", "de"),
				new Wort("user",     "en")
				);
		wb.add(
				new Wort("Hilfe", "de"),
				new Wort("help",  "en")
				);
		System.out.println("Alle deutschen Wörter:");
		ArrayList<Wort> deutsche_woerter = wb.getByLanguage("de");
		for (Wort w : deutsche_woerter) {
			System.out.println(w.toString());
		}
		System.out.println("Alle englischen Wörter:");
		ArrayList<Wort> englische_woerter = wb.getByLanguage("en");
		for (Wort w : englische_woerter) {
			System.out.println(w.toString());
		}
		System.out.println("Wort in deutsch?");
		System.out.print("> ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		Wort w = wb.getTranslationFor(wb.getWortByInput(input));
		System.out.println(w.toString());
	}
}
