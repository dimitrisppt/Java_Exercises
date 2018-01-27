// Imports ArrayList class from java's utilities
import java.util.ArrayList;

/**
 * The class Battleship has field row and shipSize of type integer, floating of type boolean and parts of type ArrayList of Part.
 * The constructor Battleship receives two parameters, row and shipSize of type integer. Also creates a new ArrayList which is stored
 * in the parts field, and then adds parts to the ArrayList. Furthermore sets the floating field to true.
 * It has a method hit which receives two parameters row and column of type integer, and returns a boolean value true, if there is a part at the supplied
 * number of row and column. If the part has already been destroyed then confirms the result. If no part exists there returns false.
 * It has a method equal which overrides the equal method, returns a boolean value and receives a ship of type Object.
 * It has a method toString which overrides the toString method, returns a String value which is the parts(hidden or destroyed) of each ship.
 * It has a method is floating that returns a boolean value true if the ship is not sunk.
 */
public class Battleship {
	
	// Creation of field row of type integer.
	private int row;
	// Creation of field shipSize of type integer.
	private int shipSize;
	// Creation of field parts of type ArrayList of Part.
	private ArrayList<Part> parts;
	// Creation of field floating of type boolean.
	private boolean floating;
	
	/**
	 * The constructor Battleship receives two parameters row and shipSize of type integer.
	 * Creates a new ArrayList that is stored in parts field and adds a part to it each time it loops.
	 */
	public Battleship(int row, int shipSize) {
		
		// Refers shipSize to the class.
		this.shipSize = shipSize;
		// Refers row to the class.
		this.row = row;
		// Creates a new ArrayList of Part and stores it in parts field.
		parts = new ArrayList<Part>();
		// Loops until i is not less than the supplied shipSize number.
		for (int i=0; i<shipSize; i++) {
			// Adds a Part to the parts ArrayList.
			parts.add(new Part(row, i));
		}
		// Sets the floating field to true.
		floating = true;
	}
	
	/**
	 * The method hit receives two parameters row and column of type integer and returns a boolean value.
	 * Also it checks if this part is already been destroyed or not. If not it destroys it. 
	 */
	public boolean hit(int row, int column) {
		
		// Declares a temporary Part with name tempPart and stores a new Part in it. 
		Part tempPart = new Part(row,column);
		// Loops until i is not less than the size of the parts ArrayList.
		for (int i=0; i<parts.size(); i++){
			// Checks if the tempPart is equal with the part in ArrayList in position (i).
			if (tempPart.equals(parts.get(i))) {
				// Checks if the part in position (i) is destroyed.
				if (parts.get(i).is()){
					// Outputs a warning message
					System.out.println("This part has already been destroyed!");
					// Returns true.
					return true;
				}
				// Sets the part in position (i) to destroyed = true.
				parts.get(i).set();
				// Returns true.
				return true;
			}
		}
		// Returns false.
		return false;
	}
	
	/**
	 * This method overrides the equals method, it returns a boolean value, and receives a ship of type Object.
	 */
	public boolean equals(Object ship) {
		
		// Checks there is not an instance of ship in the Battleship.
		if (!(ship instanceof Battleship)) {
			// Returns false.
			return false;
		}
		// Checks if the size of parts ArrayList is not the same as the size of the parts ArrayList in the instance of the Battleship, ship.
		if ((parts.size() != ((Battleship)ship).parts.size())) {
			// Returns false.
			return false;
		}
		// Checks if the floating variable is not equal to the floating status of the instance ship of the Battleship.
		if (isFloating() != ((Battleship)ship).isFloating()){
			// Returns false.
			return false;
		}
		// Returns true.
		return true;
	}
	
	/**
	 * This method overrides the toString method. It returns a String value which is the parts(hidden or destroyed) of each ship.
	 */
	public String toString() {
		
		// Declares the shipParts of type String and assigns "" to it.
		String shipParts = "";
		// Loops until i is not less than shipSize.
		for (int i=0; i<shipSize; i++) {
			// Checks if the shipSize is equal to row or i is not equal to shipSize -1.
			if (shipSize == row || i != (shipSize -1)){
				// Updates the shipParts variable. Adds a ',' to the end because is not the last position of the board.
				shipParts = shipParts + parts.get(i) + ", ";
			// Else...
			}else{
				// Updates the shipParts variable.
				shipParts = shipParts + parts.get(i);
			}
		} 
		// Returns the shipParts variable which represents the hidden or destroyed parts of each ship on the board.
		return shipParts;
	}
	
	/**
	 * The method isFloating returns a boolean value true if the ship is not sunk.
	 */
	private boolean isFloating() {
		// Sets the floating variable to false
		floating = false;
		// Loop until i is not less than shipSize.
		for (int i=0; i<shipSize; i++) {
			// Checks if the part at position (i) in the ArrayList parts is destroyed or not.
			if (parts.get(i).is() == false) {
				// Sets the floating variable to true.
				floating = true;
			}
		}
		// Returns the floating variable.
		return floating;
	}
		
}
