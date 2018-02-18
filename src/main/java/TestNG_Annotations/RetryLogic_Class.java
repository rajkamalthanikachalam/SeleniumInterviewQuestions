package TestNG_Annotations;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class RetryLogic_Class {

	@Test
	public void Test1(){
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void Test2(){
		Assert.assertEquals(false, false);
	}
	
	@Test
	public void Test3(){
		Assert.assertEquals(2, 2);
	}
}
