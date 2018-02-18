package com.qa.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

// At @Test level

public class RetryListener implements IRetryAnalyzer{
	
	int count = 0 ;
	int retryLimit = 3 ;  // set your retry Limit
	
	public boolean retry(ITestResult result){
		if(count< retryLimit){
			count++;
			return true;
		}
		return false;
	}

}

	
