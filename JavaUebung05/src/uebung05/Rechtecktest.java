package uebung05;

import javax.swing.JOptionPane;

public class Rechtecktest {

	public static void main(String[] args) {
		
		Rechteck r = new Rechteck();
		String laenge, breite, einheit;
		laenge = JOptionPane
				.showInputDialog("Geben Sie die Laenge des Rechteckes an: ");
		breite = JOptionPane
				.showInputDialog("Geben Sie die Breite des Rechteckes an: ");
		einheit = JOptionPane
				.showInputDialog("Geben Sie die Maﬂeinheit an: ");
		r.laenge = Double.parseDouble(laenge);
		r.breite = Double.parseDouble(breite);
		
		System.out.println("Die Laenge des Rechteckes betraegt: " + r.getLaenge() + " " + einheit);
		System.out.println("Die Breite des Rechteckes betraegt: " + r.getBreite() + " " + einheit);
		System.out.println("Die lange Seite des Rechteckes betraegt: " + r.getLangeSeite() + " " + einheit);
		System.out.println("Die kurze Seite des Rechteckes betraegt: " + r.getKurzeSeite() + " " + einheit);
		System.out.println("Die Diagonale des Rechteckes betraegt: " + r.getDiagonale() + " " + einheit);
		System.out.println("Der Flaecheninhalt des Rechteckes betraegt: " + r.getFlaeche() + " " + einheit + '\u00b2');
		System.out.println("Der Umfang des Rechteckes betraegt: " + r.getUmfang() + " " + einheit);
		
		r.laengeAusgeben();
		r.breiteVerkleiner(3.3);
	}
}
