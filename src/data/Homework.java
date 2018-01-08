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

	/**
	 * Main function responsible for reading a text file and determining the
	 * students grade.
	 * 
	 * @param args
	 *            command-line arguments
	 * @throws FileNotFoundException
	 *             exception thrown if the "HW-student.txt" is not found
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner wordReader = new Scanner(new File("input/HW-student.txt"));
		
		// Array of assignment names to check for completion
		String[] assignments = { "numbersElements", "ReferenceMystery2", "jaggedArray", "mode", "longestSortedSequence",
				"ReferenceMystery3", "PointClient", "publicVsPrivate", "addTimeSpan", "getSlopeLine" };

		int count = 0;

		String missing = "";
		while (wordReader.hasNext()) {
			String current = wordReader.nextLine();
			int start = current.indexOf(":");
			for (int i = 0; i < assignments.length; i++) {
				if (current.substring(start + 2).equals(assignments[i])) {
					assignments[i] = "Check";
					break;
				}
			}
		}
		boolean t = false;
		
		for (int j = 0; j < assignments.length; j++) {
			if (assignments[j].equals("Check"))
				count += 10;
			else {
				if (t == false) {
					missing += assignments[j];
					t = true;
				} else
					missing += ", " + assignments[j];
			}
		}
		
		if (count == 100)
			System.out.println(100);
		else
			System.out.println(count + " (missing " + missing + ")");
		wordReader.close();
	}
}