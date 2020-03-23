package DataProvider;


import org.testng.annotations.DataProvider;

public class UesersDP {

	@DataProvider(name="users")
	
	public Object[][] usersDp() {
		
		Object[][] users = {{"Deepika", "manager"}, {"reyan","manager"}};
		return users; 
		
		
		
	}
}
