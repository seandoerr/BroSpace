package MainPackage;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
	
	int xLoc, yLoc, size;//first
	int lives;//second
	int dx, dy;
	Image still;
	
	public Player(int x, int y) {
		
		xLoc = x;
		yLoc = y;
		ImageIcon i = new ImageIcon("/Users/OG/Desktop/circle.png");
		still = i.getImage();
		
	}
	
	
	/****************Movements**************/
	public void move() {
		
		xLoc += dx;
		yLoc += dy;
	}
	
	public void keyPressed(KeyEvent e) {
		System.out.println("here");
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			dx = -2;
		}
		
		if(key == KeyEvent.VK_RIGHT) {
			dx = 2;
		}

		if(key == KeyEvent.VK_UP) {
			dy= 2;
		}
		
		if(key == KeyEvent.VK_DOWN) {
			dy= -2;
		}
	}
	
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			dx=0;
		}
		
		if(key == KeyEvent.VK_RIGHT) {
			dx=0;
		}

		if(key == KeyEvent.VK_UP) {
			dy=0;
		}
		
		if(key == KeyEvent.VK_DOWN) {
			dy=0;
		}
	}

	public Image getImage() {
		return still;
	}


	public int getxLoc() {
		return xLoc;
	}


	public int getyLoc() {
		return yLoc;
	}


	public int getSize() {
		return size;
	}


	public int getLives() {
		return lives;
	}


	public int getDx() {
		return dx;
	}


	public int getDy() {
		return dy;
	}


	public Image getStill() {
		return still;
	}

	

}
