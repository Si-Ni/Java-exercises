/* Kreisberechnung: Für einen Kreis werden der Umfang und der 
 * Flächeninhalt berechnet.
 * Der Kreisradius wird beim Programmstart als erster Parameter und
 * die Einheit als zweiter Parameter übergeben.
*/

public class Kreisberechnung3 {
	public static void main(String[] args) {
	String einheit = args[1];
	double radius = Double.parseDouble(args[0]);
	double umfang = 2.0 * 3.1415926 * radius;
	double flaeche = 3.1415926 * radius * radius;
	System.out.print("Umfang: ");
	System.out.println(umfang);
	System.out.print("Flaeche: ");
	System.out.print(flaeche);
	System.out.println(" " + einheit + '\u00b2');
	}
} 