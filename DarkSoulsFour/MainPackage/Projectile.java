package MainPackage;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Projectile 
{
	int x, y;
	Image projectile;
	boolean visible;
	public Projectile(int x, int y) 
	{
		ImageIcon newProjectile = new ImageIcon("fireball2.png ");
		projectile = newProjectile.getImage();
		this.x = x;
		this.y = y;
		visible = true;
	}
	
	// x+size y+size/2
	public void move() 
	{
		x += 3;
		if(x > 637)
		{
			visible = false;
		}
	}

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
	
	public Rectangle getBounds() {
		return new Rectangle(x-10, y-10, 10, 10);
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
