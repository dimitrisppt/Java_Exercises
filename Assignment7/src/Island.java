/**
 * The class Island contains a constructor that receives two parameters and generates a treasureChest which is
 * buried randomly in one location of the Island.
 * It has a method dig that receives a location of type integer as a parameter and returns a TreasureChest.
 * It has a method getIslandName that returns a String variable which is the name of the Island.
 * It has a method getNumBurryLocations that returns the number of available locations that the treasureChest can be buried.
 * It has a method setTreasureLocation that sets the randomly generated treasureLocation number equal to -1 to be different from the supplied location number 
 * inside the dig method, after the pirate dug in, because the pirate cannot find the treasureChest for a second time.
 */
public class Island {
	
	// Creation of field name of type String.
	private String name;
	// Creation of field numLocations of type integer.
	private int numLocations;
	// Creation of field locations which is an array of type boolean.
	private boolean[] locations;
	// Creation of field treasureChest of type TreasureChest.
	private TreasureChest treasureChest;
	// Creation of field treasureLocation of type integer.
	private int treasureLocation;
	
	/**
	 * Creation of constructor Island that receives two parameters: name of type String and numLocations of type integer
	 */
	public Island(String name, int numLocations) {
		
		// Refers name to the class.
		this.name = name;
		// Refers numLocations to the class
		this.numLocations = numLocations;
		// Creates a boolean array with length of numLocations which is a supplied variable to the class and then refers locations to the class.
		this.locations = new boolean[numLocations];
		// Creates a TreasureChest and refers treasureChest to the class.
		this.treasureChest = new TreasureChest();
		// Generates a random number using the Math class, that generates numbers up to the value of the supplied numLocation variable. Then refers treasureLocation to the class.
		this.treasureLocation = (int)(Math.random() * numLocations);
		// The for loop is done until the index is less than the supplied numLocation variable.
		for (int i=0; i<numLocations; i++){
			// Fills each time the locations array slot of the corresponding index with false because they don't have a treasureChest buried.
			locations[i]= false;
		}
		// The randomly generated number is used as index to set a random slot of the array locations with the value of true.
		locations[treasureLocation]= true;
	}
	
	/**
	 * The dig method receives an integer variable location and returns a TreasureChest if
	 * the supplied locations is the same with the treasureLocation.
	 */
	public TreasureChest dig(int location){
		
		// Checks if the location is less than the length of the locations array.
		if (location < locations.length) {
			
			// Checks if the supplied location number has the same value as the treasureLocation which is the random generated number.
			if (location == treasureLocation) {
				
				// Stores the treasureChest into the containsTreasureChest variable of type TreasureChest.
				TreasureChest containsTreasureChest = treasureChest;
				// Sets the slot of the locations array that corresponds to the treasureLocation value to false.
				locations[treasureLocation] = false;
				// Returns the variable containsTreasureChest which is a TreasureChest.
				return containsTreasureChest;
			
			// If the supplied location number hasn't got the same value as the treasureLocation which is the random generated number
			} else {
				// Returns null.
				return null;
			}
		// If the location is greater than the length of the locations array then
		} else {
			// Returns null.
			return null;
		}
	}
	
	/**
	 * The method getIslandName returns the name of the Island which is a String variable.
	 */
	public String getIslandName(){
		// Returns the name of the Island.
		return name;
	}
	
	/**
	 * The method getNumBurryLocations returns the number of available locations that the treasureChest can be buried.
	 */
	public int getNumBuryLocations(){
		// Returns numLocations variable of type integer.
		return numLocations; 
	}
	
	/**
	 * The method setTreasureLocation sets the randomly generated treasureLocation number equal to -1 to be different from the supplied location number 
     * inside the dig method, after the pirate dug in, because the pirate cannot find the treasureChest for a second time.
	 */
	public void setTreasureLocation(){
		// treasureLocation is equal to -1.
		treasureLocation = -1;
	}

}
