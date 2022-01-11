/* Programm zu quadratischen Gleichungen
 * @date 11.09.2019
 * @author Simon Nikolaidis
 */
 
 import javax.swing.JOptionPane;
 
 public class LoesungenQuadratischeGleichungen {
	public static void main(String[] args){
	
	double a, b, c, D;
	
	a = Double.parseDouble (JOptionPane.showInputDialog("ax" + '\u00b2'
		+ " + bx + c; Geben Sie den Koeffizienten a ein:"));
	b = Double.parseDouble (JOptionPane.showInputDialog("ax" + '\u00b2'
		+ " + bx + c; Geben Sie den Koeffizienten b ein:"));
	c = Double.parseDouble (JOptionPane.showInputDialog("ax" + '\u00b2'
		+ " + bx + c; Geben Sie den Koeffizienten c ein:"));
	
		D = b * b - 4 * a * c;
		
			if( D == 0 ) {
			JOptionPane.showMessageDialog(null, "Die Gleichung hat eine Loesung!");
			}else{
				if( D > 0 ) {
				JOptionPane.showMessageDialog(null, "Die Gleichung hat zwei Loesungen!");
				}else{
					JOptionPane.showMessageDialog(null, "Die Gleichung hat keine Loesung!");
				}
			}
	}
 }