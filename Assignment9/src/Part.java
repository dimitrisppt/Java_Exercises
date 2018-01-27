/**
 * The class Part has three fields: row and column of type integer, destroyed of type boolean.
 * The constructor Part receives two parameters, row and column of type integer.
 * It has a method set that sets the destroyed field to true.
 * It has a method is that checks whether is destroyed or not and returns a boolean value.
 * It has a method equals which overrides the equal method, returns a boolean value and receives a part of type Object
 * It has a method toString which overrided the toString method, returns a string representation for hidden or destroyed part of the ship.
 */
public class Part {
	
	// Creation of field row of type integer.
	private int row;
	// Creation of field column of type integer.
	private int column;
	// Creation of field destroyed of type boolean.
	private boolean destroyed;
	
	/**
	 * The constructor Part receives two parameters: row and column of type integer.
	 * Sets the destroyed field to false when is created.
	 */
	public Part(int row, int column){
		// Refer row variable to the class.
		this.row = row;
		// Refer column variable to the class.
		this.column = column;
		// Set destroyed variable to false.
		destroyed = false;
	}
	
	/**
	 * The method set, sets the destroyed field to true.
	 */
	public void set(){
		// Sets destroyed field to true.
		destroyed = true;
	}
	
	/**
	 * The method is, returns true if the destroyed field is equal to true, else returns false.
	 */
	public boolean is(){
		// Checks if destroyed field is equal to true.
		if (destroyed == true) {
			// Returns true.
			return true;
		}
		// Returns false.
		return false;
	}
	
	/**
	 * This method overrides the equals method, it returns a boolean value, and receives a part of type Object.
	 */
	public boolean equals(Object part) {
		// Checks if part is not an instance of Part.
		if (!(part instanceof Part)){
			// Returns false.
			return false;	
		}
		// Returns true.
		return row == ((Part)part).row && column == ((Part)part).column;
	}
	
	/**
	 * The to String method returns a String value, that represents the part, if it's hidden or destroyed.
	 */
	public String toString() {
		// Checks whether the part is destroyed.
		if (is() == true) {
			// Returns a string value that represents the destroyed part.
			return "[X]";
		}
		// Returns a string value that represents the hidden part.
		return "[ ]";
	}
}
