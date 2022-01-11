package uebung07;

import javax.swing.JOptionPane;

public class Stringsort {

	public static void main(String[] args) {
		
		String eingabe1 = JOptionPane.showInputDialog("Geben Sie die erste Zeichenkette ein!");
		String eingabe2 = JOptionPane.showInputDialog("Geben Sie die zweite Zeichenkette ein!");
		String eingabe3 = JOptionPane.showInputDialog("Geben Sie die dritte Zeichenkette ein!");
		
		int test = eingabe1.compareTo(eingabe2);
		int test2 = eingabe1.compareTo(eingabe3);
		int test3 = eingabe2.compareTo(eingabe3);
			if (test < 0 && test2 < 0) {
				System.out.println("1.: " + eingabe1);
				if (test3 < 0) {
					System.out.println("2.: " + eingabe2);
					System.out.println("3.: " + eingabe3);
				}else if(test3 > 0) {
					System.out.println("2.: " + eingabe3);
					System.out.println("3.: " + eingabe2);
				}
			}else if(test > 0 && test2 > 0) {
				if (test3 < 0) {
					System.out.println("1.: " + eingabe2);
					System.out.println("2.: " + eingabe3);
				}else if(test3 > 0) {
					System.out.println("1.: " + eingabe3);
					System.out.println("2.: " + eingabe2);
				}
				System.out.println("3.: " + eingabe1);
			}else if(test > 0 && test2 < 0 || test < 0 && test2 > 0) {
				if (test3 < 0) {
					System.out.println("1.: " + eingabe2);
					System.out.println("2.: " + eingabe1);
					System.out.println("3.: " + eingabe3);
				}else if(test3 > 0) {
					System.out.println("1.: " + eingabe3);
					System.out.println("2.: " + eingabe1);
					System.out.println("3.: " + eingabe2);
				}
			}else {
				System.out.println("Die Zeichenketten sind gleich");
			}
	}

}
