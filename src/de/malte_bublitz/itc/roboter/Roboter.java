package de.malte_bublitz.itc.roboter;

public class Roboter {
	private int x;
	private int y;
	enum Richtung {
		NORD, OST, SUED, WEST
	};
	private Richtung richtung;
	private boolean beladen;
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}
	public Richtung getRichtung() {
		return this.richtung;
	}
	public boolean getBeladen() {
		return this.beladen;
	}
	public void platzieren(int x, int y, Richtung richtung, boolean beladen) {
		this.x        = x;
		this.y        = y;
		this.richtung = richtung;
		this.beladen  = beladen;
	}
	public void einsvor() {
		switch(this.richtung) {
			case NORD:
				this.y += 1;
				break;
			case OST:
				this.x += 1;
				break;
			case SUED:
				this.y -= 1;
				break;
			case WEST:
				this.x -= 1;
				break;
		}
	}
	public void rechts() {
		this.richtung = Richtung.values()[(this.richtung.ordinal()+1)%4];
	}
	public void links() {
		if (this.richtung.ordinal()-1<0) {
			this.richtung = Richtung.values()[Richtung.values().length-1];
		} else {
			this.richtung = Richtung.values()[(this.richtung.ordinal()-1)%4];
		}
	}
	public void aufab() {
		this.beladen = !this.beladen;
	}
	public Roboter() {
		this.x = 0;
		this.y = 0;
		this.richtung = Richtung.NORD;
		this.beladen = false;
	}
}
