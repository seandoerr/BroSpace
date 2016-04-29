package MainPackage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener  {
	
	Player person;
	Timer time;
	Image img;
	
	public Game() {
		person = new Player(0,0);
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon();//background
		time = new Timer(5, this);
		time.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		person.move();
		repaint();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, 0, 0, null);
		g2d.drawImage(person.getImage(), person.getxLoc() , person.getyLoc() ,null);
		
	}
	
	private class AL extends KeyAdapter {
		
		public void keyReleased(KeyEvent e) {
			System.out.println("here");
			person.keyReleased(e);
		}
		
		public void keyPressed(KeyEvent e) {
			person.keyPressed(e);
			System.out.println("here");
		}
	}
	
	

}
