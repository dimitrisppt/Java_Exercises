/**
 * The class Harvester has two fields: fuelTankSize and topSpeed of type integer.
 * The constructor Harvester receives two parameters fuelTankSize and topSpeed of type integer.
 * It has a method getHarvestingCapacity that returns an integer value.
 */
public class Harvester {
	
	// Creation of field fuelTankSize of type integer. 
	private int fuelTankSize;
	// Creation of field topSpeed of type integer.
	private int topSpeed;
	
	/**
	 * The constructor Harvester receives two parameters fuelTankSize and topSpeed of type integer.
	 */
	public Harvester(int fuelTankSize, int topSpeed){
		
		// Refers the fuelTankSize variable to the class.
		this.fuelTankSize=fuelTankSize;
		// Refers the topSpeed variable to the class.
		this.topSpeed=topSpeed;
		
	}

	/**
	 * The method getHarvestingCapacity returns an integer value which is the summation of the topSpeed and the fuelTankSize
	 */
	public int getHarvestingCapacity() {
		// Returns the summation of the topSpeed and the fuelTankSize
		return topSpeed + fuelTankSize;
	}
	
}
