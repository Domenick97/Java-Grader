package data;

import java.util.*;
import java.io.*;

/**
 * Reads an external text file (usually copied from a pdf) submitted by a
 * student to determine their homework grade. Outputs the grade the student
 * should receive and feedback of which assignments are missing.
 * 
 * 
 * @author Domenick DiBiase
 *
 */
public class Homework {
	/** Instance of the Homework */
	private static Homework singlton = new Homework();

	/**
	 * Gets the instance of the
	 * 
	 * @return the instance of the Derivative
	 */
	public static Homework getInstance() {
		return singlton;
	}

	/**
	 * Main function responsible for reading a text file and determining the
	 * students grade.
	 * 
	 * @param assign
	 *            array of assignment names
	 * @throws FileNotFoundException
	 *             exception thrown if the "HW-student.txt" is not found
	 */
	public String grade(String[] assignments, String input) {
		Scanner wordReader = new Scanner(input);
		int count = 0;
		String missing = "";

		// Scans the text input for the assignment names marking them as complete if
		// they are found
		while (wordReader.hasNext()) {
			String next = wordReader.next();
			for (int i = 0; i < assignments.length; i++) {
				if (next.equals(assignments[i])) {
					assignments[i] = "Check";
					break;
				}
			}
		}

		// Boolean for first assignment
		boolean t = false;

		// Determines which assignments are missing and calculates the students grade
		for (int j = 0; j < assignments.length; j++) {
			if (assignments[j].equals("Check"))
				count += 10;
			else {
				assignments[j] = assignments[j].trim();
				
				if (t == false && assignments[j] != null && assignments[j].length() != 0) {
					missing += assignments[j];
					t = true;
					
				} else if(assignments[j] != null && assignments[j].length() != 0) {
					missing += ", " + assignments[j];
				}
			}
		}

		wordReader.close();

		if (count == 100)
			return "100";
		else
			return count + "   missing " + missing + "";
	}
}
