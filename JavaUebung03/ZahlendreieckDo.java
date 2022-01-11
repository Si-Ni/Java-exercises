/* Programm "Zahlendreieck DO-Schleife"
 * date: 16.09.2019
 * author: Simon Nikolaidis
 */
 
public class ZahlendreieckDo {
 
	public static void main(String[] args){
	int zaehler = 0;
	String ausgabe = "";
	
	do {
		ausgabe = ausgabe + zaehler;
		System.out.println(ausgabe);
		zaehler ++;
	} while (zaehler < 10);
	}
 }