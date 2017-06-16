package gui14;

/*
 * Klasse BestellTableModel (Musterlösung zur Kapitel 14 Aufgabe 3)
 * Die Klasse ist von der Klasse DefaultTableModel abgeleitet.
 * Die Klasse ist die Basis für eine Tabelle, die unterschiedliche Datentypen
 * für Bestelldaten aufnehmen soll.
 *  
 * Hans-Peter Habelitz
 * 2011-12-28
 */

import javax.swing.table.DefaultTableModel;

public class BestellTableModel extends DefaultTableModel {
    BestellTableModel() {
	super();

    }

    BestellTableModel(Object[][] d, Object[] n) {
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

    public double getPreisPosition(int row) {
	double gesamtpreis = ((Integer) getValueAt(row, 1)).intValue()
		* ((Double) getValueAt(row, 2)).doubleValue();
	return gesamtpreis;
    }

    public double getPreisMarkiert(int[] rows) {
	double gesamtpreis = 0;
	for (int i = 0; i < rows.length; i++) {
	    gesamtpreis += getPreisPosition(rows[i]);
	}
	return gesamtpreis;
    }

    public double getPreisGesamt() {
	int max = getRowCount();
	double gesamtpreis = 0;
	for (int i = 0; i < max; i++) {
	    gesamtpreis += getPreisPosition(i);
	}
	return gesamtpreis;
    }
}
