package de.malte_bublitz.itc.vokabeltrainer;

public class Wort {
	private String name;
	private String language;
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String toString() {
		return "["+this.language+"] "+this.name;
	}
	public Wort() {
		this.name = "INVALID";
		this.language = "??";
	}
	public Wort(String name, String language) {
		this.name = name;
		this.language = language;
	}
}
