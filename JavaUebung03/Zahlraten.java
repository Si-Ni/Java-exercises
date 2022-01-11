/* Programm "Zahl ratem"
 * @date 15.09.2019
 * @author Simon Nikolaidis
 */
 
 import javax.swing.JOptionPane;
 
 public class Zahlraten{
	public static void main(String[] args){
	
	int eingabe;
	int Zahl = 6;
	
	eingabe = Integer.parseInt (JOptionPane.showInputDialog("Geben Sie eine Zahl zwischen 0 und 10 an"));
	
	switch (eingabe) {
	case 6: 
		JOptionPane.showMessageDialog(null, "Treffer!");
		break;
	case 4:
	case 5:
	case 7:
	case 8: 
		JOptionPane.showMessageDialog(null, "Knapp daneben!");
		break;
	default:
		JOptionPane.showMessageDialog(null, "Daneben!");
	}
	}
 }