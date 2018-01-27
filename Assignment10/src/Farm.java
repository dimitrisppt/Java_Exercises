// Imports ArrayList from java's utilities.
import java.util.ArrayList;

/**
 * The class Farm consists of three fields: numberOfFields of type ArrayList of Field, 
 * numberOfHarvesters of type ArrayList of Harvester and profit of type integer.
 * The constructor farm sets the profit to 0, creates a new ArrayList of Field and of Harvester and then are stored
 * into the numberOfFields and numberOfHarvester field respectively.
 * It has a method addHarvester which receives two parameters, fuelTankSize and topSpeed of type integer.
 * It has a method addCombineHarvester which receives three parameters fuelTankSize, topSpeed, lenght of type integer.
 * It has a method addField which receives two parameters type of type String and value of type integer.
 * It has a method getProfit that returns an integer value which is the profit of the farm.
 * It has a method harvest that calculates the profit of the farm.
 */
public class Farm {

	// Creation of field numberOfFields of type ArrayList of Field
	private ArrayList<Field> numberOfFields;
	// Creation of field numberOfHarvesters of type ArrayList of Harvester
	private ArrayList<Harvester> numberOfHarvesters;
	// Creation of field profit of type integer.
	private int profit;
	
	/**
	 * The constructor Farm sets the profit to 0, creates new ArrayList of Field and of Harvester which are stored
	 * into the numberOfFields and numberOfHarvesters respectively.
	 */
	public Farm(){
		
		// Initialises profit to 0.
		profit = 0;
		// Creates a new ArrayList of Field and stores it into numberOfFields field.
		numberOfFields = new ArrayList<Field>();
		// Creates a new ArrayList of Harvester and stores it into numberOfHarvesters field.
		numberOfHarvesters = new ArrayList<Harvester>();
		
	}
	
	/**
	 * The method addHarvester receives two parameters fuelTankSize and topSpeed of type integer
	 * Adds a new Harvester with the supplied parameters to the numberOfHarvesters ArrayList.
	 */
	public void addHarvester(int fuelTankSize, int topSpeed){
		// Creates object harvester of the class Harvester with parameters fuelTankSize and topSpeed.
		Harvester harvester = new Harvester(fuelTankSize, topSpeed);
		// Adds the object harvester to the numberOfHarvesters ArrayList.
		numberOfHarvesters.add(harvester);
	}
	
	/**
	 * The method addCombineHarvester receives three parameters fuelTankSize, topSpeed and length of type integer
	 * Adds a new CombineHarvester with the supplied parameters to the numberOfHarvesters ArrayList.
	 */
	public void addCombineHarvester(int fuelTankSize, int topSpeed, int length) {
		
		// Creates object combineHarvester of the class CombineHarvester with parameters fuelTankSize, topSpeed and length
		CombineHarvester combineHarvester = new CombineHarvester(fuelTankSize, topSpeed, length);
		// Adds the object combineHarvester to the numberOfHarvesters ArrayList.
		numberOfHarvesters.add(combineHarvester);
	}
	
	/**
	 * The method addField receives two parameters: type of type String and value of type integer.
	 * Adds a new Field with the supplied parameters to the numberOfFields ArrayList.
	 */
	public void addField(String type, int value){
		
		// Creates object field of the class Field with parameters type and value.
		Field field = new Field(type, value);
		// Adds the object field to the ArrayList numberOfFields.
		numberOfFields.add(field);
	}
	
	/**
	 * The method getProfit returns an integer value which is the profit of the farm.
	 */
	public int getProfit(){
		// Returns profit.
		return profit;
	}
	
	/**
	 * The method harvest calculates the profit by considering whether the totalHarvestinCapacity is less than the number of elements
	 * inside the numberOfFields ArrayList.
	 */
	public void harvest() {
		
		// Initialises totalHarvestinCapacity to 0.
		int totalHarvestingCapacity = 0;
		
		// Loops until i is not less than the numberOfHarvesters.
		for (int i=0; i<numberOfHarvesters.size(); i++){
			// Updates the value of totalHarvestingCapcity by the value of the current element in the numberOfHarvesters ArrayList.
			totalHarvestingCapacity = totalHarvestingCapacity + numberOfHarvesters.get(i).getHarvestingCapacity();
		}
		
		// Checks whether the totalHarvestingCapacity is less than the size of numberOfField ArrayList.
		if (totalHarvestingCapacity < numberOfFields.size()) {
			// Loops until i is not less than the totalHarvestingCapacity
			for (int i=0; i<totalHarvestingCapacity; i++){
				// Increments the profit by the value of each element inside the numberOfFields ArrayList.
				profit = profit + numberOfFields.get(i).harvest();
			}
		}	
		
		// Else...
		else {
			// Loops until i is not less than the size of numberOfField ArrayList.
			for (int i=0; i<numberOfFields.size(); i++){		
				// Increments the profit by the value of each element inside the numberOfFields ArrayList.
				profit = profit + numberOfFields.get(i).harvest();
			}
			
		}
		
	}
	
}
