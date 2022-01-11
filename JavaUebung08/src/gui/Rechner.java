package gui;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Rechner extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfWert1;
	private JTextField tfWert2;
	private JTextField tfErgebnis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rechner frame = new Rechner();
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
	public Rechner() {
		setTitle("Rechner");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 270);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOperand = new JLabel("Operand1");
		lblOperand.setBounds(10, 11, 78, 14);
		contentPane.add(lblOperand);
		
		JLabel lblOperand_1 = new JLabel("Operand2");
		lblOperand_1.setBounds(317, 11, 90, 14);
		contentPane.add(lblOperand_1);
		
		tfWert1 = new JTextField();
		tfWert1.setBounds(10, 36, 96, 20);
		contentPane.add(tfWert1);
		tfWert1.setColumns(10);
		
		tfWert2 = new JTextField();
		tfWert2.setBounds(317, 36, 96, 20);
		contentPane.add(tfWert2);
		tfWert2.setColumns(10);
		
		tfErgebnis = new JTextField();
		tfErgebnis.setEditable(false);
		tfErgebnis.setBounds(10, 168, 397, 20);
		contentPane.add(tfErgebnis);
		tfErgebnis.setColumns(10);
		
		JLabel lblErgebnis = new JLabel("Ergebnis");
		lblErgebnis.setBounds(10, 143, 110, 14);
		contentPane.add(lblErgebnis);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfWert1.getText().equals("") || tfWert2.getText().equals("")) {
					tfErgebnis.setText("Die Eingabe ist unvollständig!");
				}else {
					double w1, w2, ergebnis;
					w1 = Double.parseDouble(tfWert1.getText());
					w2 = Double.parseDouble(tfWert2.getText());
					ergebnis = w1 + w2;
					DecimalFormat f = new DecimalFormat("#0.0000000");
					tfErgebnis.setText(f.format(ergebnis));
					tfWert1.requestFocus();
					tfWert1.selectAll();
				}
			}
		});
		btnPlus.setBounds(150, 35, 55, 23);
		contentPane.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfWert1.getText().equals("") || tfWert2.getText().equals("")) {
					tfErgebnis.setText("Die Eingabe ist unvollständig!");
				}else {
					double w1, w2, ergebnis;
					w1 = Double.parseDouble(tfWert1.getText());
					w2 = Double.parseDouble(tfWert2.getText());
					ergebnis = w1 - w2;
					DecimalFormat f = new DecimalFormat("#0.0000000");
					tfErgebnis.setText(f.format(ergebnis));
					tfWert1.requestFocus();
					tfWert1.selectAll();
				}
			}
		});
		btnMinus.setBounds(215, 35, 55, 23);
		contentPane.add(btnMinus);
		
		JButton btnMal = new JButton("*");
		btnMal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfWert1.getText().equals("") || tfWert2.getText().equals("")) {
					tfErgebnis.setText("Die Eingabe ist unvollständig!");
				}else {
					double w1, w2, ergebnis;
					w1 = Double.parseDouble(tfWert1.getText());
					w2 = Double.parseDouble(tfWert2.getText());
					ergebnis = w1 * w2;
					DecimalFormat f = new DecimalFormat("#0.0000000");
					tfErgebnis.setText(f.format(ergebnis));
					tfWert1.requestFocus();
					tfWert1.selectAll();
				}
			}
		});
		btnMal.setBounds(150, 81, 55, 23);
		contentPane.add(btnMal);
		
		JButton btnDurch = new JButton("/");
		btnDurch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDurch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfWert1.getText().equals("") || tfWert2.getText().equals("")) {
					tfErgebnis.setText("Die Eingabe ist unvollständig!");
				}else {
					double w1, w2, ergebnis;
					w1 = Double.parseDouble(tfWert1.getText());
					w2 = Double.parseDouble(tfWert2.getText());
					if (w2 == 0) {
						tfErgebnis.setText("Division durch 0 ist nicht definiert!");
					}else {
						ergebnis = w1 / w2;
						DecimalFormat f = new DecimalFormat("#0.0000000");
						tfErgebnis.setText(f.format(ergebnis));
						tfWert1.requestFocus();
						tfWert1.selectAll();
					}
				}
			}
		});
		btnDurch.setBounds(215, 81, 55, 23);
		contentPane.add(btnDurch);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(317, 199, 89, 23);
		contentPane.add(btnEnde);
	}

}
