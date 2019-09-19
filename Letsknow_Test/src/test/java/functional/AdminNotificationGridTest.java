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

import PageObjectModel.AdminNotificationGridPage;
import PageObjectModel.LandingPage;
import PageObjectModel.LetsKnowLogin;

/**
 * 
 * @author Mittali_Bansal
 *
 */

public class AdminNotificationGridTest extends BaseTest {
	private final int thousand = 1000;
	private final int five = 5;
	private final int twothousand = 2000;
	private AdminNotificationGridPage objNotification = null;
	private LetsKnowLogin objLogin = null;
	private LandingPage objLanding = null;

	/**
	 * driver method contains all the drivers
	 */
	public final void drivers() {
		objLogin = new LetsKnowLogin(driver);
		objNotification = new AdminNotificationGridPage(driver);
		objLanding = new LandingPage(driver);
	}

	/**
	 * 
	 * @param email
	 *            email
	 * @param password
	 *            password
	 * @throws Exception
	 *             exceptions
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void verifyAdminNotificationLink(final String email, final String password) throws Exception {
		try {

			objLog.info("Testing Notification link");
			drivers();
			objLogin.login(email, password);
			objNotification.clickNotificationLink();
			Assert.assertTrue(objNotification.isNotificationsFieldLabelVisible());
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
	public final void selectAndDeleteNotificationGridTest(final String email, final String password) throws Exception {
		try {
			drivers();
			objLog.info("testing Notification grid ");
			objLogin.login(email, password);
			driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);
			objNotification.clickNotificationLink();
			objNotification.selectNotificationGrid();
			Assert.assertTrue(objNotification.isNotificationsGridSelected());
			objLog.info("deleting selected Notification grid");
			objNotification.deleteSelectedNotificationGrid();
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
	public final void verifyAddAndCloseNotificationPopUp(final String email, final String password) throws Exception {
		try {
			drivers();
			objLog.info("testing add new Notification pop up");
			objLogin = new LetsKnowLogin(driver);
			objLogin.login(email, password);
			objNotification.clickNotificationLink();
			Thread.sleep(thousand);
			objNotification.addNewNotificationPopUp();
			Assert.assertTrue(objNotification.isNotificationsPopUpVisible());
			Thread.sleep(thousand);
			objNotification.closeAddNewNotificationPopUp();
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
	public final void verifyAddNewDepartmentPopUp(final String email, final String password) throws Exception {
		try {
			drivers();
			objLog.info("testing add new department pop up");
			objLogin.login(email, password);
			objNotification.clickNotificationLink();
			objNotification.addNewDepartmentPopUp();
			Assert.assertTrue(objNotification.isDepartmentPopUpVisible());
			objNotification.addNewDepartmentValue("FRAMEWORK");
			Thread.sleep(twothousand);
			objNotification.closeAddNewDepartmentPopUp();
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
	public final void verifyAddNewNotificationPopUpFunctionalityForGeneral(final String email, final String password)
			throws Exception {
		try {
			drivers();
			objLog.info("testing add new Notification pop up");
			objLogin.login(email, password);
			objNotification.clickNotificationLink();
			Thread.sleep(thousand);
			objNotification.addNewNotificationPopUp();
			Assert.assertTrue(objNotification.isNotificationsPopUpVisible());
			Thread.sleep(thousand);
			objNotification.createNotificationValueForGeneral("mittali_bansal@epam.com");
			Thread.sleep(thousand);
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
	 * /**
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
	public final void verifyAddNewNotificationPopUpFunctionalityForMandatory(final String email, final String password)
			throws Exception {
		try {

			objLog.info("testing add new Notification pop up");
			drivers();
			objLogin.login(email, password);
			objNotification.clickNotificationLink();
			Thread.sleep(thousand);
			objNotification.addNewNotificationPopUp();
			Assert.assertTrue(objNotification.isNotificationsPopUpVisible());
			Thread.sleep(thousand);
			objNotification.createNotificationValueForMandatory("shubham_sharma@epam.com");
			Thread.sleep(thousand);
			objLanding.linkForLogoutButton();
		} catch (Exception e) {
			Reporter.log("Test has failed");
			Reporter.log(e.toString());
			Assert.fail();
			throw e;
		}
	}

}
