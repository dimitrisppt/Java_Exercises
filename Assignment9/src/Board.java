// Imports ArrayList class from java's utilities.
import java.util.ArrayList;

/**
 * The class Board has a field ships of type ArrayList of Battleship.
 * The constructor Board creates a new ArrayList which is stored in the field ships. Also creates objects of the classes
 * Battleship, Cruiser, Frigate, Minesweeper. then adds the objects into the ships ArrayList.
 * It has a method hit that receives two parameters row and column of type integer and returns a boolean value true if the supplied 
 * parameters hit the target. Else returns false.
 * It has a method toString which overrides the toString method. It returns a String value which represents the board.
 * It has a method getShips returns the ArrayList ships of Battleship.
 */
public class Board {
	
	// Creation of field ships of type ArrayList of Battleship.
	private ArrayList<Battleship> ships;
	
	/**
	 * The constructor Board doesn't receive any parameters.
	 * Creates a new ArrayList of Battleship which is stored in ships field. 
	 * Also creates objects of Battleship, Cruiser, Frigate, Minesweeper and then adds them into the ships ArrayList.
	 */
	public Board() {
		
		// Creates a new ArrayList of Battleship which is stored in ships field.
		ships = new ArrayList<Battleship>();
		// Creates object battleship of the class Battleship with parameters 0,5
		Battleship battleship = new Battleship(0,5);
		// Creates object cruiserOne of the class Cruiser with parameters 1,4
		Cruiser cruiserOne = new Cruiser(1,4);
		// Creates object cruiserTwo of the class Cruiser with parameters 2,4
		Cruiser cruiserTwo = new Cruiser(2,4);
		// Creates object frigate of the class Frigate with parameters 3,3
		Frigate frigate = new Frigate(3,3);
		// Creates object minesweeper of the class Minesweeper with parameters 4,2
		Minesweeper minesweeper = new Minesweeper(4,2);
		
		// Adds the battleship object to the ships ArrayList.
		ships.add(battleship);
		// Adds the cruiserOne object to the ships ArrayList.
		ships.add(cruiserOne);
		// Adds the cruiserTwo object to the ships ArrayList.
		ships.add(cruiserTwo);
		// Adds the frigate object to the ships ArrayList.
		ships.add(frigate);
		// Adds the minesweeper object to the ships ArrayList.
		ships.add(minesweeper);
	}
	
	/**
	 * The method hit receives two parameters row and column of type integer and returns a boolean value
	 * of true if the supplied parameters hit the target. Else return false.
	 */
	public boolean hit(int row, int column){
		// Loops until i is not less than size of ships ArrayList
		for (int i=0; i<ships.size(); i++) {
			// Checks whether the supplied row and column hit a ship.
			if (ships.get(i).hit(row, column)) {
				// Returns true.
				return true;
			}
		}
		// Returns false.
		return false;
	}
	
	/**
	 * This method overrides the toString method. It returns a String value which represents the board.
	 */
	public String toString() {
		// Declares a variable board of type String.
		String board = "";
		// Loops until i is not less than the size of ships ArrayList.
		for (int i=0; i<ships.size(); i++){
			// Updates the board variable to include the ships.
			board = board + ships.get(i);
			// Checks whether the class name of the ship at the position (i) of the ArrayList is equal to 'Battleship'.
			if (ships.get(i).getClass().getName().equals("Battleship")) {
				// Updates the board and goes to next line.
				board = board  + "\n";
			// Checks whether the class name of the ship at the position (i) of the ArrayList is equal to 'Cruiser'.
			} else if(ships.get(i).getClass().getName().equals("Cruiser")) {
				// Updates the board to include another '[ ]' because Cruiser ship's size is 4, so it need an additional square to complete the board, then goes to next line.
				board = board + ", [ ]" + "\n";
				// Checks whether the class name of the ship at the position (i) of the ArrayList is equal to 'Frigate'.
			} else if(ships.get(i).getClass().getName().equals("Frigate")) {
				// Updates the board to include another two '[ ]' because Frigate ship's size is 3, so it need two additional squares to complete the board, then goes to next line.
				board = board + "[ ]" + ", [ ]" + "\n";
				// Checks whether the class name of the ship at the position (i) of the ArrayList is equal to 'Minesweeper'.
			} else if(ships.get(i).getClass().getName().equals("Minesweeper")) {
				// Updates the board to include another three '[ ]' because Minesweeper ship's size is 2, so it need three additional squares to complete the board, then goes to next line.
				board = board + ", [ ]" + ", [ ]" + ", [ ]" + "\n";
			}
		}
		// Returns the string representation of the board.
		return board;
	}
	
	/**
	 * The method getShips returns the ArrayList ships of Battleship.
	 */
	public ArrayList<Battleship> getShips(){
		// Returns the ships ArrayList.
		return ships;
	}

}
