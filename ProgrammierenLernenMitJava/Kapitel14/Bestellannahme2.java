package gui14;

/*
 * Programm Bestellannahme2 (Musterlösung zur Kapitel 14 Aufgabe 3)
 * Das Programm dient der Aufnahme einer Bestellung.
 * In einer JTable werden die Bestellpostionen mit Artikelbezeichnung,
 * Stückzahl und Einzelpreis erfasst. Die Tabelle berechnet daraus
 * den aktuellen Gesamtbestellwert und die Mehrwertsteuer. 
 *  
 * Hans-Peter Habelitz
 * 2014-10-22
 */

import java.awt.EventQueue;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bestellannahme2 extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JLabel lblEndpreis;
    private JLabel lblMehrwertsteuer;
    private DecimalFormat df;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Bestellannahme2 frame = new Bestellannahme2();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public Bestellannahme2() {
	df = new DecimalFormat("#0.00 €");
	setTitle("Bestellannahme");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane
		.setLayout(new MigLayout("", "[grow]", "[155.00,grow][grow]"));

	JScrollPane scrollPane = new JScrollPane();
	contentPane.add(scrollPane, "cell 0 0,grow");

	table = new JTable();
	TableModel tableModel = new BestellTableModel(new Object[][] { {
		"Artikelbezeichnung", new Integer(0), new Double(0.0) } },
		new String[] { "Artikelbezeichnung", "Anzahl",
			"Einzelpreis (€)" });
	tableModel.addTableModelListener(new TableModelListener() {
	    public void tableChanged(TableModelEvent evt) {
		BestellTableModel m = (BestellTableModel) table.getModel();
		double MWSt = m.getPreisGesamt() * 0.19;
		lblMehrwertsteuer.setText("Mehrwertsteuer: " + df.format(MWSt));
		double gesamtpreis = m.getPreisGesamt() + MWSt;
		lblEndpreis.setText("Gesamtpreis: " + df.format(gesamtpreis));
	    }
	});
	table.setModel(tableModel);
	scrollPane.setViewportView(table);

	JPanel panel = new JPanel();
	contentPane.add(panel, "cell 0 1,grow");
	panel.setLayout(new MigLayout("", "[][grow][]", "[][]"));

	JButton btnNeueBestellposition = new JButton("Neue Bestellposition");
	btnNeueBestellposition.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		BestellTableModel m = (BestellTableModel) table.getModel();
		m.addRow(new Object[] { "Artikelbezeichnung", new Integer(0),
			new Double(0.0) });
	    }
	});
	panel.add(btnNeueBestellposition, "cell 0 0");

	lblMehrwertsteuer = new JLabel("Mehrwertsteuer gesamt:");
	panel.add(lblMehrwertsteuer, "cell 2 0,alignx right");

	lblEndpreis = new JLabel("Endpreis:");
	panel.add(lblEndpreis, "cell 2 1,alignx right");
    }

}
