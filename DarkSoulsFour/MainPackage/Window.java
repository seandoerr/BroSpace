package MainPackage;

import javax.swing.JFrame;

	import java.awt.*;

	import javax.swing.*;

	import java.awt.event.*;
	import java.util.ArrayList;

	public class Window extends JFrame 
	{
		private final int WINDOW_WIDTH = 600;
		private final int WINDOW_HEIGHT = 400;

		private final int BUTTON_WIDTH = 100;
		private final int BUTTON_HEIGHT = 50;
		Player one = new Player(10,10,10);


		public Window () {
			super("game");
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			setResizable(true);
			one.paint(null);
		}
	
	
	

}
