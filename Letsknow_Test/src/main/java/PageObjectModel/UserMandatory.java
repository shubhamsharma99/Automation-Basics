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

import Reusable.Constants;

/**
 * this is a class.
 * 
 * @author Mittali_Bansal
 */

public class UserMandatory extends Constants {
	private final int thousand = 1000;

	private Logger log = Logger.getLogger("");
	WebDriver driver;

	@FindBy(xpath = USERMANDATORYLINK)
	private static WebElement userMandatory;

	@FindBy(xpath = USERNOTICE)
	private static WebElement mandatoryNotice;

	/**
	 * this is the driver.
	 * 
	 * @param driver
	 *            driver
	 * 
	 */
	public UserMandatory(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * this is notification Mandatory Link function.
	 * 
	 * @throws InterruptedException
	 *             InterruptedException
	 */
	public final void notificationMandatoryLink() throws InterruptedException {
		log.info("click on Notification");
		Thread.sleep(thousand);
		userMandatory.click();
	}

	/**
	 * this is notification Mandatory Notice function.
	 */
	public final void notificationMandatoryNotice() {
		log.info("click on Notice");
		mandatoryNotice.click();
	}

	/**
	 * this is is User Mandatory Link Visible function.
	 * 
	 * @return userMandatory userMandatory
	 * @throws InterruptedException
	 *             InterruptedException
	 */
	public final boolean isUserMandatoryLinkVisible() throws InterruptedException {
		Thread.sleep(thousand);
		return userMandatory.isEnabled();
	}

	/**
	 * this is user Mandatory Notice Visible function.
	 * 
	 * @return mandatoryNotice mandatoryNotice
	 */
	public final boolean userMandatoryNoticeVisible() {
		return mandatoryNotice.isDisplayed();
	}
}
