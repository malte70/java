/*
 * ANSIConsole
 *
 * Copyright (c) 2013 Malte Bublitz, https://malte-bublitz.de
 * All rights reserved.
 *
 */

package de.malte_bublitz.util;

import java.util.Scanner;

public class ANSIConsole {
	public void escape(String code) {
		char ESC = 27;
		System.out.print(ESC + "[" + code);
	}
	public void clear() {
		escape("H");
		escape("2J");
	}
	public void setForegroundColor(String c) {
		switch (c) {
			case "BLACK":
				escape("0;30m");
				break;
			case "RED":
				escape("0;31m");
				break;
			case "GREEN":
				escape("0;32m");
				break;
			case "YELLOW":
				escape("0;33m");
				break;
			case "BLUE":
				escape("0;34m");
				break;
			case "DARK_MAGENTA":
				escape("0;35m");
				break;
			case "DARK_CYAN":
				escape("0;36m");
				break;
			case "GREY":
				escape("0;37m");
				break;
			case "DARK_GREY":
				escape("1;30m");
				break;
			case "LIGHT_RED":
				escape("1;31m");
				break;
			case "LIGHT_GREEN":
				escape("1;32m");
				break;
			case "LIGHT_YELLOW":
				escape("1;33m");
				break;
			case "LIGHT_BLUE":
				escape("1;34m");
				break;
			case "MAGENTA":
				escape("1;35m");
				break;
			case "CYAN":
				escape("1;36m");
				break;
			case "WHITE":
				escape("1;37m");
				break;
		}
	}
	public void setAttribute(String a) {
		switch (a) {
			case "BOLD":
				escape("1m");
				break;
			case "UNDERLINE":
				escape("4m");
				break;
			case "RESET":
				escape("0m");
				break;
		}
	}
	public void print(String chars) {
		System.out.print(chars);
	}
	public void println(String line) {
		System.out.println(line);
	}
	public String readLine() {
		Scanner sc = new Scanner(System.in);
		String line;
		line = sc.nextLine();
		sc.close();
		return line;
	}
	public void printLine(String element, int length) {
		for (int i=0; i<length; i++)
			print(element);
	}
	public void printTux() {
		print(
			"    .--.\n" + 
			"   |o_o |\n" +
			"   |:_/ |\n" +
			"  //   \\ \\\n" +
			" (|     | )\n" +
			"/'\\_   _/`\\\n" +
			"\\___)=(___/\n"
		);
	}
	public ANSIConsole() {}
}
