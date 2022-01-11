package uebung05;

public class Kreis {
	double radius;
	
	Kreis() {
		radius = 0;
	}
	Kreis(double r) {
		radius = r;
	}
	double getRadius() {
		return radius;
	}
	void setRadius(double r) {
		radius = r;
	}
	double getUmfang() {
		return 2.0 * Math.PI * radius;
	}
	double getFlaeche() {
		return Math.PI * radius * radius;
	}
	void setUmfang(double u) {
		radius = u / (2 * Math.PI);
	}
	void setFlaeche(double A) {
		radius = Math.sqrt(A / Math.PI);
	}
	void radiusVergrößern(double dr) {
		radius += dr;
	}
}
