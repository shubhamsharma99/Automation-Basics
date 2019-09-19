//package 
//functional
package functional;

import java.util.concurrent.TimeUnit;
//import 
//org
//junit
//Assert
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
import PageObjectModel.LandingPage;
import PageObjectModel.LetsKnowLogin;
import Reusable.Common;

/**
 * 
 * @author Mittali_Bansal
 *
 */

public class AdminLiveTest extends BaseTest {
	private final int thousand = 1000;
	private final int ten = 10;
	private final int five = 5;
	private AdminLivePage objLive = null;
	private LetsKnowLogin objLogin = null;
	private LandingPage objLanding = null;
	private Common objCommon = null;

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
	public final void verifyLiveLink(final String email, final String password) throws Exception {
		try {
			objLog.info("Testing Live link");
			objLogin = new LetsKnowLogin(driver);
			objLanding = new LandingPage(driver);
			objCommon = new Common().getInstance();
			objLive = new AdminLivePage(driver);

			objLogin.login(email, password);
			objLive.clickLiveLink();
			Assert.assertTrue(objLive.isSportsLabelPresent());
			driver.manage().timeouts().implicitlyWait(ten, TimeUnit.SECONDS);
			objLanding.linkForLogoutButton();
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
	public final void selectAndDeleteSportGrid(final String email, final String password) throws Exception {
		try {
			objLogin = new LetsKnowLogin(driver);
			objLanding = new LandingPage(driver);
			objCommon = new Common().getInstance();
			objLive = new AdminLivePage(driver);
			objLive.clickLiveLink();
			objLive.selectSportGrid();
			Assert.assertTrue(objLive.isGridSelected());
			objLog.info("deleting selected sport grid");
			driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);
			objLive.deleteSelectedSportGrid();
			objLanding.linkForLogoutButton();
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
	public final void verifyAddNewLivePopUp(final String email, final String password) throws Exception {

		try {
			objLogin = new LetsKnowLogin(driver);
			objLanding = new LandingPage(driver);
			objCommon = new Common().getInstance();
			objLive = new AdminLivePage(driver);
			objLog.info("testing add new live pop up");
			objLogin.login(email, password);
			objLive.clickLiveLink();
			objLive.clickAddNewLivePopUp();
			Assert.assertTrue(objLive.isPopUpVisible());
			driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);
			objLive.closeAddNewLivePopUp();
			Thread.sleep(thousand);
			objLanding.linkForLogoutButton();
		} catch (Exception e) {
			Reporter.log("Test Has Failed");
			Reporter.log(e.toString());
			Assert.fail();
			throw e;
		}

	}

}
