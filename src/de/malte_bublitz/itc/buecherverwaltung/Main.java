package de.malte_bublitz.itc.buecherverwaltung;

import java.util.ArrayList;
import de.malte_bublitz.itc.buecherverwaltung.Buch;

public class Main {
	private static ArrayList<Buch> bibliothek = new ArrayList<Buch>();
	private static int getAnzahlBuecher() {
		return bibliothek.size();
	}
	private static boolean istInBibliothek(Buch b) {
		for (Buch bb : bibliothek) {
			if (bb.equals(b))
				return true;
		}
		return false;
	}
	private static void entferneAusBibliothek(Buch b) {
		if (istInBibliothek(b))
			return;
		bibliothek.remove(bibliothek.indexOf(b));
	}
	public static final void main(String[] args) {
		Buch nguygen_linux_filesystem_hierarchy = new Buch("Binh Nguyen", "Linux Filesystem Hierarchy", 2004);
		bibliothek.add(new Buch("Mendel Cooper", "Advanced Bash-Scripting Guide", 2012));
		bibliothek.add(new Buch("Machtelt Garrels", "Bash Guide for Beginners", 2008));
		bibliothek.add(new Buch("Gareth Anderson", "GNU/Linux Command-Line Tools Summary", 2006));
		bibliothek.add(nguygen_linux_filesystem_hierarchy);
		bibliothek.add(new Buch("Gerard Beekmans", "Hardened Linux From Scratch", 2011));
		System.out.println("Anzahl Bücher: "+getAnzahlBuecher());
		System.out.print("Ist Linux Filesystem Hierarchy von B. Nguyen in der Bibliothek? ");
		if (istInBibliothek(nguygen_linux_filesystem_hierarchy)) {
			System.out.println("ja.");
		} else {
			System.out.println("nein.");
		}
		System.out.println("Also raus damit! :E");
		entferneAusBibliothek(nguygen_linux_filesystem_hierarchy);
		System.out.println("Neue Anzahl Bücher: "+getAnzahlBuecher());
	}
}
