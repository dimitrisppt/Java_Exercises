/**
 * The class Cruiser extends the class Battleship, and inherits all of its methods.
 */
public class Cruiser extends Battleship {
	
	/**
	 * The constructor Cruiser receives two parameters: row and shipSize of type integer.
	 */
	public Cruiser(int row ,int shipSize) {
		// The super keyword differentiates the method in the superclass from the method in the subclass. 
		super(row, shipSize);
		
	}
}
