/**
 * The class RaceTrack is used for creation of the track of the program. 
 * The method determineRaceLeader is used to compare the total time of each car needs to  
 * complete the track and to return the leader. 
 * The averageLapTime method is used to set the average time each car needs to complete a lap.
 * The getAverageLapTime method is used to return the amount of seconds a car needs to complete a lap.
 * The setIsRaining method is used to set if it's raining on the track or not.
 * The getIsRaining method is used to return a boolean value true or false whether is raining or not.
 */
public class RaceTrack {
	
	// Creation of field seconds with type integer.
	private int seconds;
	// Creation of field isRaining with type boolean.
	private boolean isRaining;
	
	/* 
	 * Declaration of the constructor RaceTrack with the needed number of seconds and a boolean value for IsRaining variable.
	 */
	public RaceTrack(int seconds, boolean isRaining) {

		// Refers to the instance seconds of the class.
		this.seconds = seconds;
		// Refers to the instance IsRaining of the class.
		this.isRaining = isRaining;
	}
	
	/**
	 * Creation of the method averageLapTime that is used to set the average time each car needs to complete a lap on the track.
	 */
	public void averageLapTime(int seconds) {

		// Refers to the instance seconds of the class.
		this.seconds = seconds;
	}
	
	/**
	 * Creation of the method getAverageLapTime that is used to return the amount of seconds a car need to complete a lap on the track.
	 */
	public int getAverageLapTime() {

		// Returns the amount of seconds.
		return seconds;
	}

	/**
	 * Creation of method setIsRaining that is used to set whether or not is raining on the track.
	 */
	public void setIsRaining(boolean raining) {

		// Refers to the instance track of the class.
		isRaining = raining;
	}	
	
	/**
	 * Creation of method getIsRaining that is used to return the boolean value true or false, whether or not is raining on the track.
	 */
	public boolean getIsRaining() {

		// Returns the boolean value true or false of IsRaining variable.
		return isRaining;
	}
		
	
	/**
	 * Creation of the method determineRaceLeader that is used to compare the total time of each car needs to  
	 * complete the track and to return the leader. 
	 */
	public Car determineRaceLeader(Car car1, Car car2, Car car3) {

		// Creation of a variable leader of type Car that is used to return the leader of a single lap.
		Car leader;

		// Compares the time of the car1 with the time of the car2.
		if (car1.getcompleteLap() < car2.getcompleteLap()) {
			
			// If the time of car1 was faster than the car2 then compares the car1 time with the time of the car3.
			if (car1.getcompleteLap() < car3.getcompleteLap()) {

				// If the time of car1 was faster than the car3 then the car1 as a leader of the lap.
				leader = car1;

			/* Else returns the car3 as a leader of the lap because car1 was faster than car2 and car3 was faster than car1 therefore
			 * the car3 is the fastest on this lap. 
			 */
			} else {

				// The car3 as a leader of the lap.
				leader = car3;
			}

		// If the car2 was faster than the car1 then will compare the time of the car2 with the time of the car3.
		} else {
			
			// If the car2 is faster than the car3 then returns the car2 as a leader of the lap.
			if (car2.getcompleteLap() < car3.getcompleteLap()) {

				// The car2 as a leader of the lap.
				leader = car2;

			/* Else returns the car3 as a leader of the lap because car2 was faster than car1 and car3 was faster than car2 therefore
			 * the car3 is the fastest on this lap. 
			 */
			} else {

				// The car3 as a leader of the lap.
				leader = car3;
			}
		}
		
		// Returns the leader of the lap.
		return leader;
	}
}
