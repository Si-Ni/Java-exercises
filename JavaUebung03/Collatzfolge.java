/* Programm zu Collatzfolge
 * @date 16.09.2019
 * @author Simon Nikolaidis
 */
 
 import javax.swing.JOptionPane;
 
 public class Collatzfolge{
	 public static void main(String[] args){
		
		int n;
		n = Integer.parseInt (JOptionPane.showInputDialog("Geben Sie einen Wert für n ein"));
		int zaehler = 0;
		int maximum = n;

		while(n != 1){
			if(n % 2 == 0){
				n = n / 2;
				zaehler++;
				System.out.println("n = " + n);
			}else{
				n = 3 * n + 1;
				zaehler++;
				System.out.println("n = " + n);
			}if(n > maximum){
				maximum = n;
			}
		}
		System.out.println("Die Länge der Folge beträgt: " + zaehler);
		System.out.println("Das Maximum der Folge beträgt: " + maximum);
	}
 }