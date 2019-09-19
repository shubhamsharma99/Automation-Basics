//package 
//functional
package functional;

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
//java
//util
//concurrent
//TimeUnit
import java.util.concurrent.TimeUnit;
//import 
//org
//openqa
//selenium
//By
import org.openqa.selenium.By;
//import
//org
//openqa
//selenium
//WebElement
import org.openqa.selenium.WebElement;

/**
 * 
 * @author Mittali_Bansal
 *
 */

public class EventTest extends BaseTest {
	private final int twothousand = 2000;
	private final int five = 5;

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
	 *             Exception
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void EventLink(final String email, final String password) throws Exception {
		try {
			objLogin = new LetsKnowLogin(driver);
			objLanding = new LandingPage(driver);
			objEvent = new EventLandingPage(driver);
			objLog.info("Testing Login button");
			objLogin.login(email, password);
			objLog.info("Testing event button");
			Assert.assertTrue(objEvent.landingPageVisible());
			String userName = objEvent.userLandingValidation();
			Assert.assertEquals("shubham", userName);
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
	public final void selectEventGrid(final String email, final String password) throws Exception {
		try {
			objLogin = new LetsKnowLogin(driver);
			objLanding = new LandingPage(driver);
			objEvent = new EventLandingPage(driver);
			objLog.info("Testing Login button");
			objLogin.login(email, password);
			objLog.info("testing event grid ");
			objEvent.selectEvent();
			objEvent.isEventGridSelected();
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
	public final void selectAndDeleteGrid(final String email, final String password) throws Exception {
		try {
			objLogin = new LetsKnowLogin(driver);
			objLanding = new LandingPage(driver);
			objEvent = new EventLandingPage(driver);
			objLog.info("Testing Login button");
			objLogin.login(email, password);
			objLog.info("testing event grid ");
			Thread.sleep(twothousand);
			objEvent.selectEvent();
			objEvent.isEventGridSelected();
			objLog.info("deleting selected grid");
			Thread.sleep(twothousand);
			objEvent.deleteEvent();
			Assert.assertFalse(objEvent.isDelete());
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
	public final void addNewPopUp(final String email, final String password) throws Exception {
		try {
			objLogin = new LetsKnowLogin(driver);
			objLanding = new LandingPage(driver);
			objEvent = new EventLandingPage(driver);
			objLog.info("Testing Login button");
			objLogin.login(email, password);
			objLog.info("testing add new pop up");
			objEvent.addNew();
			Assert.assertTrue(objEvent.eventpopUpVisible());
			driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);
			objEvent.addNewClose();
			Thread.sleep(twothousand);
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
	public final void Sort(final String email, final String password) throws Exception {
		try {
			objLogin = new LetsKnowLogin(driver);
			objLanding = new LandingPage(driver);
			objEvent = new EventLandingPage(driver);
			objLog.info("Testing Login button");
			objLogin.login(email, password);
			objLog.info("Sort");
			objEvent.sort();
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
	public final void addingDescriptionPopUp(final String email, final String password) throws Exception {
		try {
			objLogin = new LetsKnowLogin(driver);
			objLanding = new LandingPage(driver);
			objEvent = new EventLandingPage(driver);
			objLog.info("Adding Description To Pop Up");
			objLogin.login(email, password);
			objEvent.addNewEventPopupClick("Blood Donation");
			WebElement event = driver
					.findElement(By.xpath("//div[@class='ui-grid-cell-contents ng-binding ng-scope']"));
			String eventText = event.getText();
			Assert.assertEquals("Blood Donation", eventText);
			objLanding.linkForLogoutButton();
		} catch (Exception e) {
			Reporter.log("Test has failed");
			Reporter.log(e.toString());
			Assert.fail();
			throw e;
		}

	}
}
