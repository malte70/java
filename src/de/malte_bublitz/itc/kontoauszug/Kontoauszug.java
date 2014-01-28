package de.malte_bublitz.itc.kontoauszug;

import java.sql.SQLException;
import de.malte_bublitz.itc.kontoauszug.Konto;
import de.malte_bublitz.itc.kontoauszug.Buchung;

public class Kontoauszug {
	public static void main(String[] args) {
		try {
			//Konto k = Konto.neuesKontoFactory("42ABC1234", "John Doe", 10);
			Konto k = new Konto("42ABC1234");
			//Buchung b = new Buchung(42);
			//b.aufKonto(k);
			k.zeigeAuszug(5); // limit to 5
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
