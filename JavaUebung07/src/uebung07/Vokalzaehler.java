package uebung07;

import javax.swing.JOptionPane;

public class Vokalzaehler {

	public static void main(String[] args) {
		
		String eingabe = JOptionPane
				.showInputDialog("Geben Sie eine Zeichenkette ein, bei der die Vokale gezaehlt werden sollen");
		int anzahlA = 0, anzahlE = 0, anzahlI = 0, anzahlO = 0, anzahlU = 0;
		
		for(int i = 0; i < eingabe.length(); i++) {
				
			
				switch(eingabe.charAt(i)) {
					
				case 'a': 
					anzahlA++;
					break;
				case 'e': 
					anzahlE++;
					break;
				case 'i': 
					anzahlI++;
					break;
				case 'o': 
					anzahlO++;
					break;
				case 'u': 
					anzahlU++;
					break;	

				}
		}
		
		System.out.println("Die Eingabe \"" + eingabe + "\" enthält:");
		System.out.println(anzahlA + " mal a");
		System.out.println(anzahlE+ " mal e");
		System.out.println(anzahlI + " mal i");
		System.out.println(anzahlO + " mal o");
		System.out.println(anzahlU + " mal u");
		

	}

}
