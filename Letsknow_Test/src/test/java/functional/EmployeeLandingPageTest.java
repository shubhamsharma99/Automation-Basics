package functional;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjectModel.AdminLivePage;
import PageObjectModel.EmployeeLandingPage;

import PageObjectModel.LandingPage;
import PageObjectModel.LetsKnowLogin;

public class EmployeeLandingPageTest extends BaseTest {

	EmployeeLandingPage objEmployeeLanding = null;
	LetsKnowLogin objLogin = null;
	AdminLivePage objLive = null;
	LandingPage objLanding = null;
	final int thousand = 1000;

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
	public void verifyEmployeeLandingPage(String email, String password) throws Exception {
		try {
			objLog.info("Testing Login button");
			objLogin = new LetsKnowLogin(driver);
			objEmployeeLanding = new EmployeeLandingPage(driver);
			objLanding = new LandingPage(driver);
			objLogin.login(email, password);
			objLog.info("Testing employee page username");
			Assert.assertTrue(objEmployeeLanding.empLandingPageVisible());
			String userName = objEmployeeLanding.UserLandingValidation();
			Assert.assertEquals("Mittali", userName);
			objLanding.linkForLogoutButton();

		} catch (Exception e) {
			Reporter.log("Test Failed");
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
	public void verifyMenuBarLinks(String email, String password) throws Exception {
		try {
			objLog.info("Testing Login button");
			objLogin = new LetsKnowLogin(driver);
			objEmployeeLanding = new EmployeeLandingPage(driver);
			objLanding = new LandingPage(driver);
			objLogin.login(email, password);
			objLog.info("Testing employee page links");
			objEmployeeLanding.clickMandatoryLink();
			Thread.sleep(thousand);
			objEmployeeLanding.clickGeneralLink();
			Thread.sleep(thousand);
			objEmployeeLanding.clickEventsLink();
			Thread.sleep(thousand);
			objLanding.linkForLogoutButton();

		} catch (Exception e) {
			Reporter.log("Test Failed");
			Reporter.log(e.toString());
			Assert.fail();
			throw e;
		}
	}
}
