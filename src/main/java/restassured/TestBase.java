package restassured;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestBase {

	private final String API_KEY = "DTAWaxabOnXhQMmNfulL7YgCzHhh3ymAmi0Ns70x";
	private final String NASA_HOST = "https://api.nasa.gov/";
	private TestURLImage imageOpener = new TestURLImage();

	/**
	 *
	 * generateImagesFromURL will open each image given with an URL.
	 *
	 */

	public void generateImagesFromURL(List<String> urlList) {

		for (String url : urlList) {
			url = url.replaceFirst("(?i)^http://", "https://");
			this.imageOpener.openImageFromURL(url);
		}

	}

	/**
	 *
	 * getCuriosityPhotos Method requires a date variable which can be in either
	 * Martian sol or earth date with the format "YYYY-MM-dd" and an amount variable
	 * that will determine how many photos will be returned for the given day. if
	 * amount is 0, all photos will be retrned.
	 *
	 */

	public List<String> getcuriosityPhotos(int sol, int ammount) {

		List<String> curiosityPhotos = new ArrayList<String>();
		Response response = given().when()
				.get("mars-photos/api/v1/rovers/curiosity/photos?sol=" + sol + "&api_key=" + this.API_KEY);

		List<String> allPhotos = response.path("photos.img_src");
		if (ammount == 0) {
			return allPhotos;
		}

		for (int i = 0; i < ammount; i++) {

			curiosityPhotos.add(allPhotos.get(i));
		}
		this.generateImagesFromURL(curiosityPhotos);

		return curiosityPhotos;

	}

	public ArrayList<String> getcuriosityPhotos(String date, int ammount) {

		Response response = given().when()
				.get("mars-photos/api/v1/rovers/curiosity/photos?earth_date=" + date + "&api_key=" + this.API_KEY);
		ArrayList<String> curiosityPhotos = new ArrayList<String>();
		List<String> photos = response.path("photos.img_src");
		for (int i = 0; i < ammount; i++) {

			curiosityPhotos.add(photos.get(i));
		}

		this.generateImagesFromURL(curiosityPhotos);
		return curiosityPhotos;

	}

	/**
	 *
	 * getOportunityPhotos Method requires a date variable which can be in either
	 * Martian sol or earth date with the format "YYYY-MM-dd" and an amount variable
	 * that will determine how many photos will be returned for the given day.
	 *
	 * if amount is 0, all photos will be retrned.
	 *
	 */

	public List<String> getOpportunityPhotos(int sol, int ammount) {
		Response responseOpportunity = given().when()
				.get("mars-photos/api/v1/rovers/Opportunity/photos?sol=" + sol + "&api_key=" + this.API_KEY);
		List<String> allPhotos = responseOpportunity.path("photos.id");
		List<String> Opportunity = new ArrayList<String>();
		if (ammount == 0) {
			return allPhotos;
		}
		for (int i = 0; i < ammount; i++) {

			Opportunity.add(allPhotos.get(i));
		}
		this.generateImagesFromURL(Opportunity);
		return Opportunity;
	}

	public List<String> getOpportunityPhotos(String date, int ammount) {
		Response responseOpportunity = given().when()
				.get("mars-photos/api/v1/rovers/Opportunity/photos?earth_date=" + date + "&api_key=" + this.API_KEY);
		List<String> allPhotos = responseOpportunity.path("photos.id");
		List<String> Opportunity = new ArrayList<String>();
		if (ammount == 0) {
			return allPhotos;
		}
		for (int i = 0; i < ammount; i++) {

			Opportunity.add(allPhotos.get(i));
		}
		this.generateImagesFromURL(Opportunity);
		return Opportunity;
	}

	/**
	 *
	 * getSpiritPhotos Method requires a date variable which can be in either
	 * Martian sol or earth date with the format "YYYY-MM-dd" and an amount variable
	 * that will determine how many photos will be returned for the given day. if
	 * amount is 0, all photos will be retrned.
	 *
	 */

	public List<String> getSpiritPhotos(int sol, int ammount) {
		Response responseSpirit = given().when()
				.get("mars-photos/api/v1/rovers/Spirit/photos?sol=" + sol + "&api_key=" + this.API_KEY);
		List<String> allPhotos = responseSpirit.path("photos.id");
		List<String> Spirit = new ArrayList<String>();
		if (ammount == 0) {
			return allPhotos;
		}
		for (int i = 0; i < ammount; i++) {

			Spirit.add(allPhotos.get(i));
		}
		this.generateImagesFromURL(Spirit);
		return Spirit;
	}

	public List<String> getSpiritPhotos(String date, int ammount) {
		Response responseSpirit = given().when()
				.get("mars-photos/api/v1/rovers/Spirit/photos?earth_date=" + date + "&api_key=" + this.API_KEY);
		List<String> allPhotos = responseSpirit.path("photos.id");
		List<String> Spirit = new ArrayList<String>();
		if (ammount == 0) {
			return allPhotos;
		}
		for (int i = 0; i < ammount; i++) {

			Spirit.add(allPhotos.get(i));
		}
		this.generateImagesFromURL(Spirit);
		return Spirit;
	}

	/**
	 *
	 * @Before Suite will contain all the methods necessary to kick start the
	 *         project.
	 *
	 */

	@BeforeSuite
	public void setUp() {
		RestAssured.baseURI = this.NASA_HOST;

	}

}
