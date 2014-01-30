package de.malte_bublitz.itc.buecherverwaltung;

public class Buch {
	private String author;
	private String title;
	private int year;
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return this.title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return this.year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean equals(Buch b) {
		return (
			(this.author.equals(b.getAuthor()))
			&& (this.title.equals(b.getTitle()))
			&& (this.year == b.getYear())
			);
	}
	public Buch(String author, String title, int year) {
		this.author = author;
		this.title = title;
		this.year = year;
	}
}
