package reqres;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import DataProvider.UesersDP;

import helpers.UserHelper;


import org.testng.Assert;



import io.restassured.response.Response;


public class PostRequestTest {
	
	UserHelper userHelper;
	@BeforeTest
	public void setup(){
		
		 userHelper = new UserHelper();
		
	}
	
	// create user
	
	public void reqPostApi(String user, String job) {
		
		
		Response res = userHelper.reqPostApi(user, job);
		Assert.assertEquals(res.statusCode(), 201, "Response is not correct");
		
		System.out.println(" ---"+res.asString());
		
		
		
		/*
		 * System.out.println("Test"); RestAssured.baseURI =
		 * "https://reqres.in/api/users";
		 * 
		 * Response res = given().body("{\n" + "    \"name\": \""+user+"\",\n" +
		 * "    \"job\": \""+job+"\"\n" + "}").post().then().extract().response();
		 * 
		 * 
		 * 
		 * System.out.println(" ---"+res.statusCode());
		 * 
		 * System.out.println(res.asString()); Assert.assertEquals(res.getStatusCode(),
		 * 201, "Response is not correct");
		 * 
		 * System.out.println(" ---"+res.body().toString());
		 */
		
		
		
	}
	@Test(dataProvider="users", dataProviderClass=UesersDP.class)
	public void reqPostApiTest(String user, String job) {
		reqPostApi(user,job);
		
	}
	
	
	
}
