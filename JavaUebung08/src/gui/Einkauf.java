package gui;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class Einkauf extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfAnzahl;
	private JTextField tfPreis;
	private JTextField tfRabatt;
	private JLabel lblAusgabe;
	private JLabel lblAusgabe2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Einkauf frame = new Einkauf();
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
	public Einkauf() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(550, 200);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAnzahl = new JLabel("St\u00FCckzahl");
		lblAnzahl.setBounds(10, 11, 78, 14);
		contentPane.add(lblAnzahl);
		
		JLabel lblPreis = new JLabel("St\u00FCckpreis");
		lblPreis.setBounds(157, 11, 78, 14);
		contentPane.add(lblPreis);
		
		JLabel lblRabatt = new JLabel("Rabatt (%)");
		lblRabatt.setBounds(297, 11, 88, 14);
		contentPane.add(lblRabatt);
		
		JButton btnBerechnen = new JButton("Berechnen");
		btnBerechnen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				umrechnen();
			}
		});
		btnBerechnen.setBounds(419, 36, 105, 23);
		contentPane.add(btnBerechnen);
		
		lblAusgabe = new JLabel("");
		lblAusgabe.setBounds(10, 78, 278, 23);
		contentPane.add(lblAusgabe);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(419, 108, 105, 23);
		contentPane.add(btnEnde);
		
		tfAnzahl = new JTextField();
		tfAnzahl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfPreis.requestFocus();
					tfPreis.selectAll();
				}
			}
		});
		tfAnzahl.setBounds(10, 37, 96, 20);
		contentPane.add(tfAnzahl);
		tfAnzahl.setColumns(10);
		
		tfPreis = new JTextField();
		tfPreis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfRabatt.requestFocus();
					tfRabatt.selectAll();
				}
			}
		});
		tfPreis.setBounds(157, 37, 96, 20);
		contentPane.add(tfPreis);
		tfPreis.setColumns(10);
		
		tfRabatt = new JTextField();
		tfRabatt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					umrechnen();
				}
			}
		});
		tfRabatt.setBounds(297, 36, 96, 20);
		contentPane.add(tfRabatt);
		tfRabatt.setColumns(10);
		
		lblAusgabe2 = new JLabel("");
		lblAusgabe2.setBounds(10, 122, 225, 14);
		contentPane.add(lblAusgabe2);
	}
	private void umrechnen() {
		int anzahl;
		double preisEinzeln, preisGesamt, preisEnde, rabattpreis, rabatt;
		
		try {
			anzahl = Integer.parseInt(tfAnzahl.getText());
			rabatt = Double.parseDouble(tfRabatt.getText());
			preisEinzeln = Double.parseDouble(tfPreis.getText());
			preisGesamt = anzahl * preisEinzeln;
			rabattpreis = preisGesamt * rabatt / 100;
			preisEnde = preisGesamt - rabattpreis;
			DecimalFormat f = new DecimalFormat("#0.00");
			lblAusgabe.setText("Der Einkaufspreis beträgt: " + f.format(preisEnde) + "€");
			lblAusgabe2.setText("Sie erhielten " + f.format(rabattpreis) + " € Rabatt");
			tfAnzahl.requestFocus();
			tfAnzahl.selectAll();
		} catch (NumberFormatException e) {
			lblAusgabe.setText("Falsches Zahlenformat!"); 
		} catch (Exception e) {
			lblAusgabe.setText("Fehler bei der Eingabe!");
		}
	}
}
