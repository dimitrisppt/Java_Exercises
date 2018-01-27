// Imports ArrayList from java's utilities.
import java.util.ArrayList;

/**
 * The class Field consists of two fields: setOfCrops of type ArrayList of Crop and maxNumOfCrops of type integer.
 * The constructor Field receives two parameters: 'type' of type String and 'value' of type integer.
 * It has a method plant that receives two parameters: 'type' of type String and 'value' of type integer.
 * It has a method harvest that returns an integer value.
 */
public class Field {

	// Creation of field setOfCrops of type ArrayList of Crops
	private ArrayList<Crop> setOfCrops;
	// Creation of field maxNumOfCrops of type integer.
	private int maxNumOfCrops;
	
	/**
	 * The constructor Field receives two parameters: 'type' of type String and 'value' of type integer.
	 */
	public Field(String type, int value){
		
		// Creates a new ArrayList of Crop which is stored in the setOfCrops field.
		setOfCrops = new ArrayList<Crop>();
		// Sets the maxNumOfCrops to 10.
		maxNumOfCrops = 10;
		// Calls the plant method by suppling the variables type and value as parameters.
		plant(type,value);
	
	}
	
	/**
	 * The method plant receives two parameters: 'type' of type String and 'value' of type integer.
	 * Each time its called, creates a number of new Crops and stores them in the setOfCrops ArrayList.
	 */
	public void plant(String type, int value){
		
		// Loops until i is not less than maxNumOfCrops
		for (int i=0; i<maxNumOfCrops; i++){
			// Creates a new Crop with the supplied type and value, and stores it in the crop variable.
			Crop crop = new Crop(type, value);
			// Adds the crop into the setOfCrops ArrayList.
			setOfCrops.add(crop);
			
		}
	}
	
	/**
	 * The method harvest returns an integer value which is the value of all crops inside the setOfCrops ArrayList.
	 * Then clears the setOfCrops ArrayList.
	 */
	public int harvest(){
		// Initialises value to zero.
		int value = 0;
		// Loops until i is not less than the size of setOfCrops ArrayList.
		for (int i=0; i<setOfCrops.size(); i++) {
			// Adds the value of the current element of the setOfCrops ArrayList to the variable value.
			value = value + setOfCrops.get(i).getValue();
		}
		// Clears the setOfCrops ArrayList.
		setOfCrops.clear();
		// Returns the value.
		return value;
	}
	
}
