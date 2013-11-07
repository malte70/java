import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Zeile: ");
		String text2 = sc.nextLine();
		System.out.print("Zahl: ");
		float zahl2 = sc.nextFloat();
		System.out.println("Eingaben waren: "+text2+" und "+zahl2);
	}
}
