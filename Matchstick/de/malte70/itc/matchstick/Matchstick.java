package de.malte70.itc.matchstick;
/*
 * Matchstick
 *
 * Streichholzziehen für zwei Spieler.
 * Zwei Spieler ziehen abwechselnd Steichhälzer aus einem Stapel.
 * Derjenige, der das letzte Streichholz zieht, verliert.
 *
 * Ablauf:
 * stapel_groesse = 21
 * aktiver Spieler = 0 oder 1 (random)
 * Solange stapelgroesse != 0:
 *    aktiver Spieler darf n Hölzer ziehen, n={1...3}
 *    stapel_groesse -= n
 *    wenn stapel_groesse != 0:
 *       wechsel aktiver Spieler
 * Gewinnmeldung
 */


import java.util.Scanner;
import java.util.Random;

public class Matchstick {
	public static int randInt() {
		Random rand = new Random();
		// returns a number beween 0 (inclusive) and argument (exclusive)
		int randomNum = rand.nextInt(2);
		return randomNum;
	}
	public static void welcomeMessage() {
		System.out.println("[H[2J[1;32mStreichholzziehen");
		System.out.println("=================[0m\n");
		System.out.println("[1;36mZwei Spieler ziehen abwechselnd Streichhälzer von einem Stapel.");
		System.out.println("Derjenige, der den Stapel leert, verliert. Es dürfen maximal drei Streichhälzer");
		System.out.println("gezogen werden, mindestens jedoch eines.[0m\n");
	}
	public static String getPlayerName(int playernum) {
		Scanner sc = new Scanner(System.in);
		String playername = new String();
		System.out.println("Spieler "+(playernum+1)+", wie heißt du?");
		System.out.print("Hinweis: \"AI\" ist ein intelligenter Computergegner, \"Computer\" ein dummer.\n? ");
		playername = sc.nextLine();
		System.out.println("[1;31mHallo, "+playername+"[0m");
		return playername;
	}
	public static int AIPlayerPull(int stacksize, int is_intelligent, int other_input) {
		int pull=0;
		if (is_intelligent==0) {
			// dump computer
			if (stacksize > 3) {
				pull = 3;
			} else {
				if (stacksize > 1) {
					pull = stacksize-1;
				} else {
					pull = stacksize;
				}
			}
		} else {
			// AI
			if (other_input==42) {
				pull = 3;
			} else {
				pull = 4 - other_input;
				if (pull >= stacksize) {
					if (stacksize > 1) {
						pull -= 1;
					} else {
						pull = 1;
					}
				}
			}
		}
		System.out.println("[1;35m"+pull+"[0m");
		return pull;
	}
	public static void main(String[] args) {
		int stack_size = 21;
		int current_player = 1;
		int pulled_matches = 42;
		int old_pulled_matches = 1;
		Scanner sc = new Scanner(System.in);
		String[] playernames = new String[2];
		
		welcomeMessage();
		playernames[0] = getPlayerName(0);
		playernames[1] = getPlayerName(1);
		
		current_player = randInt();
		
		while (stack_size >0) {
			while (pulled_matches <= 0 || pulled_matches >= 4 || pulled_matches > stack_size) {
				System.out.println("[4mAktuell sind "+stack_size+" Streichhälzer auf dem Stapel.[0m");
				System.out.println("[1;32m" + playernames[current_player]+": Bitte ein Streichholz ziehen, mind. 1, max. 3.[0m");
				System.out.print("[4mAnzahl?[0m ");
				if (playernames[current_player].substring(0, 2).equals("AI")) {
					pulled_matches = AIPlayerPull(stack_size, 1, old_pulled_matches);
				} else if (playernames[current_player].substring(0, 8).equals("Computer")) {
					pulled_matches = AIPlayerPull(stack_size, 0, old_pulled_matches);
				} else {
					pulled_matches = sc.nextInt();
				}
				if (pulled_matches <= 0 || pulled_matches >= 4) {
					System.out.println("So nicht mein lieber! Versuch\'s nochmal!");
				}
				if (pulled_matches > stack_size) {
					System.out.println("Du versuchst mehr Streichhälzer zu ziehen, als noch da sind? Nochmal!");
				}
				//sc.nextLine();
			}
			stack_size -= pulled_matches;
			current_player = current_player==1 ? 0 : 1;
			old_pulled_matches = pulled_matches;
			pulled_matches = 42;
		}
		System.out.println(playernames[current_player]+" hat gewonnen!");
		sc.close();
	}
}
