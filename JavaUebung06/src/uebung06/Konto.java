package uebung06;

public class Konto {

	private String Kontonummer;
	private double Kontostand;
	
	Konto(String KN, double KS) {
		Kontonummer = KN;
		Kontostand = KS;
	}
	double getKontostand() {
		return Kontostand;
	}
	String getKontonummer() {
		return Kontonummer;
	}
	void einzahlen(double e) {
		Kontostand += e;
	}
	void abheben(double a) {
		Kontostand -= a;
	}
		
}
