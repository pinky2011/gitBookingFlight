package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	private WebDriver driver ;
	By acceptButton = By.id("onetrust-accept-btn-handler");
	By flightButton = By.cssSelector("a[data-decider-header='flights']");


	public LandingPage(WebDriver driver) {
		this.driver= driver;
	}

	public WebElement flightButton() {
		driver.manage().window().maximize();
		return driver.findElement(flightButton);
	}
	public WebElement acceptButton() {
		return driver.findElement(acceptButton);
	}


}
