/* Programm "Guthabenentwicklung"
 * @date 16.09.2019
 * @author Simon Nikolaidis
 */
 
 import javax.swing.JOptionPane;
 
 public class Guthabenentwicklung{
	 public static void main(String[] args){
		 
		double guthaben;
		double zinsen;
		int jahr = 0;
		
		guthaben = Double.parseDouble (JOptionPane.showInputDialog ("Gib das Guthaben deines Sparkontos ein!"));
		zinsen = Double.parseDouble (JOptionPane.showInputDialog ("Gib deinen Zinssatz ein!"));

		while(jahr < 10){
			guthaben = guthaben * (1 + zinsen / 100);
			System.out.println("Dein Guthaben dieses Jahr beträgt: " + guthaben);
			jahr++;
		}
	 }
 }