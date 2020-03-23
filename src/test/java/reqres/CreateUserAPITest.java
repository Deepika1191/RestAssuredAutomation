package reqres;

import org.testng.Assert;
import org.testng.annotations.Test;

import helpers.UserHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateUserAPITest {
	
	@Test
	public void userAPI() {
		
		UserHelper userHelper = new UserHelper();
		
		
		Response res = userHelper.reqPostApi("userA", "Manager");
		Assert.assertEquals(res.statusCode(), 201, "Response is not correct");
		
		
		
		
		
		//System.out.println(" ---"+res.asString());
		
		JsonPath json = new JsonPath(res.asString());
		
		System.out.println(json.getString("id"));
		System.out.println(json.getString("name"));
		
	}


}
