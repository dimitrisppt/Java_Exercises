/**
 * Creation of the NumericalQuestion class. It has one answer and one mark
 * that are used for the mark scheme and for the student's attempt.
 */
public class NumericalQuestion {
	
	// Creation of field answer of type integer.
	private int answer;
	// Creation of field mark of type integer.
	private int mark;
	
	/**
	 * Creation of constructor NumericalQuestion that receives two parameters, answer and mark of type integer.
	 */
	public NumericalQuestion(int answer, int mark){
		
		// Refers the answer variable to the class.
		this.answer = answer;
		// Refers the mark variable to the class.
		this.mark = mark;
		
	}
	
	/**
	 * Creation of method setMark that is used to store
	 * the mark of each question 
	 */
	public void setMark(int mark) {
		
		// Refers the mark to the class.
		this.mark = mark;
	}
	
	/**
	 * Creation of method getMark that returns the mark variable
	 * when it is called.
	 */
	public int getMark() {
		
		// Returns the mark.
		return mark;
	}
	
	/**
	 * Creation of method getAnswer that returns the answer
	 * when it is called.
	 */
	public int getAnswer() {
		
		// Returns the answer.
		return answer;
	}
}
