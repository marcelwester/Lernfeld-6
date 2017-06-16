package gui11;

/*
 * Programm Bildbetrachter1
 * Über einen Dateiauswahldialog kann eine Bilddatei (jpg, gif oder png)
 * geladen werden. Das Bild wird in einem Scrollpane dargestellt.
 * 
 * Hans-Peter Habelitz
 * 2014-09-24
 */

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Bildbetrachter1 extends JFrame {

    private JPanel contentPane;
    private ImageComponent Bild;
    private BufferedImage a;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Bildbetrachter1 frame = new Bildbetrachter1();
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
    public Bildbetrachter1() {
	setTitle("Bildbetrachter");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 445, 444);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JButton btnBilddateiOeffnen = new JButton("Bilddatei \u00F6ffnen");

	JScrollPane scrollPane = new JScrollPane();

	Bild = new ImageComponent();
	try {
	    a = ImageIO.read((getClass().getResource("/gui11/bewblau.jpg")));
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	Bild.setImage(a);
	scrollPane.setViewportView(Bild);
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(5)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(btnBilddateiOeffnen, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
	);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGap(6)
				.addComponent(btnBilddateiOeffnen)
				.addGap(11)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	);
	contentPane.setLayout(gl_contentPane);

    }
}
