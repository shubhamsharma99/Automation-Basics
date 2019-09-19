//package 
//functional
package functional;

import org.junit.Assert;
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

import PageObjectModel.EventLandingPage;
import PageObjectModel.LandingPage;
import PageObjectModel.LetsKnowLogin;
import PageObjectModel.UserMandatory;

/**
 * 
 * @author Mittali_Bansal
 *
 */

public class UserMandatoryTest extends BaseTest {

	private LetsKnowLogin objLogin = null;
	private LandingPage objLanding = null;
	private EventLandingPage objEvent = null;
	private UserMandatory objMandatory = null;
	final int thousand = 1000;

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
	public final void mandatoryLink(final String email, final String password) throws InterruptedException {

		objLog.info("Testing Login button");
		objLogin = new LetsKnowLogin(driver);
		objEvent = new EventLandingPage(driver);
		objLanding = new LandingPage(driver);
		objMandatory = new UserMandatory(driver);
		objLogin.login(email, password);
		objLog.info("Testing event button");
		Thread.sleep(thousand);
		objMandatory.notificationMandatoryLink();
		Assert.assertTrue(objMandatory.isUserMandatoryLinkVisible());
		objMandatory.notificationMandatoryNotice();
		Assert.assertTrue(objMandatory.userMandatoryNoticeVisible());
		objLanding.linkForLogoutButton();

	}

}
