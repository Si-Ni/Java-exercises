/* Programm ggtEuklid
 * @date 16.09.2019
 * @author Simon Nikolaidis
 */
 
import javax.swing.JOptionPane;

public class ggTEuklid{
	public static void main(String[] args){
	
	int m;
	int n;
	int r;
	
	n = Integer.parseInt (JOptionPane.showInputDialog ("Geben Sie einen Wert fuer n ein"));
	m = Integer.parseInt (JOptionPane.showInputDialog ("Geben Sie einen Wert fuer m ein"));
	
	r = m % n;
	
	while(r > 0){
		m = n;
		n = r;
		r = m % n;
	}
	JOptionPane.showMessageDialog(null, "ggT = " + n);
	}
}