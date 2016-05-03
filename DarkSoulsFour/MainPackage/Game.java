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
	public Image img;
	
	public Game() 
	{
		person = new Player();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("/Users/seandoerr/Desktop/space.png");//background
		img = i.getImage(); //for background
		time = new Timer(5, this);
		time.start();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		person.move();
		repaint();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(img, 0, 0, null);
		g2d.drawImage(person.getImage(), person.getX() , person.getY() ,null);
		
	}
	
	private class AL extends KeyAdapter
	{
		public void keyReleased(KeyEvent e)
		{
			person.keyReleased(e);
		}
		public void keyPressed(KeyEvent e)
		{
			person.keyPressed(e);
		}
	}
	
	
}
