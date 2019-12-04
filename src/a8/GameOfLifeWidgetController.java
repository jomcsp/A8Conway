package a8;


import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameOfLifeWidgetController extends JPanel implements ActionListener, SpotListener  {

	/* Enum to identify player. */
	
	private enum Player {BLUE, GREEN};
	

	private JLabel _message;		/* Label for messages. */
	
	
	
	
	private GameOfLifeView _view;
	private GameOfLifeModel _model;
	private boolean isPlaying = false;
	
	public GameOfLifeWidgetController(GameOfLifeView view, GameOfLifeModel model) {
		
		_view = view;
		_model = model;
		
		_model.addArray(_view._board.getBoard());
		
//		view.addActionListener(this);

		/* Reset game. */
		resetGame();
	}

	
	
	
	/* resetGame
	 * 
	 * Resets the game by clearing all the spots on the board,
	 * picking a new secret spot, resetting game status fields, 
	 * and displaying start message.
	 * 
	 */

	private void resetGame() {
		/* Clear all spots on board. Uses the fact that SpotBoard
		 * implements Iterable<Spot> to do this in a for-each loop.
		 */

		for (Spot s : _view._board) {
			s.clearSpot();
		}
		
		_model.ResetThresh();
		
		
	}


	
	public void action(String e) {
		/* Handles reset game button. Simply reset the game. */
			
			if (e.equals("reset")) {
				resetGame();
				
			} else if (e.equals("play")) {
//				
//				if (!isPlaying) {
//					isPlaying = true;
//				} else {
//					isPlaying = false;
//				}
//				
//				
//				
////				while (isPlaying) {
//				PlayThread play = new PlayThread(_view, _model, this);
//				play.run();
//				play.exit();
				//}
//				
//				for (int i = 0; i < 10; i++) {
//					play();
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e1) {
//						
//					}
//				}
				play();
//				
				
			} else if (e.equals("torus")) {
				
			}
			else {
				_view._board._spots = _model.random();
				
			}
			
			
			
	}
	
	public void action (String e, int num ) {
		if (num == -1) {
			
		} else  if (e.equals("surviveTop")) {
			//_view.MessageChange();
			_model.UpdateThresh(e, num);
		} else  if (e.equals("surviveBot")) {
			//view.MessageChange();
			_model.UpdateThresh(e, num);
		} else  if (e.equals("birthTop")) {
			//_view.MessageChange();
			_model.UpdateThresh(e, num);
		} else  if (e.equals("birthBot")) {
			//_view.MessageChange();
			_model.UpdateThresh(e, num);
		} 
	}
			
	
	public void play() {
		_view._board._spots = _model.updateArray();
	}
	
	
	
	
	@Override
	public void spotClicked(Spot s) {
		JSpot z = (JSpot) s;
		
		z.toggleSpot();
		
		int x = z.getX();
		int y = z.getY();
		
		//_model.updateModel(x,y);
		
		
	}

	@Override
	public void spotEntered(Spot s) {
		/* Highlight spot if game still going on. */
	
		
		s.highlightSpot();
	}

	@Override
	public void spotExited(Spot s) {
//		/* Unhighlight spot. */
//		
		s.unhighlightSpot();
	}
	
	public void updateModel(Spot[][] arr) {
		_model.addArray(arr);
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}





}