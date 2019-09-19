//package
//page
//object
//model
package PageObjectModel;

import java.sql.SQLException;
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
//import 
//org
//testng
//Assert
import org.testng.Assert;

import Reusable.Constants;
import Reusable.JdbcFetch;

/**
 * this is a class.
 * 
 * @author Mittali_Bansal
 */

public class LetsKnowLogin extends Constants {

	private Logger log = Logger.getLogger("");

	WebDriver driver;

	@FindBy(xpath = EMAIL)
	private static WebElement txtUserName;

	@FindBy(xpath = PASSWORD)
	private static WebElement txtPassword;

	@FindBy(xpath = SUBMIT)
	private static WebElement btnLogin;

	@FindBy(xpath = RESET)
	private static WebElement btnReset;

	@FindBy(xpath = WARNINGMSG)
	private static WebElement txtWarning;

	@FindBy(xpath = USERNAMEMSG)
	private static WebElement uiText;

	JdbcFetch obj = new JdbcFetch();

	/**
	 * 
	 * 
	 * @param driver
	 *            driver
	 */
	public LetsKnowLogin(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 * 
	 * @param strUserName
	 *            strUserName
	 * @param strPassword
	 *            strPassword
	 */

	public final void login(final String strUserName, final String strPassword) {
		log.info("Started Login functionn");
		txtUserName.sendKeys(strUserName);
		txtPassword.sendKeys(strPassword);
		btnLogin.click();
		log.info("Successfull login");
	}

	/**
	 * 
	 * @param firstName
	 *            firstname
	 * @throws ClassNotFoundException
	 *             ClassNotFoundException
	 * @throws SQLException
	 *             SQLException
	 */

	public final void login(final String firstName) throws ClassNotFoundException, SQLException {
		log.info("Opening Login function.....");
		String strUserName = obj.Username(firstName);
		String strPassword = obj.Password(firstName);
		txtUserName.sendKeys(strUserName);
		txtPassword.sendKeys(strPassword);
		btnLogin.click();
		log.info("Successfull login");
	}

	/**
	 * 
	 * 
	 * method for submit button functionality.
	 */
	public final void submitBtn() {
		log.info("Checking Submit button status.....");
		if (btnLogin.isEnabled()) {
			log.info("submit button is enabled");
		} else {
			log.info("submit button is disabled");
		}
	}

	/**
	 * 
	 * method for reset button functionality.
	 * 
	 */
	public final void resetBtn() {
		log.info("Checking Reset button status.....");
		btnReset.click();
		String warningMsg = txtWarning.getText();
		if (warningMsg.contains("This field is required.")) {
			log.info("Username field is clear...");
		} else {
			log.info("Username field is not clear...");
		}
	}

	/**
	 * 
	 * @return btnLogin btnLogin
	 */
	public final boolean isSubmitEnable() {
		log.info("Submit button assertion");
		return btnLogin.isEnabled();
	}

	/**
	 * 
	 * @return txtWarning txtWarning
	 */
	public final boolean isResetEnable() {
		log.info("Reset button assertion");
		return txtWarning.isDisplayed();

	}

	/**
	 * 
	 * @return uiText uiText
	 */
	public final boolean isUItextdisplayed() {
		log.info("UI text assertion");
		return uiText.isDisplayed();
	}

	/**
	 * 
	 * @return txtUserName txtUserName
	 */
	public final boolean isUserNameEnabled() {
		log.info("logout page assertion");
		return txtUserName.isDisplayed();

	}

	/**
	 * 
	 * @param email
	 *            email
	 */
	public final void UIcheck(String email) {
		txtUserName.sendKeys(email);
		String actualEmail = txtUserName.getText();
		if (actualEmail.contains(email + "@epam.com")) {
			log.info("Valid email");
		} else {
			isUItextdisplayed();
			Assert.assertTrue(isUItextdisplayed());
		}
	}
}

