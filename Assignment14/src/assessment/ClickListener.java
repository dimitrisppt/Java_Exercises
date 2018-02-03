package assessment;

import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.event.MouseInputListener;

public class ClickListener implements MouseInputListener {
	
	private TextObserver clickObsv; // Private instance of model.

	/*
	 * Constructor to set model reference.
	 */
	public ClickListener(TextObserver textObsv)
	{
		clickObsv = textObsv;
	}
	@Override
	/*
	 * (non-Javadoc)
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 * On click, check if doubleclick. If clickcount equals 2, then alert the model.
	 * This is the only mouse method that needs to be overriden.
	 */
	public void mouseClicked(MouseEvent arg0) {
		JList list = (JList)arg0.getSource();
		if (arg0.getClickCount() == 2) {
			
			clickObsv.doubleClicked();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
