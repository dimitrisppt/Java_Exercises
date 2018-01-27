/**
 * The class Exam is used either for the mark scheme or a student's attempt
 * at the exam. It consists of three questions. Also has a totalMark which is used 
 * either for the mark awarded to the student for the entire exam attempt or as a
 * total mark of mark scheme for the total marks available for the whole test.
 *
 *
 */
public class Exam {
	
	private int totalMark;
	// Declaration of question1 of type NumericalQuestion.
	private NumericalQuestion question1;
	// Declaration of question2 of type BooleanQuestion.
	private BooleanQuestion question2;
	// Declaration of question3 of type MultipleChoiceQuestion.
	private MultipleChoiceQuestion question3;
	// Declaration of totalMark of type integer.
	
	
	/**
	 * Creation of the Exam constructor that receives three parameters 
	 * which are the questions1, question2, question3 of types NumericalQuestion,
	 * BooleanQuestion, MultipleChoiceQuestion, respectively.)
	 */
	public Exam(NumericalQuestion question1, BooleanQuestion question2, MultipleChoiceQuestion question3) {
		
		// Refers the question1 to the class.
		this.question1 = question1;
		// Refers the question2 to the class.
		this.question2 = question2;
		// Refers the question3 to the class.
		this.question3 = question3;
		// Refers to the totalMark of the class.
		
	}
	
	/**
	 * Creation of getQuestion1 method that returns the
	 * question1 when it is called.
	 */
	public NumericalQuestion getQuestion1() {
		
		// Returns the question1.
		return question1;
	}
	
	/**
	 * Creation of getQuestion2 method that returns the 
	 * question2 when it is called. 
	 */
	public BooleanQuestion getQuestion2() {
		
		// Returns the question2.
		return question2;
	}
	
	/**
	 * Creation of getQuestion3 method that returns the
	 * question3 when it is called.
	 */
	public MultipleChoiceQuestion getQuestion3() {
		
		// Returns the question3.
		return question3;
	
	}
	
	/**
	 * Creation of setTotalMark method that sets
	 * the the marks of all question to a variable totalMark.
	 */
	public void setTotalMark(int totalMark) {
		
		// Refers the totalMark to the class.
		this.totalMark = totalMark;
	}
	
	/**
	 * A method that is used to get the totalMark .
	 */
	public int getTotalMark() {
		
		// Returns the totalMark.
		return totalMark;
		
	}
		
		
}
