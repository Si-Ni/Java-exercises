package gui10;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class Kontaktliste extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNachname;
	private JTextField tfVorname;
	private JTextField tfTelefon;
	private JTextField tfEmail;
	private DefaultListModel<String> kontakteModel;
	private JList<String> listKontakte;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kontaktliste frame = new Kontaktliste();
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
	public Kontaktliste() {
		setTitle("Kontaktliste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setBounds(10, 11, 104, 14);
		contentPane.add(lblNachname);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setBounds(182, 11, 104, 14);
		contentPane.add(lblVorname);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(360, 11, 104, 14);
		contentPane.add(lblTelefon);
		
		tfNachname = new JTextField();
		tfNachname.setBounds(10, 24, 110, 20);
		contentPane.add(tfNachname);
		tfNachname.setColumns(10);
		
		tfVorname = new JTextField();
		tfVorname.setBounds(182, 24, 110, 20);
		contentPane.add(tfVorname);
		tfVorname.setColumns(10);
		
		tfTelefon = new JTextField();
		tfTelefon.setBounds(360, 24, 162, 20);
		contentPane.add(tfTelefon);
		tfTelefon.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMail");
		lblEmail.setBounds(10, 64, 104, 14);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(10, 77, 282, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		JButton btnUebernehmen = new JButton("\u00DCbernehmen");
		btnUebernehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfNachname.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "kein Name angegeben");
					tfNachname.requestFocus();
				}else {
					kontakteModel.addElement(tfNachname.getText() + ";" + tfVorname.getText() + ";"
					+ tfTelefon.getText() + ";" + tfEmail.getText());
					tfNachname.setText("");
				    tfVorname.setText("");
				    tfTelefon.setText("");
				    tfEmail.setText("");
				    tfNachname.requestFocus();
				}
			}
		});
		btnUebernehmen.setBounds(360, 76, 162, 23);
		contentPane.add(btnUebernehmen);
		
		JLabel lblKontaktliste = new JLabel("Kontaktliste");
		lblKontaktliste.setBounds(10, 134, 130, 14);
		contentPane.add(lblKontaktliste);
		
		listKontakte = new JList<String>();
		listKontakte.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listKontakte.setBounds(10, 159, 512, 168);
		contentPane.add(listKontakte);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(449, 335, 89, 23);
		contentPane.add(btnEnde);
		
		kontakteModel = new DefaultListModel<String>();
		listKontakte.setModel(kontakteModel);
		
		JButton btnloeschen = new JButton("markierten Eintrag l\u00F6schen");
		btnloeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listKontakte.getSelectedIndex();
				if(index >= 0) {
					kontakteModel.remove(index);
				}else {
					JOptionPane.showMessageDialog(null, "Kein Eintrag markiert");
				}
			}
		});
		btnloeschen.setBounds(10, 335, 199, 23);
		contentPane.add(btnloeschen);
		
		JButton btnBearbeiten = new JButton("bearbeiten");
		btnBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listKontakte.getSelectedIndex();
					if (index >= 0) {
						String zeile = (String) kontakteModel.getElementAt(index);
						tfNachname.setText(zeile.substring(0, zeile.indexOf(";")));
						zeile = zeile.substring(zeile.indexOf(";") + 1, zeile.length());
						tfVorname.setText(zeile.substring(0, zeile.indexOf(";")));
						zeile = zeile.substring(zeile.indexOf(";") + 1, zeile.length());
						tfTelefon.setText(zeile.substring(0, zeile.indexOf(";")));
						zeile = zeile.substring(zeile.indexOf(";") + 1, zeile.length());
						tfEmail.setText(zeile);
						kontakteModel.remove(index);
					}
			}
		});
		btnBearbeiten.setBounds(271, 335, 121, 23);
		contentPane.add(btnBearbeiten);
	}
}
