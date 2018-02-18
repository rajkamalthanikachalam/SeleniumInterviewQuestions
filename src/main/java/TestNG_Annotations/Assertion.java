package TestNG_Annotations;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion {
	
	 /* org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert(); 
	 Initialize the soft assert class
	 if defined globally, it will show previous method failure result in current test also, to avoid use inside the test
	 ==>hard assertion: hard validation: if a hard assertion is getting failed: immediately test case will me marked as failed and test case will be terminated.
	 ==>soft assertion: soft validation: if a soft assertion is getting failed: test case will not be marked as passed as well as next lines will be executed 
	 ==>assertAll() : is used to mark the test case as failed, if any soft assertion is getting failed */
	
	@Test(enabled  = false)
	public void HardAssert(){
				
		System.out.println("Hard Asset Step 1");
		Assert.assertEquals(false, false);
		System.out.println("Hard Asset Step 2");
		Assert.assertEquals(false, true);
		System.out.println("Hard Asset Step 3");
	}
	
	@Test(enabled  = true)
	public void SoftAssert_1(){
		
		org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
		
		System.out.println("Soft Assert 1 Step 1");
		softAssert.assertEquals(true, false, "Soft Assert Message");
		System.out.println("Soft Assert 1 Step 2");
		softAssert.assertEquals(false, true, "Soft Assert Message");
		System.out.println("Soft Assert 1 Step 3");
		
		softAssert.assertAll(); // if missed this line, test case will be treated as pass 
	}
	
	@Test(enabled  = true)
	public void SoftAssert_2(){
		
		org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();
		
		System.out.println("Soft Assert 2 Step 1");
		softAssert.assertEquals(true, true, "Soft Assert Message");
		System.out.println("Soft Assert 2 Step 2");
		softAssert.assertEquals(true, true, "Soft Assert Message");
		System.out.println("Soft Assert 2 Step 3");
		
		softAssert.assertAll(); // if missed this line, test case will be treated as pass 
	}
}
