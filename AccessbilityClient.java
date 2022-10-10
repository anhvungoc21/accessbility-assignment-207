package accessibility;

public class AccessbilityClient {

	public static void main(String[] args) {
		// AccessibilityResults object for testing the given file
		AccessibilityResults a11y = new AccessibilityResults("a11yCheckersResults.txt");

		// Test for the showTestResults method
		a11y.showTestResults("Colour"); // 5 total

		// Tests for the showByCategory method
		a11y.showByCategory("keyboard"); // 16 total
		a11y.showByCategory("key"); // 16 total

		// Test for the showAllFailed method
		a11y.showAllFailed(); // 51 total

		// Tests for the numPass method
		System.out.println(a11y.numPass("Goog", "")); // 23 
		System.out.println(a11y.numPass("lint", "htm")); // 2
	}
}
