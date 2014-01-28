package de.malte_bublitz.itc.vererbung;


public class GrussAusgabe
{
	/*public static void main(String args[])
	{
		Franzose jean = new Franzose("Jean");
		Deutscher hans = new Deutscher("Hans");
		Bayer sepp = new Bayer("Sepp");
		sepp.setLieblingsbier("Franziskaner Weisse");
		
		System.out.println(jean.getName() + " : " + jean.getGruss());
		System.out.println(hans.getName() + " : " + hans.getGruss());
		System.out.println(sepp.getName() + " : " + sepp.getGruss());
	}*/
	public static void main(String args[]) {
		Franzose jean = new Franzose("Jean");
		Deutscher hans = new Deutscher("Hans");
		Bayer sepp = new Bayer("Sepp");
		sepp.setLieblingsbier("Franziskaner Weisse");
		Schwabe dorle = new Schwabe("Dorle");
		Italiener francesco = new Italiener("Francesco");
		Person allepersonen[] = new Person[5];
		allepersonen[0] = jean;
		allepersonen[1] = hans;
		allepersonen[2] = sepp;
		allepersonen[3] = dorle;
		allepersonen[4] = francesco;
		for (int i=0; i<5; i++) {
			System.out.println(allepersonen[i].getName() + " : " + allepersonen[i].getGruss());
		}
	}
}// class
