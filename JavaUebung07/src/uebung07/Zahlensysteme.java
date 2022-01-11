package uebung07;

import javax.swing.JOptionPane;

public class Zahlensysteme {

	public static void main(String[] args) {
		
		String eingabe = JOptionPane.showInputDialog("geben Sie eine ganze Zahl ein");
		Integer zahl = Integer.valueOf(eingabe);
		
		Double dezimal = Double.valueOf(zahl);
		String binary = Integer.toBinaryString(zahl);
		String hexal = Integer.toHexString(zahl);
		
		JOptionPane.showMessageDialog(null, "Als Dezimalzahl: " + dezimal + "\n" + "Als Dualzahl: " + binary + "\n" + "Als Hexadezimalzahl: " + hexal.toUpperCase());
	}
}
