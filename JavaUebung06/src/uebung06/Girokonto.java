package uebung06;

public class Girokonto extends Konto {
	double limit;
	
	Girokonto(String KN, double KS, double KL){
		super(KN, KS);
		limit = KL;
	}
	double getLimit() {
		return limit;
	}
	void setLimit(double KL) {
		limit = KL;
	}
	void abheben(double a) {
		if ((getKontostand() - a) >= (limit * (-1))) {
			super.abheben(a);
		}else {
			System.out.println("Fehler - Kreditlimit überschritten!");
		}
	}
}
