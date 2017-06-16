package gui14;

/*
 * Programm Kontakttabelle (Musterlösung zur Kapitel 14 Aufgabe 1)
 * Die Kontakdaten Name, Vorname, Telefonnummer und Email-Adresse
 * in Textfeldern eingegeben und von dort in eine JTable übernommen
 * werden.
 * Markierte Einträge können aus der Tabelle gelöscht werden.
 * Die Einträge können direkt in der Tabelle editiert werden.
 *  
 * Hans-Peter Habelitz
 * 2014-10-22
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import net.miginfocom.swing.MigLayout;

public class Kontakttabelle extends JFrame {

    private JPanel contentPane;
    private JTextField tfNachname;
    private JTextField tfVorname;
    private JTextField tfTelefon;
    private JTextField tfEmail;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Kontakttabelle frame = new Kontakttabelle();
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
    public Kontakttabelle() {
    	setTitle("Kontakttabelle");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 540, 308);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[131px,grow][13px][132px,grow][10px][120px,grow][9px][89px,grow]", "[14px][20px][14px][23px][14px][105px,grow][23px]"));
	
	JLabel lblNachname = new JLabel("Nachname");
	contentPane.add(lblNachname, "cell 0 0,growx,aligny top");
	
	tfNachname = new JTextField();
	contentPane.add(tfNachname, "cell 0 1,growx,aligny top");
	tfNachname.setColumns(10);
	
	JLabel lblVorname = new JLabel("Vorname");
	contentPane.add(lblVorname, "cell 2 0,alignx left,aligny top");
	
	tfVorname = new JTextField();
	contentPane.add(tfVorname, "cell 2 1,growx,aligny top");
	tfVorname.setColumns(10);
	
	JLabel lblTelefon = new JLabel("Telefon");
	contentPane.add(lblTelefon, "cell 4 0,growx,aligny top");
	
	tfTelefon = new JTextField();
	contentPane.add(tfTelefon, "cell 4 1 3 1,growx,aligny top");
	tfTelefon.setColumns(10);
	
	JLabel lblEmail = new JLabel("EMail");
	contentPane.add(lblEmail, "cell 0 2,growx,aligny top");
	
	tfEmail = new JTextField();
	contentPane.add(tfEmail, "cell 0 3 3 1,growx,aligny center");
	tfEmail.setColumns(10);
	
	JButton btnUebernehmen = new JButton("\u00DCbernehmen >>");
	btnUebernehmen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if (tfNachname.getText().isEmpty()) {
			    JOptionPane.showMessageDialog(null, "kein Name angegeben!");
			    tfNachname.requestFocus();
			} else {
			    DefaultTableModel m = (DefaultTableModel) table.getModel();
			    m.addRow(new String[] { tfNachname.getText(),
				    tfVorname.getText(), tfTelefon.getText(),
				    tfEmail.getText() });
			}
		}
	});
	contentPane.add(btnUebernehmen, "cell 4 3 3 1,growx,aligny top");
	
	JScrollPane scrollPane = new JScrollPane();
	contentPane.add(scrollPane, "cell 0 5 7 1,grow");
	
	table = new JTable();
	scrollPane.setViewportView(table);
	TableModel tableModel = new DefaultTableModel(
		    new String[][] {}, new String[] { "Nachname",
			    "Vorname", "Telefon", "EMail" });
	table.setModel(tableModel);
	JLabel lblKontaktliste = new JLabel("Kontaktliste");
	contentPane.add(lblKontaktliste, "cell 0 4,growx,aligny top");
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	contentPane.add(btnEnde, "cell 6 6,growx,aligny top");
	
	new DefaultListModel<String>();
	
	JButton btnLoeschen = new JButton("markierten Eintrag l\u00F6schen");
	btnLoeschen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if (table.getSelectedRow() >= 0) {
			    DefaultTableModel m = (DefaultTableModel) table.getModel();
			    m.removeRow(table.getSelectedRow());
			}
		}
	});
	contentPane.add(btnLoeschen, "cell 0 6 3 1,alignx left,aligny top");
    }
}
