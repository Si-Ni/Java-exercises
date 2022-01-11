package uebung05;

public class Bruchtest1 {

	public static void main(String[] args) {
		Bruch b = new Bruch();
		Bruch c = new Bruch();
		b.zaehler = 3;
		b.nenner = 4;
		c.zaehler = 5;
		c.nenner = 6;
		System.out.println("Bruch b = " + b.zaehler + "/" + b.nenner);
		System.out.print("Bruch c = " + c.zaehler + "/" + c.nenner);

	}

}
