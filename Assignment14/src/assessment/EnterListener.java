package assessment;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JTextField;

public class EnterListener implements KeyListener{
	
	private TextObserver currObserver; // Private Model, String, and JTextField fields.
	private String text;
	private JTextField field;
	
	
	/*
	 * Constructor to instantiate the supplied model and JTextField.
	 */
	public EnterListener(TextObserver modelObj, JTextField jtF) {
		
		currObserver = modelObj;
		field = jtF;
		
		
		
		
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 * If the keycode of the current KeyEvent is Enter, grab the text from field, and update the Model.
	 */
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			text = field.getText();
			currObserver.enterPressed(text);	
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
