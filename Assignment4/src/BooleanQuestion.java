/**
 * Creation of BooleanQuestion class. It has one answer of two possible values
 * true or false. It also has a mark. Both of them are used for the mark scheme
 * and for the student's mark attempt. 
 */
public class BooleanQuestion {
	
	// Creation of field answer of type boolean.
	private boolean answer;
	// Creation of field mark of type integer.
	private int mark;
	
	/**
	 * Creation of constructor BooleanQuestion that receives two parameters, the answer and the mark
	 * of type boolean and integer respectively.
	 */
	public BooleanQuestion(boolean answer, int mark) {
		
		// Refers the answer variable to the class.
		this.answer = answer;
		// Refers the mark variable to the class.
		this.mark = mark;
		
	}
	
	/**
	 * Creation of method setMark that is used to store
	 * the mark of the question 
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
	public boolean getAnswer() {
		
		// Returns the answer.
		return answer;
	}

}
