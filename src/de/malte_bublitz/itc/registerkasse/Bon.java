package de.malte_bublitz.itc.registerkasse;

import de.malte_bublitz.itc.registerkasse.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Bon {
	private double summe;
	private Date datum;
	private String adresse;
	private ArrayList<Artikel> artikelliste;
	
	public double getSumme() {
		return this.summe;
	}
	public void setSumme(double summe) {
		this.summe = summe;
	}
	public Date getDatum() {
		return this.datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public String getAdresse() {
		return this.adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public ArrayList<Artikel> getArtikelliste() {
		return this.artikelliste;
	}
	public void addArtikel(Artikel a) {
		this.artikelliste.add(a);
		this.setSumme(this.getSumme() + a.getPreisVerkauf());
	}
	public void druckeBon() {
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		System.out.println(" -- Kassenbon --");
		System.out.println("Datum: "+df.format(this.getDatum()));
		System.out.println("\nKunde:\n"+this.adresse);
		System.out.println("");
		for (Artikel a : this.artikelliste) {
			System.out.println(a.getPreisVerkauf()+" "+a.getArtikelnummer()+" "+a.getName());
		}
		System.out.println("Summe: "+this.getSumme());
		System.out.println("");
		System.out.println("");
	}
	public Bon() {
		this.summe = 0;
		this.datum = new Date();
		this.adresse = "";
		this.artikelliste = new ArrayList<Artikel>();
	}
}
