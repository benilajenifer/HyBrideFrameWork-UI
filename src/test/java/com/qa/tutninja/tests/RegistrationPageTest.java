package com.qa.tutninja.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tutninja.utils.Constants;
import com.qa.tutninja.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest{
	
	
	@BeforeClass
	public void setUpRegistration() {
		registrationPage = loginPage.navigateToRegisterPage();
	}
	
	public String getRandomEmail() {
		Random randomGenerator = new Random();
		String email = "uiframework2022"+randomGenerator.nextInt(1000)+"@gmail.com";
		return email;
	}
	
	@DataProvider
	public Object[][] getRegisterData(){
		return ExcelUtil.getTestData(Constants.REGISTER_SHEET_NAME);
	}
	
	@Test(dataProvider = "getRegisterData")
	public void userRegistrationTest(String firstName, String lastName, 
											String telephone, 
											String password, String subscribe) {
		
		Assert.assertTrue(registrationPage.accountRegistration(firstName, lastName,
															getRandomEmail(),
															telephone, password, subscribe));	
	}
	
	
	
	
	

}
