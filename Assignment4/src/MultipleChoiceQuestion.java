/**
 * Creation of MultipleChoiceQuestion class. It has three options and each one has
 * two possible values true or false. It also has a mark. Both of them are used for the mark scheme
 * and for the student's mark attempt. 
 */
public class MultipleChoiceQuestion {
	
	// Creation of field option1 of type boolean.
	private boolean option1;
	// Creation of field option2 of type boolean.
	private boolean option2;
	// Creation of field option3 of type boolean.
	private boolean option3;
	// Creation of field mark of type integer.
	private int mark;
	
	/**
	 * Creation of method MultipleChoiceQuestion that receives four parameters, option1, option2, option3
	 * of type boolean and mark of type integer.
	 */
	public MultipleChoiceQuestion(boolean option1, boolean option2, boolean option3, int mark) {
		
		// Refers the option1 to the class.
		this.option1 = option1;
		// Refers the option2 to the class.
		this.option2 = option2;
		// Refers the option3 to the class.
		this.option3 = option3;
		// Refers the mark to the class.
		this.mark = mark;
		
	}
	
	/**
	 * Creation of method getOption1 that returns the option1
	 * when it is called.
	 */
	public boolean getOption1() {
		
		// Returns the option1.
		return option1;
	}
	
	/**
	 * Creation of method getOption2 that returns the option2
	 * when it is called.
	 */
	public boolean getOption2() {
		
		// Returns the option2.
		return option2;
	}
	
	/**
	 * Creation of method getOption3 that returns the option3
	 * when it is called.
	 */
	public boolean getOption3() {
		
		// Returns the option3.
		return option3;
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
	 * Creation of method getMark that returns the mark
	 * when it is called.
	 */
	public int getMark() {
		
		// Returns the mark.
		return mark;
	}
	
}
