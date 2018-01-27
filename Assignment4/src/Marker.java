/**
 * The class Marker is used to calculate the total marks the student has taken and the total marks
 * for each question individually, by comparing the answers from the student's exam attempt with the
 * answers of the exam's mark scheme. Also is used to convert their total mark into degree classification.
 * The class Marker contains the creation of fields question1Mark, question2Mark, question3Mark, classification
 * and also declaration of the variable totalMark. Additionally contains two methods the markAttempt and the convertMarksToClassification.
 */
public class Marker {
	
	// Declaration of the variable totalMark of type integer.
	private int totalMark;
	// Creation of field question1Mark of type integer.
	private int question1Mark;
	// Creation of field question2Mark of type integer.
	private int question2Mark;
	// Creation of field question3Mark of type integer.
	private int question3Mark;
	// Creation of field classification of type boolean.
	private double classification;
	
	/**
	 * Creation of the integer method markAttempt that receives two parameters: examAttempt and markScheme of type Exam.
	 * Is used to compare the answers from the student's exam attempt with the answers of the exam's mark scheme.
	 * It also calculates the achieved mark of each question, and the total marks of the exam.
	 */
	public int markAttempt(Exam examAttempt, Exam markScheme) {
		
		// Initialisation of field question1Mark with the value of 0.
		question1Mark = 0;
		// Initialisation of field question2Mark with the value of 0.
		question2Mark = 0;
		// Initialisation of field question3Mark with the value of 0.
		question3Mark = 0;
		
		// Checks if the answer for the first question of the student's exam attempt matches with the answer in the markscheme.
		if (examAttempt.getQuestion1().getAnswer() == markScheme.getQuestion1().getAnswer())  {
			
			// Equalises the question1Mark with the markScheme's maximum available marks.
			question1Mark = markScheme.getQuestion1().getMark();
			// Makes the totalMark variable to be equal with itself plus the value in question1Mark.
			totalMark = totalMark + question1Mark;
		
		// Checks if the answer for the first question of the student's exam attempt is by one higher or lower than the answer in the markscheme.
		} else if ((examAttempt.getQuestion1().getAnswer() + 1 == (markScheme.getQuestion1().getAnswer())) || (examAttempt.getQuestion1().getAnswer() - 1 == (markScheme.getQuestion1().getAnswer()))) {
			
			// Equalises the question1Mark with the one mark lower than the markScheme's maximum available marks.
			question1Mark = markScheme.getQuestion1().getMark() - 1;
			// Makes the totalMark variable to be equal with itself plus the value in question1Mark.
			totalMark = totalMark + question1Mark;
			
		// Checks if the answer for the first question of the student's exam attempt is up to 5 higher or lower than the answer in the markscheme.
		} else if ((markScheme.getQuestion1().getAnswer() - examAttempt.getQuestion1().getAnswer()) <= 5 && (markScheme.getQuestion1().getAnswer() - examAttempt.getQuestion1().getAnswer()) >= -5) {
			
			// Makes the question1Mark equal to 1.
			question1Mark = 1;
			// Makes the totalMark variable to be equal with itself plus the value in question1Mark.
			totalMark = totalMark + question1Mark;
		
		// If nothing from the above then works then...
		} else {
			
			// Makes the question1Mark equal to 0.
			question1Mark = 0;
			
		}
		
		// Stores the question1Mark individually.
		examAttempt.getQuestion1().setMark(question1Mark);
		
		// Checks if the answer for the second question of the student's exam attempt matches with the answer in the markscheme.
		if (examAttempt.getQuestion2().getAnswer() == markScheme.getQuestion2().getAnswer()) {
			
			// Equalises the question2Mark with the markScheme's maximum available marks.
			question2Mark =  markScheme.getQuestion2().getMark(); 
			// Makes the totalMark variable to be equal with itself plus the value in question2Mark.
			totalMark = totalMark + question2Mark;
			
		// If it's different then...
		} else {
			
			// Makes the question2Mark equal to 0.
			question2Mark = 0;
		}
		
		// Stores the question2Mark individually.
		examAttempt.getQuestion2().setMark(question2Mark);
		
		// Checks if the answer for the option 1 for the third question of the student's exam attempt matches with the answer in the markscheme.
		if (examAttempt.getQuestion3().getOption1() == markScheme.getQuestion3().getOption1()) {
			
			// Equalises the question3Mark with itself plus 1.
			question3Mark = question3Mark + 1;
			
		}
		
		// Checks if the answer for the option 2 for the third question of the student's exam attempt matches with the answer in the markscheme.
		if (examAttempt.getQuestion3().getOption2() == markScheme.getQuestion3().getOption2()) {
			
			// Equalises the question3Mark with itself plus 1.
			question3Mark = question3Mark + 1;
			
		}
		
		// Checks if the answer for the option 3 for the third question of the student's exam attempt matches with the answer in the markscheme.
		if (examAttempt.getQuestion3().getOption3() == markScheme.getQuestion3().getOption3()) {
			
			// Equalises the question3Mark with itself plus 1.
			question3Mark = question3Mark +1;
		}
		
		// Stores the question3Mark individually.
		examAttempt.getQuestion3().setMark(question3Mark);
		
		
		// Makes the totalMark variable to be equal with itself plus the value in question3Mark.
		totalMark = totalMark + question3Mark;
		
		// Stores the total mark of the examAttempt.
		examAttempt.setTotalMark(totalMark);
		
		// Returns the totalMark.
		return totalMark;
	}
	
	/**
	 * Creation of the double method convertMarksToClassification that receives four parameters: mark, firstBoundary,
	 * upperSecondBoundary and lowerSecondBoundary of type integer. It's used to convert the exam's mark into
	 * classification by comparing some given boundaries to the total mark.
	 */
	public double convertMarksToClassification(int mark, int firstBoundary, int upperSecondBoundary, int lowerSecondBoundary) {
		
		// Initialises the classification variable to 0.
		classification = 0;
		
		// Checks if the mark is higher than the firstBoundary.
		if (mark >= firstBoundary) {
			
			// Makes the classification to be equal to 1.1
			classification = 1.1;
		
		// Checks if the mark is higher than the upperSecondBoundary.
		} else if (mark >= upperSecondBoundary) {
			
			// Makes the classification to be equal to 2.1
			classification = 2.1;
			
		// Checks if the mark is higher than the lowerSecondBoundary.
		} else if (mark >= lowerSecondBoundary) {
			
			// Makes the classification to be equal to 2.2 
			classification = 2.2;
		
		// If none of the above...
		} else {
			
			// Makes the classification to be equal to 0.0
			classification = 0.0;
			
		}
		
		// Returns the classification
		return classification; 
		
	}
	
	/**
	 * Creation of the getQuestion1Mark that is used to
	 * return the mark of the first question.
	 */
	public int getQuestion1Mark() {
		
		// Returns the mark of the first question.
		return question1Mark;
	}
	
	/**
	 * Creation of the getQuestion2Mark that is used to
	 * return the mark of the second question.
	 */
	public int getQuestion2Mark() {
		
		// Returns the mark of the second question.
		return question2Mark;
		
	}
	
	/**
	 * Creation of the getQuestion3Mark that is used to
	 * return the mark of the third question.
	 */
	public int getQuestion3Mark() {
		
		// Returns the mark of the third question.
		return question3Mark;
	}
	
}
