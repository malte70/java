package de.malte_bublitz.itc.registerkasse;

public class Artikel {
	private String name;
	private double preisEinkauf;
	private double preisVerkauf;
	private int aktuellerBestand;
	private int mindestBestand;
	private long artikelnummer;
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPreisEinkauf() {
		return this.preisEinkauf;
	}
	public void setPreisEinkauf(double preisEinkauf) {
		this.preisEinkauf = preisEinkauf;
	}
	public double getPreisVerkauf() {
		return this.preisVerkauf;
	}
	public void setPreisVerkauf(double preisVerkauf) {
		this.preisVerkauf = preisVerkauf;
	}
	public int getAktuellerBestand() {
		return this.aktuellerBestand;
	}
	public void setAktuellerBestand(int aktuellerBestand) {
		this.aktuellerBestand = aktuellerBestand;
	}
	public int getMindestBestand() {
		return this.mindestBestand;
	}
	public void setMindestBestand(int mindestBestand) {
		this.mindestBestand = mindestBestand;
	}
	public long getArtikelnummer() {
		return this.artikelnummer;
	}
	public void setArtikelnummer(long artikelnummer) {
		this.artikelnummer = artikelnummer;
	}
	
	public Artikel(String name, double preisEinkauf, double preisVerkauf, int aktuellerBestand, int mindestBestand, long artikelnummer) {
		this.name             = name;
		this.preisEinkauf     = preisEinkauf;
		this.preisVerkauf     = preisVerkauf;
		this.aktuellerBestand = aktuellerBestand;
		this.mindestBestand   = mindestBestand;
		this.artikelnummer    = artikelnummer;
	}
}
