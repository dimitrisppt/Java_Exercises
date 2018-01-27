/**
 * The class Coordinates contains the constructor Coordinates that receives two parameters of type integer, x and y.
 * Also contains two methods getXCoordinates and getYCoordinates that return the x and y coordinates respectively.
 * Finally it contains two methods setXCoordinates and setYCoordinates that are used to set the x and y coordinates
 * when are called.
 */
public class Coordinates {
	
	// Creation of the field x of type integer.
	private int x;
	// Creation of the field y of type integer.
	private int y;
	
	/**
	 * The constructor Coordinates receives two integer variables x and y.
	 */
	public Coordinates(int x, int y){
		
		// Refers the x variable to the class.
		this.x = x;
		// Refers the y variable to the class.
		this.y = y;
		
	}
	
	/**
	 * The setXCoordinates method is used to set the x-axis coordinates when it is called.
	 * It receives an integer variable.
	 */
	public void setXCoordinates(int x){
		
		// Refers the x variable to the class.
		this.x = x;
	}
	
	/**
	 * The setYCoordinates method is used to set the y-axis coordinates when it is called.
	 * It receives an integer variable.
	 */
	public void setYCoordinates(int y){
		
		// Refers the y variable to the class.
		this.y = y;
	}
		
	
	/**
	 * The getXCoordinates method is used to return the x-axis coordinates when it is called.
	 * It returns an integer variable.
	 */
	public int getXCoordinates(){
		
		// Returns the x-axis coordinates.
		return x;
	}
	
	/**
	 * The getYCoordinates method is used to return the y-axis coordinates when it is called.
	 * It returns an integer variable.
	 */
	public int getYCoordinates(){
		
		// Returns the y-axis coordinates.
		return y;
	}
		
}
