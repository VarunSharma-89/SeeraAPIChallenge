package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import testData.CommonTestData;

public class BaseTest extends Object {
	
	protected Properties prop = new Properties();
	protected RequestSpecification reqSpec;
	protected ResponseSpecification resSpec;
	protected JsonPath js;

	@BeforeClass
	public void hotelSearch_setup() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//environment.properties");
		prop.load(fis);
		
		RestAssured.baseURI = prop.getProperty("HOST");

		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.addHeader("token", CommonTestData.hotel_token);
		reqBuilder.addHeader("Content-Type", CommonTestData.contentType_Json);
		reqSpec = reqBuilder.build();
		
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectHeader("Server", "cloudflare");
		resBuilder.expectHeader("Content-Type", CommonTestData.contentType_Json);
		resSpec = resBuilder.build();
	}
}