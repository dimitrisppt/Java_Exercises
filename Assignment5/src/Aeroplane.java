/**
 * The class Aeroplane contains the constructor Aeroplane that has six parameters,
 * name of type String and x, y, speed, totalDistance, repairDistance of type integer.
 * Also contains a method singleFlight that receives a supplied destination and calculates the covered distance
 * of the aeroplane that needs to go to the supplied destination based on the changes of the coordinates of the x-axis and y-axis.
 * Contains the method getName that returns the name of the aeroplane.
 * Contains the method getTotalDistance that is used to return the total covered distance by the aeroplane.
 * Contains the method setTotalDistance that is used to set the total covered distance of the aeroplane.
 * Contains the method getXCoordinates that returns the x-axis coordinates of the aeroplane.
 * Contains the method getYCoordinates that returns the y-axis coordinates of the aeroplane.
 * Contains the method getRepairDistance that returns the distance the aeroplane has to cover to go for repair check.
 */
public class Aeroplane {
	
	// Creation of the field name of type String.
	private String name;
	// Creation of the field coordinates of type Coordinates.
	private Coordinates coordinates;
	// Creation of the field speed of type integer.
	private int speed;
	// Creation of the field totalDistance of type integer.
	private int totalDistance;
	// Creation of the field repairDistance of type integer.
	private int repairDistance;
	
	/**
	 * The constructor Aeroplane receives six parameters.
	 * The name of type String is the name of the aeroplane.
	 * The x and y of type integer are the x-axis and y-axis coordinates of the aeroplane.
	 * The speed of type integer is the speed of the aeroplane (distance per hour).
	 * The totalDistance of type integer is the totalDistance the aeroplane covered.
	 * The repairDistance of type integer is the distance the aeroplane has to cover to go for repair check.
	 */
	public Aeroplane(String name, int x, int y, int speed, int totalDistance, int repairDistance){
		
		// Refers the name to the class.
		this.name = name;
		/* Refers the coordinates to the class after the creation of an object of the class
		 * Coordinates with parameters x and y.
		 */
		this.coordinates = new Coordinates(x,y);
		// Refers the speed to the class.
		this.speed = speed;
		// Refers the totalDistance to the class.
		this.totalDistance = totalDistance;
		// Refers the repairDistance to the class.
		this.repairDistance = repairDistance;
		
	}
	
	/**
	 * The method getName returns the name of the aeroplane in a string variable.
	 */
	public String getName() {
		
		// Returns the name of the aeroplane.
		return name;
	}
	
	/**
	 * The method singleFlight calculates and returns the distance the aeroplane has to cover to reach a supplied destination
	 * This calculation is done until the x-axis and y-axis coordinates of the aeroplane are the same with the coordinates of the supplied destination.
	 */
	public int singleFlight(Destination destination) {
		
		// Initialisation of the variable distance to 0 because the aeroplane didn't travel yet.
		int distance = 0;
		
		// Checks if the x coordinates or the y coordinates match with the x and y coordinates of the supplied destination.
		while (coordinates.getXCoordinates() != destination.getCoordinates().getXCoordinates() || coordinates.getYCoordinates() != destination.getCoordinates().getYCoordinates()) {
			
			// If the x-axis coordinates of the aeroplane is less than the x-axis coordinates of the supplied destination then...
			if (coordinates.getXCoordinates() < destination.getCoordinates().getXCoordinates()) {
				
				// If the difference between the x-axis of the destination and the aeroplane is less than the speed of the aeroplane then...
				if (destination.getCoordinates().getXCoordinates() - coordinates.getXCoordinates() < speed) {
					
					// The distance is equal to the distance plus the difference of them.
					distance += (destination.getCoordinates().getXCoordinates() - coordinates.getXCoordinates());
					// Sets the new x-axis coordinates of the aeroplane.
					coordinates.setXCoordinates(coordinates.getXCoordinates() + ((destination.getCoordinates().getXCoordinates() - coordinates.getXCoordinates())));
				}
				
				// If the difference between the x-axis of the destination and the aeroplane is not less than the speed of the aeroplane then...
				else {
					
					// Sets the new x-axis coordinates of the aeroplane to be the previous x-axis coordinates plus the speed of the aeroplane.
					coordinates.setXCoordinates(coordinates.getXCoordinates() + speed);
					// The speed is added to the previous distance.
					distance += speed;
				}
			
			}
			
			// If the x-axis coordinates of the aeroplane is not less than the x-axis coordinates of the supplied destination then...
			else {
				
				// If the difference between the x-axis of the destination and the aeroplane is less than the speed of the aeroplane then...
				if ((coordinates.getXCoordinates() - destination.getCoordinates().getXCoordinates()) < speed) {
					
					// The distance is equal to the distance plus the difference of them.
					distance += ((coordinates.getXCoordinates() - destination.getCoordinates().getXCoordinates()));
					// Sets the new x-axis coordinates of the aeroplane.
					coordinates.setXCoordinates(coordinates.getXCoordinates() + ((destination.getCoordinates().getXCoordinates() - coordinates.getXCoordinates())));
					
				}
				
				// If the difference between the x-axis of the destination and the aeroplane is not less than the speed of the aeroplane then...
				else {
					
					// Sets the new x-axis coordinates of the aeroplane to be the previous x-axis coordinates minus the speed of the aeroplane.
					coordinates.setXCoordinates(coordinates.getXCoordinates() - speed);
					// The speed is added to the previous distance.
					distance += speed;
				}
				
			}
			
			// If the y-axis coordinates of the aeroplane is less than the y-axis coordinates of the supplied destination then...
			if (coordinates.getYCoordinates() < destination.getCoordinates().getYCoordinates()) {
				
				// If the difference between the y-axis of the destination and the aeroplane is less than the speed of the aeroplane then...
				if ((destination.getCoordinates().getYCoordinates() - coordinates.getYCoordinates()) < speed) {
					
					// The distance is equal to the distance plus the difference of them.
					distance += (destination.getCoordinates().getYCoordinates() - coordinates.getYCoordinates());
					// Sets the new x-axis coordinates of the aeroplane.
					coordinates.setYCoordinates(coordinates.getYCoordinates() + ((destination.getCoordinates().getYCoordinates() - coordinates.getYCoordinates())));
					
				}
				
				// If the difference between they y-axis of the destination and the aeroplane is not less than the speed of the aeroplane then...
				else {
					
					// Sets the new y-axis coordinates of the aeroplane to be the previous y-axis coordinates plus the speed of the aeroplane.
					coordinates.setYCoordinates(coordinates.getYCoordinates() + speed);
					// The speed is added to the previous distance.
					distance += speed;
				}
			
			}
			
			// If the y-axis coordinates of the aeroplane is not less than the y-axis coordinates of the supplied destination then...
			else {
				
				// If the difference between the y-axis of the destination and the aeroplane is less than the speed of the aeroplane then...
				if ((coordinates.getYCoordinates() - destination.getCoordinates().getYCoordinates()) < speed) {
					
					// The distance is equal to the distance plus the difference of them.
					distance += ((coordinates.getYCoordinates() - destination.getCoordinates().getYCoordinates()));
					// Sets the new y-axis coordinates of the aeroplane.
					coordinates.setYCoordinates(coordinates.getYCoordinates() + ((destination.getCoordinates().getYCoordinates() - coordinates.getYCoordinates())));

				}
				
				// If the difference between the y-axis of the destination and the aeroplane is not less than the speed of the aeroplane then...
				else {
					
					// Sets the new x-axis coordinates of the aeroplane to be the previous x-axis coordinates minus the speed of the aeroplane.
					coordinates.setYCoordinates(coordinates.getYCoordinates() - speed);
					// The speed is added to the previous distance.
					distance += speed;
				}
				
			}
		}
		
		// The totalDistance is equal to totalDistance plus distance.
		totalDistance += distance;
		// Returns the distance the aeroplane covered.
		return distance;
	}
	
	/**
	 * Returns the totalDistance the aeroplane covered at that point using an integer variable.
	 */
	public int getTotalDistance() {
		
		// Returns the totalDistance of the aeroplane.
		return totalDistance;
	}
	
	/**
	 * The setTotalDistance method is used to set the total distance of the aeroplane 
	 * using a supplied totalDistance integer variable.
	 */
	public void setTotalDistance(int totalDistance) {
		
		// Refers to the totalDistance of the class.
		this.totalDistance = totalDistance;
	}
	
	/**
	 * The getXCoordinates method is used to return the x-axis coordinate of the aeroplane.
	 */
	public int getXCoordinates() {
		
		// Returns the x-axis coordinates of the aeroplane.
		return coordinates.getXCoordinates();
	}
	
	/**
	 * The getYCoordinates method is used to return the y-axis coordinate of the aeroplane.
	 */
	public int getYCoordinates() {
		
		// Returns the y-axis coordinates of the aeroplane.
		return coordinates.getYCoordinates();
	}
	
	/**
	 * The getRepairDistance method is used to return the repairDistance which is the required distance 
	 * the aeroplane has to travel, to go for a repair check.
	 */
	public int getRepairDistance() {
		
		// Returns the repairDistance of the aeroplane.
		return repairDistance;
	}
	
}
