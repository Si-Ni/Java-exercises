package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FahrenheitCelsius extends JFrame {

	private JPanel contentPane;
	private JTextField tfFahrenheit;
	private JTextField tfCelsius;

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
					FahrenheitCelsius frame = new FahrenheitCelsius();
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
	public FahrenheitCelsius() {
		setTitle("Umrechnung Fahrenheit in Celsius");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFahrenheit = new JLabel("Grad Fahrenheit");
		lblFahrenheit.setBounds(20, 21, 90, 26);
		contentPane.add(lblFahrenheit);
		
		tfFahrenheit = new JTextField();
		tfFahrenheit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					umrechnen();
				}
			}
		});
		tfFahrenheit.setBounds(20, 58, 118, 20);
		contentPane.add(tfFahrenheit);
		tfFahrenheit.setColumns(10);
		
		JLabel lblCelsius = new JLabel("Grad Celsius");
		lblCelsius.setBounds(20, 89, 90, 26);
		contentPane.add(lblCelsius);
		
		tfCelsius = new JTextField();
		tfCelsius.setEditable(false);
		tfCelsius.setBounds(20, 126, 118, 20);
		contentPane.add(tfCelsius);
		tfCelsius.setColumns(10);
		
		JButton btnUmrechnen = new JButton("Umrechnen");
		btnUmrechnen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUmrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				umrechnen();
			}
		});
		btnUmrechnen.setBounds(213, 57, 105, 23);
		contentPane.add(btnUmrechnen);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Der Button Ende wurde betätigt");
				System.exit(0);
			}
		});
		btnEnde.setBounds(213, 125, 105, 23);
		contentPane.add(btnEnde);
	}
	
	private void umrechnen() {
		
		try {
		System.out.println("Der Button Umrechnen wurde betätigt");
		double fahrenheit, celsius;
		fahrenheit = Double.parseDouble(tfFahrenheit.getText());
		celsius = (fahrenheit - 32) * 5 / 9;
		DecimalFormat f = new DecimalFormat("#0.00");
		tfCelsius.setText(f.format(celsius));
		tfFahrenheit.requestFocus();
		tfFahrenheit.selectAll();
		} catch (NumberFormatException e) {
			tfCelsius.setText("Keine korrekte Fahrenheit-Temperatur");
		} catch (Exception e) {
			tfCelsius.setText("Keine korrekte Fahrenheit-Temperatur");
		}
	}
}
