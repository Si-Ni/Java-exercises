/* Programm zur Vergleichen von Zahlen 
 * @date 11.09.2019
 * @author Simon Nikolaidis
 */

import javax.swing.JOptionPane;

public class Zahlentest{
	public static void main(String[] args) {
	
	double Zahl;
	String eingabe;
	
	eingabe = JOptionPane.showInputDialog(
								"Geben sie eine Zahl ein: ");
	Zahl = Double.parseDouble(eingabe);
	
		if (Zahl < 0) {
			JOptionPane.showMessageDialog(
								null, "Die zahl ist negativ!");
		} else {
			JOptionPane.showMessageDialog(null,
								"Die Zahl ist nicht negativ!");
		}
	}
}