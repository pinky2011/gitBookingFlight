package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class flightsPage {
	public WebDriver driver; 

	By oneWayButton = By.cssSelector("div[data-testid='searchbox_controller_trip_type_ONEWAY']");
	By toWhere = By.cssSelector("div[data-testid='searchbox_origin']");
	By crossButton = By.cssSelector("span[class='css-1lq4ejz']");
	By toWhereEnter = By.cssSelector("input[placeholder='Where from?']");
	By allToWhere = By.cssSelector("div[class='css-2r1cd1'] div span");
	By destinationButton = By.cssSelector("input[data-testid='searchbox_destination_input']");
	By destionallAllOptions = By.xpath("//div[@class='css-2r1cd1']//div//span[2]");
	By date = By.cssSelector("input[placeholder='Depart']");
	By allMonths = By.cssSelector("div[class='Calendar-module__month___3_L3c']");
	By nextButtonCalander = By.xpath("//button[contains(@class,'next')]");
	By allDates = By.cssSelector("td[class*='date']");
	By searchButton = By.cssSelector("button[data-testid='searchbox_submit']");
	By cheapbutton = By.cssSelector("button[aria-controls='CHEAPEST']");
	By firstCheapFlight = By.cssSelector("div[id='flightcard-0']");
	By firstCheapFlightButton = By.xpath("//div[@id='flightcard-0']//div//div//div//div//div[2]//div[2]//button");		//div[@id='flightcard-0']//div//div//div//div//div[2]//div[2]//button
	By searchOnFlight = By.cssSelector("div[data-testid='flight_details_inner_modal_select_button']");
	
	
	
	
	
	public flightsPage(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement oneWay() throws InterruptedException {
		return driver.findElement(oneWayButton);
	}
	public WebElement toWhere() {
		return driver.findElement(toWhere);
	}
	public WebElement crossButton() {
		return driver.findElement(crossButton);
	}
	public WebElement toWhereEnter() {
		return driver.findElement(toWhereEnter);
	}
	public void allToWhere() {
		List<WebElement> allToWheres =  driver.findElements(allToWhere);
		for(int i = 0; i< allToWheres.size() ; i++) {
			if(allToWheres.get(i).getText().equalsIgnoreCase("Rajiv Gandhi International Airport")) {
				allToWheres.get(i).click();
				break; 
			}
		}
	}
	public WebElement destinationButton() {
		return driver.findElement(destinationButton);
	}
	public void destinationSelect() {
		List<WebElement> allOptions = driver.findElements(destionallAllOptions);
		for(int i =0;i<allOptions.size();i++) {
			if(allOptions.get(i).getText().equalsIgnoreCase("London Heathrow Airport")) {
				allOptions.get(i).click();
				break;
			}
		}	
	}

	public WebElement date() {
		return driver.findElement(date);
	}

	public void allMonthsMethod() {
		while(!driver.findElement(allMonths).getText().contains("September")) {
			driver.findElement(nextButtonCalander).click();
		}
		List<WebElement> allDateOptions = driver.findElements(allDates);
		for(int i = 0; i<allDateOptions.size();i++)
		{
			if(allDateOptions.get(i).getText().equalsIgnoreCase("22")) {
				allDateOptions.get(i).click();
				break;
			}
		}

	}
	public WebElement searchButton() {
		return driver.findElement(searchButton);
	}
	public WebElement cheapbutton() {
		return driver.findElement(cheapbutton);
	}
	public WebElement firstCheapFlight() {
		return driver.findElement(firstCheapFlight);
	}
	public WebElement firstCheapFlightButton() {
		return driver.findElement(firstCheapFlightButton);
	}
	public WebElement searchOnFlight() {
		return driver.findElement(searchOnFlight);
	}
	





}
