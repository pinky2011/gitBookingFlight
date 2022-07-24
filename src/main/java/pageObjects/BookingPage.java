package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookingPage {
	public WebDriver driver;
	By enterEmail = By.cssSelector("input[type='email']");
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
	By expiryDate = By.cssSelector("div[id='passengers.0.expiryDate'] input[name='day']");
	By expiryMonth = By.cssSelector("div[id='passengers.0.expiryDate'] input[name='month']");
	By expiryYear = By.cssSelector("div[id='passengers.0.expiryDate'] input[name='year']");
	boolean isPassPortEntered = false;
	boolean isStreetAddEntered = false;
	By nextAfterDetails = By.cssSelector("div[data-testid='checkout_extras_inner_next']");
	By nextBeforeDetails = By.cssSelector("div[data-testid='checkout_ticket_type_inner_next']");
	




	public BookingPage(WebDriver driver) {
		this.driver=driver;
	}
	public void allValues() throws InterruptedException {
		List<WebElement> allLabels =driver.findElements(By.xpath("//label[contains(@class,'Text-module')]"));  
		for(int i=0;i<allLabels.size();i++) {
			System.out.println(allLabels.get(i).getText());
			if(allLabels.get(i).getText().contains("Contact email")) {
				driver.findElement(enterEmail).sendKeys("pinkydindi2011@gmail.com");
			}
			else if(allLabels.get(i).getText().contains("Country of issue")) {
				WebElement selectbutton = driver.findElement(passPortNationality);
				Select dropdown = new Select(selectbutton);
				dropdown.selectByValue("MM");

			}
		}
		//divs
		List<WebElement> alldivs =driver.findElements(By.xpath("//div[contains(@class,'Text-module')]"));
		for(int j=0;j<alldivs.size();j++) {
			System.out.println(alldivs.get(j).getText());
			if(alldivs.get(j).getText().equalsIgnoreCase("Contact number*")) {
				driver.findElement(enterPhone).sendKeys("7416849762");
			}
			else if(alldivs.get(j).getText().equalsIgnoreCase("First names*")) {
				driver.findElement(enterFirstName).sendKeys("pinky");
			}
			else if(alldivs.get(j).getText().equalsIgnoreCase("Last names*")) {
				driver.findElement(enterLastName).sendKeys("dindi");
			}
			else if(alldivs.get(j).getText().contains("Date of birth")) {
				driver.findElement(dobMonth).sendKeys("03");
				driver.findElement(dobDay).sendKeys("21");
				driver.findElement(dobYear).sendKeys("1992");
			}
			else if(alldivs.get(j).getText().equalsIgnoreCase("Passport number*") && !isPassPortEntered ) {
				driver.findElement(passPortNumber).sendKeys("MB544664");
				isPassPortEntered = true;
			}
			else if(alldivs.get(j).getText().contains("Date of expiry")) {
				driver.findElement(expiryDate).sendKeys("22");
				driver.findElement(expiryMonth).sendKeys("03");
				driver.findElement(expiryYear).sendKeys("2025");
			} 
			else if(alldivs.get(j).getText().contains("Street address") && !isStreetAddEntered) {
				driver.findElement(address1).sendKeys("304, 23 franciscan way");
				isStreetAddEntered = true;
			}
			else if(alldivs.get(j).getText().equalsIgnoreCase("Postcode*")) {
				driver.findElement(postCode).sendKeys("1P1 INB");
			}
			else if(alldivs.get(j).getText().equalsIgnoreCase("City*")) {
				driver.findElement(city).sendKeys("ipswich");
			}
		}
		WebElement gender = driver.findElement(By.xpath("//div[@data-testid='checkout_form_passenger_0_gender']//label//div"));
		if(gender.getText().contains("Gender specified on your passport")) {
			Thread.sleep(2000);
			WebElement dropdownOptions = driver.findElement(enterGender);
			Select dropdown = new Select(dropdownOptions);
			dropdown.selectByValue("F");
		}	

	}
	public WebElement nextbuttonAfterDetails() {
		return driver.findElement(nextAfterDetails);
	}
	public WebElement nextBeforeDetails() {
		return driver.findElement(nextBeforeDetails);
	}
}