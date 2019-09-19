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
import PageObjectModel.AdminNotificationGridPage;
import PageObjectModel.EventLandingPage;
import PageObjectModel.LandingPage;
import PageObjectModel.LetsKnowLogin;
import Reusable.Common;

//import 
//java
//sql
//SQLException
import java.sql.SQLException;
//import 
//org
//.apache
//.log4j
//.Logger;
import org.apache.log4j.Logger;
//import 
//org
//openqa
//selenium
//By;
import org.openqa.selenium.By;
//import 
//org
//openqa
//selenium
//WebElement;
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Mittali_Bansal
 *
 */

public class RegressionSuite extends BaseTest {
	private final int five = 5;
	private final int twothousand = 2000;
	private final int thousand = 1000;
	private LetsKnowLogin objLogin = null;
	private Logger objLog = null;
	private Common objCommon = null;
	private LandingPage objLanding = null;
	private EventLandingPage objEvent = null;
	private AdminLivePage objLive = null;
	private AdminNotificationGridPage objNotification = null;

	/**
	 * drivers.
	 */
	public final void drivers() {
		objLogin = new LetsKnowLogin(driver);
		objLanding = new LandingPage(driver);
		objEvent = new EventLandingPage(driver);
		objNotification = new AdminNotificationGridPage(driver);
		objLive = new AdminLivePage(driver);
	}

	/**
	 * 
	 * @param email
	 *            email
	 * @throws InterruptedException
	 *             InterruptedException
	 * @throws ClassNotFoundException
	 *             ClassNotFoundException
	 * @throws SQLException
	 *             SQLException
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void adminRegressionTest(final String email, String password)
			throws InterruptedException, ClassNotFoundException, SQLException {
		// drivers();
		objLogin = new LetsKnowLogin(driver);
		objLanding = new LandingPage(driver);
		objEvent = new EventLandingPage(driver);
		objNotification = new AdminNotificationGridPage(driver);
		objLive = new AdminLivePage(driver);
		objLog = Logger.getLogger(" ");

		// admin login ,fetching username value from database
		objLog.info("testing login fuctionality with valid credentials");
		objLogin.login(email, password);
		Assert.assertTrue(new LandingPage(driver).isAddNewDisplayed());

		driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);

		// adminlanding event page
		Assert.assertTrue(objEvent.landingPageVisible());

		// testing whether user is present in database or not
		String userName = objEvent.userLandingValidation();
		Assert.assertEquals("Sunil", userName);

		// adding popup
		objEvent.addNewEventPopupClick("Blood Donation");
		WebElement event = driver.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']"));
		String eventText = event.getText();
		Assert.assertEquals("Blood Donation", eventText);

		// selecting and deleting event grid randomly
		objEvent.selectEvent();
		objEvent.isEventGridSelected();
		objLog.info("deleting selected grid");
		Thread.sleep(twothousand);
		objEvent.deleteEvent();
		Assert.assertFalse(objEvent.isDelete());

		// admin users come to notification page
		objNotification.clickNotificationLink();
		Assert.assertTrue(objNotification.isNotificationsFieldLabelVisible());

		// adding popup for notification for general
		objNotification.addNewNotificationPopUp();
		Assert.assertTrue(objNotification.isNotificationsPopUpVisible());
		Thread.sleep(thousand);
		objNotification.createNotificationValueForGeneral("mittali_bansal@epam.com");
		Thread.sleep(thousand);

		// adding popup for notification for mandatory
		objNotification.addNewNotificationPopUp();
		Assert.assertTrue(objNotification.isNotificationsPopUpVisible());
		Thread.sleep(thousand);
		objNotification.createNotificationValueForMandatory("shubham_sharma@epam.com");
		Thread.sleep(thousand);

		// selecting and deleting notification grid randomly
		objNotification.selectNotificationGrid();
		Assert.assertTrue(objNotification.isNotificationsGridSelected());
		objLog.info("deleting selected Notification grid");
		objNotification.deleteSelectedNotificationGrid();

		// adding department
		objNotification.addNewDepartmentPopUp();
		Assert.assertTrue(objNotification.isDepartmentPopUpVisible());
		objNotification.addNewDepartmentValue("FRAMEWORK");
		Thread.sleep(twothousand);
		objNotification.closeAddNewDepartmentPopUp();

		// admin users come to admin live page
		objLive.clickLiveLink();
		Assert.assertTrue(objLive.isSportsLabelPresent());
		driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);

		// admin live pop up
		objLive.clickAddNewLivePopUp();
		Assert.assertTrue(objLive.isPopUpVisible());
		driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);
		objLive.closeAddNewLivePopUp();
		Thread.sleep(thousand);

		// selecting and deleting admin live grid
		objLive.selectSportGrid();
		Assert.assertTrue(objLive.isGridSelected());
		objLog.info("deleting selected sport grid");
		driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);
		objLive.deleteSelectedSportGrid();

		// admin users logs out of application
		driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);
		objLanding.linkForLogoutButton();
		Assert.assertTrue(new LetsKnowLogin(driver).isUserNameEnabled());
	}

}
