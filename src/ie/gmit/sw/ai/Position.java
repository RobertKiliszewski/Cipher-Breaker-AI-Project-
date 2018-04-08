package ie.gmit.sw.ai;

//
//@Author : Robert Kiliszewski
//

public class Position {

	private int x;
	private int y;
	
	//Constructor
	private Position(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	//Get the position in the table
	public static Position getPos(char target, char[][] cipherTable) {

		for (int i = 0; i < 5; i++) {
			
			for (int j = 0; j < 5; j++) {
				
				if (target == cipherTable[i][j]) {
					
					return new Position(i, j);
					
				}
			}
		}
		
		return null;
	}
	
	public int getPosX() {
		return this.x;
	}
	
	public int getPosY() {
		return this.y;
	}
	
}