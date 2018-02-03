package assessment;

import java.util.Observable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextObserver extends Observable {
	
	private boolean enterPressed; // 3 Boolean values to coordinate event handling. 
	private boolean doubleClick;
	private boolean isRemindInput;
	private String input; // input String field to track current text being added.
	private Pattern remindPattern; // REGEX to determine if reminder or calendar text, along with return String (remind) or Event (returnEvent).
	private Matcher remindMatcher;
	private String reminderText;
	private Event returnEvent;
	
	/*
	 * Constructor to set values for booleans and compile reminder REGEX.
	 */
	public TextObserver()
	{
		enterPressed = false;
		doubleClick = false;
		remindPattern = Pattern.compile("[Rr]emind\\sme\\sto\\s.*");
		isRemindInput = false;
		
	}
	
	/*
	 * Helper method to return enterPressed boolean field.
	 */
	public boolean getKeyStatus(){
		return enterPressed;
	}
	
	
	/*
	 * Method to determine whether or not inputText should be processed into the Reminder pane or the Calendar pane.
	 */
	public void enterPressed(String inputText)
	{
		remindMatcher = remindPattern.matcher(inputText); // Set matcher.
		if(remindMatcher.find()) // If remindMatcher matches with anything
		{
			String info = remindMatcher.group();
			isRemindInput = true; // Set isRemindInput boolean field to true.
			inputText = inputText.replace("Remind me to ", ""); // Delete the opening "remind me to" 
			inputText = inputText.replace("remind me to ", "");
			inputText = inputText.substring(0,1).toUpperCase() + inputText.substring(1);
			reminderText = inputText;	// Update reminderText.
		}
		else // If the "remind me to" REGEX does not match, this is an actual event.
		{
			Event current = new Event(inputText); // Create a new event, passing in inputText, and setting it equal to returnEvent.
			returnEvent = current;
		}
		
		
		
		enterPressed = true; // Set enterPressed, and update observers.
		setChanged();
		notifyObservers();
	}
	
	/*
	 * Helper method to reset enterPressed when released.
	 */
	public void resetEnterButton()
	{
		enterPressed = false;
	}
	
	/*
	 * Helper method to set doubleClicked and update observers.
	 */
	public void doubleClicked()
	{
		doubleClick = true;
		setChanged();
		notifyObservers();
	}
	
	/*
	 * Helper method to return doubleClick boolean field.
	 */
	public boolean getDoubleClick(){
		return doubleClick;
	}
	
	/*
	 * Helper method to reset doubleClick boolean field.
	 */
	public void resetDoubleClick() {
		doubleClick = false;
	}
	
	/*
	 * Helper method to return isRemindInput boolean field.
	 */
	public boolean getRemindInput()
	{
		return isRemindInput;
	}
	
	/*
	 * Helper method to reset isRemindInput boolean field.
	 */
	public void resetRemindInput()
	{
		isRemindInput = false;
	}
	
	/*
	 * Helper method to return reminderText boolean field.
	 */
	public String getReminderText()
	{
		return reminderText;
	}
	
	/*
	 * Helper method to return returnEvent boolean field.
	 */
	public Event getEvent()
	{
		return returnEvent;
	}

}
