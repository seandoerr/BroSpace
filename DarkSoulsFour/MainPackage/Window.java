/*PROGRAM:Window.java
 *PROGRAMMER:Group1
 *DATE LAST MODIFIED:5-16-16
 *DESCRIPTION:The purpose of the program is to create JFrame Component that will contain the 
 *game.
 * 
 */
package MainPackage;

import javax.swing.JFrame;

	public class Window 
	{
		private final int WINDOW_WIDTH = 637;
		private final int WINDOW_HEIGHT = 455;

		/*DESCRIPTION:Constructor 
		 *PRECONDITION:NA
		 *POSTCONDITION:Sets the JFrame and adds the game panel 
		 * 
		 */
		public Window () 
		{
			JFrame frame = new JFrame();
			frame.add(new Game());
			frame.setTitle("Gaben pls");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			frame.setResizable(false);
			
		}
		
		public static void main(String[] args)
		{
			new Window();
		}
	
	
	

}
