import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class Messreihe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfEingabe;
	private DefaultListModel<Double> MessreiheModel;
	private JList<Double> listMessreihe;
	private JButton btnUebernehmen;
	private JButton btnSpeichern;
	private String dateiname;
	private JButton btnLaden;

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
		setTitle("Messreihe speichern");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfEingabe = new JTextField();
		tfEingabe.setBounds(10, 30, 134, 20);
		contentPane.add(tfEingabe);
		tfEingabe.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Messwert");
		lblNewLabel.setBounds(10, 11, 96, 14);
		contentPane.add(lblNewLabel);
		
		listMessreihe = new JList<Double>();
		listMessreihe.setBounds(199, 32, 225, 184);
		contentPane.add(listMessreihe);
		
		MessreiheModel = new DefaultListModel<Double>();
		listMessreihe.setModel(MessreiheModel);
		
		JLabel lblMessreihe = new JLabel("Messreihe");
		lblMessreihe.setBounds(199, 11, 118, 14);
		contentPane.add(lblMessreihe);
		
		btnUebernehmen = new JButton("\u00DCbernehmen >>");
		btnUebernehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfEingabe.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Eingabe ist unvollständig");
				}else {
					try {
						MessreiheModel.addElement(Double.parseDouble(tfEingabe.getText()));
						tfEingabe.setText("");
						tfEingabe.requestFocus();
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "ungültiges Format");
						ex.printStackTrace();
					}
				}
			}
		});
		btnUebernehmen.setBounds(10, 61, 134, 23);
		contentPane.add(btnUebernehmen);
		
		btnSpeichern = new JButton("Messreihe speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();		//creates FileChooser
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);	//only Files
				fc.setFileFilter(new FileNameExtensionFilter("Messwertdateien *.mwd", "mwd"));	//only Files with ending mwd
				fc.setCurrentDirectory(new File("."));
				int status = fc.showSaveDialog(null);	//get Status
				if (status == JFileChooser.APPROVE_OPTION) {	//if saved/open
					String selFile = fc.getSelectedFile().getAbsolutePath();	//getting Filename
					int index = selFile.indexOf('.');							//Index of .
					if (index >= 0) {
						dateiname = selFile.substring(0, index).concat(".mwd");	//Dateiname = Name + .mwd
					}else {
						dateiname = selFile.concat(".mwd");
					}
					try {
						BufferedWriter out = new BufferedWriter(new FileWriter(dateiname));
						for (int i = 0; i < MessreiheModel.getSize(); i++) {
							out.write(MessreiheModel.get(i).toString());
							out.newLine();
						}
						out.close();
					}catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Fehler beim Speichern");
					}
				}
			}
		});
		btnSpeichern.setBounds(230, 227, 171, 23);
		contentPane.add(btnSpeichern);
		
		btnLaden = new JButton("Laden");
		btnLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fc.setFileFilter(new FileNameExtensionFilter(
					"Messwertdateien *.mwd", "mwd"));
				fc.setCurrentDirectory(new File("."));
				int status = fc.showOpenDialog(null);
				if (status == JFileChooser.APPROVE_OPTION) {
				    dateiname = fc.getSelectedFile().getAbsolutePath();
				    String messwertzeile;
				    try {
					BufferedReader in = new BufferedReader(new FileReader(
						dateiname));
					MessreiheModel.clear();
					while ((messwertzeile = in.readLine()) != null) {
					    MessreiheModel.addElement(Double.parseDouble(messwertzeile));
					}
					in.close();
				    } catch (Exception ex) {
					JOptionPane.showMessageDialog(null,
						"Fehler beim Öffnen der Datei!");
				    }
				}
			}
		});
		btnLaden.setBounds(10, 227, 96, 23);
		contentPane.add(btnLaden);
	}
}
