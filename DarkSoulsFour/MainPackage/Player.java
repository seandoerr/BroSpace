/*PROGRAM:Player.java
 *PROGRAMMER:Group1
 *DATE LAST MODIFIED:5-16-16
 *DESCRIPTION:The purpose of this program is to create the playable character that will be used in the game.
 *This class will be used to monitor the players location in the level and check for collisions. The user
 *will be able to move the character using the arrow keys
 * 
 */
package MainPackage;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Player 
{
	
	private final int WINDOW_WIDTH = 600;
	private final int WINDOW_HEIGHT = 400;
	
	int xLoc, yLoc;
	int dx, dy, nx, nx2;
	Image still;
	boolean ded = false;
	
	static ArrayList<Projectile> projectiles;
	
	/*DESCRIPTION:Constructor 
	 *PRECONDITION:NA
	 *POSTCONDITION:initializes instances
	 * 
	 */
	public Player() 
	{
		
		xLoc = 110;
		yLoc = 200;
		nx2 = 590;
		nx = 0;
		ImageIcon i = new ImageIcon("sprite2_0.png");
		still = i.getImage();
		projectiles = new ArrayList<Projectile>();
	}
	
	
	/*DESCRIPTION:Creates a new projectile from the player's location and adds to the projectiles ArrayList
	 *PRECONDITION:NA
	 *POSTCONDITION:new projectile is added into projectiles
	 * 
	 */
	public void shoot()
	{
		Projectile p = new Projectile(xLoc, yLoc);
		projectiles.add(p);
	}
	
	
	/*DESCRIPTION:
	 *PRECONDITION:
	 *POSTCONDITION:
	 * 
	 */
	public void move()
	{
		xLoc += dx;
		yLoc += dy;
		nx2 += dx;
		nx += dx;
		checkBoundaries();
	}
	
	
	/*DESCRIPTION:Checks to make sure that the player is within the playable boundaries
	 *PRECONDITION:
	 *POSTCONDITION:
	 * 
	 */
	public void checkBoundaries()
	{
		if(xLoc < 0)
		{
			xLoc = 0;
		}
		if(xLoc > WINDOW_WIDTH)
		{
			xLoc = WINDOW_WIDTH;
		}
		if(yLoc < 0)
		{
			yLoc = 0;
		}
		if(yLoc > WINDOW_HEIGHT)
		{
			yLoc = WINDOW_HEIGHT;
		}
	}
	
	/*DESCRIPTION:checks keyEvent @param and will adjust the players coordinates depending on the key pressed
	 *PRECONDITION:user presses key
	 *POSTCONDITION:player location is adjusted
	 * 
	 */
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_SPACE)
		{
			shoot();
		}
		
		if(key == KeyEvent.VK_LEFT);
		{
				dx = -2;
				dy = 0;
		}
		if(key == KeyEvent.VK_DOWN)
		{
				dy = 2;
				dx = 0;
		}
		if(key == KeyEvent.VK_UP)
		{
				dy = -2;
				dx = 0;
		}
		
		if(key == KeyEvent.VK_RIGHT)
		{	
				dx = 2;
				dy = 0;

		}
		
	}
	
	/*DESCRIPTION:returns the player character to a standstill when the user releases a key
	 *PRECONDITION:user presses a key and releases
	 *POSTCONDITION:the the change direction changed to zero
	 * 
	 */
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT);
		{
			dx = 0;		
		}
		
		if(key == KeyEvent.VK_RIGHT)
		{
			dx = 0;
		}
		
		if(key == KeyEvent.VK_DOWN)
		{
			dy = 0;
		}
		if(key == KeyEvent.VK_UP)
		{
			dy = 0;
		}
		
	}
	
	/*DESCRIPTION:Returns a Rectangle object based on the location and size of the player
	 *PRECONDITION:NA
	 *POSTCONDITION:Rectangle is returned
	 * 
	 */
	public Rectangle getBounds() {
		return new Rectangle(xLoc, yLoc, 32, 32);
	}
	
	
	/* GETTERS AND SETTERS*/
	public static ArrayList<Projectile> getProjectiles()
	{
		return projectiles;
	}
	
	public int getX()
	{
		return xLoc;
	}
	
	public int getY()
	{
		return yLoc;
	}

	public int getDx() 
	{
		return dx;
	}

	public void setDx(int dx) 
	{
		this.dx = dx;
	}

	public int getDy() 
	{
		return dy;
	}

	public void setDy(int dy)
	{
		this.dy = dy;
	}

	public Image getImage() 
	{
		return still;
	}

	public void setStill(Image still) 
	{
		this.still = still;
	}
	
	public void setDed(boolean bool) {
		ded = bool;
	}
	
	public boolean getDed() {
		return ded;
	}
	
	

}
