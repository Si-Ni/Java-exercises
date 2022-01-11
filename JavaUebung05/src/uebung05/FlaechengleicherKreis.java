package uebung05;

import javax.swing.JOptionPane;

public class FlaechengleicherKreis {

	public static void main(String[] args) {
		
		Kreis k = new Kreis();
		Rechteck r = new Rechteck();
		String laenge, breite;
		
		laenge = JOptionPane
				.showInputDialog("Geben Sie die Laenge des Rechteckes an: ");
		breite = JOptionPane
				.showInputDialog("Geben Sie die Breite des Rechteckes an: ");
		
		r.laenge = Double.parseDouble(laenge);
		r.breite = Double.parseDouble(breite);
		
		k.setFlaeche(r.getFlaeche());
		
		System.out.println("Rechtecklaenge: " + r.getLaenge());
		System.out.println("Rechteckbreite: " + r.getBreite());
		System.out.println("Rechteckflaeche: " + r.getFlaeche());
		System.out.println("Kreisradius: " + k.getRadius());
		System.out.println("Kreisflaeche: " + k.getFlaeche());

	}

}
