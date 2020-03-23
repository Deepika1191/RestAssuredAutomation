package reqres;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataProvider.UserPageDP;
import helpers.GetuserHelper;

public class GetUsersApiTest {
	
// Given -> BasesUrl and Method Tpe is GET
	// When -> Steps
	// Then -> Expected result
	GetuserHelper userHelper;	
@BeforeTest
public void Getsetup() {
		
		
		userHelper = new GetuserHelper();
		
	}
	
	public void getUserApi(int i) {
		
		Response  res = userHelper.getUserApi(2);

		
		
	}
	
	@Test(dataProvider="page", dataProviderClass=UserPageDP.class)
	public void getUserApiTest(int i) {
		getUserApi(i);
		//getUserApi(2);
		//getUserApi(3);
	}
}
