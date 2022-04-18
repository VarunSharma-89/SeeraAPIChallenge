package utilities;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods {
	
	public static XmlPath rawToXML(Response r)
	{
		String respon=r.asString();
		XmlPath xp=new XmlPath(respon);
		return xp;
	}
	
	public static JsonPath rawToJson(Response r)
	{ 
		String respon=r.asString();
		JsonPath jp=new JsonPath(respon);
		return jp;
	}	

}
