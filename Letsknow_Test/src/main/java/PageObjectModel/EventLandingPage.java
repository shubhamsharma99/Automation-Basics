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
//import 
//java
//util
//concurrent
//TimeUnit
import java.util.concurrent.TimeUnit;
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
//WebDriver
import org.openqa.selenium.WebDriver;
//import 
//org
//openqa
//selenium
//WebElement
import org.openqa.selenium.WebElement;
//import //org
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
//import 
//org
//openqa
//selenium
//support
//ui
//ExpectedConditions
import org.openqa.selenium.support.ui.ExpectedConditions;
//import 
//org
//openqa
//selenium
//support
//ui
//WebDriverWait
import org.openqa.selenium.support.ui.WebDriverWait;
//import 
//org
//testng
//Reporter
import org.testng.Reporter;

import Reusable.Constants;

/**
 * this is a class.
 * 
 * @author Mittali_Bansal
 */

public class EventLandingPage extends Constants {
	private final int five = 5;
	private final int thirty = 30;
	private Logger log = Logger.getLogger("");
	WebDriver driver;

	@FindBy(xpath = USERNAMEVAL)
	private static WebElement userNameValidation;

	@FindBy(xpath = ADDEVENT)
	private static WebElement btnAddEvent;

	@FindBy(xpath = EVENTSELECT)
	private static WebElement btnEventSelect;

	@FindBy(xpath = ADDEVENTCLOSE)
	private static WebElement btnAddEventClose;

	@FindBy(xpath = EVENTDELETE)
	private static WebElement btnEventDelete;

	@FindBy(xpath = SORT)
	private static WebElement btnSort;

	@FindBy(xpath = SORTDESCENDING)
	private static WebElement btnSortDescending;

	@FindBy(xpath = LIVEPOPUPTEXTXPATH)
	private static WebElement popUpTextXpath;

	@FindBy(xpath = LANDINGPAGEVAL)
	private static WebElement landingPageValidation;

	@FindBy(xpath = "//input[@name='eventName']")
	private static WebElement eventName;

	@FindBy(xpath = "//textarea[@name='description']")
	private static WebElement eventDescription;

	@FindBy(xpath = "//button[contains(text(),'Submit')]")
	private static WebElement submitBtn;

	@FindBy(xpath = "//div[@id='1477397580608-0-uiGrid-0007-cell']/div")
	private static WebElement eventNameVar;

	/**
	 * 
	 * @param driver
	 *            driver
	 */
	public EventLandingPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 * @return userNameVal
	 */
	public final String userLandingValidation() {
		log.info("Checking username.....");
		String userNameVal = userNameValidation.getText();
		return userNameVal;
	}

	/**
	 * 
	 */
	public final void addNew() {

		log.info("Add new pop up");
		WebDriverWait wait = new WebDriverWait(driver, thirty);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ADDEVENT)));
		btnAddEvent.click();

	}

	/**
	 * 
	 */
	public final void addNewClose() {

		WebDriverWait wait = new WebDriverWait(driver, thirty);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EVENTSELECT)));
		btnAddEventClose.click();
		log.info("Add new pop up closed");
	}

	/**
	 * 
	 */
	public final void selectEvent() {

		log.info("Select Event Notification.....");
		WebDriverWait wait = new WebDriverWait(driver, thirty);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EVENTSELECT)));
		Random rnd = new Random();
		List<WebElement> grids = driver.findElements(By.xpath("//div[@ng-click='selectButtonClick(row, $event)']"));
		grids.get(rnd.nextInt(grids.size())).click();
	}

	/**
	 * 
	 */
	public final void deleteEvent() {

		log.info("click delete event");
		WebDriverWait wait = new WebDriverWait(driver, thirty);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(EVENTDELETE)));
		btnEventDelete.click();
		log.info(" event deleted");
	}

	/**
	 * 
	 */
	public final void deleteEventRefresh() {
		try {
			log.info("click delete event");
			btnEventDelete.click();
			log.info(" event deleted");
			driver.navigate().refresh();
		} catch (Exception e) {
			Reporter.log("Test Failed");
			Reporter.log(e.toString());
		}
	}

	/**
	 * 
	 */
	public final void sort() {
		log.info("Sort button func");
		WebDriverWait wait = new WebDriverWait(driver, thirty);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SORT)));
		btnSort.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(SORTDESCENDING)));
		btnSortDescending.click();
	}

	/**
	 * 
	 * @return landingPageValidation landingPageValidation
	 */
	public final boolean landingPageVisible() {
		return landingPageValidation.isEnabled();
	}

	/**
	 * 
	 * @return PopUpTextXpath PopUpTextXpath
	 */
	public final boolean eventpopUpVisible() {
		return popUpTextXpath.isEnabled();
	}

	/**
	 * 
	 * @return btnEventSelect btnEventSelect
	 */
	public final boolean isEventGridSelected() {
		return btnEventSelect.isSelected();
	}

	/**
	 * 
	 * @return driver driver
	 */
	public final boolean isDelete() {
		return driver.getPageSource().contains("Help Desk team is available now");
	}

	/**
	 * 
	 * @param EventName
	 *            EventName
	 */
	public final void addNewEventPopupClick(String evenTName) {
		log.info("testing event pop up and adding information");
		btnAddEvent.click();
		eventName.sendKeys(evenTName);
		eventDescription.sendKeys("This is the " + evenTName + " happening at 5th floor");
		driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);
		submitBtn.click();

	}

}

