package de.malte_bublitz.itc.vererbung;


import de.malte_bublitz.util.ANSIConsole;
import java.util.Scanner;

public class GrussAusgabe2
{
	public static void main(String args[]) {
		ANSIConsole c = new ANSIConsole();
		String
			name = "",
			herkunft = "";
		Person allepersonen[] = new Person[666];
		int i=0;
		Scanner sc = new Scanner(System.in);
		c.println("Moin.");
		c.println("Bitte nun die Details zu den Personen anzeigen.");
		c.println("Beenden mit Eingabe von \"ende.\" als Name.");
		
		while (!name.equals("ende.")) {
			c.println("Neue Person erstellen.");
			c.print("Name? ");
			name = sc.nextLine();
			if (name.equals("ende."))
				continue;
			c.println("Unterstützte Herkunften: Frankreich, Deutschland, Bayern, Schwaben, Italien");
			c.print("Herkunft? ");
			herkunft = sc.nextLine();
			if (herkunft.equals("Frankreich")) {
				allepersonen[i] = new Franzose(name);
			} else if (herkunft.equals("Deutschland")) {
				allepersonen[i] = new Deutscher(name);
			} else if (herkunft.equals("Bayern")) {
				allepersonen[i] = new Bayer(name);
			} else if (herkunft.equals("Schwaben")) {
				allepersonen[i] = new Schwabe(name);
			} else if (herkunft.equals("Italien")) {
				allepersonen[i] = new Italiener(name);
			}
			c.println("Danke.");
			i++;
		}
		
		sc.close();
		for (i=0; i<allepersonen.length; i++) {
			if (allepersonen[i]!=null) {
				c.println(allepersonen[i].getName() + " : " + allepersonen[i].getGruss());
			}
		}
	}
}// class
