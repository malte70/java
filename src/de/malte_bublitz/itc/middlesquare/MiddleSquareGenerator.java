package de.malte_bublitz.itc.middlesquare;

public class MiddleSquareGenerator {
	private int lastRandomNumber;
	
	public void initialize(int startValue) {
		this.lastRandomNumber = startValue;
	}
	
	public int getRandomNumber() {
		this.lastRandomNumber = (int)( Math.pow(this.lastRandomNumber, 2) / 100 ) % 10000;
		return this.lastRandomNumber;
	}
	public MiddleSquareGenerator() {
		this.initialize(1337);
	}
}
