package utilityPackage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class DataProvider {

	private static String[] nameDetails;

	private DataProvider() {
		// Prevent instantiation
	}

	// Made the method static to call easily anywhere in the package
	public static String[] generateEmployeeDetails() {
		String[] firstNames = {"Virat", "Rohit", "Shivam", "Shubhaman", "Suryakumar", "Pavan", "Ashwin", "Ishaan", "Shardul", "Yuzvendra"};
		String[] middleNames = {"A.", "B.", "C.", "D.", "E.", "F.", "G.", "H.", "I.", "J."};
		String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Rodriguez", "Martinez"};

		Random rand = new Random();
		int randomIndex1 = rand.nextInt(firstNames.length);
		int randomIndex2 = rand.nextInt(middleNames.length);
		int randomIndex3 = rand.nextInt(lastNames.length);

		// Create a single combination of first, middle, and last name
		String firstName = firstNames[randomIndex1];
		String middleName = middleNames[randomIndex2];
		String lastName = lastNames[randomIndex3];

		int min = 111;  // Minimum value of the range
		int max = 999;  // Maximum value of the range

		// Generate a random integer between min (inclusive) and max (inclusive)
		int randomNumber = rand.nextInt((max - min) + 1) + min;

		String employeeID = "ORN" + randomNumber;

		return new String[]{firstName, middleName, lastName, employeeID};
	}

	// Method to get the nameDetails
	public static String[] getNameDetails() {
		if (nameDetails == null) {
			nameDetails = generateEmployeeDetails(); // Generate name only once
		}
		return nameDetails;
	}

	// Optional: Method to reset the nameDetails if needed
	public static void resetNameDetails() {
		nameDetails = null;
	}

	public static String getCurrentTimeStamp(String desiredFormat) {

		//Sample Format as Argument
		//ddMMyyyy_HHmmss = 16042024_080537
		//ddMMMuuuu = 16Apr2024
		//MM/dd/yyyy = 04/16/2024

		// Get the current date and time for Dynamic File Name 
		LocalDateTime currentDateTime = LocalDateTime.now();

		// Define the date-time format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(desiredFormat);
		String currentTimeStamp = currentDateTime.format(formatter);
		return currentTimeStamp;
	}

	public static int getIntValue(int min, int max) {

		// Generate random number between min and max (inclusive)
		int randomNumber = (int)(Math.random() * (max - min + 1)) + min;

		return randomNumber;
	}

	public static int extractNumericValue(String input) {
		// Use regular expression to replace all non-numeric characters with an empty string
		String numericString = input.replaceAll("[^0-9]", ""); 

		// Convert the cleaned numeric string to an integer
		int numericValue = Integer.parseInt(numericString);

		return numericValue;

	}


//Class Brace	
}


