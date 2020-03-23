package helpers;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetuserHelper {
	public Response getUserApi(int i) {
		// TODO Auto-generated method stub	
	RestAssured.baseURI = "https://reqres.in";
	
	Response res = given().
	get("/api/users?page="+i).
	then().extract().response();
	
	System.out.println(res.asString());
	System.out.println(res.getStatusCode());
	
	JsonPath json = new JsonPath(res.asString());
	
	System.out.println("---------"+json.getInt("total_pages"));
	
	return res;
	}

}
