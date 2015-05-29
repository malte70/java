package de.malte_bublitz.itc.roboter;

import de.malte_bublitz.util.ANSIConsole;
import de.malte_bublitz.itc.roboter.Roboter;
import java.util.Scanner;

public class Robotersteuerung {
	public static Roboter robby;
	public static int
		xmin,
		ymin,
		xmax,
		ymax;
	public static boolean beenden = false;
	public static ANSIConsole c;
	public static void steuerpultBedienen() {
		Scanner sc = new Scanner(System.in);
		String input;
		c.clear();
		c.setForegroundColor(ANSIConsole.COLOR_GREEN);
		c.println("Status");
		c.printLine("=", 20);
		c.setAttribute(ANSIConsole.ATTR_RESET);
		c.println("");
		c.println("Position: ("+robby.getX()+"|"+robby.getY()+")");
		c.println("Blickrichtung: "+robby.getRichtung().toString());
		c.println("Beladen: "+(robby.getBeladen()?"ja":"nein"));
		c.print("\nBefehl?> ");
		try {
			input = sc.nextLine().toLowerCase();
			if (input.equals("links")) {
				robby.links();
			} else if (input.equals("rechts")) {
				robby.rechts();
			} else if (input.equals("löschen")) {
				robby.aufab();
			} else if (input.equals("vor")) {
				switch (robby.getRichtung()) {
					case NORD:
						if (robby.getY()<ymax)
							robby.einsvor();
						break;
					case OST:
						if (robby.getX()<xmax)
							robby.einsvor();
						break;
				}
			} else if (input.equals("exit")) {
				beenden = true;
			} else {
				c.setForegroundColor(ANSIConsole.COLOR_RED);
				c.println("Illegal command.");
				c.setAttribute(ANSIConsole.ATTR_RESET);
			}
		} catch (java.util.NoSuchElementException e) {
			beenden = true;
			c.println("");
		}
	}
	public static void main(String[] args) {
		robby = new Roboter();
		robby.platzieren(1, 1, Roboter.Richtung.NORD, false);
		xmin = 0;
		ymin = 0;
		xmax = 10;
		ymax = 10;
		c = new ANSIConsole();
		while (!beenden) {
			steuerpultBedienen();
		}
	}
}
