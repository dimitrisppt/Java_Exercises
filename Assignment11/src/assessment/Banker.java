package assessment;

// From java's utilities import TreeMap.
import java.util.TreeMap;
// From java's utilities import Scanner.
import java.util.Scanner;

/**
 * Creation of this class Banker which inherits the properties of the class Person.
 * This class consists of the main method, a constructor, addRelative, removeRelative, searchClosestRelative, moveChildren, isGuardianFriendly, isLastGuardian,
 * friendliestRelative methods. Also overrides the toString method.
 * @author DimitrisRodrigo
 *
 */
public class Banker extends Person {

	// Creation of field relativesList of type TreeMap with key Relative and a value of Integer.
	private static TreeMap<Relative, Integer> relativesList;

	/**
	 * This constructor receives one parameter, name of type String, and TreeMap is initialised.
	 * @param name
	 */
	public Banker(String name) {

		// Calls the constructor of the superclass.
		super(name, 5);
		// Creates a new TreeMap which is stored in relativesList field.
		relativesList = new TreeMap<Relative, Integer>();
	}

	/**
	 * This method receives a parameter of type Relative and then
	 * adds the Relative to the TreeMap.
	 * @param relative
	 */
	public static void addRelative(Relative relative) {

		// Adds the Relative to the TreeMap by also passing their distance as value of the TreeMap.
		relativesList.put(relative, relative.getDistance());
	}

	
	/**
	 * This method receives a Relative and then
	 * removes the relative from a list if their are unfriendly. Then returns true.
	 * If the Relative is not found return false.
	 * @param relative
	 * @return
	 */
	public static boolean removeRelative(Relative relative) {

		// Checks whether the relativesList contains the given Relative.
		if (relativesList.containsKey(relative)) {
			
			// Removes the relative from the relativesList.
			relativesList.remove(relative);
			// Returns true.
			return true;
		}
		// Returns false.
		return false;
	}

	/**
	 * This method searches for the relative that lives closest to Mr Poe's, then returns the Relative.
	 * @return
	 */
	public static Relative searchClosestRelative() {

		// Declaration and initialisation of the variable tempDistance with a big value, because we want true the if condition for the first element of the relativesList.
		int tempDistance = 999999999;
		// Creation of the variable closestRelative of type Relative. Initialisation to null.
		Relative closestRelative = null;

		// For each Relative r in relativesList keys, do:
		for (Relative r : relativesList.keySet()) {

			/* Checks whether the value(distance) of that Relative r is less than the tempDistance. (For the first element we want this condition true,
			 *thus tempDistance is equal to a big number at the beginning).
			 */
			if (relativesList.get(r) < tempDistance) {
				
				// tempDistance is equal to the value of the current Relative r.
				tempDistance = relativesList.get(r);
				// closestRelative is equal to the current Relative r.
				closestRelative = r;
			}
		}
		// Returns the closest Relative.
		return closestRelative;
	}

	/**
	 * This method receives a Relative as a parameter and gives the guardian of the children to the relative.
	 * @param relative
	 */
	public static void moveChildren(Relative relative) {
		
		// Calls the method setHasChildren for the object relative and 
		relative.setHasChildren();
	}

	/**
	 * This method receives a Relative as a parameter and returns a boolean value.
	 * It determines a guardian to be unfriendly if their level of 
	 * friendliness is strictly less than Mr Poe's.
	 * @param relative
	 * @return
	 */
	public static boolean isGuardianFriendly(Relative relative) {

		// If relative's level of friendliness is less than 5 which is the Bankers level then:
		if (relative.getFriendliness() < 5) {
			
			// Returns false.
			return false;
		// Else,
		} else {

			// Returns true.
			return true;
		}
	}

	/**
	 * The method isLastGuardian receives a Relative as a parameter and returns a boolean value.
	 * This method identifies the last relative that has the guardian.
	 * @param relative
	 * @return
	 */
	public static boolean isLastGuardian(Relative relative) {
		
		// Checks if relative object is not null,
		if (relative != null) {
			// Calls the method getIsLastGuardian for the relative object and returns the result.
			return relative.getIsLastGuardian();
		// Else,
		} else {
			// Returns false.
			return false;
		}
	}

	
	/**
	 * This method searches for the relative that is the friendliest relative among all, then returns the Relative.
	 * @return
	 */
	public static Relative friendliestRelative() {

		// Declaration and initialisation of the variable tempFriendliness with zero, because we want true the if condition for the first element of the relativesList.
		int tempFriendliness = 0;
		// Creation of the variable friendliestRelative of type Relative. Initialisation to null.
		Relative friendliestRelative = null;

		// For each Relative r in relativesList keys, do:
		for (Relative r : relativesList.keySet()) {

			/* Checks whether the friendliness of that Relative r is greater than the tempFriendliness. (For the first element we want this condition true,
			 *thus tempFriendliness is equal to zero at the beginning).
			 */
			if (r.getFriendliness() > tempFriendliness) {

				// tempFriendliness is equal to the friendliness of the current Relative r.
				tempFriendliness = r.getFriendliness();
				// friendliestRelative is equal to the current Relative r.
				friendliestRelative = r;
			}
		}
		// Returns the friendliest Relative.
		return friendliestRelative;

	}

	/**
	 * The toString method returns a string that "textually represents" this object Banker and consists of their name and their friendliness and banker list.
	 */
	public String toString() {

		// Returns the string representation of Banker.
		return "Banker" + "[Name: " + getName() + ", " + "Friendliness: " + getFriendliness() + "]" + "\n" + "Banker List: " + relativesList.toString() + "]";
	}

	/**
	 * The main method of the program. Where the execution of the program takes place.
	 * @param args
	 */
	public static void main(String[] args) {

		// Creation of object mrPoe of type Banker with parameter "Mr Poe".
		Banker mrPoe = new Banker("Mr Poe");
		// Declaration of closestRelative variable.
		Relative closestRelative = null;

		// Creation of object josephine of type Relative with parameters "Josephine", 5, 100.
		Relative josephine = new Relative("Josephine", 5, 100);
		// Creation of object olef of type Relative with parameters "Olaf", -10, 10.
		Relative olaf = new Relative("Olaf", -10, 10);
		// Creation of object sir of type Relative with parameters "Sir", 0, 20.
		Relative sir = new Relative("Sir", 0, 20);
		// Creation of object uncleMonty of type Relative with parameters "Uncle Monty", 10, 20.
		Relative uncleMonty = new Relative("Uncle Monty", 10, 20);

		// Calls the addRelative method which adds the object josephine to the TreeMap.
		addRelative(josephine);
		// Calls the addRelative method which adds the object olaf to the TreeMap.
		addRelative(olaf);
		// Calls the addRelative method which adds the object sir to the TreeMap.
		addRelative(sir);
		// Calls the addRelative method which adds the object uncleMonty to the TreeMap.
		addRelative(uncleMonty);

		// Creates object in of class Scanner.
		Scanner in = new Scanner(System.in);
		// Initialises the userInput variable of type String.
		String userInput = "";

		// While userInput is not equal to 'exit', do:
		while (!userInput.equals("exit")) {
			
			// Prints the string representation of mrPoe object and changes line.
			System.out.println(mrPoe.toString() + "\n");
			
			// While relativesList TreeMap is not empty and the last guardian is not found yet do:
			while (!relativesList.isEmpty() && !isLastGuardian(closestRelative)) {

				// Sets the value of closestRelative variable to be the result of the searchClosestRelative method.
				closestRelative = searchClosestRelative();
				// Moves children to the closestRelative
				moveChildren(closestRelative);
				// Prints the name of the closest relative who currently has the guard of the children.
				System.out.println("Moving children to: " + closestRelative.getName());

				// If guardian is friendly then:
				if (isGuardianFriendly(closestRelative)) {
					// The closest relative becomes the guard of the children and sets the hasChildren field to true.
					closestRelative.setHasChildren();
					// Because guardian is friendly and has the children becomes the last guardian. Sets the lastGuardian field to true.
					closestRelative.setLastGuardian();
					// Prints the name of the closest relative following by a message to inform the user. Then changes line.
					System.out.println(closestRelative.getName() + " is friendly and will have the guard of the children." + "\n");

				// If guardian is not friendly then:
				} else {

					// Calls the removeRelative method which removes the current closest relative from the TreeMap.
					removeRelative(closestRelative);
					// Prints the name of the current closest relative following by a message that informs the user about the friendliness status of the relative.
					System.out.println(closestRelative.getName() + " is unfriendly. Removing " + closestRelative.getName() + " from the list." + "\n");
				}
			}

			// Prints an informing message with options for the user to select.
			System.out.println("Please enter one of the following options: 'add relative' or 'exit' to end.");
			// Asks user for input.
			userInput = in.nextLine();

			// If userInput is equal to 'add relative' then:
			if (userInput.equals("add relative")) {

				// While userInput is not equal to 'no', do:
				while (!userInput.equals("no")) {

					// Prints a message to the screen with instructions.
					System.out.print("Enter the name of relative you want to add: ");
					// Asks user for input.
					userInput = in.nextLine();
					// Defines a variable name of type String and initialises it to the value of userInput.
					String name = userInput;

					// Prints a message to the screen with instructions.
					System.out.print("Enter the friendliness of relative you want to add: ");
					// Asks user for integer input.
					int userInput2 = in.nextInt();
					// Defines a variable friendliness of type integer and initialises it to the value of userInput2.
					int friendliness = userInput2;
					
					// Prints a message to the screen with instructions.
					System.out.print("Enter the distance of relative you want to add: ");
					// Asks user for integer input.
					int userInput3 = in.nextInt();
					// Defines a variable distance of type integer and initialises it to the value of userInput3.
					int distance = userInput3;

					// Creates an object userRelative of type Relative with name, friendliness and distance as parameters.
					Relative userRelative = new Relative(name, friendliness, distance);

					// Calls the addRelative method which adds the object userRelative to the TreeMap.
					addRelative(userRelative);
					// Asks input from the user.
					userInput = in.nextLine();
					
					// Prints a message to the screen with instructions.
					System.out.println("Do you want to add another relative?: 'yes' or 'no'");
					// Asks input from the user.
					userInput = in.nextLine();
					
					// If userInput is equal to 'no' then:
					if (userInput.equals("no")) {
						
						// Do loop until while condition is met.
						do {
							// Prints a message to the screen with instructions.
							System.out.println("Please enter one of the following options to calculate the closest or friendliest relative or cancel: 'closest relative', 'friendliest relative', 'cancel'.");
							// Asks input from the user.
							userInput = in.nextLine();
							
							// If userInput is equal to 'closest relative', then:
							if (userInput.equals("closest relative")) {
								
								// Searches for the closest relative and prints their name.
								System.out.println("Closest Relative: " + searchClosestRelative().getName());

							// Else if userInput is equal to 'friendliest relative', then:
							} else if (userInput.equals("friendliest relative")) {
								
								// Searches for the friendliest relative and prints their name.
								System.out.println("Friendliest Relative: " + friendliestRelative().getName());
							
							// Else if userInput is equal to 'cancel', then:
							} else if (userInput.equals("cancel")) {
								// Sets userInput to 'cancel'.
								userInput = "cancel";
							}
							
						// Repeat until userInput is equal to cancel.
						} while (!userInput.equals("cancel"));
						
						// Sets userInput to 'no'.
						userInput = "no";

					}

				}
			}

		}
		
		// Closes the Scanner.
		in.close();
	}

}
