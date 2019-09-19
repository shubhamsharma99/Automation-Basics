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

import PageObjectModel.EventLandingPage;
import PageObjectModel.LandingPage;
import PageObjectModel.LetsKnowLogin;

/**
 * 
 * @author Mittali_Bansal
 *
 */

public class EmpGeneralTest extends BaseTest {

	private LetsKnowLogin objLogin = null;
	private LandingPage objLanding = null;
	private EventLandingPage objEvent = null;

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
	public final void liveLink(final String email, final String password) throws Exception {
		try {
			// objLog.info("Testing Login button");
			objLogin = new LetsKnowLogin(driver);
			objLogin.login(email, password);
			// objLog.info("Testing event button");
			objEvent = new EventLandingPage(driver);
			Assert.assertTrue(objEvent.landingPageVisible());
			objLanding.linkForLogoutButton();
			String userName = objEvent.userLandingValidation();
			Assert.assertEquals("shubham", userName);

		} catch (Exception e) {
			Reporter.log("Test Failed");
			Reporter.log(e.toString());
			Assert.fail();
			throw e;
		}
	}
}
