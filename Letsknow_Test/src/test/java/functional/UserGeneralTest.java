//package 
//functional
package functional;

import org.junit.Assert;
//import 
//org
//testng
//Reporter
import org.testng.Reporter;
//import 
//org
//testng
//annotations
//Parameters
import org.testng.annotations.Parameters;
//import 
//org
//testng
//annotations
//Test
import org.testng.annotations.Test;
import PageObjectModel.AdminLivePage;
import PageObjectModel.EmpGeneralPage;
import PageObjectModel.EventLandingPage;
import PageObjectModel.LandingPage;
import PageObjectModel.LetsKnowLogin;

/**
 * 
 * @author Mittali_Bansal
 *
 */

public class UserGeneralTest extends BaseTest {
	private final int thousand = 1000;

	private LetsKnowLogin objLogin = null;
	private LandingPage objLanding = null;
	private EventLandingPage objEvent = null;
	private EmpGeneralPage objGeneral = null;

	/**
	 * 
	 * @param email
	 *            email
	 * @param password
	 *            password
	 * @throws InterruptedException
	 *             InterruptedException
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void GeneralLink(final String email, final String password) throws InterruptedException {
		try {
			objLogin = new LetsKnowLogin(driver);
			objEvent = new EventLandingPage(driver);
			objLanding = new LandingPage(driver);
			objGeneral = new EmpGeneralPage(driver);
			objLog.info("Testing Login button");
			objLogin.login(email, password);
			objLog.info("Testing event button");
			Thread.sleep(thousand);
			objGeneral.notificationMandatoryLink();
			Thread.sleep(thousand);
			Assert.assertTrue(objGeneral.userGeneralVisible());
			Thread.sleep(thousand);
			objLanding.linkForLogoutButton();
		} catch (Exception e) {
			Reporter.log("Test Failed");
			Reporter.log(e.toString());
			Assert.fail();
		}
	}

	/**
	 * 
	 * @param email
	 *            email
	 * @param password
	 *            password
	 * @throws InterruptedException
	 *             InterruptedException
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void GeneralRadio(final String email, final String password) throws InterruptedException {
		objLogin = new LetsKnowLogin(driver);
		objEvent = new EventLandingPage(driver);
		objLanding = new LandingPage(driver);
		objGeneral = new EmpGeneralPage(driver);
		objLog.info("Testing Login button");
		objLogin.login(email, password);
		objLog.info("Testing event button");
		objGeneral.notificationMandatoryLink();
		Thread.sleep(thousand);
		Assert.assertTrue(objGeneral.userGeneralVisible());
		objGeneral.departmentRadioButton();
		objLanding.linkForLogoutButton();

	}

	/**
	 * @param email
	 *            email
	 * @param password
	 *            password
	 * @throws InterruptedException
	 *             InterruptedException
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void GeneralNotice(final String email, final String password) throws InterruptedException {
		objLogin = new LetsKnowLogin(driver);
		objEvent = new EventLandingPage(driver);
		objLanding = new LandingPage(driver);
		objGeneral = new EmpGeneralPage(driver);
		objLog.info("Testing Login button");
		objLogin.login(email, password);
		objLog.info("Testing event button");
		objGeneral.notificationMandatoryLink();
		Assert.assertTrue(objGeneral.userGeneralVisible());
		objGeneral.departmentRadioButton();
		objGeneral.notificationGeneralNotice();
		Assert.assertTrue(objGeneral.userGeneralNoticeVisible());
		objLanding.linkForLogoutButton();
	}
}
