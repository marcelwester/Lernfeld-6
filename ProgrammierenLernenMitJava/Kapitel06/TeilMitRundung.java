package uebung06;

/*
 * Klasse TeilMitRundung
 * Hans-Peter Habelitz
 * 2013-12-28
 */

public class TeilMitRundung {
    double radius;

    TeilMitRundung() {
	radius = 1;
    }

    TeilMitRundung(double r) {
	radius = r;
    }

    double getRadius() {
	return radius;
    }

    void setRadius(double r) {
	radius = r;
    }

    void radiusVergroessernUm(double vr) {
	radius = radius + vr;
    }
}
