package gui12;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;

public class Zeichnen2 extends JFrame {

	private JPanel contentPane;
	private JTextField tfPositionX1;
	private JTextField tfPositionY1;
	private JTextField tfPositionX2;
	private JTextField tfPositionY2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnLinie, rdbtnKreis;
	private JLabel lblPositionX1, lblPositionX2, lblPositionY2, lblPositionY1;
	private JCheckBox chckbxGefuellt;
	private char figur;
	private int x1, x2, y1, y2;
	private JPanel panelZeichenflaeche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zeichnen2 frame = new Zeichnen2();
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
	public Zeichnen2() {
		setTitle("Zeichnen2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZeichenflaeche = new JLabel("Zeichenfl\u00E4che");
		lblZeichenflaeche.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZeichenflaeche.setBounds(10, 11, 164, 14);
		contentPane.add(lblZeichenflaeche);
		
		panelZeichenflaeche = new JPanel();
		panelZeichenflaeche.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelZeichenflaeche.setBackground(new Color(255, 255, 255));
		panelZeichenflaeche.setBounds(10, 36, 330, 414);
		contentPane.add(panelZeichenflaeche);
		
		JPanel panelBedienelemente = new JPanel();
		panelBedienelemente.setBounds(350, 36, 324, 414);
		contentPane.add(panelBedienelemente);
		panelBedienelemente.setLayout(null);
		
		lblPositionX1 = new JLabel("Position x:");
		lblPositionX1.setBounds(10, 11, 88, 14);
		panelBedienelemente.add(lblPositionX1);
		
		tfPositionX1 = new JTextField();
		tfPositionX1.setBounds(97, 8, 82, 20);
		panelBedienelemente.add(tfPositionX1);
		tfPositionX1.setColumns(10);
		
		lblPositionY1 = new JLabel("y:");
		lblPositionY1.setBounds(194, 11, 48, 14);
		panelBedienelemente.add(lblPositionY1);
		
		tfPositionY1 = new JTextField();
		tfPositionY1.setBounds(242, 8, 82, 20);
		panelBedienelemente.add(tfPositionY1);
		tfPositionY1.setColumns(10);
		
		lblPositionX2 = new JLabel("Breite:");
		lblPositionX2.setBounds(10, 49, 88, 14);
		panelBedienelemente.add(lblPositionX2);
		
		tfPositionX2 = new JTextField();
		tfPositionX2.setBounds(97, 46, 82, 20);
		panelBedienelemente.add(tfPositionX2);
		tfPositionX2.setColumns(10);
		
		tfPositionY2 = new JTextField();
		tfPositionY2.setBounds(242, 46, 82, 20);
		panelBedienelemente.add(tfPositionY2);
		tfPositionY2.setColumns(10);
		
		lblPositionY2 = new JLabel("H\u00F6he:");
		lblPositionY2.setBounds(194, 49, 62, 14);
		panelBedienelemente.add(lblPositionY2);
		
		JRadioButton rdbtnRechteck = new JRadioButton("Rechteck");
		rdbtnRechteck.setSelected(true);
		rdbtnRechteck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setzeBeschriftungen();
				lblPositionY2.setVisible(true);
				tfPositionY2.setVisible(true);
				figur = 'R';
			}
		});
		buttonGroup.add(rdbtnRechteck);
		rdbtnRechteck.setBounds(82, 120, 109, 23);
		panelBedienelemente.add(rdbtnRechteck);
		
		rdbtnKreis = new JRadioButton("Kreis");
		rdbtnKreis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setzeBeschriftungen();
				lblPositionY2.setVisible(false);
				tfPositionY2.setVisible(false);
				figur = 'K';
			}
		});
		buttonGroup.add(rdbtnKreis);
		rdbtnKreis.setBounds(82, 146, 109, 23);
		panelBedienelemente.add(rdbtnKreis);
		
		JRadioButton rdbtnOval = new JRadioButton("Oval");
		rdbtnOval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setzeBeschriftungen();
				lblPositionY2.setVisible(true);
				tfPositionY2.setVisible(true);
				figur = 'O';
			}
		});
		buttonGroup.add(rdbtnOval);
		rdbtnOval.setBounds(82, 172, 109, 23);
		panelBedienelemente.add(rdbtnOval);
		
		rdbtnLinie = new JRadioButton("Linie");
		rdbtnLinie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setzeBeschriftungen();
				lblPositionY2.setVisible(true);
				tfPositionY2.setVisible(true);
				figur = 'L';
			}
		});
		buttonGroup.add(rdbtnLinie);
		rdbtnLinie.setBounds(82, 198, 109, 23);
		panelBedienelemente.add(rdbtnLinie);
		
		chckbxGefuellt = new JCheckBox("gef\u00FCllt");
		chckbxGefuellt.setBounds(82, 266, 97, 23);
		panelBedienelemente.add(chckbxGefuellt);
		
		JButton btnZeichnen = new JButton("Zeichnen");
		btnZeichnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					x1 = Integer.parseInt(tfPositionX1.getText());
					x2 = Integer.parseInt(tfPositionX2.getText());
					y1 = Integer.parseInt(tfPositionY1.getText());
					y2 = Integer.parseInt(tfPositionY2.getText());
					switch(figur) {
					case 'R':
						if(chckbxGefuellt.isSelected()) {
							panelZeichenflaeche.getGraphics().fillRect(x1, y1, x2, y2);
						} else {
							panelZeichenflaeche.getGraphics().drawRect(x1, y1, x2, y2);
						}
						break;
					case 'K':
						if(chckbxGefuellt.isSelected()) {
							panelZeichenflaeche.getGraphics().fillOval(x1, y1, x2, x2);
						} else {
							panelZeichenflaeche.getGraphics().drawOval(x1, y1, x2, x2);
						}
						break;
					case 'O':
						if(chckbxGefuellt.isSelected()) {
							panelZeichenflaeche.getGraphics().fillOval(x1, y1, x2, y2);
						} else {
							panelZeichenflaeche.getGraphics().drawOval(x1, y1, x2, y2);
						}
						break;	
					case 'L':
							panelZeichenflaeche.getGraphics().drawLine(x1, y1, x2, y2);
						break;	
					}
				}catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Die Eingaben sind ungültig");
				}
			}
		});
		btnZeichnen.setBounds(82, 316, 89, 23);
		panelBedienelemente.add(btnZeichnen);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(235, 391, 89, 23);
		panelBedienelemente.add(btnEnde);
	}
	
	private void setzeBeschriftungen() {
		if(rdbtnLinie.isSelected()) {
			lblPositionX1.setText("Startpunkt x:");
			lblPositionX2.setText("Endpunkt x:");
			lblPositionY2.setText("y:");
			chckbxGefuellt.setVisible(false);
		} else {
			lblPositionX1.setText("Position x:");
			chckbxGefuellt.setVisible(true);
			if(rdbtnKreis.isSelected()) {
				lblPositionX2.setText("Durchmesser:");
			} else {
				lblPositionX2.setText("Breite:");
			}
			lblPositionY2.setText("Höhe:");
		}
	}
	
}
