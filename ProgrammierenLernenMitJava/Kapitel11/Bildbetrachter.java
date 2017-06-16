package gui11;

/*
 * Programm Bildbetrachter
 * Über einen Dateiauswahldialog kann eine Bilddatei (jpg, gif oder png)
 * geladen werden. Das Bild wird in einem Scrollpane dargestellt.
 * 
 * Hans-Peter Habelitz
 * 2014-09-24
 */

import java.awt.EventQueue;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class Bildbetrachter extends JFrame {

    private JPanel contentPane;
    private JScrollPane scrollPane;
    private ImageComponent bild;
    private BufferedImage bufImg;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Bildbetrachter frame = new Bildbetrachter();
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
    public Bildbetrachter() {
	bild = new ImageComponent();
	JScrollPane scrollPane = new JScrollPane();
	setTitle("Bildbetrachter");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 444, 586);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow]", "[][grow]"));

	JButton btnBilddateiOeffnen = new JButton(
		"Bilddatei \u00F6ffnen");
	btnBilddateiOeffnen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setFileFilter(new FileNameExtensionFilter("*.jpg;*.gif",
			"jpg", "gif"));
		fc.setCurrentDirectory(new File("."));
		int status = fc.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION) {
		    String selFile = fc.getSelectedFile().getAbsolutePath();
		    try {
			bufImg = ImageIO.read(new File(selFile));
			System.out.println(bufImg);
			bild.setImage(bufImg);
			scrollPane.setSize(bufImg.getWidth() + 2,
				bufImg.getHeight() + 2);
			scrollPane.setViewportView(bild);
			setSize(bufImg.getWidth() + 43, bufImg.getHeight() + 95);

		    } catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
				"Fehler beim Öffnen der Datei!");
			ex.printStackTrace();
		    }
		}
	    }
	});
	contentPane.add(btnBilddateiOeffnen, "cell 0 0");
	contentPane.add(scrollPane, "cell 0 1,grow");

	try {
	    bufImg = ImageIO
		    .read((getClass().getResource("/gui11/bewblau.jpg")));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	bild.setImage(bufImg);
	scrollPane.setViewportView(bild);
    }

}
