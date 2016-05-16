/*PROGRAM:Projectile.Java
 *PROGRAMMER:Group1
 *DATE LAST MODIFIED:5-16-16
 *DESCRIPTION:The purpose of this class is to create the firing system that the player will use
 *to hit the enemies.
 */
package MainPackage;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Projectile 
{
	
	int x, y;
	Image projectile;
	boolean visible;
	
	/*DESCRIPTION:Constructor
	 *PRECONDITION:NA
	 *POSTCONDITION:Initializes the instances
	 */
	public Projectile(int x, int y) 
	{
		ImageIcon newProjectile = new ImageIcon("fireball2.png ");
		projectile = newProjectile.getImage();
		this.x = x;
		this.y = y;
		visible = true;
	}
	
	/*DESCRIPTION:Moves the location of the projectile to the right
	 *PRECONDITION:NA
	 *POSTCONDITION:The x location is adjusted to the right by a value of 3
	 */
	public void move() 
	{
		x += 3;
		if(x > 637)
		{
			visible = false;
		}
	}
	
	/*DESCRIPTION:Returns a Rectangle object used for hit detection 
	 *PRECONDITION:NA
	 *POSTCONDITION:Creates a Rectangle object based on the Projectile size and the location, then returns to the user
	 */
	public Rectangle getBounds() {
		return new Rectangle(x-10, y-10, 10, 10);
	}
	
	/*******************GETTERS AND SETTERS*******************/
	
	public int getX() 
	{
		return x;
	}

	public void setX(int x) 
	{
		this.x = x;
	}

	public int getY() 
	{
		return y;
	}

	public void setY(int y) 
	{
		this.y = y;
	}

	public Image getProjectile() 
	{
		return projectile;
	}

	public void setProjectile(Image projectile) 
	{
		this.projectile = projectile;
	}
	

	public boolean isVisible() 
	{
		return visible;
	}

	public void setVisible(boolean visible) 
	{
		this.visible = visible;
	}

}
