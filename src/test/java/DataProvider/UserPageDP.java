package DataProvider;

import org.testng.annotations.DataProvider;

public class UserPageDP {

	@DataProvider(name="page")
	public Object[][] pageData(){

		/*Object[][] obj1 = new Object[3][];
		obj1[0][0] = 1;
		obj1[1][0] = 2;*/
		
		
		Object[][] obj = {{1},{2},{3}};
		
		return obj;
		
	}
}
