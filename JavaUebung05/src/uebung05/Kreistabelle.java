package uebung05;

import javax.swing.JOptionPane;

public class Kreistabelle {

	public static void main(String[] args) {
		
		String eingabeRadius, eingabeErhoehung;
		double r, dr;
		
		eingabeRadius = JOptionPane.showInputDialog("Geben Sie den Kreisradius ein: ");
		eingabeErhoehung = JOptionPane.showInputDialog("Geben Sie den Wert ein, um den der Radius pro Schritt erhöht werden soll: ");
		
		r = Double.parseDouble(eingabeRadius);
		dr = Double.parseDouble(eingabeErhoehung);
		Kreis k = new Kreis(r);
		
		System.out.println("Radius\t\tUmfang\t\t\t\tFläche");
		for (int i = 0; i < 30; i++) {
			System.out.println(k.getRadius() + "\t\t" + k.getUmfang() + "\t\t" + k.getFlaeche());
			k.radiusVergrößern(dr);
		}
	}
}
