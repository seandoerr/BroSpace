package MainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener  
{
	
	Player person;
	Timer time;
	public Image img, img2;
	Enemies enemy;
	ArrayList<Enemies> level = new ArrayList<Enemies>();
	
	int iterator, b;
		
	public Game() 
	{
		enemy = new Enemies(2);
		
		
		// current level
		level.add(new Enemies(2));
		level.add(new Enemies(1));
		level.add(new Enemies(0));
		level.add(new Enemies(2));
		level.add(new Enemies(1));
		level.add(new Enemies(2));
		
		person = new Player();
		addKeyListener(new AL());
		setFocusable(true);
		ImageIcon i = new ImageIcon("SpaceBG.gif");//background
		img = i.getImage(); //for background
		time = new Timer(5, this);
		time.start();
		ImageIcon fire = new ImageIcon("fireball2.png");
		img2 = fire.getImage();
		 iterator  = 0;
		 b = 0;
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		
		ArrayList<Projectile> projectiles = Player.getProjectiles();
		for(int i = 0; i < projectiles.size(); i++)
		{
			Projectile p = (Projectile) projectiles.get(i);
			if(p.isVisible() == true)
			{
				p.move();
			}
			else
			{
				projectiles.remove(i);
			}
		}
		
		person.move();
		
		repaint();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		
		/*if((person.getX() - 110) % 1280 == 0) 
		{
			person.nx = 0;
		}
		if((person.getX() - 750) % 1280 == 0)
		{
			person.nx2 = 0;
		}*/
		
		g2d.drawImage(img,0/*622-person.nx2*/, 0, null);
		//System.out.println(person.getX());
		
		/*if(person.getX() >= 110)
		{
			g2d.drawImage(img,622-person.nx, 0, null);
		}*/
		g2d.drawImage(person.getImage(), person.getX(), person.getY() ,null);
		
		
		
		ArrayList<Projectile> projectiles = Player.getProjectiles();
		for(int i = 0; i < projectiles.size(); i++)
		{
			Projectile p = (Projectile) projectiles.get(i);
			g2d.drawImage(img2, p.getX() /*- person.nx*/, p.getY(), null);
			
			/*if(i == 0)
			{
				System.out.println("Projectile: " + (p.getX() - person.nx));
				System.out.println("Person: " + person.getX());
			}*/
		}
		
		if(iterator % 500 == 0) {
					
					System.out.println("here");
					
					if(b < 6) {
						System.out.println("prease");
						b++;
					//	g2d.drawImage(level.get(b).getImage(), level.get(b).getX(), level.get(b).getY(), null);
					}
		}
		
		iterator++;
		
		if( iterator > 500)
			level.get(0).fire();
		if( iterator > 700)
			level.get(1).fire();
		if( iterator > 300)
			level.get(2).fire();
		if( iterator > 400)
			level.get(3).fire();
		if( iterator > 500)
			level.get(4).fire();
		if( iterator > 600)
			level.get(5).fire();
		
		for( int i=0; i < 6 ; i++) {
			g2d.drawImage(level.get(i).getImage(), level.get(i).getX(), level.get(i).getY(), null);
		}
		
		
		
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
