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
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Osterdatum extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfJahr;
	private JLabel lblAusgabe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Osterdatum frame = new Osterdatum();
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
	public Osterdatum() {
		setTitle("Osterdatum");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 210);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblJahr = new JLabel("Jahr");
		lblJahr.setBounds(10, 11, 80, 14);
		contentPane.add(lblJahr);
		
		tfJahr = new JTextField();
		tfJahr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					berechnen();
				}
			}
		});
		tfJahr.setBounds(10, 36, 96, 20);
		contentPane.add(tfJahr);
		tfJahr.setColumns(10);
		
		JButton btnBerechnen = new JButton("Datum f\u00FCr Ostersonntag berechnen");
		btnBerechnen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBerechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				berechnen();
			}
		});
		btnBerechnen.setBounds(140, 35, 261, 23);
		contentPane.add(btnBerechnen);
		
		JLabel lblNewLabel = new JLabel("Datum f\u00FCr Ostersonntag:");
		lblNewLabel.setBounds(10, 102, 152, 14);
		contentPane.add(lblNewLabel);
		
		lblAusgabe = new JLabel("");
		lblAusgabe.setBounds(177, 102, 224, 14);
		contentPane.add(lblAusgabe);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(218, 137, 89, 23);
		contentPane.add(btnEnde);
	}
	private void berechnen() {
		if(tfJahr.getText().equals("")) {
			lblAusgabe.setText("Die Eingabe ist unvollständig");
		}else if(Integer.parseInt(tfJahr.getText()) <= 1583) {
			lblAusgabe.setText("Berechnung nur für Jahreszahl > 1583");
		}else {
			int y = Integer.parseInt(tfJahr.getText());
			int g = y % 19;
		    int c = y / 100;
		    int h = (c - c / 4 - (8 * c + 13) / 25 + 19 * g + 15) % 30;
		    int i = h - (h / 28) * (1 - (29 / (h + 1)) * ((21 - g) / 11));
		    int j = (y + y / 4 + i + 2 - c + c / 4) % 7;
		    int l = i - j;
		    int m = 3 + (l + 40) / 44;
		    int d = l + 28 - 31 * (m / 4);
		    lblAusgabe.setText(d + "." + m + ".");
		}
		tfJahr.requestFocus();
		tfJahr.selectAll();
	}
}
