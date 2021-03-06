/*PROGRAM:Game.java
 *PROGRAMMER:Group1
 *DATE LAST MODIFIED:5-16-16
 *DESCRIPTION:The purpose of this class is to run the game loop on a JPanel:allowing a to player move, shoot projectiles,
 *allow enemies to come in waves, and provide a means of hit detection. 
 */
package MainPackage;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

public class Game extends JPanel implements ActionListener  
{
	Queue<Integer> levelSize;
	
	final int LAST_LEVEL = 10;
	
	Player person;
	
	Timer time;
	
	static int currentSize = 0 ;
	static int endOfWave =0;
	
	public Image img, img2;
	
	Enemies enemy;
	
	ArrayList<Enemies> level = new ArrayList<Enemies>();
	
	int currentLevel =  0; 
	
	Queue<Enemies> level2 = new LinkedList<Enemies>();
	
	int iterator, b, foe,score, numEnemies;
	
	boolean endGame = false;
	
	ImageIcon play = new ImageIcon("title.png");
	ImageIcon over = new ImageIcon("gameOver2.png");
	
	/*DESCIRPTION:constructor that initializes instances of class
	 * PRECONDITION:NA
	 * POSTCONDITION:The game is initialized and the timer is started
	 * 
	 */
		
	public Game() 
	{
		numEnemies=0;
		Random ran = new Random();
		enemy = new Enemies(2);
		levelSize = new LinkedList<Integer>();
		
		UIManager UI = new UIManager();
		UI.put("OptionPane.background", new ImageIcon("SpaceBG.gif"));
		UI.put("Panel.background",Color.BLACK);

		JOptionPane gameStart = new JOptionPane();
		gameStart.showMessageDialog(null, "", "", JOptionPane.INFORMATION_MESSAGE,play);
		
		
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
	
	/*DESCIRPTION:creates a method to handle the action events from the timer 
	 * PRECONDITION:timer must be started
	 * POSTCONDITION:the game is constantly updated each 5 msecs and repainted onto the JPanel 
	 */
	public void actionPerformed(ActionEvent e) 
	{
		hitDetection();
		
		ArrayList<Projectile> projectiles = Player.getProjectiles();
		for(int i = 0; i < projectiles.size(); i++)
		{
			Projectile p = (Projectile) projectiles.get(i);
			if(p.isVisible() == true&&!person.getDed())
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
	
	/*DESCIRPTION:Draws the Player , Enemies, and projectiles on the screen. 
	 *PRECONDITION:NA
	 *POSTCONDITION:objects are printed on the jPanel which is continually updated based upon each 
	 *their respective locations and the user input.
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
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
		
		if(iterator==0) {
			currentSize = levelSize.poll();//this will initialize the size of the wave
			
			
			System.out.println("Wave Size: "+currentSize);
		}
		
		iterator++;
		
		if(iterator < 100) {
			g.setColor(Color.RED);
			g.setFont(new Font("Lucida Sans Typewriter",20,20));
			g.drawString("WAVE "+ (currentLevel+1), 250, 200);
		}
		
		//starts each of the enemies at different times
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
		
		if( iterator>700 && currentSize>6) {
			level.get(foe+6).fire();
			endOfWave = 200;
		}
		
		if( iterator>800 && currentSize>7) {//moving the eight enemy
			
			level.get(foe+7).fire();
			endOfWave = 400;
		}
		
		if( iterator>900 && currentSize>8) {
			level.get(foe+8).fire();
			endOfWave = 600;
		}
		
		if( iterator>1000 && currentSize>9) {
			level.get(foe+9).fire();
			endOfWave = 800;
		}
		
		
		//this will number will indicate the end of a wave
		if(iterator==(1400+endOfWave)) {//need to change this iterator value, indicates the end of the wave
			
			foe+=currentSize;
			iterator=0;
			currentLevel++;
			
			System.out.println("_____________________END OF LEVEL "+ currentLevel +"_____________________");
			if(currentLevel==LAST_LEVEL||person.getDed()) {//checks to see if the last level
				endGame=true;
			}
		}
		
		//exits the game at the last wave
		if(endGame) 
		{
			time.stop();
			UIManager UI = new UIManager();
			UI.put("OptionPane.background", Color.DARK_GRAY);
			UI.put("Panel.background",Color.DARK_GRAY);
			JOptionPane gameOver = new JOptionPane("Game Over");
			if(person.getDed()) {
				gameOver.showMessageDialog(null, ("You Lose!\nScore: "+score+"\nWave "+currentLevel),"", JOptionPane.INFORMATION_MESSAGE,over);
			}
			else {
				gameOver.showMessageDialog(null, ("You Win!\nScore: "+score+"\nWave "+currentLevel),"", JOptionPane.INFORMATION_MESSAGE,over);
			}
			System.exit(100);
		}
		
		for( int i=0; i < currentSize ; i++) {//change to currentSize
			if(level.get(foe+i).getAlive()==true) {
				g2d.drawImage(level.get(i+foe).getImage(), level.get(i+foe).getX(), level.get(i+foe).getY(), null);
			}
		}	
	}
	
	/*DESCIRPTION: This method will checks projectiles, enemies, and the player object to see if their locations intersect.
	 * PRECONDITION:NA
	 * POSTCONDITION:Depending if any of the objects intersect, this method will update their visibility and determine if the game 
	 * end.
	 */
	public void hitDetection() {
		Rectangle aEnemy;
		ArrayList<Projectile> projectiles = Player.getProjectiles();
		Rectangle personBounds = person.getBounds();
		
		for(int i = 0; i < projectiles.size(); i++)
		{
			Projectile p = (Projectile) projectiles.get(i);
			Rectangle a = p.getBounds();
			
			//checks to see the enemy intersects with projectile
			for( int x = 0 ;x < level.size(); x++) {
				aEnemy = level.get(x).getBounds();
				if(a.intersects(aEnemy)&& level.get(x).getAlive()) {
					score++;
					level.get(x).setAlive(false);
					p.setVisible(false);				
				}
			}						
		}
		
		//checks to see the enemy intersects with person
		for ( int x = 0 ;x< level.size(); x++) {
			Enemies oneOfEm = level.get(x);
			Rectangle ship = oneOfEm.getBounds(); 
			if((ship.intersects(personBounds)||oneOfEm.getX()<0)&&oneOfEm.getAlive()) {
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
