package TestNG_Annotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNG_Annotations_1 {
  
	// Below is the order of annotation execution by TestNG(without @Test)
	// Whenever @test is executed, @BeforeMethod and @AfterMethod will execute before and after the each @Test 
	
  //private static final Class[] Array = null;
  @BeforeSuite
  public void beforeSuite() {
	 System.out.println("1 ==> beforeSuite");
  }
 
  @BeforeTest
  public void beforeTest() {
	  System.out.println("2 ==> beforeTest");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("3 ==> beforeClass");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("4 ==> beforeMethod");
  }
  
  @Test(priority = 1, groups = "First")
  public void TestMethod1() {
	  System.out.println("5 ==> TestMethod 1");
  }
  
  //dependsOnMethods helps to define the dependency , once the dependent method executed successfully, following file will run
  //Groups helps to segregate the test case in TestNG report under groups 
  @Test(priority = 2, groups = "Second",dependsOnMethods = "TestMethod1")  
  public void TestMethod2() {
	  System.out.println("5 ==> TestMethod 2");
  }
  
  //invocationCount - it helps to run the particular test method specified no of times 
  @Test(priority = 3, groups = "Third", invocationCount = 5)
  public void TestMethod3() {
	  System.out.println("5 ==> TestMethod 3");
  }
  
  //timeOut - helps to fix the time for that specific test case, if test case exceeds the time limit, it proceed to next test
  //invocationTimeOut - similar to time out 
  @Test(priority = 4, groups = "Four",  invocationTimeOut = 2)
  public void TestMethod4() {
	  System.out.println("5 ==> TestMethod 3");
  }
  
  //expectedExceptions - this helps to define earlier , if this error occurs ignore it
  @Test(priority = 5, expectedExceptions = NumberFormatException.class)
  public void TestMethod5() {
	  System.out.println("5 ==> TestMethod 3");
  }
  
  @AfterMethod(timeOut = 2000)
  public void afterMethod() {
	  System.out.println("6 ==> afterMethod");
  }
  
  @AfterClass
  public void afterClass() {
	  System.out.println("7 ==> afterClass");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("8 ==> afterTest");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("9 ==> afterSuite");
  }

}
