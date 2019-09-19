//package 
//functional
//import 
//org
//testng
//annotations
//Parameters
package functional;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import PageObjectModel.LandingPage;
import PageObjectModel.LetsKnowLogin;
import Reusable.Common;
import Reusable.Constants;
import Reusable.PropertyReader;
import Reusable.driverFactory;
import org.junit.Assert;
import org.testng.Reporter;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * 
 * @author Mittali_Bansal
 *
 */

public class LoginTest extends driverFactory {

	private driverFactory objFact = null;
	private WebDriver driver = null;
	private LetsKnowLogin objLogin = null;
	private Logger objLog = null;
	private Common objCommon = null;
	private PropertyReader objProp = null;
	private LandingPage objLanding = null;

	/**
	 * before test setup.
	 */
	@BeforeTest
	public final void setup() {
		objFact = new driverFactory().getInstance();
		driver = objFact.launchAndReturnDriver();
		objLogin = new LetsKnowLogin(driver);
		objLog = Logger.getLogger(" ");
		objProp = new PropertyReader().getInstance();
		objProp.loadProperties(Constants.CONFIG_FILE_PATH);
		objCommon = new Common().getInstance();
		objCommon.launchApplication(driver, objProp.getProperty("url"));
		objLog.info("Setting up objects");
		objLanding = new LandingPage(driver);
		objLog.info("working landing");

	}

	/**
	 * aftertest method.
	 */
	@AfterTest
	public final void teardown() {
		objLog.info("Memory is released");
		objFact.destroyTheDriver();
		objLogin = null;
		objLog = null;
		objProp = null;
		objCommon = null;

	}

	/**
	 * 
	 * @param email
	 *            email
	 * @param password
	 *            password
	 * @throws Exception
	 *             exception
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void loginWithValid(final String email, final String password) throws Exception {
		try {
			objLog.info("testing login with valid credentials");
			objLogin.login(email, password);
			Assert.assertTrue(new LandingPage(driver).isAddNewDisplayed());
			objLog.info("login with valid credentials test case passed...");
			Thread.sleep(2000);
		} catch (Exception e) {
			Reporter.log("Test has failed");
			Reporter.log(e.toString());
			Assert.fail();
			throw e;
		}

	}

	/**
	 * 
	 * @param email
	 *            email
	 * @param password
	 *            password
	 * @throws Exception
	 *             exception
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void loginWithInvalid(final String email, final String password) throws Exception {
		try {
			objLog.info("testing login with Invalid credentials");
			objLogin.login(email, password);
			Assert.assertTrue(new LandingPage(driver).isAddNewDisplayed());
		} catch (Exception e) {
			Reporter.log("Test Has Failed");
			Reporter.log(e.toString());
			Assert.fail();
			throw e;
		}

	}

	/**
	 * 
	 * @param email
	 *            email
	 * @param password
	 *            password
	 * @throws Exception
	 *             exception
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void submitBtnTest(final String email, final String password) throws Exception {
		try {
			objLog.info("testing submit button functionality");
			objLogin.login(email, password);
			objLogin.submitBtn();
			Assert.assertTrue(new LetsKnowLogin(driver).isSubmitEnable());
		} catch (Exception e) {
			Reporter.log("Test Has Failed");
			Reporter.log(e.toString());
			Assert.fail();
			throw e;
		}

	}

	/**
	 * 
	 * @param email
	 *            email
	 * @param password
	 *            password
	 * @throws Exception
	 *             exception
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void resetBtnTest(final String email, final String password) throws Exception {
		try {
			objLog.info("testing reset button functionality");
			objLogin.login(email, password);
			objLogin.resetBtn();
			Assert.assertTrue(new LetsKnowLogin(driver).isResetEnable());
		} catch (Exception e) {
			Reporter.log("Test Has Failed");
			Reporter.log(e.toString());
			Assert.fail();
			throw e;
		}

	}

	/**
	 * 
	 * @param email
	 *            email
	 * @param password
	 *            password
	 * @throws Exception
	 *             exception
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void logoutTestSuccessfull(final String email, final String password) throws Exception {
		try {
			objLog.info("Testing Logout Functionality");
			//objLogin.login(email, password);
			objLanding.linkForLogoutButton();
			Assert.fail();
			//Assert.assertTrue(new LetsKnowLogin(driver).isUserNameEnabled());
		} catch (Exception e) {
			Reporter.log("Test Has Failed");
			Reporter.log(e.toString());
			// Assert.fail();
			throw e;
		}

	}

}
