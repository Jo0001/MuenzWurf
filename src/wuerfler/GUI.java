package wuerfler;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.String;

public class GUI {
	private SpielSteuerung Steuerung; // dieSpielSteuerung
	private JFrame frame;
	private JLabel lblPunktzahl;
	private JLabel lblWuerfe;
	private JLabel lblMuenze1;
	private JLabel lblMuenze2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		Steuerung = new SpielSteuerung(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 498, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		lblPunktzahl = new JLabel("Punkte");
		lblPunktzahl.setBackground(Color.WHITE);
		lblPunktzahl.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPunktzahl.setBounds(400, 60, 73, 19);
		frame.getContentPane().add(lblPunktzahl);

		lblWuerfe = new JLabel("wuerfe");
		lblWuerfe.setBackground(Color.WHITE);
		lblWuerfe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWuerfe.setBounds(400, 139, 73, 29);
		frame.getContentPane().add(lblWuerfe);

		JLabel lblPunkte = new JLabel("Punkte");
		lblPunkte.setBounds(400, 46, 46, 14);
		frame.getContentPane().add(lblPunkte);

		JLabel lblAnzahlWuerfe = new JLabel("Anzahl Wuerfe");
		lblAnzahlWuerfe.setBounds(400, 131, 87, 14);
		frame.getContentPane().add(lblAnzahlWuerfe);

		JButton btnMuenzeWerfen = new JButton("Muenze werfen");
		btnMuenzeWerfen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clickMuenzeWerfen();
			}
		});
		btnMuenzeWerfen.setBounds(142, 208, 123, 23);
		frame.getContentPane().add(btnMuenzeWerfen);

		lblMuenze1 = new JLabel("");
		lblMuenze1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMuenze1.setVerticalAlignment(SwingConstants.TOP);
		lblMuenze1.setIcon(null);
		lblMuenze1.setBounds(21, 11, 175, 169);
		frame.getContentPane().add(lblMuenze1);

		lblMuenze2 = new JLabel("");
		lblMuenze2.setIcon(null);
		lblMuenze2.setVerticalAlignment(SwingConstants.TOP);
		lblMuenze2.setHorizontalAlignment(SwingConstants.CENTER);
		lblMuenze2.setBounds(206, 11, 175, 169);
		frame.getContentPane().add(lblMuenze2);

	}

	public void clickMuenzeWerfen() {

		Steuerung.werfeMuenzen();

	}

	public void anzeigenMuenze1(int pMuenze1) {
		if (pMuenze1 == 1) {
			lblMuenze1.setIcon(new ImageIcon(GUI.class.getResource("/wuerfler/zahl.PNG")));
		} else {
			lblMuenze1.setIcon(new ImageIcon(GUI.class.getResource("/wuerfler/wappen.PNG")));
		}
	}

	public void anzeigenMuenze2(int pMuenze2) {
		if (pMuenze2 == 1) {
			lblMuenze2.setIcon(new ImageIcon(GUI.class.getResource("/wuerfler/zahl.PNG")));
		} else {
			lblMuenze2.setIcon(new ImageIcon(GUI.class.getResource("/wuerfler/wappen.PNG")));
		}
	}

	public void anzeigenPunkte(int pPunkte) {

		lblPunktzahl.setText(String.valueOf(pPunkte));

	}

	public void anzeigenAnzahlWuerfe(int pWuerfe) {

		lblWuerfe.setText(String.valueOf(pWuerfe));

	}
}