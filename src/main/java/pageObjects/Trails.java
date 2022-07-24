package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class Trails {


	public static void main(String[] args) throws InterruptedException {
		By enterEmail = By.name("email");
		By enterFirstName = By.name("passengers.0.firstName");
		By enterLastName = By.name("passengers.0.lastName");
		By enterGender = By.name("passengers.0.gender");
		By enterPhone = By.name("phone");
		By dobMonth = By.name("month");
		By dobDay = By.name("day");
		By dobYear  = By.name("year");
		By passPortNumber = By.name("passengers.0.passportNumber");
		By address1 = By.name("booker.address_1");
		By postCode = By.name("booker.zipCode");
		By city = By.name("booker.cityName");
		By passPortNationality = By.name("passengers.0.nationality");


		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://flights.booking.com/checkout/pax/d6a1f_H4sIAAAAAAAA_y2Pb2-CMBDGP42-o9ACVkyaBYRMs7GJTo2vGqjlr4rSLk4__S5g7nLP77m0yXOl1lc1M838VBWlVsZvg4pWt0WqJRLt2cw7GFnbNtWlMNOqMxeH8HOxJmQTrUxsGlBidniTf9pQnWDjKpMoVYJNX9SxCSLOMtguaNSvRKuZg0hIgqUVTAgZlh173-4DGvfuyOL5_f799FUcKtCIxnVM4yZ5JE1zT-ol-UlGdgjdP5dCMIyQQz3c-zZVzB5IaIatAY-arSPfc4YUEIJ4xMVjJU9S6Kq9fMgH2-yoaxtwm7wSYnzxzQ5b1CD2y4_IHDvnm-3egEa2D11wC1mg5UtTvnKRTYAyTiGhLziNQI7cyabeFEhyw8F5CpRzF2bFMRr-1ny5B3lyUYpJffoHbISMPZoBAAA.?aid=304142&label=gen173nr-1FCAEoggI46AdIM1gEaFCIAQGYAQm4ARfIAQzYAQHoAQH4AQyIAgGoAgO4Aoqf15UGwAIB0gIkODMwNmIxMmItZTMwNS00NjQ4LWE1NDAtNzFlYWQ3ZTk3ZTU22AIG4AIB");
		Thread.sleep(2000);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		driver.manage().window().maximize();


		List<WebElement> allLabels =driver.findElements(By.xpath("//label[contains(@class,'Text-module')]"));  
		for(int i= 0;i<allLabels.size();i++) {
			System.out.println(allLabels.get(i).getText());
			Thread.sleep(2000);
			if(allLabels.get(i).getText().contains("Contact email")) {
				driver.findElement(enterEmail).sendKeys("pinkydindi2011@gmail.com");
			
			}
			else if(allLabels.get(i).getText().contains("First names")) {
				driver.findElement(enterFirstName).sendKeys("pinky");
			
			}
			else if(allLabels.get(i).getText().contains("Last names")) {
				driver.findElement(enterLastName).sendKeys("dindi");
				
			}
			else if(allLabels.get(i).getText().contains("Gender specified on your passport")) {
				WebElement dropdownOptions = driver.findElement(enterGender);
				Select dropdown = new Select(dropdownOptions);
				dropdown.selectByValue("F");
			
			}
			else if(allLabels.get(i).getText().contains("Country of issue")) {
				WebElement selectbutton = driver.findElement(passPortNationality);
				Select dropdown = new Select(selectbutton);
				dropdown.selectByValue("MM");
				
			}
		}
		
		List<WebElement> allphonenumbers = driver.findElements(By.xpath("//div[contains(@class,'Text-module')]"));
		for(int j=0;j<allphonenumbers.size();j++) {
			System.out.println(allphonenumbers.get(j).getText());
			if(allphonenumbers.get(j).getText().contains("Contact number")) {
				driver.findElement(enterPhone).sendKeys("7416849762");
			
			}
			if(allphonenumbers.get(j).getText().contains("Date of birth")) {
				driver.findElement(dobMonth).sendKeys("03");
				
			}
			if(allphonenumbers.get(j).getText().contains("Date of birth")) {
				driver.findElement(dobMonth).sendKeys("03");
				driver.findElement(dobDay).sendKeys("21");
				driver.findElement(dobYear).sendKeys("1992");
				
			}
		
			if(allphonenumbers.get(j).getText().contains("Passport number")) {
				driver.findElement(passPortNumber).sendKeys("MB544664");
			
				
			} 
			if(allphonenumbers.get(j).getText().contains("Date of expiry")) {
				driver.findElement(dobMonth).sendKeys("06");
				driver.findElement(dobDay).sendKeys("29");
				driver.findElement(dobYear).sendKeys("2025");
			}
			if(allphonenumbers.get(j).getText().contains("Street address")) {
				driver.findElement(address1).sendKeys("304, 23 franciscan way");
				
			}  
			if(allphonenumbers.get(j).getText().contains("Postcode")) {
				driver.findElement(postCode).sendKeys("IP1 1NB");
				
			} 
			if(allphonenumbers.get(j).getText().equalsIgnoreCase("City*")) {
				driver.findElement(city).sendKeys("ipswich");
			
			}
		}
	}

}

