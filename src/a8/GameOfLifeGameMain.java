package a8;


import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameOfLifeGameMain {
	
	GameOfLifeWidgetController _controller;


	public static void main(String[] args) {
		
		JFrame main_frame = new JFrame();
		main_frame.setTitle("Game Of Life");
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* Create panel for content. Uses BorderLayout. */
		JPanel top_panel = new JPanel();
		top_panel.setLayout(new BorderLayout());
		main_frame.setContentPane(top_panel);

		/* Create ExampleWidget component and put into center
		 * of content panel.
		 */
		
		
		GameOfLifeView view = new GameOfLifeView (10);
		
		
		GameOfLifeModel model = new GameOfLifeModel ();
		GameOfLifeWidgetController controller = new GameOfLifeWidgetController(view, model);
		view.addController(controller);
		
		
		top_panel.add(view, BorderLayout.CENTER);


		/* Pack main frame and make visible. */
		
		main_frame.pack();
		main_frame.setVisible(true);
		
		
		
		
	}
	
	
	
}
