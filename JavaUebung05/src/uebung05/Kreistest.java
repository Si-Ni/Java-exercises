package uebung05;

import javax.swing.JOptionPane;

public class Kreistest {

	public static void main(String[] args) {
		
		String Kreisradius, einheit;
		double r;
		
		Kreisradius = JOptionPane
				.showInputDialog("Geben Sie einen Kreisradius ein: ");
		einheit = JOptionPane
				.showInputDialog("Geben Sie eine Einheit an: ");
		r = Double.parseDouble(Kreisradius);
		
		Kreis k = new Kreis(r);
		JOptionPane.showMessageDialog(null, "Der Radius des Kreises betr�gt: " + k.getRadius() + einheit);
		JOptionPane.showMessageDialog(null, "Der Umfang des Kreises betr�gt: " + k.getUmfang() + einheit);
		JOptionPane.showMessageDialog(null, "Der Flaecheninhalt des Kreises betr�gt: " + k.getFlaeche() + einheit + '\u00b2');
	}

}
