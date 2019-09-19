//package
//page
//object
//model
package PageObjectModel;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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

public class EmployeeLandingPage extends Constants {
	private final int thirty = 30;
	private Logger log = Logger.getLogger("");
	WebDriver driver;

	@FindBy(xpath = EMPLOYEEUSERNAMEVALIDATIONXPATH)
	private static WebElement employeeUserNameValidation;

	@FindBy(xpath = EMPLANDINGPAGEVALXPATH)
	private static WebElement empLandingPageVal;

	@FindBy(xpath = EMPLANDINGMANDATORYXPATH)
	private static WebElement btnEmpLandingMandatory;

	@FindBy(xpath = EMPLANDINGGENERALXPATH)
	private static WebElement btnEmpLandingGeneral;

	@FindBy(xpath = EMPLANDINGEVENTSXPATH)
	private static WebElement btnEmpLandingEvents;

	/**
	 * this is the driver.
	 * 
	 * @param driver
	 *            driver
	 */
	public EmployeeLandingPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * this is User Landing Validation function.
	 * 
	 * @return employeeUserNameVal employeeUserNameVal
	 */
	public final String UserLandingValidation() {
		log.info("Checking username.....");
		String employeeUserNameVal = employeeUserNameValidation.getText();
		return employeeUserNameVal;
	}

	/**
	 * this is empLanding Page Visible function.
	 * 
	 * @return empLandingPageVal empLandingPageVal
	 */
	public final boolean empLandingPageVisible() {
		return empLandingPageVal.isEnabled();
	}

	/**
	 * this is click Mandatory Link function.
	 */
	public final void clickMandatoryLink() {

		log.info("Click mandatory link.....");
		driver.manage().timeouts().implicitlyWait(thirty, TimeUnit.SECONDS);
		btnEmpLandingMandatory.click();
	}

	/**
	 * this is click General Link function.
	 */
	public final void clickGeneralLink() {

		log.info("Click general link.....");
		driver.manage().timeouts().implicitlyWait(thirty, TimeUnit.SECONDS);
		btnEmpLandingGeneral.click();
	}

	/**
	 * this is click Events Link function.
	 */
	public final void clickEventsLink() {

		log.info("Click events link.....");
		driver.manage().timeouts().implicitlyWait(thirty, TimeUnit.SECONDS);
		btnEmpLandingEvents.click();
	}
}
