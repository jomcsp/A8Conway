package a8;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GameOfLifeView extends JPanel implements ChangeListener, ActionListener, SpotListener {
	
	static final int SQUARE_MIN = 1;
	static final int SQUARE_MAX = 500;
	static final int SQUARE_INTER = 1;
	
	private GameOfLifeWidgetController _controller;
	private GameOfLifeModel _model;
	
	
	JSpotBoard3 _board;		/* SpotBoard playing area. */
	JLabel _message;		/* Label for messages. */
	private JSlider _slider;
	private JButton _resetButton;
	private JButton _playButton;
	private JButton _randomButton;
	
	private JSlider _surviveSliderTop;
	private JSlider _surviveSliderBot;
	private JSlider _birthSliderTop;
	private JSlider _birthSliderBot;
	
	


	
	
	//, GameOfLifeWidgetController controller, GameOfLifeModel model
	public GameOfLifeView (int amount) {

	
		
		
		
		_board = new JSpotBoard3(amount, amount);
		_message = new JLabel();
		
		
		
		
		
		/* Set layout and place SpotBoard at center. */
		
		setLayout(new BorderLayout());
		add(_board, BorderLayout.CENTER);

		/* Create subpanel for message area and reset button. */
		
		JPanel reset_message_panel = new JPanel();
		reset_message_panel.setLayout(new GridLayout(8,2));
		_message.setText("Welcome to Game of Life.  Please let load if going up to 500:)");

		/* Reset button. Add ourselves as the action listener. */
		
		_resetButton = new JButton("Restart");
		_resetButton.addActionListener(this);
		
		_playButton = new JButton("Play");
		_playButton.addActionListener(this);
		
		_randomButton = new JButton ("Random");
		_randomButton.addActionListener(this);
		
		JButton torusButton = new JButton ("Torus");
		torusButton.addActionListener(this);
		
		
		reset_message_panel.add(_playButton);
		reset_message_panel.add(_randomButton);
		reset_message_panel.add(_resetButton);
		reset_message_panel.add(torusButton);
		
		
		
		
		
		// add jSlider for size.
		JLabel sizeText = new JLabel();
		sizeText.setText("BoardSize");
		reset_message_panel.add(sizeText);
		
		_slider = new JSlider (JSlider.HORIZONTAL, SQUARE_MIN, SQUARE_MAX, SQUARE_INTER);
		_slider.addChangeListener(this);
		reset_message_panel.add(_slider);
		
		
		
		JLabel surviveText = new JLabel();
		surviveText.setText("Survive Thresh Top");
		reset_message_panel.add(surviveText);
		
		_surviveSliderTop = new JSlider (JSlider.HORIZONTAL, 0, 9, 1);
		_surviveSliderTop.addChangeListener(this);
		reset_message_panel.add(_surviveSliderTop);
		
		JLabel surviveTextTop = new JLabel();
		surviveTextTop.setText("Survive Thresh Bot");
		reset_message_panel.add(surviveTextTop);
		
		_surviveSliderBot = new JSlider (JSlider.HORIZONTAL, 0, 9, 1);
		_surviveSliderBot.addChangeListener(this);
		reset_message_panel.add(_surviveSliderBot);

		
		
		
		JLabel birthText = new JLabel();
		birthText.setText("Birth Thresh Top");
		reset_message_panel.add(birthText);
		
		_birthSliderTop = new JSlider (JSlider.HORIZONTAL, 0, 9, 1);
		_birthSliderTop.addChangeListener(this);
		reset_message_panel.add(_birthSliderTop);

		JLabel birthTextBot = new JLabel();
		birthTextBot.setText("Birth Thresh Bot");
		reset_message_panel.add(birthTextBot);
		
		_birthSliderBot = new JSlider (JSlider.HORIZONTAL, 0, 9, 1);
		_birthSliderBot.addChangeListener(this);
		reset_message_panel.add(_birthSliderBot);
		
		
		
		reset_message_panel.add(_message);

		/* Add subpanel in south area of layout. */
		
		add(reset_message_panel, BorderLayout.SOUTH);

		/* Add ourselves as a spot listener for all of the
		 * spots on the spot board.
		 */
		_board.addSpotListener(this);
	}


	@Override
	public void spotClicked(Spot spot) {
		_controller.spotClicked(spot);
		
	}


	@Override
	public void spotEntered(Spot spot) {
		_controller.spotEntered(spot);
		
		
	}


	@Override
	public void spotExited(Spot spot) {
		_controller.spotExited(spot);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String z = "";
		//System.out.println("button works");
		if (e.getSource() == _resetButton) {
			z = "reset";
		} else if (e.getSource() == _playButton) {
			z = "play";
		} else if (e.getSource() == _randomButton) {
		z = "random";
		} else {
			z = "torus";
		}
		
		_controller.action(z);
		
		
	}


	@Override
	public void stateChanged(ChangeEvent e) {
JSlider source = (JSlider) e.getSource();
		

	if (e.getSource() == _slider) {
		if (!source.getValueIsAdjusting()) {
			int amount = (int) source.getValue();
			removeAll();
			setLayout(new GridLayout(amount, amount));
			revalidate();
			repaint();
		
			_board = new JSpotBoard3(amount, amount);
			_controller.updateModel(_board._spots);
			
			_message = new JLabel();
			_slider = new JSlider (JSlider.HORIZONTAL, SQUARE_MIN, SQUARE_MAX, SQUARE_INTER);
			/* Set layout and place SpotBoard at center. */
			
			setLayout(new BorderLayout());
			add(_board, BorderLayout.CENTER);
			_message.setText("Welcome to Game of Life.  Please let load if going up to 500:)");
			/* Create subpanel for message area and reset button. */
			
			JPanel reset_message_panel = new JPanel();
			reset_message_panel.setLayout(new GridLayout());

			/* Reset button. Add ourselves as the action listener. */
			JButton reset_button = new JButton("Restart");
			reset_button.addActionListener(this);
			
			_playButton = new JButton("Play");
			_playButton.addActionListener(this);
			
			_randomButton = new JButton ("Random");
			_randomButton.addActionListener(this);
			
			JButton torusButton = new JButton ("Torus");
			torusButton.addActionListener(this);
			
			
			reset_message_panel.add(_playButton);
			reset_message_panel.add(_randomButton);
			reset_message_panel.add(_resetButton);
			reset_message_panel.add(torusButton);
			
			
			
			
			
			// add jSlider for size.
			JLabel sizeText = new JLabel();
			sizeText.setText("BoardSize");
			reset_message_panel.add(sizeText);
			
			_slider = new JSlider (JSlider.HORIZONTAL, SQUARE_MIN, SQUARE_MAX, SQUARE_INTER);
			_slider.addChangeListener(this);
			reset_message_panel.add(_slider);
			
			
			
			JLabel surviveText = new JLabel();
			surviveText.setText("Survive Thresh Top");
			reset_message_panel.add(surviveText);
			
			_surviveSliderTop = new JSlider (JSlider.HORIZONTAL, 0, 9, 1);
			_surviveSliderTop.addChangeListener(this);
			reset_message_panel.add(_surviveSliderTop);
			
			JLabel surviveTextTop = new JLabel();
			surviveTextTop.setText("Survive Thresh Bot");
			reset_message_panel.add(surviveTextTop);
			
			_surviveSliderBot = new JSlider (JSlider.HORIZONTAL, 0, 9, 1);
			_surviveSliderBot.addChangeListener(this);
			reset_message_panel.add(_surviveSliderBot);

			
			
			
			JLabel birthText = new JLabel();
			birthText.setText("Birth Thresh Top");
			reset_message_panel.add(birthText);
			
			_birthSliderTop = new JSlider (JSlider.HORIZONTAL, 0, 9, 1);
			_birthSliderTop.addChangeListener(this);
			reset_message_panel.add(_birthSliderTop);

			JLabel birthTextBot = new JLabel();
			birthTextBot.setText("Birth Thresh Bot");
			reset_message_panel.add(birthTextBot);
			
			_birthSliderBot = new JSlider (JSlider.HORIZONTAL, 0, 9, 1);
			_birthSliderBot.addChangeListener(this);
			reset_message_panel.add(_birthSliderBot);
			
			
			
			reset_message_panel.add(_message);
			/* Add subpanel in south area of layout. */
			
			add(reset_message_panel, BorderLayout.SOUTH);

			/* Add ourselves as a spot listener for all of the
			 * spots on the spot board.
			 */
			_board.addSpotListener(this);
	}
	}	
		
		String z = "";
		int num = 0;
	if (e.getSource() == _surviveSliderTop) {
		z = "surviveTop";
		num = source.getValue();
		
		if (ThreshCheck(_surviveSliderTop.getValue(), _surviveSliderBot.getValue())) {
			z = "";
			num = -1;
			_message.setText("Invalid Value for Sliders, Make Sure Top > Bot");
		} else {
			_message.setText(z + " set to " + num);
		}
	} else if (e.getSource() == _surviveSliderBot) {
		z = "surviveBot";
		num = source.getValue();
		if (ThreshCheck(_surviveSliderTop.getValue(), _surviveSliderBot.getValue())) {
			z = "";
			num = -1;
			_message.setText("Invalid Value for Sliders, Make Sure Top > Bot");
		} else {
			_message.setText(z + " set to " + num);
		}
	} else if (e.getSource() == _birthSliderTop) {
		z = "birthTop";
		num = source.getValue();
		if (ThreshCheck(_birthSliderTop.getValue(), _birthSliderBot.getValue())) {
			z = "";
			num = -1;
			_message.setText("Invalid Value for Sliders, Make Sure Top > Bot");
		} else {
			_message.setText(z + " set to " + num);
		}
	} 
	else if (e.getSource() == _birthSliderBot) {
		z = "birthBot";
		num = source.getValue();
		if (ThreshCheck(_birthSliderTop.getValue(), _birthSliderBot.getValue())) {
			z = "";
			num = -1;
			_message.setText("Invalid Value for Sliders, Make Sure Top > Bot");
		} else {
			_message.setText(z + " set to " + num);
		}
	
	}



	_controller.action(z, num);
		
		
		
		
		
		
	}


//	public void addActionListener(GameOfLifeWidgetController gameOfLifeWidgetController) {
//		// TODO Auto-generated method stub
//		
//	}
	private boolean ThreshCheck (int top, int bot) {
		
		if (top >= bot) {
			return false;
		}
		
		
		
		return true;
	}
	public void addController (GameOfLifeWidgetController x) {
		_controller = x;
	}
	
	public void MessageChange () {
		_message.setText("Game Of Life");
	}
	
	
	
}
