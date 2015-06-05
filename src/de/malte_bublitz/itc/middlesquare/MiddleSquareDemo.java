package de.malte_bublitz.itc.middlesquare;

import de.malte_bublitz.itc.middlesquare.MiddleSquareGenerator;

public class MiddleSquareDemo {
	public static String version = "2015.06.05";
	public static void cliVersion() {
		System.out.println("MiddleSquareDemo " + version);
	}
	public static void cliHelp() {
		cliVersion();
		System.out.println("");
		System.out.println("Usage:");
		System.out.println("  java -jar middlesquare.MiddleSquareDemo.jar");
		System.out.println("  java -jar middlesquare.MiddleSquareDemo.jar [--help|--version]");
		System.out.println("  java -jar middlesquare.MiddleSquareDemo.jar <initial Value> <count>");
		System.out.println("");
		System.out.println("Options/Arguments:");
		System.out.println("  --help          Display this help and exit");
		System.out.println("  --version       Show the version and exit");
		System.out.println("  initial value   Initial value for the generator");
		System.out.println("  count           Number of random numbers to generate");
		System.out.println("");
	}
	public static void main(String []args) {
		int
			i = 0,
			initialValue = 1337,
			count = 5;
		
		/**
		 * Parse command line arguments
		 */
		if (args.length >= 1) {
			if (args[0].equals("--help")) {
				cliHelp();
				return;
			} else if (args[0].equals("--version")) {
				cliVersion();
				return;
			} else {
				initialValue = Integer.parseInt(args[0]);
				count = Integer.parseInt(args[1]);
			}
		}
		
		/**
		 * Generate numbers
		 */
		MiddleSquareGenerator rng = new MiddleSquareGenerator();
		rng.initialize(initialValue);
		for (i=0; i<count; i++) {
			System.out.println("number["+i+"] = "+rng.getRandomNumber());
		}
	}
}
