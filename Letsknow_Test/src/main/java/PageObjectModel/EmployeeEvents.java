//package
//page
//object
//model
package PageObjectModel;

import java.util.List;
//import 
//java
//util
//Random
import java.util.Random;
import java.util.logging.Logger;

//import 
//org
//openqa
//selenium
//By
import org.openqa.selenium.By;
//import 
//org
//openqa
//selenium
//By
import org.openqa.selenium.WebDriver;
//import 
//org
//openqa
//selenium
//WebElement
import org.openqa.selenium.WebElement;
//import 
//org
//openqa
//selenium
//support
//FindBy
import org.openqa.selenium.support.FindBy;
//import 
//org
//openqa
//selenium
//support
//PageFactory
import org.openqa.selenium.support.PageFactory;

import Reusable.Constants;

/**
 * this is a class.
 * 
 * @author Mittali_Bansal
 */

public class EmployeeEvents extends Constants {

	private Logger log = Logger.getLogger("");
	final int thousand = 1000;

	WebDriver driver;

	@FindBy(linkText = "Events")
	private static WebElement employeeEvent;

	@FindBy(xpath = "html/body/div[1]/div/div/accordion/div/div[*]/div[1]")
	private static WebElement eventList;

	@FindBy(xpath = "//span[@class='ng-binding ng-scope']")
	private static WebElement firstEvent;

	/**
	 * this is the driver.
	 * 
	 * @param driver
	 *            driver
	 */
	public EmployeeEvents(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * this is click Employee Event function.
	 */
	public final void clickEmployeeEvent() {
		log.info("clicking employee events");
		employeeEvent.click();

	}

	/**
	 * this is select Event function.
	 */
	public final void selectEvent() {
		firstEvent.click();

	}

	/**
	 * 
	 * @throws InterruptedException
	 *             InterruptedException
	 */
	public final void randomlySelectEvent() throws InterruptedException {
		Random rnd = new Random();
		List<WebElement> radios = driver
				.findElements(By.xpath("html/body/div[1]/div/div/accordion/div/div[*]/div[1]/h4/a/span"));
		Thread.sleep(thousand);
		radios.get(rnd.nextInt(radios.size())).click();
		log.info("radio button clicked");
	}

}

