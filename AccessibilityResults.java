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
			Scanner fScan = new Scanner(new File(fname));
			while (fScan.hasNextLine()) {
				// Scan each line and store into an AccessibilityTest object
				String line = fScan.nextLine();
				Scanner lScan = new Scanner(line);
				// 6-length String array for storing fields of a AccessbilityTest object
				String[] testFields = new String[6];
				// ArrayList for storing string tokens of the description of a test
				ArrayList<String> descTokens = new ArrayList<>();

				int index = 0; // Keeps track of which information of the test is being processed
				while (lScan.hasNext()) {
					String token = lScan.next();
					if (index < 5) {
						// If at indexes < 5, we are parsing the first 5 fields of the test
						testFields[index] = token;
						index++;
					} else {
						// If at index 5, we are parsing the description of the test
						descTokens.add(token);
					} 
				}

				// Create and add description to the `testFields` array
				testFields[5] = String.join(" ", descTokens); // TODO: Might need to be .iterator()

				// Add AccessbilityTest object to `tests` and close line scanner
				tests.add(new AccessibilityTest(testFields));
				lScan.close();
			}

			// Wrap up by closing file scanner
			fScan.close();

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
		int count = 0;
		target = target.toLowerCase();
		// Iterate through all tests
		for (AccessibilityTest test: tests) {
			// If the test's description contains the target string, print it
			if (test.getDescription().contains(target)) {
				System.out.println(test.toString());
				count++;
			}
		}

		System.out.printf("Total tests matching: %d%n", count);
	}

	/**
	 * Takes a category (or a portion of the category) as a parameter, 
	 * and displays the test information of all tests that match (or contain) that category (should be case insensitive).
	 * Also displays the number of tests found.
	 * @param ctgr The test category to be matched
	 */
	public void showByCategory(String ctgr) {
		int count = 0;
		ctgr = ctgr.toLowerCase();

		// Iterate through all tests
		for (AccessibilityTest test: tests) {
			// If the test's category contains the target string, print it
			if (test.getCategory().contains(ctgr)) {
				System.out.println(test.toString());
				count++;
			}
		}
		
		System.out.printf("Total tests in category: %d%n", count);
	}

	/**
	 * Displays the tests that all checkers failed (i.e. a test is only shown if Google, WAVE, ASLint, and SortSite failed)
	 * and the number of tests that all failed. A failed test is the result “notfound”
	 */
	public void showAllFailed() {
		int count = 0;

		for (AccessibilityTest test: tests) {
			// Test each checker for failed result
			if (test.getGoogleResult().equals("notfound") &&
					test.getWaveResult().equals("notfound") &&
					test.getSortSiteResult().equals("notfound") &&
					test.getASLintResult().equals("notfound")) {
				System.out.println(test.toString());
				count++;
			}
		}
		
		System.out.printf("Total tests failed: %d%n", count);
	}

	/**
	 * Returns the number tests that had a result of either error or error_paid. 
	 * Works with a partial checker name or partial category name and should be case insensitive.
	 * @param checker The checker to be matched
	 * @param target The target string to be matched
	 * @return The number of tests that match both the checker and the target string
	 */
	public int numPass(String checker, String ctgr) {
		int count = 0;
		checker = checker.toLowerCase();
		ctgr = ctgr.toLowerCase();
		
		for (AccessibilityTest test: tests) {
			// Check for valid category
			if (!test.getCategory().contains(ctgr)) continue;
			
			// Choose the checker result based on the target checker string
			String checkerResult;
			if ("google".contains(checker)) {
				checkerResult = test.getGoogleResult();
			} else if ("wave".contains(checker))  {
				checkerResult = test.getWaveResult();
			} else if ("sortsite".contains(checker))  {
				checkerResult = test.getSortSiteResult();
			} else if ("aslint".contains(checker)) {
				checkerResult = test.getASLintResult();
			} else {
				continue;
			}
			
			// Check if the result of the selected checker passes
			// A result passes when it is "error" or "error_paid"
			if (checkerResult.equals("error") || checkerResult.equals("error_paid")) {
				count++;
			}
		}
		
		return count;
	}
}
