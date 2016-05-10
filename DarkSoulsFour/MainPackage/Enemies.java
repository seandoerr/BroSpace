package MainPackage;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import javax.swing.Timer;

public class Enemies { // 600 width 400 height

	final double ENEMY_VELOCITY = -1;

	final int ENEMY_SIZE = 50;

	final int DELAY = 1000;

	int x, y, size;

	ImageIcon img;

	Image theHomie;
	
	boolean alive = true;

	Rectangle border;

	public Enemies(int locationStart) {

		if (locationStart > 4 || locationStart < 0) {

			locationStart = -4;

		}

		y = (locationStart * 100) - size;// going to move to hundreds pixel
											// location

		size = ENEMY_SIZE; // the grid of the enemy

		x = 800 - size;

		img = new ImageIcon("enemy.png");

		theHomie = img.getImage();

	}

	// fires the enemy to the left of the screen from the right

	public void fire() {

		x += ENEMY_VELOCITY;

	}

	public int getX() {

		return x;

	}

	public void setX(int x) {

		this.x = x;

	}

	public int getY() {

		return y;

	}

	public void setY(int y) {

		this.y = y;

	}

	public int getSize() {

		return size;

	}

	public void setSize(int size) {

		this.size = size;

	}

	public Image getImage() {

		return this.theHomie;

	}

	public void setImg(ImageIcon img) {

		this.img = img;

	}
	
	public Rectangle getBounds() {
		return new Rectangle(x-10, y-15, 25, 25);
	}
	
	public boolean getAlive() {
		return alive;
	}
	
	public void setAlive(boolean isAlive) {
		alive = isAlive;
	}

}