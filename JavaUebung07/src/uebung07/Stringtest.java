package uebung07;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class Stringtest {
	public static void main(String[] args) {
		
		String a = "Das ist ";
		String b = "eine Zeichenkette";
		String c = "Das ist ";
		
		if(a.equals(c)) {
			System.out.println("a und c sind gleiche Zeichenketten");
		}else {
			System.out.println("a und c sind ungleich");
		}
		
		a = a.concat(b);
		System.out.println(a);
		int length = a.length();
		System.out.println(length);
		int compared = c.compareTo(b); //lexikalische Einordnung
		System.out.println(compared);
		char c1 = a.charAt(2);
		System.out.println(c1);
		a = a.toUpperCase();
		System.out.println(a);
		a = a.toLowerCase();
		System.out.println(a);
		c = String.valueOf(34.5);
		System.out.println(c);
		
		// StringBuilder:
		
		StringBuilder d = new StringBuilder();
		StringBuilder e = new StringBuilder("Zeichenkette!");
		System.out.println(d);
		System.out.println(e);
		//Methoden für diese Klasse: siehe Buch S.237
		
		//Wrapper Klassen:
		
		Integer  int1 = Integer.valueOf( "30" );
		int int2 = int1.intValue();		//Integer aus String
		System.out.println(int2);
		String Binary = Integer.toBinaryString(int1);
		System.out.println(Binary);		//String aus Integer
		int f = Integer.parseInt(Binary);
		System.out.println(f);			//Integer aus String
		
		//Time and Date:
		Instant zeitpunkt = Instant.now();
		System.out.println(zeitpunkt);
		
		Instant zeitpunkt1 = Instant.EPOCH;
		Instant zeitpunkt2 = zeitpunkt1.plus(10, ChronoUnit.SECONDS);
		System.out.println(zeitpunkt2);
		
		Duration dauer = Duration.of(10, ChronoUnit.MINUTES);
		Duration verlaengerung = dauer.plus(2, ChronoUnit.HOURS);
		System.out.println(verlaengerung);
		//siehe Beispielprogramm S.252
		
	}
}
