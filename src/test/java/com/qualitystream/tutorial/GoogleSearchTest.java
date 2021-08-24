package com.qualitystream.tutorial;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mop.mcdonalds.com.ar/");
		
	}
	

	@Test
	
	public void testdeliveryscrip1() {
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
	      WebElement element = driver.findElement(By.linkText("Ver detalle"));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
	    

			
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
	      driver.findElement(By.id("autocomplete-2")).click();
	      driver.findElement(By.id("autocomplete-2")).sendKeys("Av. Corrientes 348");
	      
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	     
			
		        List<WebElement> autoSuggestions=driver.findElements(By.cssSelector(".pac-item"));
		        
		        for (WebElement suggestions : autoSuggestions) {
		            if (suggestions.getText().contains("Av. Corrientes 348")) {
		                suggestions.getText();
		            	suggestions.click();
		            	
		            	break;
		            }
		        }
	      
		        String cssSelectors = "." + "FL2";

				WebElement listaSucursal = driver.findElement(By.cssSelector(cssSelectors));     
				listaSucursal.click();
				driver.findElement(By.cssSelector(".mz-sla__button > button")).click();
				
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				
			      WebElement element11 = driver.findElement(By.cssSelector(".gm-style > div:nth-child(2) > div:nth-child(3)"));
			      Actions builder11 = new Actions(driver);
			      builder11.moveToElement(element11).release().perform();
			      
			      
				  driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
				  
					WebElement check1 = driver.findElement(By.xpath("//div[contains(@class,'AssemblyPill mt4')][1]/ul/li[1]/label/span[1]"));
					check1.click();
					

					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				  
					WebElement check2 = driver.findElement(By.xpath("//div[contains(@class,'AssemblyPill mt4')][2]/ul/li[1]/label/span[1]"));
					Actions actions1 = new Actions(driver);
					actions1.moveToElement(check2).click().build().perform();
					

					driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
					
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

					try {
						FileUtils.copyFile(scrFile, new File("./src/test/resources/screents/checkbox.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

		  driver.findElement(By.id("AddToCartButton__buyButton")).click();
		  
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		  
	      driver.findElement(By.linkText("Ir a pagar")).click();
	      
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	      
	        WebElement element16 = driver.findElement(By.id("cart-to-orderform"));
     
	      
	      
	      driver.findElement(By.cssSelector(".checkout-container")).click();
	      
	        WebElement element18 = driver.findElement(By.id("cart-to-orderform"));

	      
	    	      
	      driver.findElement(By.id("cart-to-orderform")).click();
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@After 
	
	public void teardown() {
		
		driver.quit();
	}
	
}
