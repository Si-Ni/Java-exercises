package gui10;

import java.awt.Cursor;
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
import java.awt.event.ActionEvent;

public class Notenbilanz extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int notenzahl, i, notennummer;
    private double summe, besteNote, schlechtesteNote, notenschnitt;
    private double[] noten;
	private JPanel contentPane;
	private JTextField tfAnzahlNoten;
	private JTextField tfNote;
	private JButton btnAnzahl‹bernehmen;
	private JLabel lblNote;
	private JButton btnNote‹bernehmen;
	private DecimalFormat fzahl;
	private JLabel lblAnzahlNotenEnde;
	private JLabel lblDurchschnitt;
	private JLabel lblBesteNote;
	private JLabel lblSchlechtesteNote;
	private JButton btnNeu;
	private JLabel lblNoten;
	private JTextField tfNotennummer;
	private JTextField tfNeuerWert;
	private JLabel lblNotennummer;
	private JButton btnNotennummer;
	private JLabel lblNeuerWert;
	private JButton btnNeuenWertSpeichern;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notenbilanz frame = new Notenbilanz();
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
	public Notenbilanz() {
		setTitle("Notenbilanz");
		fzahl = new DecimalFormat("###,##0.00");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAnzahlNoten = new JLabel("Anzahl Noten");
		lblAnzahlNoten.setBounds(10, 11, 112, 14);
		contentPane.add(lblAnzahlNoten);
		
		tfAnzahlNoten = new JTextField();
		tfAnzahlNoten.setBounds(10, 25, 96, 20);
		contentPane.add(tfAnzahlNoten);
		tfAnzahlNoten.setColumns(10);
		
		btnAnzahl‹bernehmen = new JButton("\u00DCbernehmen");
		btnAnzahl‹bernehmen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnzahl‹bernehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfAnzahlNoten.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Geben Sie die Anzahl der Noten an");
					tfAnzahlNoten.requestFocus();
				}else{
					notenzahl = Integer.parseInt(tfAnzahlNoten.getText());
					noten = new double[notenzahl];
				    i = 1;
				    summe = 0;
				    besteNote = 7;
				    schlechtesteNote = 0;
					tfAnzahlNoten.setEditable(false);
					btnAnzahl‹bernehmen.setVisible(false);
					tfNote.setVisible(true);
					lblNote.setVisible(true);
					btnNote‹bernehmen.setVisible(true);
					tfNote.requestFocus();
				}
			}
		});
		btnAnzahl‹bernehmen.setBounds(156, 24, 129, 23);
		contentPane.add(btnAnzahl‹bernehmen);
		
		lblNote = new JLabel("1.Note");
		lblNote.setBounds(10, 80, 96, 14);
		lblNote.setVisible(false);
		contentPane.add(lblNote);
		
		tfNote = new JTextField();
		tfNote.setBounds(10, 97, 96, 20);
		tfNote.setVisible(false);
		contentPane.add(tfNote);
		tfNote.setColumns(10);
		
		btnNote‹bernehmen = new JButton("\u00DCbernehmen");
		btnNote‹bernehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNote.getText().equals("") || Double.parseDouble(tfNote.getText()) < 1 || Double.parseDouble(tfNote.getText()) > 6) {
					JOptionPane.showMessageDialog(null, "Die Eingabe ist ung¸ltig!");
					tfNote.requestFocus();
				}else{
					summe = summe + Double.parseDouble(tfNote.getText());
					noten[i-1]=Double.parseDouble(tfNote.getText());
					notenschnitt = summe / i;
					lblDurchschnitt.setText("Notenschnitt: " + fzahl.format(notenschnitt));
					lblAnzahlNotenEnde.setText("Anzahl eingegebene Noten: " + Integer.toString(i));
					
					if(Double.parseDouble(tfNote.getText()) > schlechtesteNote) {
						schlechtesteNote = Double.parseDouble(tfNote.getText());
						lblSchlechtesteNote.setText("schlechteste Note: "
							+ Double.toString(schlechtesteNote));
					    }
					if (Double.parseDouble(tfNote.getText()) < besteNote) {
						besteNote = Double.parseDouble(tfNote.getText());
						lblBesteNote
							.setText("beste Note: " + Double.toString(besteNote));
					}
					if(notenzahl == i) {
						notenschnitt = summe / notenzahl;
						btnNote‹bernehmen.setVisible(false);
						btnNeu.setVisible(true);
						lblNoten.setText("Noten: ");
						for ( int i=0; i<noten.length; i++ ) {
							lblNoten.setText(lblNoten.getText() + " | " + (i+1) +": " + noten[i]);
						}
						lblNoten.setVisible(true);
						lblNotennummer.setVisible(true);
						tfNotennummer.setVisible(true);
						btnNotennummer.setVisible(true);
					}else{
						i++;
						lblNote.setText(Integer.toString(i) + ".Note");
						tfNote.setText("");
						tfNote.requestFocus();
					}
				}
			}
		});
		btnNote‹bernehmen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNote‹bernehmen.setBounds(156, 96, 129, 23);
		btnNote‹bernehmen.setVisible(false);
		contentPane.add(btnNote‹bernehmen);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(375, 227, 89, 23);
		contentPane.add(btnEnde);
		
		lblAnzahlNotenEnde = new JLabel("");
		lblAnzahlNotenEnde.setBounds(10, 144, 240, 14);
		contentPane.add(lblAnzahlNotenEnde);
		
		lblDurchschnitt = new JLabel("");
		lblDurchschnitt.setBounds(10, 169, 146, 14);
		contentPane.add(lblDurchschnitt);
		
		lblBesteNote = new JLabel("");
		lblBesteNote.setBounds(10, 209, 146, 14);
		contentPane.add(lblBesteNote);
		
		lblSchlechtesteNote = new JLabel("");
		lblSchlechtesteNote.setBounds(10, 231, 146, 14);
		contentPane.add(lblSchlechtesteNote);
		
		btnNeu = new JButton("Neue Berechnung");
		btnNeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i = 1;
				lblNote.setText(Integer.toString(i) + ".Note");
				summe = 0;
				besteNote = 6;
				schlechtesteNote = 0;
				btnAnzahl‹bernehmen.setVisible(true);
				tfAnzahlNoten.setEditable(true);
				lblNote.setVisible(false);
				tfNote.setVisible(false);
				tfNote.setText("");
				btnNote‹bernehmen.setVisible(false);
				tfAnzahlNoten.setText("");
				tfAnzahlNoten.requestFocus();
				lblDurchschnitt.setText("");
				lblBesteNote.setText("");
				lblSchlechtesteNote.setText("");
				lblAnzahlNotenEnde.setText("");
				btnNeu.setVisible(false);
				lblNoten.setVisible(false);
				lblNotennummer.setVisible(false);
				tfNotennummer.setText("1");
				tfNotennummer.setVisible(false);
				btnNotennummer.setVisible(false);
				lblNeuerWert.setVisible(false);
				tfNeuerWert.setVisible(false);
				btnNeuenWertSpeichern.setVisible(false);
			}
		});
		btnNeu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNeu.setVisible(false);
		btnNeu.setBounds(329, 24, 167, 23);
		contentPane.add(btnNeu);
		
		lblNoten = new JLabel("");
		lblNoten.setBounds(10, 189, 313, 14);
		contentPane.add(lblNoten);
		
		tfNotennummer = new JTextField();
		tfNotennummer.setBounds(300, 97, 44, 20);
		contentPane.add(tfNotennummer);
		tfNotennummer.setColumns(10);
		tfNotennummer.setVisible(false);
		
		lblNotennummer = new JLabel(". Note bearbeiten");
		lblNotennummer.setBounds(354, 100, 102, 14);
		contentPane.add(lblNotennummer);
		lblNotennummer.setVisible(false);
		
		btnNotennummer = new JButton("OK");
		btnNotennummer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					notennummer = Integer.parseInt(tfNotennummer.getText()) - 1;
					if((notennummer >= 0) && (notennummer < notenzahl)) {
						lblNeuerWert.setText(notennummer + 1 + ". Note");
						lblNeuerWert.setVisible(true);
						tfNeuerWert.setVisible(true);
						btnNeuenWertSpeichern.setVisible(true);
						tfNeuerWert.setText(String.valueOf(noten[notennummer]));
						tfNeuerWert.requestFocus();
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "ung¸ltiges Zahlenformat");
				}
			}
		});
		btnNotennummer.setBounds(466, 96, 55, 23);
		contentPane.add(btnNotennummer);
		btnNotennummer.setVisible(false);
		btnNotennummer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblNeuerWert = new JLabel("");
		lblNeuerWert.setBounds(300, 144, 48, 14);
		contentPane.add(lblNeuerWert);
		lblNeuerWert.setVisible(false);
		
		tfNeuerWert = new JTextField();
		tfNeuerWert.setBounds(300, 169, 78, 20);
		contentPane.add(tfNeuerWert);
		tfNeuerWert.setColumns(10);
		tfNeuerWert.setVisible(false);
		
		btnNeuenWertSpeichern = new JButton("Speichern");
		btnNeuenWertSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(Double.parseDouble(tfNeuerWert.getText()) >= 1 && Double.parseDouble(tfNeuerWert.getText()) <= 6) {
						noten[notennummer] = Double.parseDouble(tfNeuerWert.getText());
						summe = 0;
						besteNote = noten[0];
						schlechtesteNote = noten[0];
						lblNoten.setText("Noten: ");
						for (double x : noten) {
							summe = summe + x;
							if (besteNote > x) {
								besteNote = x;
							}
							if (schlechtesteNote < x) {
								schlechtesteNote = x;
							}
							lblNoten.setText(lblNoten.getText() + " " + x);
						}
						notenschnitt = summe / notenzahl;
						String notenschnittAusgabe = fzahl.format(notenschnitt);
						lblBesteNote.setText("beste Note: " + Double.toString(besteNote));
						lblSchlechtesteNote.setText("schlechteste Note: " + Double.toString(schlechtesteNote));
						lblDurchschnitt.setText("Notenschnitt: " + notenschnittAusgabe);
					}else {
						JOptionPane.showMessageDialog(null, "ung¸ltige Eingabe");
					}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "ung¸ltiges Zeichenformat");
				}
			}
		});
		btnNeuenWertSpeichern.setBounds(419, 169, 102, 23);
		contentPane.add(btnNeuenWertSpeichern);
		btnNeuenWertSpeichern.setVisible(false);
		btnNeuenWertSpeichern.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
}
