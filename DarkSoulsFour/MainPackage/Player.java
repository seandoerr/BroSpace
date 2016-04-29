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
	public void moveUp(int move) { //dont hardcode variable, create
		yLoc += dy;//pixels
	}
	
	public void moveDown(int move) {
		yLoc += dy;//pixels
	}
	
	public void moveLeft(int move) {
		xLoc += dx;//pixels
	}
	
	public void moveRight(int move) {
		xLoc += dx;//pixels
	}
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_LEFT) {
			dx = -2;
		}
		
		if(key == KeyEvent.VK_RIGHT) {
			dx = 2;
		}

		if(key == KeyEvent.VK_UP) {
			dy=2;
		}
		
		if(key == KeyEvent.VK_DOWN) {
			dy=-2;
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

public void paint(Graphics g) {
		System.out.println(xLoc);
		System.out.println(yLoc);
		System.out.println(xLoc+size);
		System.out.println(yLoc+size);
		g.drawRect(xLoc, yLoc, xLoc+size, yLoc+size);
	}
	

}
