package gui;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class ZollZentimeter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfZoll;
	private JLabel lblTest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZollZentimeter frame = new ZollZentimeter();
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
	public ZollZentimeter() {
		setTitle("Umrechnung von Zoll in Zentimeter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 378, 134);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZoll = new JLabel("Zoll");
		lblZoll.setBounds(28, 11, 64, 22);
		contentPane.add(lblZoll);
		
		JButton btnUmrechnen = new JButton("Umrechnen");
		btnUmrechnen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUmrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				umrechnen();
			}
		});
		btnUmrechnen.setBounds(26, 63, 112, 23);
		contentPane.add(btnUmrechnen);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(222, 63, 96, 23);
		contentPane.add(btnEnde);
		
		JLabel lblZentimeter = new JLabel("Zentimeter");
		lblZentimeter.setBounds(222, 15, 64, 14);
		contentPane.add(lblZentimeter);
		
		tfZoll = new JTextField();
		tfZoll.setBounds(26, 32, 96, 20);
		contentPane.add(tfZoll);
		tfZoll.setColumns(10);
		
		lblTest = new JLabel(""); //!!! Wichtig, wenn JLabel als Variable deklariert wurde muss JLabel vor Objekterstellung weg !!!
		lblTest.setBounds(222, 32, 96, 20);
		contentPane.add(lblTest);
	}
	
	private void umrechnen() {
		System.out.println("test");
		double zoll, zentimeter;
		zoll = Double.parseDouble(tfZoll.getText());
		System.out.println(zoll);
		zentimeter = zoll * 2.54;
		System.out.println(zentimeter);
		DecimalFormat f = new DecimalFormat("#0.00");
		lblTest.setText(f.format(zentimeter) + " cm");
		tfZoll.requestFocus();
		tfZoll.selectAll();
		
	}
}
