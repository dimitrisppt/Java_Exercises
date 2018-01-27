/** 
 * The RaceSimulator program implements an application that calculates the leader of a race after each round and outputs
 * their Car Id by comparing the time needed a car to complete a round at the track. The simulation is for 2 rounds without
 * rain and one round with rain. 
 */
public class RaceSimulator {

	/**
	 * The main method of the program where the execution takes place.
	 * Contains the creation of objects of class RaceTrack and class Car.
	 */
	public static void main(String[] args) {

		// Creating an object silverstone of the class RaceTrack using constructor to initialise its fields.
		RaceTrack silverstone = new RaceTrack(90, false);

		// Creating an object car1 of the class Car using constructor to initialise its fields.
		Car car1 = new Car(silverstone, 1, 55, 6, 5, 25, 12, 15, 0);

		// Creating an object car2 of the class Car using constructor to initialise its fields.
		Car car2 = new Car(silverstone, 2, 60, 8, 7, 28, 14, 10, 0);

		// Creating an object car3 of the class Car using constructor to initialise its fields.
		Car car3 = new Car(silverstone, 3, 90, 10, 6, 30, 16, 9, 0);
	
		
		// Makes the car1 to race for a lap in silverstone.
		car1.completeLap();
		// Makes the car1 to race for a lap in silverstone.
		car2.completeLap();
		// Makes the car1 to race for a lap in silverstone.
		car3.completeLap();
		// Outputs the leader's id of the lap to the screen.
		System.out.println("Leader Car:" + silverstone.determineRaceLeader(car1, car2, car3).getCar());

		// Makes the car1 to race for a lap in silverstone.
		car1.completeLap();
		// Makes the car2 to race for a lap in silverstone.
		car2.completeLap();
		// Makes the car3 to race for a lap in silverstone.
		car3.completeLap();
		// Outputs the leader's id of the lap to the screen.
		System.out.println("Leader Car:" + silverstone.determineRaceLeader(car1, car2, car3).getCar());
		
		// Makes it rain on silverstone by passing boolean value true to the setIsRaining method.
		silverstone.setIsRaining(true);
		// Makes the car1 to race for a lap in silverstone.
		car1.completeLap();
		// Makes the car2 to race for a lap in silverstone.
		car2.completeLap();
		// Makes the car3 to race for a lap in silverstone.
		car3.completeLap();
		// Outputs the leader's id of the lap to the screen.
		System.out.println("Winner Car:" + silverstone.determineRaceLeader(car1, car2, car3).getCar());
		
		
	}
	
}
