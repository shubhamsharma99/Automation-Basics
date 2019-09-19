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
//WebDriver
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

public class EmpGeneralPage extends Constants {
	private final int thousand = 1000;
	private Logger log = Logger.getLogger("");
	WebDriver driver;

	@FindBy(xpath = USERGENERALRADIOSUBMIT)
	private static WebElement generalRadioSubmit;

	@FindBy(xpath = USERGENERALLINK)
	private static WebElement userGeneral;

	@FindBy(xpath = USERNOTICE)
	private static WebElement generalNotice;

	/**
	 * this is the driver.
	 * 
	 * @param driver
	 *            driver
	 */
	public EmpGeneralPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * this is notification mandatory link function.
	 */
	public final void notificationMandatoryLink() {
		log.info("click on Notification General");
		userGeneral.click();
	}

	/**
	 * this is department Radio Button function.
	 * 
	 * @throws InterruptedException
	 *             InterruptedException
	 */
	public final void departmentRadioButton() throws InterruptedException {
		Random rnd = new Random();
		List<WebElement> radios = driver
				.findElements(By.xpath("html/body/div/div/form/div/table/tbody/tr[*]/td/input"));
		radios.get(rnd.nextInt(radios.size())).click();
		log.info("radio button clicked");
		Thread.sleep(thousand);
		generalRadioSubmit.click();
		log.info("click on Notice");
		Thread.sleep(thousand);
		while (driver.getPageSource().contains("NO DATA FOUND")) {
			Thread.sleep(thousand);
			driver.navigate().back();
			Thread.sleep(thousand);
			departmentRadioButton();
		}
		generalNotice.click();

	}

	/**
	 * 
	 * @throws InterruptedException
	 *             InterruptedException
	 */
	public final void notificationGeneralNotice() throws InterruptedException {
		log.info("click on Notice");
		log.info("click on Notice");

		while (driver.getPageSource().contains("NO DATA FOUND")) {
			driver.navigate().back();
			Thread.sleep(thousand);
			departmentRadioButton();
		}
		generalNotice.click();
	}

	/**
	 * 
	 * @return userGeneral
	 */
	public final boolean userGeneralVisible() {
		return userGeneral.isEnabled();
	}

	/**
	 * 
	 * @return generalNotice
	 */
	public final boolean userGeneralNoticeVisible() {
		return generalNotice.isDisplayed();
	}
}

