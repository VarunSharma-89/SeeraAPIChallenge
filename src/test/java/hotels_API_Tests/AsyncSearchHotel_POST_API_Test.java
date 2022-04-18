package hotels_API_Tests;

import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import baseClass.BaseTest;
import io.restassured.response.Response;
import resources.Endpoint_Resources;
import testData.CommonTestData;
import testData.Payloads;
import utilities.ReusableMethods;

public class AsyncSearchHotel_POST_API_Test extends BaseTest {
	
	private static Logger log = LogManager.getLogger(AsyncSearchHotel_POST_API_Test.class.getName());

	// Positive Flow :
	
	@Test
	public void asyncSearchHotel_positiveFlow() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Async Search Hotel Happy Flow & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearchPostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .statusCode(200).spec(resSpec).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertNotNull(js.get("sId"));
	}
	
	
	// Negative Scenarios Flow :
	
	@Test
	public void asyncSearchHotel_invalidEndpoint() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide invalid endpoint & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearchPostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelInvalidPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(404).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 404);
				Assert.assertEquals(js.get("error"), "Not Found");
	}
	
	@Test
	public void asyncSearchHotel_pastCheckInDate_PostData() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide CheckIn date as a past date from the current date & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearch_pastCheckInDate_PostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void asyncSearchHotel_pastCheckOutDate_PostData() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide CheckOut date as a past date from the CheckIn date & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearch_pastCheckOutDate_PostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void asyncSearchHotel_checkInCheckOut_sameDate() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide same CheckIn & CheckOut dates & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearch_checkInCheckOutSameDate_PostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void asyncSearchHotel_moreThanMaxGapBetween_checkInCheckOutDate() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide more than max(30) days gap between CheckIn & CheckOut dates & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearch_moreThanMaxGapBetween_checkInCheckOutDate_PostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void asyncSearchHotel_noCheckInDateField() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Don't provide CheckIn date field & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearch_noCheckInDateField_PostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void asyncSearchHotel_noCheckOutDateField() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Don't provide CheckOut date field & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearch_noCheckOutDateField_PostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void asyncSearchHotel_moreThanMax_NumberofAdults() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide more than the max(8) number of allowed Adults & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearch_moreThanMax_Adults_PostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void asyncSearchHotel_lessThanMin_NumberofAdults() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide less than the min(1) number of allowed Adults & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearch_lessThanMin_Adults_PostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void asyncSearchHotel_noAdultsField() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Don't provide Adults field & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearch_noAdultsField_PostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void asyncSearchHotel_invalidAuthToken() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide invalid Auth Token header value & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .header("token", CommonTestData.invalid_hotel_token)
						 .header("Content-Type", CommonTestData.contentType_Json)
						 .body(Payloads.asyncSearchPostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(401).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 401);
	}
	
	@Test
	public void asyncSearchHotel_noAuthToken() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Don't provide Auth Token header & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .header("Content-Type", CommonTestData.contentType_Json)
						 .body(Payloads.asyncSearchPostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(401).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 401);
	}
	
	@Test
	public void asyncSearchHotel_invalidPlaceID() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Provide invalid PlaceID & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearch_invalidPlaceID_PostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
	@Test
	public void asyncSearchHotel_noPlaceID() {
				log.info("Host information" + prop.getProperty("HOST"));
				log.info("Don't provide PlaceID field & verify the response (POST Request)");
				Response postRes = 
						 given()
						 .spec(reqSpec)
						 .body(Payloads.asyncSearch_noPlaceIDField_PostData()).log().all()
						.when()
						 .post(Endpoint_Resources.asyncSearchHotelPostEndpoint())
						.then()
						 .spec(resSpec)
						 .statusCode(400).log().all()
						.extract().response();
				
				log.info(postRes);
				js = ReusableMethods.rawToJson(postRes);
				//Verify Response Message
				Assert.assertEquals(js.get("status"), 400);
				Assert.assertEquals(js.get("error"), "Bad Request");
	}
	
}
