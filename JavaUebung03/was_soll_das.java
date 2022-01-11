/* Programm "Was soll das"
 * @date 16.09.2019
 * @author Simon Nikolaidis
 */
 
 import javax.swing.JOptionPane;
 
public class was_soll_das{
	public static void main(String[] args){
	
	int m;
	int n;
	
	n = Integer.parseInt (JOptionPane.showInputDialog ("Geben Sie einen Wert fuer n ein"));
	m = Integer.parseInt (JOptionPane.showInputDialog ("Geben Sie einen Wert fuer m ein"));
	
	while (m != n) {
		if (m > n){
			m = m - n;
		}else{
			n = n - m;
		}
	}
	JOptionPane.showMessageDialog(null, "m = " + m);
	}
}