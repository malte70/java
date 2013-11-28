package de.malte_bublitz.itc.helloworld_ANSIConsole;


import de.malte_bublitz.util.ANSIConsole;

public class HelloWorld {
	public static void main(String[] args) {
		ANSIConsole c = new ANSIConsole();
		c.setForegroundColor("GREEN");
		c.println("Hallo Welt!");
		c.setAttribute("RESET");
	}
}
