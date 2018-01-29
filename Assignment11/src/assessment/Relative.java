package assessment;

/**
 * Creation of this class Relative which inherits the properties of the class Person
 * and implements the Comparable interface. 
 * This class consists of a constructor, and the following methods: getDistance, setHasChildren, getHasChildren, setLastGuardian, getIsLastGuardian.
 * Also overrides the toString and compareTo methods.
 * @author DimitrisRodrigo
 *
 */
public class Relative extends Person implements Comparable<Relative> {

	// Creation of field distance of type integer which is the distance between the relative's homes from Mr Poe's.
	private int distance;
	// Creation of a field isLastGuardian of type boolean.
	private boolean isLastGuardian;
	// Creation of a field hasChildren of type boolean.
	private boolean hasChildren;

	/**
	 * This constructor receives three parameters, name of type String, friendliness and distance of type integer.
	 * @param name
	 * @param friendliness
	 * @param distance
	 */
	public Relative(String name, int friendliness, int distance) {
		
		// Calls the constructor of the superclass.
		super(name, friendliness);
		// Refers the field distance to the class.
		this.distance = distance;
		// Initialises the field isLastGuardian to false.
		isLastGuardian = false;
		// Initialises the field hasChildren to false.
		hasChildren = false;
	}

	/**
	 * This method returns an integer value which is the distance.
	 * @return
	 */
	public int getDistance() {

		// Returns distance.
		return distance;
	}

	/**
	 * This method sets hasChildren field to true.
	 */
	public void setHasChildren() {

		// Sets hasChildren field to true.
		hasChildren = true;
	}

	/**
	 * This method returns the boolean value of the field hasChildren.
	 * @return
	 */
	public boolean getHasChildren() {
		
		// Returns hasChildren field.
		return hasChildren;
	}

	/**
	 * This method sets isLastGuardian field to true.
	 */
	public void setLastGuardian() {

		// Sets isLastGuardian field to true.
		isLastGuardian = true;
	}

	/**
	 * This method returns the boolean value of the field isLastGuardian.
	 * @return
	 */
	public boolean getIsLastGuardian() {

		// Returns the value of field isLastGuardian.
		return isLastGuardian;
	}

	/**
	 * The toString method returns a string that "textually represents" this object Relative and consists of their name and their friendliness.
	 */
	public String toString() {
		
		// Returns the string representation of Person.
		return "Person" + "[Name=" + getName() + ", " + "Friendliness=" + getFriendliness() + ", " + "Distance";
	}

	/**
	 * This method overrides the compareTo method and now compares Relatives, by comparing their names.
	 */
	public int compareTo(Relative relative) {

		// Returns a negative or positive integer value or zero depending whether the next argument precedes, following or is the same as the previous argument.
		return getName().compareTo(relative.getName());
	}

}
