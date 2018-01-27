/**
 * The class Minesweeper extends the class Battleship, and inherits all of its methods.
 */
public class Minesweeper extends Battleship {
	/**
	 * The constructor Minesweeper receives two parameters: row and shipSize of type integer.
	 */
	public Minesweeper(int row, int shipSize) {
		// The super keyword differentiates the method in the superclass from the method in the subclass. 
		super(row, shipSize);
		
	}
	
	/**
	 * The method hit receives two integer parameters, row and column and returns a boolean value.
	 */
	public boolean hit(int row, int column){
		
		// Initialises num as integer variable and stores to it a randomly genarated value from 0 to 1, to achieve the 50% hit rate.
		int num = (int)(Math.random() * 2);
		// Checks whether the num variable is equal to 0.
		if (num == 0) {
			// Returns false.
			return false;
		}
		// Calls the inherited hit method and returns the result.
		return super.hit(row, column);
	}
}
