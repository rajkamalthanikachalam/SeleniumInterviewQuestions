package com.qa.utilities;

import java.util.ArrayList;

public class TestUtil {

	static ExcelReader reader;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		try{
			reader = new ExcelReader("../Selenium_InterviewQuestions/src/main/java/com/qa/data/Test.xlsx");	
		}catch(Exception e){
			e.printStackTrace();
		}
		
		for(int rowNum =2; rowNum<= reader.getRowCount("NewContactDetails"); rowNum++){
			
			String FirstName = reader.getCellData("NewContactDetails", "FirstName", rowNum);
			String LastName = reader.getCellData("NewContactDetails", "LastName", rowNum);
			String Title = reader.getCellData("NewContactDetails", "Title", rowNum);
			String Image = reader.getCellData("NewContactDetails", "Image", rowNum);
			String NickName = reader.getCellData("NewContactDetails", "NickName", rowNum);
			String Company = reader.getCellData("NewContactDetails", "Company", rowNum);
			String Position = reader.getCellData("NewContactDetails", "Position", rowNum);
			String Department = reader.getCellData("NewContactDetails", "Department", rowNum);
			String RefferedBy = reader.getCellData("NewContactDetails", "RefferedBy", rowNum);
			String Mobile = reader.getCellData("NewContactDetails", "Mobile", rowNum);
			String EmailAddress = reader.getCellData("NewContactDetails", "EmailAddress", rowNum);
			String ReceiveEmail = reader.getCellData("NewContactDetails", "ReceiveEmail", rowNum);
			
			Object obj[] = {FirstName, LastName, Title, Image, NickName, Company, Position, Department, RefferedBy, Mobile, EmailAddress, ReceiveEmail};
			mydata.add(obj);
		}
		return mydata;	
	}

}
