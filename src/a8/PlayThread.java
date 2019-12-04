package a8;



public class PlayThread extends Thread {
		protected GameOfLifeView _view;
		protected GameOfLifeModel _model;
		protected GameOfLifeWidgetController _controller;
		private boolean exit = true;
		
		public PlayThread(GameOfLifeView view, GameOfLifeModel model, GameOfLifeWidgetController controller) {
			_view = view;
			_model = model;
			_controller = controller;
		}

		public void run() {
			
			while (exit) {
				_controller.play();
				
			}
			
			}
		
		
		public void exit() {
			exit = false;
		}
	
}
