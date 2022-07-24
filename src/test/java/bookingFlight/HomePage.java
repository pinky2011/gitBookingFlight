package bookingFlight;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BookingPage;
import pageObjects.LandingPage;
import pageObjects.flightsPage;
import resources.Base;

public class HomePage extends Base {
	public WebDriver driver;
	@AfterTest
	public void teardown() {
		driver.close();
	}
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("URL"));
	}
	
	@Test
	public void frontPageNavigation() throws IOException, InterruptedException {
		LandingPage lan = new LandingPage(driver);

		lan.acceptButton().click();
		Thread.sleep(1000);
		lan.flightButton().click();
		Thread.sleep(2000);

		flightsPage fp = new flightsPage(driver);
		fp.oneWay().click();
		fp.toWhere().click();
		fp.crossButton().click();
		fp.toWhereEnter().sendKeys("hyd");
		fp.allToWhere();
		fp.destinationButton().sendKeys("lhr");
		Thread.sleep(2000);
		fp.destinationSelect();
		fp.date().click();
		fp.allMonthsMethod();
		fp.searchButton().click();
		Thread.sleep(6000);
		fp.cheapbutton().click();
		fp.firstCheapFlight().click();
		fp.firstCheapFlightButton().click();
		fp.searchOnFlight().click();

		BookingPage bp = new BookingPage(driver);
		bp.nextBeforeDetails().click();
		bp.allValues();
		bp.nextbuttonAfterDetails().click();
		Thread.sleep(2000);
		bp.nextbuttonAfterDetails().click();
		Thread.sleep(2000);
		bp.nextbuttonAfterDetails().click();






	}



}
