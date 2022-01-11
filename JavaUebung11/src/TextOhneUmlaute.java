import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class TextOhneUmlaute extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String dateiname;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TextOhneUmlaute frame = new TextOhneUmlaute();
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
	public TextOhneUmlaute() {
		setTitle("Umlaute entfernen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setBounds(10, 11, 414, 218);
		contentPane.add(textPane);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fc.setFileFilter(new FileNameExtensionFilter("Textdateien *.txt", "txt"));
				fc.setCurrentDirectory(new File("."));
				int status = fc.showSaveDialog(null);
				if (status == JFileChooser.APPROVE_OPTION) {
				    String selFile = fc.getSelectedFile().getAbsolutePath();
				    int index = selFile.indexOf('.');
				    if (index >= 0) {
					dateiname = selFile.substring(0, index).concat(".txt");
				    } else {
					dateiname = selFile.concat(".txt");
				    }
				    OhneUmlautWriter out = null;
				    try {
					out = new OhneUmlautWriter(new FileWriter(dateiname));
					out.write(textPane.getText());
				    } catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Fehler beim Speichern!");
				    } finally {
					if (out != null) {
					    try {
						out.close();
					    } catch (IOException ex) {
						ex.printStackTrace();
					    }
					}
				    }
				}
			}
		});
		btnSpeichern.setBounds(20, 240, 127, 23);
		contentPane.add(btnSpeichern);
		
		JButton btnLaden = new JButton("Laden");
		btnLaden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fc.setFileFilter(new FileNameExtensionFilter("Textdateien *.txt", "txt"));
				fc.setCurrentDirectory(new File("."));
				int status = fc.showOpenDialog(null);
				BufferedReader in = null;
				if (status == JFileChooser.APPROVE_OPTION) {
				    dateiname = fc.getSelectedFile().getAbsolutePath();
				    try {
					in = new BufferedReader(new FileReader(dateiname));
					int c;
					StringBuffer zeile = new StringBuffer();
					while ((c = in.read()) >= 0) {
					    zeile.append((char) c);
					}
					textPane.setText(zeile.toString());

				    } catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Fehler beim Lesen!");
				    } finally {
					if (in != null) {
					    try {
						in.close();
					    } catch (IOException ex) {
						ex.printStackTrace();
					    }
					}
				    }
				}
			}
		});
		btnLaden.setBounds(286, 240, 127, 23);
		contentPane.add(btnLaden);
	}
}
