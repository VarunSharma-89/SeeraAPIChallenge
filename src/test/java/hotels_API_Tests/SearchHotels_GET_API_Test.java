package hotels_API_Tests;

import io.restassured.response.Response;
import resources.Endpoint_Resources;
import testData.CommonTestData;
import utilities.ReusableMethods;
import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseTest;

public class SearchHotels_GET_API_Test extends BaseTest {
	
	private static Logger log = LogManager.getLogger(SearchHotels_GET_API_Test.class.getName());

	@Test
	public void searchHotel_positiveFlow() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Search Hotel Happy Flow & verify the response (GET Request)");
				Response getRes = 
						 given()
						 .spec(reqSpec)
						 .queryParam("placeId", CommonTestData.placeID).queryParam("pageSize", CommonTestData.pageSize)						 
						 .log().all()
						.when()
						 .get(Endpoint_Resources.searchHotelsGetEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(200).log().all()
						.extract().response();
				
				log.info(getRes);
				js = ReusableMethods.rawToJson(getRes);
				//Verify Response Message
				Assert.assertEquals(js.get("sortBy"), "priority");
				Assert.assertEquals(js.get("distanceShow"), true);
				Assert.assertEquals(js.get("countryCode"), "AE");
				Assert.assertNotNull(js.get("hotels"));
				Assert.assertEquals(js.get("distanceDetails.en"), " km from city center of Abu Dhabi");
				Assert.assertEquals(js.get("distanceDetails.ar"), " كم من مركز مدينة ‬أبو ظبي");
				Assert.assertNotNull(js.get("pagination.nextPageId"));
				Assert.assertEquals(js.get("pagination.pageNo"), 1);
				Assert.assertEquals(js.get("pagination.pageSize"), CommonTestData.pageSize);
				Assert.assertNotNull(js.get("pagination.totalResultsCount"));
				Assert.assertNotNull(js.get("geoCoordinate.latitude"));
				Assert.assertNotNull(js.get("geoCoordinate.longitude"));
				Assert.assertEquals(js.get("geoCoordinate.radiusInMeters"), 45000);
	}
	
	@Test
	public void searchHotel_invalidEndpoint() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide invalid endpoint & verify the response (GET Request)");
				Response getRes = 
						 given()
						 .spec(reqSpec)
						 .queryParam("placeId", CommonTestData.placeID).queryParam("pageSize", CommonTestData.pageSize)						 
						 .log().all()
						.when()
						 .get(Endpoint_Resources.searchHotelsInvalidGetEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(404).log().all()
						.extract().response();
				
				log.info(getRes);
				js = ReusableMethods.rawToJson(getRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 404);
				Assert.assertEquals(js.get("error"), "Not Found");
	}
	
	@Test
	public void searchHotel_invalidPlaceID() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide invalid PlaceID as Query Param & verify the response (GET Request)");
				Response getRes = 
						 given()
						 .spec(reqSpec)
						 .queryParam("placeId", CommonTestData.invalid_PlaceID).queryParam("pageSize", CommonTestData.pageSize)
						 .log().all()
						.when()
						 .get(Endpoint_Resources.searchHotelsGetEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(getRes);
				js = ReusableMethods.rawToJson(getRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void searchHotel_noPlaceID() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide invalid PlaceID as Query Param & verify the response (GET Request)");
				Response getRes = 
						 given()
						 .spec(reqSpec)
						 .queryParam("pageSize", CommonTestData.pageSize)						 
						 .log().all()
						.when()
						 .get(Endpoint_Resources.searchHotelsGetEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(getRes);
				js = ReusableMethods.rawToJson(getRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void searchHotel_invalidPageSize() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide invalid PlaceID as Query Param & verify the response (GET Request)");
				Response getRes = 
						 given()
						 .spec(reqSpec)
						 .queryParam("placeId", CommonTestData.placeID).queryParam("pageSize", CommonTestData.invalid_pageSize)
						 .log().all()
						.when()
						 .get(Endpoint_Resources.searchHotelsGetEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(getRes);
				js = ReusableMethods.rawToJson(getRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void searchHotel_invalidAuthToken() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide invalid Auth Token header value & verify the response (GET Request)");
				Response getRes = 
						 given()
						 .header("token", CommonTestData.invalid_hotel_token).header("Content-Type", CommonTestData.contentType_Json)
						 .queryParam("placeId", CommonTestData.placeID).queryParam("pageSize", CommonTestData.pageSize)						 
						 .log().all()
						.when()
						 .get(Endpoint_Resources.searchHotelsGetEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(401).log().all()
						.extract().response();
				
				log.info(getRes);
				js = ReusableMethods.rawToJson(getRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 401);
	}
	
	@Test
	public void searchHotel_noAuthToken() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Don't provide Auth Token header & verify the response (GET Request)");
				Response getRes = 
						 given()
						 .header("Content-Type", CommonTestData.contentType_Json)
						 .queryParam("placeId", CommonTestData.placeID).queryParam("pageSize", CommonTestData.pageSize)						 
						 .log().all()
						.when()
						 .get(Endpoint_Resources.searchHotelsGetEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(401).log().all()
						.extract().response();
				
				log.info(getRes);
				js = ReusableMethods.rawToJson(getRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 401);
	}
	
}
