/** 
 * The MarkExams program implements an application that takes an exam attempt from a student and compares the answers of the test 
 * with a mark scheme. For each answer the student takes a mark out of a number of maximum available marks for that question
 * taken in mind specific parameters of marking for each question. Then the program  outputs the marks that the student took for each  question.
 * Also outputs the total mark of the exam attempt, and determines the classification of this mark.
 */
public class MarkExams {
	
	/**
	 * The main method of the program where the execution takes place.
	 * Contains the creation of objects of the classes NumericalQuestion, BooleanQuestion, MultipleChoiseQuestion, Exam and Marker.
	 */
	public static void main(String[] args) {
		
		// Creation of the constructor nqMarkScheme with parameters 198 and 6 of the class NumericalQuestion.
		NumericalQuestion nqMarkScheme = new NumericalQuestion(198, 6);
		
		// Creation of the constructor bqMarkScheme with parameters true and 1 of the class BooleanQuestion.
		BooleanQuestion bqMarkScheme = new BooleanQuestion(true, 1);
		
		// Creation of the constructor mcpMarkScheme with parameters false, false, false and 3 of the class MultipleChoiceQuestion.
		MultipleChoiceQuestion mcpMarkScheme = new MultipleChoiceQuestion(false, false, false, 3);
		
		// Creation of the constructor markScheme with parameters nqMarkScheme, bqMarkScheme and mcpMarkScheme of the class Exam.
		Exam markScheme = new Exam(nqMarkScheme, bqMarkScheme, mcpMarkScheme);
		
		// Creation of the constructor nqAttempt with parameters 196 and 0 of the class NumericalQuestion.
		NumericalQuestion nqAttempt = new NumericalQuestion(196, 0);
		
		// Creation of the constructor bqAttempt with parameters true and 0 of the class BooleanQuestion.
		BooleanQuestion bqAttempt = new BooleanQuestion(true, 0);
		
		// Creation of the constructor mcpAttempt with parameters false, false, false and 0 of the class MultipleChoiceQuestion.
		MultipleChoiceQuestion mcpAttempt = new MultipleChoiceQuestion(false, false, false, 0);
		
		// Creation of the constructor examAttempt with parameters nqAttempt, bqAttept and mcpAttempt of the class Exam.
		Exam examAttempt = new Exam(nqAttempt, bqAttempt, mcpAttempt);
		
		// Creation of the object examMarker of the class Marker.
		Marker examMarker = new Marker();
		
		// Calling the method markAttempt using the object examMarker and passing examAttempt and markScheme as parameters. 
		examMarker.markAttempt(examAttempt, markScheme);
		
		// Declaration and calculation of the variable mark, by adding together the mark of each of the three questions.
		int mark = examAttempt.getTotalMark();
		
		// Outputs the marks that the student has taken, out of the maximum available marks of the first question.
		System.out.println("Question1: " + examMarker.getQuestion1Mark() + " out of " + nqMarkScheme.getMark());
		// Outputs the marks that the student has taken, out of the maximum available marks of the second question.
		System.out.println("Question2: " + examMarker.getQuestion2Mark() + " out of " + bqMarkScheme.getMark());
		// Outputs the marks that the student has taken, out of the maximum available marks of the third question.
		System.out.println("Question3: " + examMarker.getQuestion3Mark() + " out of " + mcpMarkScheme.getMark());
		
		// Output the total marks the student has taken.
		System.out.println("Total Mark awarded: " + mark);
		
		// Calculates and prints the classification of the student based on their total mark.
		System.out.println("Classification: " + examMarker.convertMarksToClassification(mark, 9, 7, 6));
	
		
	}

}
