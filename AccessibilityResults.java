package accessibility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AccessibilityResults {

	/**
	 * Private field for storing tests that have been read in the constructor
	 */
	private ArrayList<AccessibilityTest> tests = new ArrayList<>();
	
	/**
	 * Constructor of an AccessbilityResults object
	 * This method reads the file with file name fname,
	 * and stores information in an array of AccessbilityTest objects.
	 */
	public AccessibilityResults(String fname) {
		try {
			Scanner fscan = new Scanner(new File(fname));
			
		} catch (FileNotFoundException e) {
			System.out.printf("File %s not found. Please try again!%n", fname);
		}
	}
	
	/**
	 * @return the number of tests in this AccessbilityResults object
	 */
	public int numTests() {
		return tests.size();
	}
	
	/**
	 * Takes test details (or a portion of the test details) as a parameter, 
	 * and displays the test information of all tests that match (or contain) that detail (should be case insensitive).
	 * Also displays the number of tests found.
	 * @param target The test detail string to be matched
	 */
	public void showTestResults(String target) {
		
	}
	
	/**
	 * Takes a category (or a portion of the category) as a parameter, 
	 * and displays the test information of all tests that match (or contain) that category (should be case insensitive).
	 * Also displays the number of tests found.
	 * @param ctgr The test category to be matched
	 */
	public void showByCategory(String ctgr) {
		
	}
	
	/**
	 * Displays the tests that all checkers failed (i.e. a test is only shown if Google, WAVE, ASLint, and SortSite failed)
	 * and the number of tests that all failed. A failed test is the result “notfound”
	 */
	public void showAllFailed() {
		
	}
	
	/**
	 * Returns the number tests that had a result of either error or error_paid. 
	 * Works with a partial checker name or partial category name and should be case insensitive.
	 * @param checker The checker to be matched
	 * @param target The target string to be matched
	 * @return The number of tests that match both the checker and the target string
	 */
	public int numPass(String checker, String target) {
		return 0;
	}
}
