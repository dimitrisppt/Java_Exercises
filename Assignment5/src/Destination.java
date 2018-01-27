/**
 * The class Destination contains the constructor Destination that receives three parameters, the name, x and y of type String, integer, integer respectively.
 * Also contains the method getName that is used to return the name of the destination.
 * Finally contains the method getCoordinates that is used to return the coordinates of that destination.
 */
public class Destination {
	
	// Creation of the field name of type String.
	private String name;
	// Creation of the field coordinates of type Coordinates.
	private Coordinates coordinates;
	
	/**
	 * The constructor Destination receives three parameters
	 * The name of type String which is the name of the destination, 
	 * the x of type integer, which is the x-axis coordinates of the destination,
	 * and the y of type integer, which is the y-axis coordinates of the destination
	 */
	public Destination(String name, int x, int y){
		
		// Refers the name to the class.
		this.name = name;
		/* Refers the coordinates to the class after the creation of an object of the class
		 * Coordinates with parameters x and y.
		 */
		this.coordinates = new Coordinates(x, y);
		
	}
	
	/**
	 * The getName method returns the name of the destination
	 * in the variable name of type String.
	 */
	public String getName() {
		
		// Returns the name of the destination.
		return name;
	}
	
	/**
	 * The getCoordinates returns the coordinates of the destination
	 * in the variable coordinates of type Coordinates.
	 */
	public Coordinates getCoordinates(){
		
		// Returns the coordinates of the destination.
		return coordinates;
	}
}
