package assessment;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame implements Observer {

	// CREATE ALL PRIVATE GUI OBJECTS AND BUFFEREDWRITER OBJECTS.
	private TextObserver textObsv;
	private JPanel mainPanel;
	private JPanel calendarPanel;
	private static DefaultListModel<String> calendarModel;
	private JList jlCenterCalendar;
	public static DefaultListModel<String> reminderModel;
	private JPanel reminderPanel;
	private JList jlCenterReminder;
	private JTabbedPane jtpNorth;
	private JTextField jtfSouth;
	private static String calendarFile;
	private static String reminderFile;
	private static BufferedWriter remindWriter;
	private static BufferedWriter calendarWriter;
	private static BufferedWriter deleterWriter;
	private static BufferedWriter deletecWriter;
		
	/*
	 * Constructor to initialize all widgets and writers in the main GUI.
	 */
	public GUI(TextObserver textObsv) throws IOException { // Construct the GUI object.
		super("");
		setPreferredSize(new Dimension(800,500));
		setTitle("Event Planner");
		this.textObsv = textObsv;
		this.textObsv.addObserver(this);
		setDefaultCloseOperation(HIDE_ON_CLOSE); // Set to HIDE_ON_CLOSE rather than EXIT_ON_CLOSE. This enables us to quickly read and save from the JList when the user closes the program.
		
		calendarFile = "src/assessment/calendarFile"; // Create references to our two save files.
		reminderFile = "src/assessment/reminderFile";
		
		remindWriter = new BufferedWriter(new FileWriter(reminderFile, true)); // Initialize two BufferedWriters to enable them to write into the files.
		calendarWriter = new BufferedWriter(new FileWriter(calendarFile, true));

		
		
		// CONSTRUCT GUI
		mainPanel = new JPanel(new BorderLayout());

		calendarPanel = new JPanel(new BorderLayout());

		calendarModel = new DefaultListModel();
		jlCenterCalendar = new JList(calendarModel);
		calendarPanel.add(jlCenterCalendar, BorderLayout.CENTER);

		reminderModel = new DefaultListModel();
		reminderPanel = new JPanel(new BorderLayout());
		jlCenterReminder = new JList(reminderModel);
		jlCenterReminder.setLayoutOrientation(JList.VERTICAL);
		reminderPanel.add(jlCenterReminder, BorderLayout.CENTER);
		
		
		readFromFile(calendarFile); // Call the readFromFile method on both files.
		readFromFile(reminderFile);
		
		deleterWriter = new BufferedWriter(new FileWriter(reminderFile)); // Then, clear the files to prevent accidentally having duplicate additions.
		deletecWriter = new BufferedWriter(new FileWriter(calendarFile));
		deleterWriter.close();
		deletecWriter.close();

		jtpNorth = new JTabbedPane();
		jtpNorth.addTab("Calendar", calendarPanel);
		jtpNorth.addTab("Reminder", reminderPanel);

		mainPanel.add(jtpNorth, BorderLayout.CENTER);
		jtfSouth = new JTextField();
		jtfSouth.addKeyListener(new EnterListener(textObsv, jtfSouth));

		ClickListener clListen = new ClickListener(textObsv);
		jlCenterCalendar.addMouseListener(clListen);
		jlCenterReminder.addMouseListener(clListen);

		mainPanel.add(jtfSouth, BorderLayout.SOUTH);

		add(mainPanel);
		pack();
		setVisible(true);

	}

	public static void main(String[] args) throws IOException {
		GUI gui = new GUI(new TextObserver()); // Create the new GUI object.
		
		gui.addComponentListener(new ComponentAdapter() { 
			public void componentHidden(ComponentEvent e) // When the GUI is hidden, 
			{
				for(int i = 0; i < reminderModel.getSize(); i++) // Iterate through reminderModel
				{
					try {
						remindWriter.write(reminderModel.getElementAt(i)); // Write each line of reminderModel back to the reminderFile file.
						remindWriter.newLine();
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				try {
					remindWriter.close(); // Close the remindWriter BufferedWriter.
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				for(int i = 0; i < calendarModel.getSize(); i++) // Iterate through calendarModel
				{

					try {
						calendarWriter.write(calendarModel.getElementAt(i)); // Write each line of calendarModel back to the calendarFile file.
						calendarWriter.newLine();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace(); 
					}
					
				}
				try {
					calendarWriter.close(); // Close the calendarWriter BufferedWriter.
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 * Update method to update text in both lists.
	 */
	public void update(Observable object1, Object object2) {

		if (textObsv.getKeyStatus()) { // If Enter key has been pressed
			if (textObsv.getRemindInput()) {
				reminderModel.addElement(textObsv.getReminderText()); // Add model reminderText to reminderModel, switch to that pane, and reset model text.
				
				jtpNorth.setSelectedIndex(1);
				textObsv.resetRemindInput();
			}
			else {
				int check = jtpNorth.getSelectedIndex(); // Get current index of the pane.

				if (check == 0) {
					calendarModel.addElement(textObsv.getEvent().getOutput()); // If 0, add to calendar
				} else if (check == 1) { // If 1, check if the textbox contains "remind me to"
					if(jtfSouth.getText().contains("[Rr]emind me to"))
					{
						reminderModel.addElement(jtfSouth.getText()); // If it does then add to reminderModel
						
					}
					
					else
					{
						
						
						jtpNorth.setSelectedIndex(0); // If it doesn't then add to calendarModel
					}
				}
						
				 else {
					System.out.println("You have not selected a pane."); // If no pane is selected
				}
			}
			textObsv.resetEnterButton(); // Reset enter button and set textfield text to blank.
			jtfSouth.setText("");
		}

		if (textObsv.getDoubleClick()) { // If the user has double clicked

			int check = jtpNorth.getSelectedIndex();

			if (check == 0) { // Check the currently selected pane
				int index = jlCenterCalendar.getSelectedIndex(); // Remove the selected index from the JList.
				calendarModel.remove(index);
			} else if (check == 1) {
				int index = jlCenterReminder.getSelectedIndex();
				reminderModel.remove(index);
			}

		}

		textObsv.resetDoubleClick(); // Reset the model's doubleClick boolean field.
	}
	
	/*
	 * Method to read from calendarFile and reminderFile and add respectively into JList.
	 */
	public void readFromFile(String file) throws IOException {
		
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			if (file.equals(calendarFile)){
				while ((line = reader.readLine()) != null) {
					calendarModel.addElement(line); // add to calendarModel
				}
			} 
			if (file.equals(reminderFile)) {
				while ((line = reader.readLine()) != null) {
					reminderModel.addElement(line); // add to reminderModel
				}
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
