package gui10;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class Messreihe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfAnzahl;
	private JTextField tfWerte;
	private JTextField tfStelle;
	private JTextField tfNeuerWert;
	private JButton btnAnzahl;
	private JLabel lblMesswerte;
	private JLabel lblWievieleMesswerteSollen;
	private JButton btnBearbeiten;
	private JLabel lblMesswert;
	private JLabel lblAusgabeMesswerte;
	private JButton btnMessreiheAuswerten;
	private JButton btnBestaetige;
	private Double[] werte;
	private JLabel lblMinimalwert;
	private JLabel lblMaximalwert;
	private JLabel lblMittelwert;
	private JLabel lblStelleDesWertes;
	private JButton btnOk;
	private JLabel lblNeuerWert;
	private JButton btnSpeichern;
	private int n, a, Stelle;
	private double minimalwert, maximalwert, durchschnitt, hilfe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messreihe frame = new Messreihe();
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
	public Messreihe() {
		setTitle("Messreihe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWievieleMesswerteSollen = new JLabel("Wieviele Messwerte sollen aufgenommen werden ?");
		lblWievieleMesswerteSollen.setBounds(10, 11, 326, 14);
		contentPane.add(lblWievieleMesswerteSollen);
		
		tfAnzahl = new JTextField();
		tfAnzahl.setBounds(334, 8, 60, 20);
		contentPane.add(tfAnzahl);
		tfAnzahl.setColumns(10);
		
		btnAnzahl = new JButton("OK");
		btnAnzahl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					n = 0;
					a = Integer.parseInt(tfAnzahl.getText());
					werte = new Double[a];
					lblMesswert.setVisible(true);
					tfWerte.setVisible(true);
					btnBestaetige.setVisible(true);
					btnAnzahl.setVisible(true);
					tfAnzahl.setVisible(true);
					lblWievieleMesswerteSollen.setVisible(true);
					btnAnzahl.setVisible(false);
					lblWievieleMesswerteSollen.setVisible(false);
					tfAnzahl.setVisible(false);
					}
				catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Falsches Zahlenformat!");
				}
			}
		});
		btnAnzahl.setBounds(404, 7, 60, 23);
		contentPane.add(btnAnzahl);
		
		lblMesswert = new JLabel("1. Messwert");
		lblMesswert.setVisible(false);
		lblMesswert.setBounds(10, 47, 88, 14);
		contentPane.add(lblMesswert);
		
		tfWerte = new JTextField();
		tfWerte.setVisible(false);
		tfWerte.setBounds(10, 68, 88, 20);
		contentPane.add(tfWerte);
		tfWerte.setColumns(10);
		
		lblMesswerte = new JLabel("Messwerte:");
		lblMesswerte.setVisible(false);
		lblMesswerte.setBounds(10, 99, 88, 14);
		contentPane.add(lblMesswerte);
		
		lblAusgabeMesswerte = new JLabel("Ausgabe");
		lblAusgabeMesswerte.setVisible(false);
		lblAusgabeMesswerte.setBounds(10, 124, 440, 14);
		contentPane.add(lblAusgabeMesswerte);
		
		btnMessreiheAuswerten = new JButton("Messreihe auswerten");
		btnMessreiheAuswerten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Arrays.sort(werte);
					minimalwert = werte[0];
					maximalwert = werte[a-1];
					for(int x = 0; x < (a); x++) {
						hilfe = hilfe + werte[x];
					}
					DecimalFormat f = new DecimalFormat("#0.00");
					durchschnitt = hilfe / a;
					lblMinimalwert.setText("Minimalwert: " + Double.toString(minimalwert));
					lblMaximalwert.setText("Maximalwert: " + Double.toString(maximalwert));
					lblMittelwert.setText("Mittelwert: " + f.format(durchschnitt));
					lblMinimalwert.setVisible(true);
					lblMaximalwert.setVisible(true);
					lblMittelwert.setVisible(true);
					btnBearbeiten.setVisible(false);
					btnMessreiheAuswerten.setVisible(false);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten");
				}
			}
		});
		btnMessreiheAuswerten.setVisible(false);
		btnMessreiheAuswerten.setBounds(10, 149, 177, 23);
		contentPane.add(btnMessreiheAuswerten);
		
		btnBearbeiten = new JButton("Bearbeiten");
		btnBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblStelleDesWertes.setVisible(true);
				tfStelle.setVisible(true);
				btnOk.setVisible(true);
				lblNeuerWert.setVisible(true);
				tfNeuerWert.setVisible(true);
				btnSpeichern.setVisible(true);
				btnMessreiheAuswerten.setVisible(false);
				btnBearbeiten.setVisible(false);
			}
		});
		btnBearbeiten.setVisible(false);
		btnBearbeiten.setBounds(292, 149, 102, 23);
		contentPane.add(btnBearbeiten);
		
		lblMinimalwert = new JLabel("Minimalwert");
		lblMinimalwert.setVisible(false);
		lblMinimalwert.setBounds(10, 183, 140, 14);
		contentPane.add(lblMinimalwert);
		
		lblMaximalwert = new JLabel("Maximalwert");
		lblMaximalwert.setVisible(false);
		lblMaximalwert.setBounds(10, 208, 140, 14);
		contentPane.add(lblMaximalwert);
		
		lblMittelwert = new JLabel("Mittelwert");
		lblMittelwert.setVisible(false);
		lblMittelwert.setBounds(10, 233, 140, 14);
		contentPane.add(lblMittelwert);
		
		tfStelle = new JTextField();
		tfStelle.setVisible(false);
		tfStelle.setBounds(264, 202, 72, 20);
		contentPane.add(tfStelle);
		tfStelle.setColumns(10);
		
		lblStelleDesWertes = new JLabel("Stelle des Wertes");
		lblStelleDesWertes.setVisible(false);
		lblStelleDesWertes.setBounds(264, 183, 130, 14);
		contentPane.add(lblStelleDesWertes);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Stelle = Integer.parseInt(tfStelle.getText());
					lblStelleDesWertes.setVisible(false);
					tfStelle.setVisible(false);
					btnOk.setVisible(false);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Falsches Zahlenformat!");
				}
			}
		});
		btnOk.setVisible(false);
		btnOk.setBounds(404, 201, 60, 23);
		contentPane.add(btnOk);
		
		lblNeuerWert = new JLabel("Neuer Wert");
		lblNeuerWert.setVisible(false);
		lblNeuerWert.setBounds(264, 233, 117, 14);
		contentPane.add(lblNeuerWert);
		
		tfNeuerWert = new JTextField();
		tfNeuerWert.setVisible(false);
		tfNeuerWert.setBounds(264, 258, 72, 20);
		contentPane.add(tfNeuerWert);
		tfNeuerWert.setColumns(10);
		
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					werte[Stelle-1] = Double.parseDouble(tfNeuerWert.getText());
					lblNeuerWert.setVisible(false);
					tfNeuerWert.setVisible(false);
					btnSpeichern.setVisible(false);
					btnMessreiheAuswerten.setVisible(true);
					btnBearbeiten.setVisible(true);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Falsches Zahlenformat!");
				}
			}
		});
		btnSpeichern.setVisible(false);
		btnSpeichern.setBounds(362, 257, 102, 23);
		contentPane.add(btnSpeichern);
		
		btnBestaetige = new JButton("Best\u00E4tige");
		btnBestaetige.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(n < (a-1)) {
						lblMesswert.setText((n+2) + ". Messwert");
						werte[n] = Double.parseDouble(tfWerte.getText());
						n++;
						tfWerte.setText("");
						tfWerte.requestFocus();
					}else if(n == (a-1)){
						werte[n] = Double.parseDouble(tfWerte.getText());
						String hilfe = "";
						btnBestaetige.setVisible(false);
						lblMesswert.setVisible(false);
						tfWerte.setVisible(false);
						lblMesswerte.setVisible(true);
						for(int x = 0; x < a; x++) {
							hilfe = hilfe + " " + String.valueOf(werte[x] + "(" + (x+1) + ")");
							lblAusgabeMesswerte.setText(hilfe);
						}
						lblAusgabeMesswerte.setVisible(true);
						btnMessreiheAuswerten.setVisible(true);
						btnBearbeiten.setVisible(true);
					}	
				}catch (Exception ex){
					JOptionPane.showMessageDialog(null, "Falsches Zahlenformat!");
				}
			}
		});
		btnBestaetige.setVisible(false);
		btnBestaetige.setBounds(112, 67, 89, 23);
		contentPane.add(btnBestaetige);
	}
}
