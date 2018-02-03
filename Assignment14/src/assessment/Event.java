package assessment;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Event {

	private String contents; // String values for total contents, final output, and sub-parts.
	private String event = "-";
	private String date = "-";
	private String time = "-";
	private String location = "-";
	private String output;

	// Pattern list.
	private static Pattern dayPattern;
	private static Pattern dayAndDatePattern;
	private static Pattern dateTwo;

	private static Pattern timePatternOne;
	private static Pattern timePatternTwo;
	private static Pattern timePatternThree;
	private static Pattern timePatternFour;
	private static Pattern timePatternFive;

	private static Pattern datePatternOne;
	private static Pattern datePatternTwo;
	private static Pattern datePatternThree;
	private static Pattern datePatternFour;

	public Event(String input) {
		contents = input; // Set contents String field to input.
		
		// COMPILE ALL REGEX PATTERNS.
		dayPattern = Pattern.compile("([Mm]on|[Tt]ues|[Ww]ednes|[Tt]hurs|[Ff]ri|[Ss]atur|[Ss]un)day");
		dateTwo = Pattern.compile("(\\d{1,2}/){2}\\d{1,4}");

		timePatternOne = Pattern.compile("(([0]?[1-9]|[1][0-2]?))\\s?pm");
		timePatternTwo = Pattern.compile("(([0]?[1-9]|[1][0-2]?))\\s?am");
		timePatternThree = Pattern.compile("^(\\d|[01]\\d|2[0-3]):[0-5]\\d");
		timePatternFour = Pattern.compile("[Ii]n\\s[Tt]he\\s[Mm]orning");
		timePatternFive = Pattern.compile("[Ii]n\\s[Tt]he\\s[Ee]vening");

		datePatternOne = Pattern.compile(
				"([Mm]on|[Tt]ues|[Ww]ednes|[Tt]hurs|[Ff]ri|[Ss]atur|[Ss]un)day \\d?\\d(st|nd|rd|th) (([Jj]anu|[Ff]ebru)ary|[Mm]arch|[Aa]pril|[Mm]ay|[Jj]u(ne|ly)|[Aa]ugust|([Ss]eptem|[Oo]cto|[Nn]ovem|[Dd]ecem)ber)");
		datePatternTwo = Pattern.compile("(\\d{1,2}/){2}\\d{1,4}");
		datePatternThree = Pattern.compile("([Oo]n\\s[Mm]on|[Tt]ues|[Ww]ednes|[Tt]hurs|[Ff]ri|[Ss]atur|[Ss]un)day");
		datePatternFour = Pattern.compile("([Nn]ext\\s[Mm]on|[Tt]ues|[Ww]ednes|[Tt]hurs|[Ff]ri|[Ss]atur|[Ss]un)day");

		// ALL PATTERN COMPILATION ABOVE HERE.


		separateParts(); // Call separateParts method to divide the input String into the four sub sections.
		output = "Event: " + event + " | " + "Date: " + date + " | " + "Time: " + time + " | " + "Location: " // Construct final output.
				+ location;

	}

	/*
	 * Method to extract location from input String.
	 */
	private void extractLoc(String input) {
		String locInput = input.substring(0, 1).toUpperCase() + input.substring(1); // Upper case the first character of the string.
		location = locInput; // Set location.
	}

	/*
	 * Method to extract time from input String.
	 */
	private void extractTime(String input) {
		Matcher m1 = timePatternOne.matcher(input); // Construct all Matcher objects.
		Matcher m2 = timePatternTwo.matcher(input);
		Matcher m3 = timePatternThree.matcher(input);
		Matcher m4 = timePatternFour.matcher(input);
		Matcher m5 = timePatternFive.matcher(input);

		if (m1.find()) { // If matcher 1 finds a match, 
			if (input.equals("12pm")) { // If 12 o'clock, replace pm with :00
				input = input.replace("pm", ":00");
			} else {
				if (input.length() == 4) { // If there are 4 characters, substring to just first two.
					input = input.substring(0, 2);
				} else if (input.length() == 3) { // If 3, just substring first one.
					input = input.substring(0, 1);
				}
				int tempInput = Integer.parseInt(input) + 12; // Add twelve to put in 24 hour format.
				input = tempInput + ":00";
			}
		} else if (m2.find()) { // If matcher 2 finds a match,
			if (input.equals("12am")) { // Check for 12, and replace with 00:00
				input = input.replace("12am", "00:00");

			} else {

				input = input.replace("am", ":00"); // Else simply replace am with :00
				input = "0" + input;
			}
		} else if (m3.find()) { // If matcher 3 finds a match, do nothing.

		} else if (m4.find()) { // If matcher 4 finds a match, input = 9am
			input = "09:00";
		} else if (m5.find()) { // If matcher 5 finds a match, input = 8pm

			input = "20:00";
		}

		time = input; // Update time.
	}

	/*
	 * Method to extract date from input String.
	 */
	private void extractDate(String input) {
		Matcher m1 = datePatternOne.matcher(input); // Construct 3 Matcher objects.
		Matcher m2 = datePatternTwo.matcher(input);
		Matcher m3 = datePatternThree.matcher(input);
		

		if (m1.find()) { // If matcher 1 matches, do nothing.
			date = input;
		} else if (m2.find()) { // If matcher 2 matches, convert into date format specified in brief.
			String[] temp = input.split("/");
			int year = 0;
			int month = 0;
			int day = 0;
			String addDay = "";
			for (int i = 0; i < temp.length; i++) {
				if (i == 0) {
					if (temp[i].substring(0, 1).equals("0")) {
						temp[i] = temp[i].substring(1);
					}
					day = Integer.parseInt(temp[i]);
					addDay = addPrefix(day);
					}
				else if (i == 1)
					month = Integer.parseInt(temp[i]);
				else if (i == 2)
					year = Integer.parseInt(temp[i]);
			}
			
			Date curr = new Date(year, month, day); // This constructor has been deprecated. Noted for future assignments.
			SimpleDateFormat simpleDate = new SimpleDateFormat("EEEE");
			String finalDay = simpleDate.format(curr); // Format our constructed Date.

			String monthString = new DateFormatSymbols().getMonths()[month - 1]; 

			date = finalDay + " " + addDay + " " + monthString; // Construct final date String.

		} else if (m3.find()) { // If matcher 3 matches, get the next occurence of the specified day of week.
			Calendar Calendar1 = Calendar.getInstance();
			System.out.println(input);
			if (input.equals("monday") || input.equals("Monday")) {
				int offset = Calendar.MONDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset +=7;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);

			} else if (input.equals("Tuesday") || input.equals("tuesday")) {
				int offset = Calendar.TUESDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset += 7;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);
			}else if (input.equals("Wednesday") || input.equals("wednesday")) {
				System.out.println("Its a wednesday!");
				int offset = Calendar.WEDNESDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset+= 7;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);
			}else if (input.equals("thursday") || input.equals("Thursday")) {
				int offset = Calendar.THURSDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset +=7;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);


			}else if (input.equals("Friday") ||input.equals("friday")) {
				int offset = Calendar.FRIDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset += 7;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);


			}else if (input.equals("Saturday") || input.equals("saturday")) {
				int offset = Calendar.SATURDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset += 7;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);

			}else if (input.equals("Sunday") || input.equals("sunday")) {
				int offset = Calendar.SUNDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset +=7;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);

			}
			
			String newDay = addPrefix(Calendar1.get(Calendar.DAY_OF_MONTH)); // Add necessary prefix to our day.
			String newMonth = convertMonth(Calendar1.get(Calendar.MONTH)); // Convert the int return from Calendar1.get() to a month String.
			newMonth = newMonth.substring(0,1).toUpperCase() + newMonth.substring(1);
			input = input.substring(0, 1).toUpperCase() + input.substring(1);
			date = input + " " +  newDay + " " + newMonth; // Construct final date String.
		} 
			

		

	}
	
	/*
	 * If the user has specified a "Next" date, then do the same as Matcher 3 above, except add an extra 7 days when calculating the offset.
	 */
	public void extractNextDate(String input)
	{
		Matcher m4 = datePatternFour.matcher(input);
		if (m4.find()) {
			System.out.println("NEXTNEXTNEXT");
			Calendar Calendar1 = Calendar.getInstance();
			System.out.println(input);
			if (input.equals("Monday") || input.equals("monday")) {
				int offset = Calendar.MONDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset +=14;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);

			} else if (input.equals("Tuesday") || input.equals("tuesday")) {
				int offset = Calendar.TUESDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset += 14;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);
			}else if (input.equals("Wednesday") || input.equals("wednesday")) {
				System.out.println("Its a wednesday!");
				int offset = Calendar.WEDNESDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset+= 14;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);
			}else if (input.equals("thursday") || input.equals("Thursday")) {
				int offset = Calendar.THURSDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset +=14;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);


			}else if (input.equals("Friday") ||input.equals("friday")) {
				int offset = Calendar.FRIDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset += 14;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);


			}else if (input.equals("Saturday") || input.equals("saturday")) {
				int offset = Calendar.SATURDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset += 14;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);

			}else if (input.equals("Sunday") || input.equals("sunday")) {
				int offset = Calendar.SUNDAY - Calendar1.get(Calendar.DAY_OF_WEEK);
				if(offset <= 0)
				{
					offset +=14;
				}
				Calendar1.add(Calendar.DAY_OF_MONTH, offset);

			}
			String newDay = addPrefix(Calendar1.get(Calendar.DAY_OF_MONTH)); // The same as in Matcher 3 find().
			String newMonth = convertMonth(Calendar1.get(Calendar.MONTH));
			newMonth = newMonth.substring(0,1).toUpperCase() + newMonth.substring(1);
			input = input.substring(0, 1).toUpperCase() + input.substring(1);
			date = input + " " +  newDay + " " + newMonth;

		}
	}

	

	/*
	 * Method to extract event from input String.
	 */
	private void extractEvent(String input) {

		while (input.substring(0, 1).equals(" ")) { // Get rid of blank spaces.

			input = input.substring(1);

			input = input.substring(0, 1).toUpperCase() + input.substring(1);

		}
		input = input.substring(0, 1).toUpperCase() + input.substring(1);
		event = input; // Update event.

	}

	/*
	 * Seperate the supplied contents String into parts and call the necessary extract() methods on those parts.
	 */
	public void separateParts() {
		if (contents.contains("At") || contents.contains("at")) { // If contents contains At
			String[] temp = contents.split(" "); // Split the string and iterate through.
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].equals("At") || temp[i].equals("at")) {
					contents = contents.replaceFirst("At", ""); // Get rid of At in the string
					contents = contents.replaceFirst("at", "");
					if (temp[i + 1].matches(".*\\d+.*")) { // If the following word contains a number, it is a time.
						extractTime(temp[i + 1]); // Call extractTime
						contents = contents.replaceFirst(temp[i + 1], "");
					} else { // If the following word does not contain a number, it is a location.
						extractLoc(temp[i + 1]); // Call extractLoc
						contents = contents.replaceFirst(temp[i + 1], "");
					}
				}
			}

		}
		if (contents.contains("on") || contents.contains("On")) { // If contents contains On

			String[] temp = contents.split(" "); // Split the string and iterate through.
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].equals("On") || temp[i].equals("on")) {
					Matcher m1 = datePatternThree.matcher(temp[i + 1]); // Create three matchers.
					Matcher m2 = datePatternFour.matcher(temp[i + 1]);
					Matcher m3 = datePatternTwo.matcher(temp[i + 1]);
					if (m1.find()) {
						if(i < temp.length - 2) // To make sure we will not look beyond the end of the split array
						{
							String testString = temp[i + 1] + " " + temp[i + 2] + " " + temp[i + 3]; // In cases of (On Wednesday 3rd March)
							Matcher testMatch = datePatternOne.matcher(testString);
							if (testMatch.find()) { // If we are in that particular format,
								if (testMatch.find()) { // extractDate on testString.
									extractDate(testString);
									contents = contents.replaceFirst(testString, "");
									contents = contents.replaceFirst("On", "");
									contents = contents.replaceFirst("on", "");
										
								} else { // If not, extractDate on just the next word.
									extractDate(temp[i + 1]);
									contents = contents.replaceFirst(temp[i + 1], "");
									contents = contents.replaceFirst("On", "");
									contents = contents.replaceFirst("on", "");
								}
							}
							
						}
						else { // If not, extractDate on just the next word.
							extractDate(temp[i + 1]);
							contents = contents.replaceFirst(temp[i + 1], "");
							contents = contents.replaceFirst("On", "");
							contents = contents.replaceFirst("on", "");
		
						
						}
						

					} 
					else if (m3.find()) { // If matcher 3 matches, extractDate() on the next word.
						extractDate(temp[i + 1]);
						contents = contents.replaceFirst(temp[i + 1], "");
						contents = contents.replaceFirst("On", "");
						contents = contents.replaceFirst("on", "");
					}
				}
			}

		}
		if (contents.contains("next") || contents.contains("Next")) { // If contents contains Next

			String[] temp = contents.split(" "); // Split the string and iterate through.
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].equals("Next") || temp[i].equals("next")) {
					Matcher m1 = datePatternFour.matcher(temp[i+1]); // Construct matcher, and compare as before.
					if (m1.find()) {
						extractNextDate(temp[i + 1]); // This time, call extractNextDate() on the next word.
						contents = contents.replaceFirst("Next", "");
						contents = contents.replaceFirst("next", "");
						contents = contents.replaceFirst(temp[i + 1], "");
					}
				}
			}

		}
		if (contents.contains("In the morning") || contents.contains("in the morning")) { // If contents contains (in the morning), extractTime on that phrase and delete it.
			extractTime("In the morning");
			contents = contents.replaceFirst("In the morning", "");
			contents = contents.replaceFirst("in the morning", "");
		}
		if (contents.contains("In the evening") || contents.contains("in the evening")) { // If contents contains (in the evening), extractTime on that phrase and delete it.
			extractTime("In the evening");
			contents = contents.replaceFirst("In the evening", "");
			contents = contents.replaceFirst("in the evening", "");
		}
		extractEvent(contents.trim());

	}
	
	/*
	 * Method to add a prefix to an int depending on number.
	 */
	public String addPrefix(int input) {
		int day = input;
		String addDay;
		if (day == 1) {
			addDay = Integer.toString(day) + "st";
			return addDay;
		} else if (day == 2) {
			addDay = Integer.toString(day) + "nd";
			return addDay;
		} else if (day == 3) {
			addDay = Integer.toString(day) + "rd";
			return addDay;
		} else if (day >= 4 && day <= 31) {
			addDay = Integer.toString(day) + "th";
			return addDay;
		} else {
			return null;
		}
	}
	
	/*
	 * Method to convert an int to a String representing its corresponding month.
	 */
	public String convertMonth(int month) {
		if(month == 0){
			return "January";
		} else if(month == 1){
			return "February";
		} else if(month == 2){
			return "March";
		} else if(month == 3){
			return "April";
		}else if(month == 4){
			return "May";
		} else if(month == 5){
			return "June";
		} else if(month == 6){
			return "July";
		}else if(month == 7){
			return "August";
		} else if(month == 8){
			return "September";
		} else if(month == 9){
			return "October";
		}else if(month == 10){
			return "November";
		} else if(month == 11){
			return "December";
		}
		return null;
	}


	/*
	 * Helper method to return completed output.
	 */
	public String getOutput() {
		return output;
	}



}
