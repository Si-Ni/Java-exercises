package gui09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class Uhrzeit extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tfStunden;
    private JTextField tfMinuten;
    private JLabel lblAusgabe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Uhrzeit frame = new Uhrzeit();
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
    public Uhrzeit() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblStunden = new JLabel("Stunden");
        lblStunden.setBounds(10, 11, 100, 14);
        contentPane.add(lblStunden);

        JLabel lblMinuten = new JLabel("Minuten");
        lblMinuten.setBounds(125, 11, 108, 14);
        contentPane.add(lblMinuten);

        tfStunden = new JTextField();
        tfStunden.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					tfMinuten.requestFocus();
				}
			}
		});
        tfStunden.setBounds(10, 36, 66, 20);
        contentPane.add(tfStunden);
        tfStunden.setColumns(10);

        tfMinuten = new JTextField();
        tfMinuten.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					erstellen();
				}
			}
		});
        tfMinuten.setBounds(125, 36, 66, 20);
        contentPane.add(tfMinuten);
        tfMinuten.setColumns(10);

        JButton btnberechne = new JButton("\u00DCbernehmen");
        btnberechne.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		erstellen();
        	}
        });
        btnberechne.setBounds(286, 34, 133, 23);
        contentPane.add(btnberechne);

        lblAusgabe = new JLabel("");
        lblAusgabe.setBounds(10, 103, 294, 14);
        contentPane.add(lblAusgabe);

        JButton btnEnde = new JButton("Ende");
        btnEnde.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
        btnEnde.setBounds(305, 131, 89, 23);
        contentPane.add(btnEnde);
    }
    	public void erstellen() {
    		int stunden, minuten;
    		try {
    			stunden = Integer.parseInt(tfStunden.getText());
	    		if(stunden < 0 || stunden > 23)  {
	    			throw new UhrzeitFormatException2(
	    					"Bitte nur Stundenwerte von 0 bis 23 angeben");
	    		}
	    		minuten = Integer.parseInt(tfMinuten.getText());
	    		if(minuten > 59 || minuten < 0) {
	    			throw new UhrzeitFormatException2(
	    					"Bitte nur Minutenwerte von 0 bis 59 angeben");
	    		}
	    			if (stunden < 10 && minuten < 10) {
	    				lblAusgabe.setText("Die Uhrzeit ist: 0" + stunden + ":0" + minuten + " Uhr!");
	    				tfStunden.requestFocus();
	    			}else if (stunden < 10 && minuten > 10) {
	    				lblAusgabe.setText("Die Uhrzeit ist: 0" + stunden + ":" + minuten + " Uhr!");
	    				tfStunden.requestFocus();
	    			}else if (stunden > 10 && minuten < 10) {
	    				lblAusgabe.setText("Die Uhrzeit ist: " + stunden + ":0" + minuten + " Uhr!");
	    				tfStunden.requestFocus();
	    			}else {
	    				lblAusgabe.setText("Die Uhrzeit ist: " + stunden + ":" + minuten + " Uhr!");
	    				tfStunden.requestFocus();
	    			}
	    		
    		}catch (UhrzeitFormatException2 ufe){
    			JOptionPane.showMessageDialog(null, ufe.getMessage());
    		}catch (NumberFormatException e) {
    			JOptionPane.showMessageDialog(null, "Formatfehler bei der Zahleneingabe.");
    		}
    	}
} 