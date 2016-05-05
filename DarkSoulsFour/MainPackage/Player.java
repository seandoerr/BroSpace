package MainPackage;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player 
{
	
	private final int WINDOW_WIDTH = 600;
	private final int WINDOW_HEIGHT = 400;
	
	int xLoc, yLoc;//first
	//int lives;//second
	int dx, dy;
	Image still;
	
	public Player() 
	{
		
		xLoc = 110;
		yLoc = 200;
		ImageIcon i = new ImageIcon("/Users/seandoerr/Desktop/sprite2_0.png");
		still = i.getImage();
		
	}
	
	public void move()
	{
		xLoc += dx;
		yLoc += dy;
		checkBoundaries();
	}
	
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
	
	public int getX()
	{
		return xLoc;
	}
	
	public int getY()
	{
		return yLoc;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public Image getImage() {
		return still;
	}

	public void setStill(Image still) {
		this.still = still;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
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
	

}
