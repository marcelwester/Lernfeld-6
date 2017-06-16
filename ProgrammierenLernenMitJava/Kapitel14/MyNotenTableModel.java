package gui14;

/*
 * Klasse MyNotenTableModel (von der Klasse DefaultTableModel abgeleitet)
 * Die Klasse ist die Basis für eine Tabelle, die unterschiedliche Datentypen
 * aufnehmen soll. Sie ist in der Lage, den Gesamtnotenschnitt und den Notenschnitt
 * über einen markierten Bereich der Tabelle zu berechnen.
 *  
 * Hans-Peter Habelitz
 * 2011-12-27
 */

import javax.swing.table.DefaultTableModel;

public class MyNotenTableModel extends DefaultTableModel {
    MyNotenTableModel() {
	super();

    }

    MyNotenTableModel(Object[][] d, Object[] n) {
	super(d, n);
    }

    public Class getColumnClass(int col) {
	if (col == 0)
	    return String.class;
	else if (col == 1)
	    return Integer.class;
	else
	    return Double.class;
    }

    public double getNotegewichtet(int row) {
	int gewichtung = ((Integer) getValueAt(row, 1)).intValue();
	double note = ((Double) getValueAt(row, 2)).doubleValue();
	return gewichtung * note;
    }

    public int getGewichtung(int row) {
	int gewichtung = ((Integer) getValueAt(row, 1)).intValue();
	return gewichtung;
    }

    public double getNotengewichtet(int[] rows) {
	double gesamt = 0;
	for (int i = 0; i < rows.length; i++) {
	    gesamt += getNotegewichtet(rows[i]);
	}
	return gesamt;
    }

    public int getGewichtung(int[] rows) {
	int gewichtung = 0;
	for (int i = 0; i < rows.length; i++) {
	    gewichtung += getGewichtung(rows[i]);
	}
	return gewichtung;
    }

    public double getNotengewichtet() {
	int max = getRowCount();
	double gesamt = 0;
	for (int i = 0; i < max; i++) {
	    gesamt += getNotegewichtet(i);
	}
	return gesamt;
    }

    public double getGewichtung() {
	int max = getRowCount();
	double gewichtung = 0;
	for (int i = 0; i < max; i++) {
	    gewichtung += getGewichtung(i);
	}
	return gewichtung;
    }
}
