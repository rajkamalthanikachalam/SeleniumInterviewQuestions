package com.qa.analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class RetryTransformer implements IAnnotationTransformer {

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {  
		// Auto generated , just implement by clicking on class name
		//In Class name
		//Need to implement in testng.xml file
		
		annotation.setRetryAnalyzer(com.qa.analyzer.RetryListener.class);	
	}

}
