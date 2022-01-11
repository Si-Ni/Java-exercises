package gui;

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
	private int notenzahl, i;
    private double summe, besteNote, schlechtesteNote, notenschnitt;
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
		setSize(450, 300);
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
		btnEnde.setBounds(335, 227, 89, 23);
		contentPane.add(btnEnde);
		
		lblAnzahlNotenEnde = new JLabel("");
		lblAnzahlNotenEnde.setBounds(10, 144, 240, 14);
		contentPane.add(lblAnzahlNotenEnde);
		
		lblDurchschnitt = new JLabel("");
		lblDurchschnitt.setBounds(10, 169, 146, 14);
		contentPane.add(lblDurchschnitt);
		
		lblBesteNote = new JLabel("");
		lblBesteNote.setBounds(10, 204, 146, 14);
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
			}
		});
		btnNeu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNeu.setVisible(false);
		btnNeu.setBounds(156, 58, 167, 23);
		contentPane.add(btnNeu);
	}

}
