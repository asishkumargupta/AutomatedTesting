package cris.apos.utils;





import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BrowserFunctions {

	public static WebDriver launchChromeBrowser(String urlToOpen ) {
		String driverPath;
		WebDriver driver;
		WebDriverWait wait;
		
		/*
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		driverPath = DiffUtilityFunctions.getPropertyValue("chromeDriverPath");

		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");

		System.out.println("\nlaunching CHROME browser");
*/
		
		
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		driverPath = DiffUtilityFunctions.getPropertyValue("chromeDriverPath");

		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");

		System.out.println("\nlaunching CHROME browser");
		
		driver = new ChromeDriver(options);

	//	wait = new WebDriverWait(driver, 900);
	

		driver.manage().window().maximize();

		driver.get(urlToOpen);
		return driver;


	}


	public static void primesLogin(WebDriver driverParam) {
		String capcha = null;
		boolean elementExists;
		driverParam.findElement(By.xpath("/html/body/div[3]/form/div[2]/input")).sendKeys(DiffUtilityFunctions.getPropertyValue("primesUserName"));
		driverParam.findElement(By.xpath("/html/body/div[3]/form/div[3]/input")).sendKeys(DiffUtilityFunctions.getPropertyValue("primesPassword"));	
		/*try {
			
			capcha = DiffUtilityFunctions.capchaInputDialog();

		} catch (IOException e) {

			e.printStackTrace();
		}
		try {
			driverParam.findElement(By.id("nlpAnswer"));
			elementExists = true;
		} catch (NoSuchElementException e) {
			elementExists = false;
		}
		if (elementExists)
			driverParam.findElement(By.id("nlpAnswer")).sendKeys(capcha);
		else 
			driverParam.findElement(By.name("j_captcha")).sendKeys(capcha);*/

		driverParam.findElement(By.xpath("/html/body/div[3]/form/div[4]/button")).click();
		driverParam.switchTo().defaultContent();	


	}

	



	public static WebDriver paymentSubmit(WebDriver driver) {
		String xpathString = null,
				psgnSplitConfirmXpath = null;
		List<WebElement> RadioGroup1 = driver.findElements(By.name("PREFERRED"));
		RadioGroup1.get(0).click();

		driver.findElement(By.id("validate")).click();
		driver.findElement(By.xpath("//html/body/div[5]/div[3]/div/button[1]/span")).click();	


		psgnSplitConfirmXpath = "/html/body/div[6]/div[3]/div/button[1]/span" ;
		if (isElementPresent(driver,psgnSplitConfirmXpath)) {
			driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/button[1]/span")).click();
		}

		driver.findElement(By.name("sb")).click();

		return driver ;
	}


	public static boolean isElementPresent(WebDriver driver,String xpathString){
		try{
			driver.findElement(By.xpath(xpathString));
			return true;
		}
		catch(NoSuchElementException e){
			return false;
		}
	}
	public static void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = null;
		
			wait = new WebDriverWait(driver, 20);
		
        try {
			wait.until(pageLoadCondition);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			System.out.println("\nContinuing after Time Out exception");
			
		}
    }

	public static void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	}
	public static WebElement explicitWait(WebDriver driver , String xpathString) {
		Calendar cal = null ;
		WebElement guru99seleniumlink = null;
		cal = Calendar.getInstance();
	//	System.out.println("\n Wait time started at  time:" + cal.getTime());
		WebDriverWait wait=new WebDriverWait(driver, 2);
		
			try {
				guru99seleniumlink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( xpathString)));
			} catch (UnhandledAlertException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
				System.out.println("\nContinuing After Some error ocured UnhandledAlertException & retrying again");
				guru99seleniumlink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( xpathString)));
			}
			
			catch (WebDriverException e) {
				// TODO Auto-generated catch block
		//		e.printStackTrace();
				cal = Calendar.getInstance();
				System.out.println("\nContinuing After Some error ocured WebDriverException & retrying again");
				guru99seleniumlink= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( xpathString)));

			}
			
		
	
	//	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
	//	System.out.println("\n Wait time ended at  time:" + cal.getTime());
		return guru99seleniumlink ;
	}

	
	
	
	public static void logOutPrime(WebDriver driver , String xpathString) {
		
		try {
			driver.findElement(By.xpath(xpathString)).click();
			driver.findElement(By.linkText("Logout")).click();
		} catch (Exception e) {
			System.out.println("\nUnable to find LogOut button");
			e.printStackTrace();
		}
		driver.quit();
		
	}

	
}
