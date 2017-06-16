package gui12;

/*
 * Programm Textzeichner2 (mit Fontauswahl-Dialog)
 * Gibt an beliebigen Positionen eines Panels Text in
 * den Farben schwarz oder rot aus.
 * 
 * Hans-Peter Habelitz
 * 2014-10-21
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Textzeichner2 extends JFrame {

    private JPanel contentPane;
    private JTextField tfTexteingabe;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private Graphics2D g2d;
    private JRadioButton rdbtnSchwarz;
    private JRadioButton rdbtnRot;
    private JButton btnSchriftart;
    private JLabel lblSchriftprobe;
    private Font f;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Textzeichner2 frame = new Textzeichner2();
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
    public Textzeichner2() {
	setTitle("Textzeichner2");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane
		.setLayout(new MigLayout("", "[283.00,grow][grow]", "[grow]"));

	JPanel panelZeichenflaeche = new JPanel();
	panelZeichenflaeche.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Color farbe;
		if (rdbtnSchwarz.isSelected()) {
		    farbe = Color.black;
		} else {
		    farbe = Color.red;
		}
		g2d = (Graphics2D) panelZeichenflaeche.getGraphics();
		if (f != null) {
		    g2d.setFont(f);
		}
		g2d.setColor(farbe);
		g2d.drawString(tfTexteingabe.getText(), x, y);
	    }
	});
	panelZeichenflaeche.setBorder(new LineBorder(new Color(0, 0, 0)));
	panelZeichenflaeche.setBackground(new Color(255, 255, 255));
	contentPane.add(panelZeichenflaeche, "cell 0 0,grow");

	JPanel panelBedienelemente = new JPanel();
	contentPane.add(panelBedienelemente, "cell 1 0,grow");
	panelBedienelemente.setLayout(new MigLayout("", "[grow]",
		"[][][][][][][][]"));

	JLabel lblTexteingabe = new JLabel("Texteingabe");
	panelBedienelemente.add(lblTexteingabe, "cell 0 0");

	tfTexteingabe = new JTextField();
	panelBedienelemente.add(tfTexteingabe, "cell 0 1,growx");
	tfTexteingabe.setColumns(10);

	rdbtnSchwarz = new JRadioButton("schwarz");
	rdbtnSchwarz.setSelected(true);
	buttonGroup.add(rdbtnSchwarz);
	panelBedienelemente.add(rdbtnSchwarz, "cell 0 3");

	rdbtnRot = new JRadioButton("rot");
	buttonGroup.add(rdbtnRot);
	panelBedienelemente.add(rdbtnRot, "cell 0 4");

	btnSchriftart = new JButton("Schriftart w\u00E4hlen");
	btnSchriftart.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		g2d = (Graphics2D) panelZeichenflaeche.getGraphics();
		if (f == null) {
		    f = g2d.getFont();
		}
		Font nf = JMyFontChooser.showDialog(null, f);
		if (nf != null) {
		    f = nf;
		}
		lblSchriftprobe.setFont(f);
		g2d.setFont(f);
	    }
	});
	panelBedienelemente.add(btnSchriftart, "cell 0 6");

	lblSchriftprobe = new JLabel("Schriftprobe");
	panelBedienelemente.add(lblSchriftprobe, "cell 0 7,alignx center");
    }

}
