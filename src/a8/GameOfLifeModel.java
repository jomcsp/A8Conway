package a8;





public class GameOfLifeModel {
	
	protected Spot [][] _boardArray;
	protected Spot [][] _blankArray;
	private int _deadCount = 0;
	
	private int _surviveTop = 3;
	private int _surviveBot = 2;
	private int _birthTop = 3;
	private int _birthBot = 3;
	
	public GameOfLifeModel () {
		
	}
	
	
	public void addArray (Spot[][] spots) {
		_boardArray = spots;
		_blankArray = _boardArray.clone();
	}

	public Spot[][] updateArray() {
//		
//		JSpotBoard3 spots = new JSpotBoard3(_boardArray.length, _boardArray.length);
//	
//		for (int i = 0; i < spots._spots.length ; i++) {
//			for (int j = 0; j < spots._spots[i].length ; j++) {
//				spots._spots[i][j].clearSpot();
//			}
//		}
//			
		int[][] tempSpots = new int[_boardArray.length][_boardArray.length];
		
		for (int i = 0; i < tempSpots.length; i++) {
			for (int j = 0; j < tempSpots.length; j++) {
				
				if (_boardArray[i][j].isEmpty()) {
					tempSpots[i][j] = 0;
				} else {
					tempSpots[i][j] = 1;
				}
				
			}
		}

		
		
		for (int i = 0; i < _boardArray.length ; i++) {
			for (int j = 0; j < _boardArray[i].length ; j++) {
			
				int counter = direction(i, j, tempSpots);
				//System.out.println("For cell: " + i + " " + j);
				//System.out.println("alive count is " + counter + " " + "dead " + _deadCount);
				
				if (counter < _surviveBot && tempSpots[i][j] == 1) {
					_boardArray[i][j].toggleSpot();
				}
				
				else if (counter > _surviveTop && tempSpots[i][j] == 1) {
					_boardArray[i][j].toggleSpot();
				}
				else if (counter == _birthTop && tempSpots[i][j] == 0) {
					_boardArray[i][j].toggleSpot();
				}

			}
			 
		}
		
		
	
		return _boardArray;
	}
	
	
	public Spot[][] random () {
		for (int i = 0; i < _boardArray.length ; i++) {
			for (int j = 0; j < _boardArray[i].length ; j++) {
				if (Math.random() < .4) {
					_boardArray[i][j].toggleSpot();
				}
			}
			 
		}
		
		return _boardArray;
		
	}
	
	private int direction (int x, int y, int[][] arr ) {
		
		int counter = 0;
		_deadCount = 0;
		
		for (int a = -1; a < 2; a++) {
			for (int b = -1; b < 2; b++) {
				//System.out.println(a + " " + b);
				
				if (arr[x][y] == 1 && (a == 0 && b == 0)) {
					counter--;
				}
				
				int leg1 = a + x;
				int leg2 = b + y;
				boolean tooLong = false;
				
				
				if (arr.length <= (leg1) ||
					arr.length <= (leg2) ||
					-1 == (leg1) ||
					-1 == (leg2)) {
					tooLong = true;
				}
				
				
				if(tooLong) {
				}
				else if (arr[x + a][y + b] == 1) {
					//System.out.println("Counted " + (x + a) + " " + (y+b));
					counter++;
				} else {
					_deadCount++;
				}
				
			}
		}
		
		

		//System.out.println(x+ " " + y + " " + "counter is " + counter);
		return counter;
		
		
		
		
	}
	
	public void UpdateThresh (String x, int num) {
	
		if (x.equals("surviveTop")) {
			_surviveTop = num;
			
		} else  if (x.equals("surviveBot")) {
			_surviveBot = num;
			
		} else  if (x.equals("birthTop")) {
			_birthTop = num;
			
		} else  if (x.equals("birthBot")) {
			_birthBot = num;
		} 
	}
	
	public void ResetThresh () {
		 _surviveTop = 3;
		 _surviveBot = 2;
		 _birthTop = 3;
		 _birthBot = 3;
	}
	
	
	
	
}
