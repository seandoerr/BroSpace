package MainPackage;

import javax.swing.JFrame;

	public class Window //extends JFrame 
	{
		private final int WINDOW_WIDTH = 637;
		private final int WINDOW_HEIGHT = 455;

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
			
			/*super("game");
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
			setResizable(true);*/
		}
		
		public static void main(String[] args)
		{
			new Window();
		}
	
	
	

}
