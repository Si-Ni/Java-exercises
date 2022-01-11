package uebung06;

public class Kontotest {

	public static void main(String[] args) {
		
		Konto k = new Konto("000000001", 1000);
		
		System.out.println("Ihre Kontonummer lautet: "+ k.getKontonummer());
		System.out.println("Ihr Kontostand beträgt: " + k.getKontostand() + " €");

		k.einzahlen(500);
		k.abheben(750.5);
		
		System.out.println("Ihre Kontonummer lautet: "+ k.getKontonummer());
		System.out.println("Ihr neuer Kontostand beträgt: " + k.getKontostand() + " €");
	}

}
