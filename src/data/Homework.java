package data;

import java.util.*;
import java.io.*;

/**
 * Reads an external text file (usually copied from a pdf) submitted by a
 * student to determine their homework grade. Outputs the grade the student
 * should receive and feedback of which assignments are missing.
 * 
 * Date Created: November 29, 2017
 * 
 * Update: April, 3, 2018
 * 
 * @version 1.5
 * 
 * @author Domenick DiBiase
 */
public class Homework {
	/** Instance of the Homework */
	private static Homework singlton = new Homework();

	/**
	 * Gets the instance of the Homework class
	 * 
	 * @return the instance of the Homework class
	 */
	public static Homework getInstance() {
		return singlton;
	}

	/**
	 * Grades the sudent's homework assignment by scanning the the input text (what
	 * the student submitted) for specific assignments.
	 * 
	 * @param assign
	 *            array of assignment names
	 * @throws FileNotFoundException
	 *             exception thrown if the "HW-student.txt" is not found
	 */
	public String grade(ArrayList<String> assignments, String input) {
		Scanner wordReader = new Scanner(input);
		int totalGrade = 100;
		String missing = "";

		// Scans the text input for the assignment names marking them as complete if
		// they are found
		while (wordReader.hasNext()) {
			String next = wordReader.next();
			System.out.println(next);
			System.out.println("OK");
			for (int i = 0; i < assignments.size(); i++) {
				if (next.equals(assignments.get(i))) {
					assignments.remove(i);
					break;
				}
			}
		}

		// Determines which assignments are missing and calculates the students grade
		for (int j = 0; j < assignments.size(); j++) {
			totalGrade -= 10;
			if(j ==0) {
				missing += assignments.get(j);
			} else {
				missing += ", " + assignments.get(j);
			}			
		}

		wordReader.close();

		if (totalGrade == 100)
			return "100";
		else
			return totalGrade + "   missing " + missing + "";
	}
}
