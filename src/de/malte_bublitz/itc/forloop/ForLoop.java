package de.malte_bublitz.itc.forloop;

public class ForLoop {
	public static void simpleLoop() {
		/*
		 * simple for loop
		 */
		for (int i=1; i<=5; i++) {
			System.out.println("Durchlauf "+1);
		}
	}
	public static void oneDimArray() {
		/*
		 * arrays (1-dim)
		 */
		int[] zahlen = new int[5];
		for (int i=0; i<5; i++) {
			zahlen[i] = (i+1)*(i+1);
		}
		for (int i=0; i<5; i++) {
			System.out.println("Element "+(i+1)+": "+zahlen[i]);
		}
	}
	public static void twoDimArray() {
		/*
		 * arrays (2-dim)
		 */
		int[][] zahlen2 = new int[5][10];
		for (int i=0; i<5; i++) {
			for (int j=0; j<10; j++) {
				zahlen2[i][j] = i*j;
			}
		}
		for (int i=0; i<5; i++) {
			for (int j=0; j<10; j++) {
				System.out.println("zahlen["+i+"]["+j+"] = "+zahlen2[i][j]);
			}
		}
	}
	public static final void main(String[] args) {
		simpleLoop();
		oneDimArray();
		twoDimArray();
	}
}
