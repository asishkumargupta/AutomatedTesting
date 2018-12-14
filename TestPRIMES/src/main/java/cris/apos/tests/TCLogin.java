package cris.apos.tests;

import cris.apos.utils.BrowserFunctions;
import cris.apos.utils.DiffUtilityFunctions;
import cris.apos.utils.LoggingSteps;
import org.openqa.selenium.*;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

public class TCLogin {
	
	@Test

	public void test_TCLogin () {
		WebDriver driver;
		String expectedMsg="PASSENGER RESERVATION INFORMATION MANAGEMENT ENHANCED SYSTEM";
		
		String actualMsg = null;
		LoggingSteps.log("warn",Thread.currentThread().getStackTrace()[2].getMethodName(),expectedMsg);
		driver = BrowserFunctions.launchChromeBrowser(DiffUtilityFunctions.getPropertyValue("primesURL"));
		BrowserFunctions.primesLogin(driver);

		//For logging - start
		
		//For logging - end
		
		try {
			actualMsg = driver.findElement(By.xpath("//*[@id='header-text']")).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]")).click();
		System.out.println("Actual message :" + actualMsg);
		AssertJUnit.assertEquals(expectedMsg, actualMsg);	
		//driver.quit();
		
			
		}
	}




	

	

