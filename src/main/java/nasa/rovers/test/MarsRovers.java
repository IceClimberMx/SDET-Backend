package nasa.rovers.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import restassured.TestBase;

/**
 *
 * MarsRovers class contains the 4 tests that will retrieve URL and display
 * images from the Curiosity rover.
 *
 */

public class MarsRovers extends TestBase {

	private final String EARTH_DATE = "2015-05-30";
	private final int SOL_DATE_1000 = 1000;

	/**
	 *
	 * This test will compare the first 10 photos that Curiosity took with a given
	 * Sol and Earth date. date.
	 *
	 */

	@Test(description = "Retrieve and compare the first 10 Mars photos made by Curiosity on 1000 sol and on Earth date equal to 1000 Martian sol.")
	public void comparePhotosWithSolAndEarth() {

		List<String> SolDate = this.getcuriosityPhotos(this.SOL_DATE_1000, 10);
		List<String> EarthDate = this.getcuriosityPhotos(this.EARTH_DATE, 10);

		Assert.assertEquals(SolDate.size(), EarthDate.size());

		for (int i = 0; i < SolDate.size(); i++) {
			System.out.println("Photo #: " + i + " Photo with sol date: " + SolDate.get(i) + " Photo with Earth Date: "
					+ EarthDate.get(i));
		}

	}

	/**
	 *
	 * This test will validate that the sum of Spirit and Opportunity photos times
	 * 10 will not be larger than the amount of photos curiosity has for a given
	 * date.
	 *
	 */

	@Test(description = "Validate that the amounts of pictures that each Curiosity camera took on 1000 Mars sol is not greater than 10 times the amount taken by other cameras on the same date.")
	public void compareRovers() {

		Assert.assertEquals(this.getcuriosityPhotos(this.SOL_DATE_1000, 0)
				.size() < (this.getOpportunityPhotos(this.SOL_DATE_1000, 0).size()
						+ this.getSpiritPhotos(this.SOL_DATE_1000, 0).size()) * 10,
				false);
	}

	/**
	 *
	 * This test will retrieve the first 10 Martian photos from curiosity on a given
	 * earth date date.
	 *
	 */

	@Test(description = "Retrieve the first 10 Mars photos made by Curiosity on Earth date equal to 1000 Martian sol.")
	public void retrievePhotosWithEarthDate() {

		Assert.assertEquals(this.getcuriosityPhotos(this.EARTH_DATE, 10).size(), 10);
		System.out.println(this.getcuriosityPhotos(this.EARTH_DATE, 10));
	}

	/**
	 *
	 * This test will retrieve the first 10 Martian photos from curiosity on a given
	 * sol date date.
	 *
	 */

	@Test(description = "Retrieve the first 10 Mars photos made by Curiosity on 1000 Martian sol.")
	public void retrievePhotosWithSolDate() {

		Assert.assertEquals(this.getcuriosityPhotos(this.SOL_DATE_1000, 10).size(), 10);
		System.out.println(this.getcuriosityPhotos(this.SOL_DATE_1000, 10));

	}

}
