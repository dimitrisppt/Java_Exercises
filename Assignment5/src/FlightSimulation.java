/**
 * The FlightSimulator program implements an application that simulates an aeroplane which travels across three destinations each day and at the end of each day returns back
 * passing by the three destinations. For each destination, the program outputs the name of the aeroplane, the starting destination of the journey and the destination where the journey ends.
 * also outputs the distance of the journey, the total distance the aeroplane has travelled and the current x-axis and y-axis coordinates of the aeroplane. This simulation is run for 120 days,
 * and outputs the number of each day and the total travelled distance up until the start of the day.
 * When the total distance the aeroplane has travelled is greater than 1000 the aeroplane has to undergo for repair which it takes 7 days. Then the total distance of the aeroplane it's resets to 0.
 * Also outputs the number of times that the aeroplane had to undergo repairs.
 */
public class FlightSimulation {

	/**
	 * The method singleDay is used to print all the necessary statements for the simulation of a single day.
	 * It receives four parameters: the destination1, destination2, destination3 of type Destination and the aeroplane of type Aeroplane
	 */
	public static void singleDay(Destination destination1, Destination destination2, Destination destination3, Aeroplane aeroplane) {
		
		// Outputs the name of the aeroplane.
		System.out.println("Aeroplane Name: " + aeroplane.getName());
		// Outputs the name of the first destination.
		System.out.println("Journey start destination: " + destination1.getName());
		// Outputs the name of the second destination.
		System.out.println("Journey end destination: " + destination2.getName());
		// Outputs the distance of the journey from destination1 to destination2.
		System.out.println("Single journey distance: " + aeroplane.singleFlight(destination2));
		// Outputs the total distance the aeroplane has travelled.
		System.out.println("Total distance aeroplane travelled: " + aeroplane.getTotalDistance());
		// Outputs the current coordinates of the aeroplane.
		System.out.println("Aeroplane current coordinates: " + "x: " + aeroplane.getXCoordinates() + " " + "y: " + aeroplane.getYCoordinates());
		
		
		
		// Outputs the name of the aeroplane.
		System.out.println("Aeroplane Name: " + aeroplane.getName());
		// Outputs the name of the second destination.
		System.out.println("Journey start destination: " + destination2.getName());
		// Outputs the name of the third destination.
		System.out.println("Journey end destination: " + destination3.getName());
		// Outputs the distance of the journey from destination2 to destination3.
		System.out.println("Single journey distance: " + aeroplane.singleFlight(destination3));
		// Outputs the total distance the aeroplane has travelled.
		System.out.println("Total distance aeroplane travelled: " + aeroplane.getTotalDistance());
		// Outputs the current coordinates of the aeroplane.
		System.out.println("Aeroplane current coordinates: " + "x: " + aeroplane.getXCoordinates() + " " + "y: " + aeroplane.getYCoordinates());
		
		
		
		// Outputs the name of the aeroplane.
		System.out.println("Aeroplane Name: " + aeroplane.getName());
		// Outputs the name of the third destination.
		System.out.println("Journey start destination: " + destination3.getName());
		// Outputs the name of the second destination.
		System.out.println("Journey end destination: " + destination2.getName());
		// Outputs the distance of the journey from destination3 to destination2.
		System.out.println("Single journey distance: " + aeroplane.singleFlight(destination2));
		// Outputs the total distance the aeroplane has travelled.
		System.out.println("Total distance aeroplane travelled: " + aeroplane.getTotalDistance());
		// Outputs the current coordinates of the aeroplane.
		System.out.println("Aeroplane current coordinates: " + "x: " + aeroplane.getXCoordinates() + " " + "y: " + aeroplane.getYCoordinates());
		
		

		// Outputs the name of the aeroplane.
		System.out.println("Aeroplane Name: " + aeroplane.getName());
		// Outputs the name of the second destination.
		System.out.println("Journey start destination: " + destination2.getName());
		// Outputs the name of the first destination.
		System.out.println("Journey end destination: " + destination1.getName());
		// Outputs the distance of the journey from destination2 to destination1.
		System.out.println("Single journey distance: " + aeroplane.singleFlight(destination1));
		// Outputs the total distance the aeroplane has travelled.
		System.out.println("Total distance aeroplane travelled: " + aeroplane.getTotalDistance());
		// Outputs the current coordinates of the aeroplane.
		System.out.println("Aeroplane current coordinates: " + "x: " + aeroplane.getXCoordinates() + " " + "y: " + aeroplane.getYCoordinates());
		
			
	}
	
	/**
	 * This is the main method of the program. Where the execution is done. 
	 */
	public static void main(String[] args) {
		
		// Initialisation of the variable counterRepairs to zero. It counts the number of time the airplane undergo for repair.
		int counterRepairs = 0;
		
		// Creation of the constructor destination1 of the class Destination with parameters "Mumbai", 60 and 75.
		Destination destination1 = new Destination("Mumbai", 60, 75);
		// Creation of the constructor destination2 of the class Destination with parameters "Stockholm", 85 and 95.
		Destination destination2 = new Destination("Stockholm", 85, 95);
		// Creation of the constructor destination3 of the class Destination with parameters "New", 130 and 140.
		Destination destination3 = new Destination("New", 130, 140);
		// Creation of the constructor aeroplane of the class Aeroplane with parameters "Air Force One", 60, 75, 20, 0, 1000.
		Aeroplane aeroplane = new Aeroplane("Air Force One", 60, 75, 20, 0, 1000);
	
		// To repeat the simulation for 120 days.
		for (int i = 0; i<120; i++) {
			
			// Outputs the number of each day.
			System.out.println("Day: " + (i+1));
			// Outputs the total travelled distance of the aeroplane up until the start of the day.
			System.out.println("Total travelled distance up until the start of the day: " + aeroplane.getTotalDistance());
			
			// Checks whether the repairDistance of the aeroplane is greater than the total distance the aeroplane has covered at that time.
			if (aeroplane.getRepairDistance() >= aeroplane.getTotalDistance()) {
				
				// Simulates a single day with parameters the destination1, destination2, destination3 and aeroplane. 
				singleDay(destination1, destination2, destination3, aeroplane);
			
			// If the repairDistance of the aeroplane is less than the total distance the aeroplane has covered at that time.
			} else {
				
				// The counter i is skipped 7 days.
				i += 7;
				// Sets the total distance of the aeroplane to 0.
				aeroplane.setTotalDistance(0);
				// Increment counterRepairs by 1.
				counterRepairs += 1;
			}
			
			// Outputs the number of times the aeroplane had to undergo repairs.
			System.out.println("Number of times that the aeroplane had to undergo repairs: " + counterRepairs);

		}
	}
}
