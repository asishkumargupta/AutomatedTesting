package cris.apos.tests;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cris.apos.input.*;
import cris.apos.utils.BrowserFunctions;
import cris.apos.utils.DiffUtilityFunctions;
import cris.apos.utils.LoggingSteps;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import org.testng.AssertJUnit;






public class TCAccountsReportVerifyLinks {

	@Test

	public void test_TCDailyReportsVerifyLinks () {
		WebDriver driver;
		Path inpFile = Paths.get(DiffUtilityFunctions.getPropertyValue("primesAccountsRepInputFile"));
	//	SoftAssert softAssert = new SoftAssert();
		WebElement linkElement;
		Calendar cal = Calendar.getInstance();
		System.out.println("Testing started at time  :" + cal.getTime());
		TCLogin tcLogin = new TCLogin();
		String expectedMsg="PASSENGER RESERVATION INFORMATION MANAGEMENT ENHANCED SYSTEM";

		String actualMsg = null;
		LoggingSteps.log("warn",Thread.currentThread().getStackTrace()[2].getMethodName(),expectedMsg);

		driver = BrowserFunctions.launchChromeBrowser(DiffUtilityFunctions.getPropertyValue("primesURL"));

		BrowserFunctions.primesLogin(driver);
		BrowserFunctions.waitForLoad(driver);
		try {
			actualMsg = driver.findElement(By.xpath("//*[@id='header-text']")).getText();
		} catch (Exception e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
		}

		BrowserFunctions.waitForLoad(driver);

		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[1]")).click(); //Click to show full menu
		driver.findElement(By.xpath("//*[@id='LicashCollection']/a/span/b")).click();//Click Accoounts Report
		
		BrowserFunctions.waitForLoad(driver);
		//System.out.println("Waiting started at time  :" + cal.getTime());
		
		

		//System.out.println("Waiting ended at time  :" + cal.getTime());
		
		//driver.findElement(By.xpath("//*[@id='bookingLocation']")).click();//Click BOOKING LOCATION
		  
		
		//alternative way - start
		
		String xpathFunctionName = null;
		//String xpathvar = "\"//*[@id='" + functionName + "\']\"" ;
		//String xpathvar = "//*[@id='" + functionName + "\']" ;
		//		System.out.println("xpathvar = " + xpathvar);
				
				
//		driver.findElement(By.xpath(xpathvar)).click();//Click BOOKING LOCATION
	//	driver.findElement(By.xpath("//*[@id='cancelModification']")).click();//Click CANCEL/MODIFICATION
	//	driver.findElement(By.xpath("//*[@id='concession']")).click();//Click CONCESSION
	//	driver.findElement(By.xpath("//*[@id='voucherCstRtc']")).click();;//Click VOUCHER/CST/RTC
		
	//	driver.findElement(By.xpath("//*[@id='bank']")).click();//Click BANK
	//	driver.findElement(By.xpath("//*[@id='circularJourney']")).click();//Click CIRCULAR JOURNEY
	//	driver.findElement(By.xpath("//*[@id='serviceTax']")).click();//Click GOODS AND SERVICE TAX
	//	driver.findElement(By.xpath("//*[@id='originating']")).click();//Click ORIGINATING
//		driver.findElement(By.xpath("//*[@id='others']")).click();//Click OTHERS
	
	//	driver.findElement(By.xpath("//*[@id='others']")).click();//Click OVERSEAS TRAINS
	//	driver.findElement(By.linkText(" OVERSEAS TRAINS  ")).click();
	//	driver.findElement(By.tagName(" OVERSEAS TRAINS  ")).click();
	//	driver.findElement(By.partialLinkText(" OVERSEAS TRAINS  ")).click();
		/*
		String xpathOverseasTrain = 
				
	"/html/body[@class='page-header-fixed page-sidebar-closed-hide-logo page-content-white']"
	+ "/div[@class='page-wrapper']/div[@class='page-container']/div[@class='page-content-wrapper']"
	+ "/div[@class='page-content']/div[@class='row']/div[@class='col-xs-12']"
	+ "/div[@class='portlet light portlet-fit bordered']/div[@class='portlet-body']"
	+ "/div[@class='row']/div[@class='row'][4]/div[@class='col-md-4 col-sm-4 col-xs-12']"
	+ "/div[@class='color-demo']/div[@class='bg-default bg-font-default bold uppercase']"
	+ "/div[@class='btn-group']/span[@id='others']";
		
		driver.findElement(By.xpath(xpathName)).click();
		
	driver.findElement(By.xpath("//*[@id='others'][position()=1]")).click();//Click OVERSEAS TRAINS	
		
		*/
		
		
	//	driver.findElement(By.xpath("//*[@id='others'][1]")).click();//Click OVERSEAS
		
		//driver.findElement(By.xpath("(//SPAN[@id='others']/../../../../../..//SPAN[@id='others'])[2]")).click();//Click OVERSEAS TRAINS
		
	
		//alternative way - end 
		
		//To check links - start

		List<WebElement> webLinkElements = driver.findElements(By.tagName("a"));
		ArrayList<String> webLinkTexts = new ArrayList<String>();
		int i = 0;
		List<SingleLinkDetails> completeLinkToVerify ;

//extract all the link texts of each link element present in the web & store in webLinkTexts ArrayList - start
		for (WebElement elements : webLinkElements) {

			if ( elements.getText() != null && !elements.getText().isEmpty() )
			{
				webLinkTexts.add(elements.getText()) ;
					//System.out.println("Stored=" + elements.getText());
				i++;
			}
			else i++;
		}
		//extract all the link texts of each link element present in the web & store in webLinkTexts ArrayList - end
		
		//Links present in input file for Actual testing - start
		completeLinkToVerify = DiffUtilityFunctions.readInputFilePopulateData(inpFile);
		
		
		
		
		
		
		
		
	//	System.out.println("=====>>>>> File contents Read =====>>>>>" + completeLinkToVerify);
		//Links present in input file for Actual testing - end

		
		
/*//Print all links present in the web 
		for (String t : webLinkTexts) {
			System.out.println("\nTo be Tested " +  t);
		}
*/


		//Test for   all links present in input file - start
		
		for ( i = 0; i < completeLinkToVerify.size(); i++) {
			
			try {
				linkElement = BrowserFunctions.explicitWait(driver , "//*[@id='LicashCollection']/a/span/b");

				linkElement.click();
				driver.findElement(By.linkText(completeLinkToVerify.get(i).getLinkName())).click();
				System.out.println(
						completeLinkToVerify.get(i).getTestCaseId() + " , " + 
						completeLinkToVerify.get(i).getcategoryName()+ " , " + 
						completeLinkToVerify.get(i).getfunctionName()+ " , " + 
						completeLinkToVerify.get(i).getLinkName() + " , " + " PASSED "
						);
			
				
				BrowserFunctions.explicitWait(driver , "/html/body/div[2]/div[4]/div[2]/div/div[1]/ul/li[2]/a");

				driver.navigate().back();

				

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
			//	System.out.println(completeLinkToVerify.get(i).getLinkName() + " is not working ");
				System.out.println(
						completeLinkToVerify.get(i).getTestCaseId() + " , " + 
						completeLinkToVerify.get(i).getcategoryName()+ " , " + 
						completeLinkToVerify.get(i).getfunctionName()+ " , " + 
						completeLinkToVerify.get(i).getLinkName() + " , " + " FAILED " 
						);
	
				//softAssert.assertTrue(false);
				  //softAssert.assertEquals(1, 2);
				//  softAssert.assertAll();
				
			}
			
	
		}       

		//Test for   all links present in input file - end
	//	System.out.println("Actual message :" + actualMsg);
	//	AssertJUnit.assertEquals(expectedMsg, actualMsg);	
		
		BrowserFunctions.logOutPrime(driver, "/html/body/div[2]/div[1]/div/div[2]/ul/li[2]/a/span/strong");
		//driver.quit();
		cal = Calendar.getInstance();
		System.out.println("Testing completed at time  :" + cal.getTime());
	//	  softAssert.assertAll();

	}
}








