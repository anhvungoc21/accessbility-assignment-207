package accessibility;

/*
Names of all authors: Anh Vu
Assignment name: Assignment 3
Assignment due date: October 10, 2022
Written/online sources used: None
Help obtained: None
I confirm that the above list of sources is complete AND that I have not talked to
anyone else (e.g., CSC 207 students) about the solution to this problem
*/

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
		
		// Code used for populating the report table
//		String[] categories  = {"content", "layout", "colour/contrast", "typography", "language", "title", "headings", "lists", "tables",
//				"images", "multimedia", "links", "buttons", "forms", "navigation", "keyboard", "frames", "css", "html", ""};
//		
//		for (String category: categories) {
//			System.out.println(category);
//			System.out.println(a11y.numPass("google", category));
//			System.out.println(a11y.numPass("wave", category));
//			System.out.println(a11y.numPass("sortsite", category));
//			System.out.println(a11y.numPass("aslint", category));
//			a11y.showByCategory(category);
//			System.out.println("----------");
//		}
	}
}
