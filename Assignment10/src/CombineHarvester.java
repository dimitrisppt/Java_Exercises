/**
 * The class CombineHarvester extends the class Harvester and inherits their methods. 
 * Also the CombineHarvester has some additional functionality.
 * The constructor receives three parameters, fuelTankSize, topSpeed and length of type integer,
 * It has the getHarvestingCapacity method that returns an integer value.
 */
public class CombineHarvester extends Harvester{
	
	// Creation of field length of type integer.
	private int length;

	/**
	 * The constructor CombineHarvester receives three parameters, fuelTankSize, topSpeed and length of type integer.
	 */
	public CombineHarvester(int fuelTankSize, int topSpeed, int length) {
		
		// The super keyword differentiates the method in the superclass from the method in the subclass. 
		super(fuelTankSize, topSpeed);
		// Refers the length variable to the class.
		this.length = length;
		
	}
	
	/**
	 * The method getHarvestingCapacity returns an integer value which is the harvestingCapacity of the normal Harvester multiplied by the length.
	 */
	public int getHarvestingCapacity() {
		// Returns an integer value.
		return super.getHarvestingCapacity() * length;
	}
	

}
