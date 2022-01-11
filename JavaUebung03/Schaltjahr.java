/* Programm zu Schaltjahr 
 * @date 11.09.2019
 * @author Simon Nikolaidis
 */
 
 import javax.swing.JOptionPane;
 
 public class Schaltjahr {
	public static void main(String[] args) {
	
	int Jahr;
	
	Jahr = Integer.parseInt(JOptionPane.showInputDialog("Gib hier ein Jahr ein, das du überprüfen möchtest: "));
	
	if((Jahr % 4) == 0 || (Jahr % 400) == 0){
	JOptionPane.showMessageDialog(null, "Das Jahr ist ein Schaltjahr!");
	}else{
		if((Jahr % 4) == 0 ^ (Jahr % 100) == 0){
		JOptionPane.showMessageDialog(null, "Das Jahr ist ein Schaltjahr!");
		}
	}

		if((Jahr % 4) > 0){
	JOptionPane.showMessageDialog(null, "Das Jahr ist kein Schaltjahr!");
	}
	}
}	
