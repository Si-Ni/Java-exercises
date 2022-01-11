package gui10;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Arrayausgabe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfAnzahl;
	private JTextField tfZahlen;
	private int[] zahlen;
	private JButton btnOk;
	private JButton btnNeueEingabe;
	private JButton btnAnzahl;
	private int a;
	private JLabel lblVorwärts; 
	private JLabel lblAusgabeVorwaerts;
	private JLabel lblRückwärts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arrayausgabe frame = new Arrayausgabe();
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
	public Arrayausgabe() {
		setTitle("Arrayausgabe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAnzahl = new JLabel("Wieviele Zahlen sollen eingegeben werden ?");
		lblAnzahl.setBounds(10, 11, 290, 14);
		contentPane.add(lblAnzahl);
		
		tfAnzahl = new JTextField();
		tfAnzahl.setBounds(295, 8, 56, 20);
		contentPane.add(tfAnzahl);
		tfAnzahl.setColumns(10);
		
		btnAnzahl = new JButton("OK");
		btnAnzahl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = Integer.parseInt(tfAnzahl.getText());
				zahlen = new int[a];
				tfZahlen.setEnabled(true);
				btnOk.setEnabled(true);
				btnNeueEingabe.setEnabled(true);
				btnAnzahl.setEnabled(false);
				tfAnzahl.setEnabled(false);
			}
		});
		btnAnzahl.setBounds(361, 7, 63, 23);
		contentPane.add(btnAnzahl);
		
		tfZahlen = new JTextField();
		tfZahlen.setEnabled(false);
		tfZahlen.setBounds(10, 90, 96, 20);
		contentPane.add(tfZahlen);
		tfZahlen.setColumns(10);
		
		JLabel lblZahl = new JLabel("Zahl");
		lblZahl.setBounds(10, 65, 48, 14);
		contentPane.add(lblZahl);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StringBuffer eingabe = new StringBuffer(tfZahlen.getText());
				String hilfe;
				String hilfe2 = "";
				String hilfe3 = "";
				for(int i = 0; i < a; i++) {
				int p = eingabe.indexOf(" ");
				if(p > 0) {
					hilfe = eingabe.substring(0, p);
					eingabe.replace(0, p+1, "");
					zahlen[i] = Integer.parseInt(hilfe);
				}else {
					zahlen[i] = Integer.parseInt(eingabe.toString());
				}
				}
				for(int x = 0; x < a; x++) {
					hilfe2 = hilfe2 + " " + String.valueOf(zahlen[x]);
				}
				lblVorwärts.setText(hilfe2);
				for(int y = (a-1); y >= 0; y--) {
					hilfe3 = hilfe3 + " " + String.valueOf(zahlen[y]);
				}
				lblRückwärts.setText(hilfe3);
				btnOk.setEnabled(false);
				tfZahlen.setEnabled(false);
			}
		});
		btnOk.setEnabled(false);
		btnOk.setBounds(116, 89, 63, 23);
		contentPane.add(btnOk);
		
		btnNeueEingabe = new JButton("Neue Eingabe");
		btnNeueEingabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfAnzahl.setEnabled(true);
				tfAnzahl.setText("");
				btnAnzahl.setEnabled(true);
				tfZahlen.setText("");
			}
		});
		btnNeueEingabe.setEnabled(false);
		btnNeueEingabe.setBounds(255, 89, 139, 23);
		contentPane.add(btnNeueEingabe);
		
		lblAusgabeVorwaerts = new JLabel("Ausgabe vorw\u00E4rts");
		lblAusgabeVorwaerts.setBounds(10, 157, 116, 14);
		contentPane.add(lblAusgabeVorwaerts);
		
		JLabel lblAusgabeRckwrts = new JLabel("Ausgabe r\u00FCckw\u00E4rts");
		lblAusgabeRckwrts.setBounds(10, 197, 116, 14);
		contentPane.add(lblAusgabeRckwrts);
		
		lblVorwärts = new JLabel("Ausgabe 1");
		lblVorwärts.setBounds(141, 157, 210, 14);
		contentPane.add(lblVorwärts);
		
		lblRückwärts = new JLabel("Ausgabe 2");
		lblRückwärts.setBounds(141, 197, 210, 14);
		contentPane.add(lblRückwärts);
	}
}
