package assessment;

/**
 * Creation of a class Person, which is extended to the classes relative and banker.
 * This process where one class acquires the properties (methods and fields) of another is call inheritance. 
 * This class contains a constructor, getName and getFriendliness methods and overrides the toString method.
 * @author DimitrisRodrigo
 * 
 */
public class Person {

	// Creation of field name of type String.
	private String name;
	// Creation of field friendliness of type integer.
	private int friendliness;

	/**
	 * This constructor receives two parameters, name of type String and friendliness of type integer.
	 * @param name
	 * @param friendliness
	 */
	public Person(String name, int friendliness) {
		
		// Refers the field name to the class.
		this.name = name;
		// Refers the field friendliness to the class.
		this.friendliness = friendliness;
	}

	/**
	 * Returns a String which is the name of Person.
	 * @return
	 */
	public String getName() {
		
		// Returns the name.
		return name;
	}

	/**
	 * Returns an integer which is the friendliness of Person.
	 * @return
	 */
	public int getFriendliness() {

		// Returns the friendliness.
		return friendliness;
	}

	/**
	 * The toString method returns a string that "textually represents" this object Person and consists of their name and their friendliness.
	 */
	public String toString() {

		// Returns the string representation of Person.
		return "Person" + "[Name=" + getName() + ", " + "Friendliness=" + getFriendliness() + "]";
	}

}
