package MainPackage;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends JPanel implements ActionListener  
{
	Queue<Integer> levelSize;
	
	final int LAST_LEVEL = 5;
	
	Player person;
	
	Timer time;
	
	public Image img, img2;
	
	Enemies enemy;
	
	ArrayList<Enemies> level = new ArrayList<Enemies>();
	
	int currentLevel =  0; 
	
	Queue<Enemies> level2 = new LinkedList<Enemies>();
	
	int iterator, b, foe,score, numEnemies;
	
	boolean endGame = false;
	
		
	public Game() 
	{
		numEnemies=0;
		Random ran = new Random();
		enemy = new Enemies(2);
		levelSize = new LinkedList<Integer>();
		
		
		//current level
		level.add(new Enemies(2));
		level.add(new Enemies(1));
		level.add(new Enemies(0));
		level.add(new Enemies(2));
		level.add(new Enemies(1));
		level.add(new Enemies(2));
		levelSize.offer(6);
		
		//level two
		level.add(new Enemies(2));
		level.add(new Enemies(4));
		level.add(new Enemies(3));
		level.add(new Enemies(3));
		level.add(new Enemies(1));
		level.add(new Enemies(0));
		levelSize.offer(6);
		
		//level three
		level.add(new Enemies(0));
		level.add(new Enemies(4));
		level.add(new Enemies(0));
		level.add(new Enemies(4));
		level.add(new Enemies(0));
		level.add(new Enemies(4));
		levelSize.offer(6);
		
		for( int i = 0 ; i < LAST_LEVEL-3;i++ ) {
			numEnemies++;
			
			levelSize.offer((6+numEnemies));
			
			for(int x = 0; x < (6+numEnemies) ; x++) {
				level.add(new Enemies(ran.nextInt(5)));
			}
		}
		
		
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
		 foe = 0;
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		hitDetection();
		
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
		
		hitDetection();
		
		
		
		g2d.drawImage(img,0, 0, null);
		
		
		if(!person.getDed()) {
			g2d.drawImage(person.getImage(), person.getX(), person.getY() ,null);
		}
		
		
		
		ArrayList<Projectile> projectiles = Player.getProjectiles();
		for(int i = 0; i < projectiles.size(); i++)
		{
			Projectile p = (Projectile) projectiles.get(i);
			g2d.drawImage(img2, p.getX(), p.getY(), null);
			
		}
		
		
		iterator++;
		
		
		
		if( iterator > 100) {	
			level.get(foe).fire();
		}
		if( iterator > 200){
			level.get(foe+1).fire();
		}
		if( iterator > 300) {
			level.get(foe+2).fire();
		}
		if( iterator > 400) {
			level.get(foe+3).fire();
		}
		if( iterator > 500) {
			level.get(foe+4).fire();
		}
		if( iterator > 600) {
			level.get(foe+5).fire();
		}
		
		if(iterator==1400) {
			
			foe+=6;
			iterator=0;
			currentLevel++;
			
			if(currentLevel>3) {
				//increment the number of enemies
				//
			}
			
			System.out.println("_____________________END OF LEVEL "+ currentLevel +"_____________________");
			if(currentLevel==LAST_LEVEL) {
				endGame=true;
			}
		}
		
		if(endGame) {
			System.exit(100);
		}
		
		for( int i=0; i < 6 ; i++) {
			if(level.get(foe+i).getAlive()==true) {
				g2d.drawImage(level.get(i+foe).getImage(), level.get(i+foe).getX(), level.get(i+foe).getY(), null);
			}
		}	
	}
	
	public void hitDetection() {
		Rectangle poop;
		ArrayList projectiles = Player.getProjectiles();
		Rectangle personBounds = person.getBounds();
		
		for(int i = 0; i < projectiles.size(); i++)
		{
			System.out.println("checking");
			Projectile p = (Projectile) projectiles.get(i);
			Rectangle a = p.getBounds();
			
			for( int x = 0 ;x < level.size(); x++) {
				poop = level.get(x).getBounds();
				if(a.intersects(poop)&& level.get(x).getAlive()) {
					score++;
					System.out.println("got em");
					level.get(x).setAlive(false);
					p.setVisible(false);				
				}
			}						
		}
		
		for ( int x = 0 ;x< level.size(); x++) {
			Rectangle ship = level.get(x).getBounds(); 
			if(ship.intersects(personBounds)&&level.get(x).getAlive()) {
				System.out.println("DED");
				person.setDed(true);
			}
			
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
