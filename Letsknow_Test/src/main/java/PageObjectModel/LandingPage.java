//package
//page
//object
//model
package PageObjectModel;

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

/**
 * this is a class.
 * 
 * @author Mittali_Bansal
 */

public class LandingPage {

	private Logger log = Logger.getLogger("");

	WebDriver driver;

	@FindBy(xpath = "//button[@class='btn btn-success pull-right btn-sharp marRt20']")
	private static WebElement btnAddNew;

	@FindBy(xpath = "//span[@class='glyphicon glyphicon-user ng-binding']")
	private static WebElement lnkUser;

	@FindBy(xpath = "//a[@ng-click='logout()']")
	private static WebElement lnkLogout;

	/**
	 * this is the driver.
	 * 
	 * @param driver
	 *            driver
	 */
	public LandingPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * this is is Add New Displayed function.
	 * 
	 * @return btnAddNew btnAddNew
	 */
	public final boolean isAddNewDisplayed() {
		log.info("Checking add new button on landing page");
		return btnAddNew.isDisplayed();
	}

	/**
	 * this is link For Logout Button function.
	 */
	public final void linkForLogoutButton() {
		log.info("Clicking on link for logout button");
		lnkLogout.click();
		log.info(("User Logged out successfully"));
	}
}
