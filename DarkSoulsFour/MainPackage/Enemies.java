/*PROGRAM:Enemies.java
 *PROGRAMMER:Group1
 *DATE LAST MODIFIED:5-16-16
 *DESCRIPTION:The purpose of this program is to provide the Enemies the Player must hit
 *in order to further the game.
 */
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

	
	/*DESCRIPTION:constructor
	 *PRECONDITION:int @param should be from 0-4
	 *POSTCONDITION:Initializes the class instances and places the Enemy at a location dependent on 
	 *	the int value @param
	 * 
	 */
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

	
	/*DESCRIPTION:moves the enemy to the left of the screen from the right
	 *PRECONDITION:NA
	 *POSTCONDITION:Changes the x value by the value of ENEMY_VELOCITY
	 * 
	 */
	public void fire() {

		x += ENEMY_VELOCITY;

	}
	
	/*DESCRIPTION:Returns a Rectangle that will be used for hit detection
	 *PRECONDITION:NA
	 *POSTCONDITION:Rectangle is returned dependent on the size and location of Enemies object
	 * 
	 */
	public Rectangle getBounds() {
		return new Rectangle(x-10, y-15, 25, 25);
	}
	
	
	/***************GETTERS AND SETTERS***************/

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
	
	public boolean getAlive() {
		return alive;
	}
	
	public void setAlive(boolean isAlive) {
		alive = isAlive;
	}

}