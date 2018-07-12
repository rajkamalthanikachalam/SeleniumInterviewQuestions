package Hashmap_Selenium;

public class HashMap {
	
	
	public static java.util.HashMap<String, String> UserInfo(){
		//HashMap<String, String> userInfo = new HashMap<String,String>();
		java.util.HashMap<String,String> userInfo = new java.util.HashMap<String,String>();
		userInfo.put("user1", "Admin_AdminUser");//Username & Password are saved with _ between them
		userInfo.put("User2","008rajkamal_Feb$2018@"); 
		userInfo.put("User3", "DummyUser_DummyUser");
		return userInfo;
			
	}

}
