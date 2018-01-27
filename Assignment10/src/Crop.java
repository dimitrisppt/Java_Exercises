/**
 * The class Crop contains two fields: 'type' of type String, 'value' of type integer
 * The constructor Crop receives two parameters 'type' of type String, 'value' of type integer.
 * It has a method getValue that returns an integer value.
 */
public class Crop {
	
	// Creation of the field 'type' of type String
	private String type;
	// cCreation of field value of type integer
	private int value;
	
	/**
	 * The constructor Crop receives two parameters, 'type' of type String and 'value' of type integer.
	 */
	public Crop(String type, int value){
		
		// Refers type to the class.
		this.type=type;
		// Refers value to the class.
		this.value=value;
		
	}

	// The method getValue returns an integer value.
	public int getValue(){
		// Returns the value of the field 'value'.
		return value;
	}
}
