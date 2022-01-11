package uebung05;

public class Rechteck {
	
	double laenge;
	double breite;
	
	Rechteck() {
		laenge = 0;
		breite = 0;
	}
	Rechteck(double l, double b) {
		laenge = l;
		breite = b;
	}
	void setLaenge(double l) {
		laenge = l;
	}
	void setbreite(double b) {
		breite = b;
	}
	void setSeiten(double l, double b) {
		laenge = l;
		breite = b;
	}
	double getLaenge() {
		return laenge;
	}
	double getBreite() {
		return breite;
	}
	double getLangeSeite() {
		if (laenge > breite)
			return laenge;
		else 
			return breite;
	}
	double getKurzeSeite() {
		if (laenge < breite)
			return laenge;
		else
			return breite;
	}
	double getDiagonale() {
		return Math.sqrt(laenge*laenge+breite*breite);
	}
	double getFlaeche() {
		return laenge * breite;
	}
	double getUmfang() {
		return 2 * laenge + 2 * breite;
	}
	void laengeAusgeben() {
		double laenge = 5.4;
		System.out.println("Laenge: " + laenge);
	}
	void laengeVergroessern(double dl) {
		laenge += dl; 
	}
	void breiteVergroessern(double db) {
		breite += db; 
	}
	void laengeVerkleiner(double dl) {
		laenge -= dl; 
	}
	void breiteVerkleiner(double db) {
		breite -= db; 
		System.out.println(breite);
	}
}
