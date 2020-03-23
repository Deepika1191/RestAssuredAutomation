package helpers;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UserHelper {

	
	
	public Response reqPostApi(String user, String job) {
		System.out.println("Test");
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		Response res = given().body("{\n" + 
				"    \"name\": \""+user+"\",\n" + 
				"    \"job\": \""+job+"\"\n" + 
				"}").post().then().extract().response();
		
		
		
		System.out.println(" ---"+res.statusCode());
		
		System.out.println(res.asString());
		//Assert.assertEquals(res.getStatusCode(), 201, "Response is not correct");
		
		System.out.println(" ---"+res.asString());
		
		
		return res;
		
	}

}
