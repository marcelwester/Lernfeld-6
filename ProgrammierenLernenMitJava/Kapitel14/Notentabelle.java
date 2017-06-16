package gui14;

/*
 * Programm Notentabelle
 * Das Programm speichert in einer Tabelle Noten mit Gewichtung und Beschreibung,
 * für die unterschiedliche Datentypen verwendet werden.
 * Es verwendet die Klasse MyNotenTableModel, um aus den Notendaten die Durchschnitts-
 * note zu berechnen.
 *  
 * Hans-Peter Habelitz
 * 2014-10-22
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class Notentabelle extends JFrame implements TableModelListener, ListSelectionListener {

    private JPanel contentPane;
    private JTextField tfLeistungsnachweis;
    private JTextField tfGewichtung;
    private JTextField tfNote;
    private JTable tableNoten;
    private DecimalFormat df;
    private JLabel lblSelectedNotenschnitt;
    private JLabel lblNotenschnitt;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Notentabelle frame = new Notentabelle();
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
    public Notentabelle() {
	df = new DecimalFormat("#0.##");
	setTitle("Notentabelle");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 444, 355);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow]", "[198.00,grow][]"));

	JScrollPane scrollPane = new JScrollPane();
	contentPane.add(scrollPane, "cell 0 0,grow");

	tableNoten = new JTable();
	MyNotenTableModel tableNotenModel = new MyNotenTableModel(
		new Object[][] { { "Klassenarbeit", new Integer(1),
			new Double(1.0) } }, new String[] { "Leistungsnachweis",
			"Gewichtung", "Note" });
	tableNotenModel.addTableModelListener(this);
	tableNoten = new JTable();
	scrollPane.setViewportView(tableNoten);
	tableNoten.setModel(tableNotenModel);
	tableNoten.getSelectionModel().addListSelectionListener(this);

	tableNoten.getColumnModel().getColumn(0).setPreferredWidth(106);
	scrollPane.setViewportView(tableNoten);

	JPanel panelBedienelemente = new JPanel();
	contentPane.add(panelBedienelemente, "cell 0 1,grow");
	panelBedienelemente.setLayout(new MigLayout("", "[][grow][][]",
		"[][][]"));

	JLabel lblLeistungsnachweis = new JLabel("Leistungsnachweis");
	panelBedienelemente.add(lblLeistungsnachweis,
		"cell 0 0,alignx trailing");

	tfLeistungsnachweis = new JTextField();
	panelBedienelemente.add(tfLeistungsnachweis, "cell 1 0,growx");
	tfLeistungsnachweis.setColumns(10);

	lblNotenschnitt = new JLabel("Notenschnitt:");
	panelBedienelemente.add(lblNotenschnitt, "cell 3 0");

	JLabel lblGewichtung = new JLabel("Gewichtung:");
	panelBedienelemente.add(lblGewichtung, "cell 0 1,alignx trailing");

	tfGewichtung = new JTextField();
	panelBedienelemente.add(tfGewichtung, "cell 1 1,growx");
	tfGewichtung.setColumns(10);

	lblSelectedNotenschnitt = new JLabel("");
	panelBedienelemente.add(lblSelectedNotenschnitt, "cell 3 1");

	JLabel lblNote = new JLabel("Note:");
	panelBedienelemente.add(lblNote, "cell 0 2,alignx trailing");

	tfNote = new JTextField();
	panelBedienelemente.add(tfNote, "cell 1 2,growx");
	tfNote.setColumns(10);

	JButton btnInTabelleUebernehmen = new JButton(
		"In Tabelle \u00FCbernehmen");
	btnInTabelleUebernehmen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		try {
		    String t = tfLeistungsnachweis.getText();
		    int w = Integer.parseInt(tfGewichtung.getText());
		    double n = Double.parseDouble(tfNote.getText());
		    DefaultTableModel m = (DefaultTableModel) tableNoten
			    .getModel();
		    m.addRow(new Object[] { t, new Integer(w), new Double(n) });
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	    }
	});
	panelBedienelemente.add(btnInTabelleUebernehmen, "cell 3 2");
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
	// TODO Auto-generated method stub
	int[] rows = tableNoten.getSelectedRows();
	if (rows.length > 0) {
	    MyNotenTableModel m = (MyNotenTableModel) tableNoten.getModel();
	    double schnitt = m.getNotengewichtet(rows) / m.getGewichtung(rows);
	    lblSelectedNotenschnitt.setText("Notenschnitt der Auswahl: "
		    + df.format(schnitt));
	}
    }

    @Override
    public void tableChanged(TableModelEvent e) {
	// TODO Auto-generated method stub
	MyNotenTableModel m = (MyNotenTableModel) tableNoten.getModel();
	double schnitt = m.getNotengewichtet() / m.getGewichtung();
	lblNotenschnitt.setText("Notenschnitt: " + df.format(schnitt));
	lblSelectedNotenschnitt.setText("");
    }

}
