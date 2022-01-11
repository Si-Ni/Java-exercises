package uebung07;

import javax.swing.JOptionPane;

public class Stringrueckwaerts {

	public static void main(String[] args) {
		
		String eingabe = JOptionPane.showInputDialog("Geben Sie eine zeichenkette ein!");
		StringBuilder rueckwaerts = new StringBuilder("");
		
		for(int i = 0; i < eingabe.length(); i++) {
			char c = eingabe.charAt(i);
			rueckwaerts.insert(0, c);
		}
		System.out.println(rueckwaerts);

	}

}
