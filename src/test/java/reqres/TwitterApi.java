package reqres;


import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class TwitterApi {

	String consumerKey = "NRagPogQPOXOeAOFFbHulWMBM" ;
	String consumerSecret = "O46kpYA7J6d9Ayz0GtHxwbNcNbfQqb2Re4tPdEF5ZGTl31EmGx";
	String accessToken = "2942465238-W3Zn3UibYXj1x4wqvy1G6idB50IF98ANYzYoiSh";
	String secretToken = "ADEJBl6bYWcltI7U8fD1hwPYOIAM1WkVMPv2p6TkHILEx";
			
	Logger log = Logger.getLogger(TwitterApi.class);
	
	String tweetId;
	
	String baseUrl = "https://api.twitter.com/1.1/statuses";
	
//	
//	public String createTweet() {
//		
//		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses/update.json";
//		
//		String res = RestAssured.given().auth().oauth(consumerKey, consumerSecret, accessToken,secretToken).queryParam("status", "Hellow world!")
//		.post().then().extract().asString();
//		log.info("...."+res);
//		System.out.println("---"+res);
//		JsonPath json = new JsonPath(res);
//		
//		String tweetId = json.getString("id");
//		return tweetId;
//	}
	
	
	@Test
	public void twitter() {
		
		
		RestAssured.baseURI = baseUrl; 
		
		String res = RestAssured.given().auth().oauth(consumerKey, consumerSecret, accessToken,secretToken).queryParam("status", "Hellow world!")
		.post("/update.json").then().extract().asString();
		log.info("...."+res);
		System.out.println("---"+res);
		JsonPath json = new JsonPath(res);
		
		 tweetId = json.getString("id");
		
				
	}
	// Levels - DEBUG, INFO, WARNING, ERROR
	
	@Test
	public void getTweet() {
		
		try{
			RestAssured.baseURI = baseUrl;
			
			Response res = given().auth().oauth(consumerKey, consumerSecret, accessToken, secretToken)
			.queryParam("screen_name", "imVkohli")
			.queryParam("count", 2).get("/user_timeline.json").then().extract().response();
			
			System.out.println(res.asString());
			log.info("-------"+res);
			JsonPath json = new JsonPath(res.asString());
			
			System.out.println("..%%%..."+json.getString("text"));
			
			Assert.assertEquals(res.statusCode(), 200, "Status code doesnot match");
			Assert.assertFalse(json.getString("text").isEmpty());
			
		}catch(Error err) {
			
			log.error("...."+err.getMessage());
		}
		
		
	}
	
	
	@AfterTest
	public void deleteTweet() {
		
		
		RestAssured.baseURI = baseUrl;
		
		Response res = given().auth().oauth(consumerKey, consumerSecret, accessToken, secretToken)
				.queryParam("id", tweetId)
				.post("/destroy.json").then().extract().response();
		
		System.out.println("Teardwon" + res.getStatusCode());
		
		Assert.assertEquals(res.getStatusCode(),200);
		
		System.out.println("Teardwon complete");
		
	}
	
}
