package uebung06;

public class Seriennummerntest {

	public static void main(String[] args) {
		
		BruchMitSeriennummer a = new BruchMitSeriennummer(1, 2);
		BruchMitSeriennummer b = new BruchMitSeriennummer(3, 4);
		BruchMitSeriennummer c = new BruchMitSeriennummer(5, 6);
		BruchMitSeriennummer d = new BruchMitSeriennummer(7, 8);
		BruchMitSeriennummer e = new BruchMitSeriennummer(9, 10);
		
		System.out.println(a.bruchToString() + " " + "Seriennummer: " + a.getSeriennummer());
		System.out.println(b.bruchToString() + " " + "Seriennummer: " + b.getSeriennummer());
		System.out.println(c.bruchToString() + " " + "Seriennummer: " + c.getSeriennummer());
		System.out.println(d.bruchToString() + " " + "Seriennummer: " + d.getSeriennummer());
		System.out.println(e.bruchToString() + " " + "Seriennummer: " + e.getSeriennummer());
	}
}
