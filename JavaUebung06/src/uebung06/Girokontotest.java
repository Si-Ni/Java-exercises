package uebung06;

public class Girokontotest {

	public static void main(String[] args) {
		Girokonto gk = new Girokonto("0000000001", 10000, 1000);
		gk.abheben(11000);
		System.out.println("Kontostand: " + gk.getKontostand());
		gk.einzahlen(11000);
		gk.abheben(110001);
		System.out.println("Kontostand: " + gk.getKontostand());
	}

}
