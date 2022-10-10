package accessibility;

public class AccessibilityTest {
	/**
	 * Private fields for information about an accessibility test
	 */
	private String category;
	private String google;
	private String wave;
	private String sortsite;
	private String aslint;
	private String description;

	/**
	 * Constructor for an AccessibilityTest object
	 * @param cat category of the test
	 * @param gg google result
	 * @param wv wave result 
	 * @param ss sortsite result
	 * @param asl aslint result
	 * @param desc description of the test
	 */
	public AccessibilityTest(String cat, String gg, String wv, String ss, String asl, String desc) {
		this.category = cat;
		this.google = gg;
		this.wave = wv;
		this.sortsite = ss;
		this.aslint = asl;
		this.description = desc;
	}

	/**
	 * Getter for the category of the test
	 * @return a String of the private category field
	 */
	public String getCategory() {
		return this.category;
	}

	/**
	 * Getter for the Google result of the test
	 * @return a String of the private google field
	 */
	public String getGoogleResult() {
		return this.google;
	}

	/**
	 * Getter for the WAVE result of the test
	 * @return a String of the private wave field
	 */
	public String getWaveResult() {
		return this.wave;
	}

	/**
	 * Getter for the SortSite result of the test
	 * @return a String of the private sortsite field
	 */
	public String getSortSiteResult() {
		return this.sortsite;
	}

	/**
	 * Getter for the ASLint result of the test
	 * @return a String of the private aslint field
	 */
	public String getASLintResult() {
		return this.aslint;
	}

	/**
	 * Getter for the description of the test
	 * @return a String of the private description field
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Returns a string of a readable format of the results of the test
	 */
	@Override
	public String toString() {
		return String.format(
				"Accessbility Test:%nTest Category: %s%nGoogle result: %s%nWAVE result: %s%nSort-Site result: %s%nASLint result: %s%nTest Description: %s%n",
				this.category,
				this.google,
				this.wave,
				this.sortsite,
				this.aslint,
				this.description
		);
	}
}
