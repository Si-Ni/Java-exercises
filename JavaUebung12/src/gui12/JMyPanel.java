package gui12;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class JMyPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.red);
		g.drawLine(0, 0, this.getWidth(), this.getHeight());
		
		
	}
	
}
