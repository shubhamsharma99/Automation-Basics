//package 
//functional
package functional;

import java.util.concurrent.TimeUnit;
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

import PageObjectModel.EmployeeEvents;
import PageObjectModel.LandingPage;
import PageObjectModel.LetsKnowLogin;

/**
 * 
 * @author Mittali_Bansal
 *
 */

public class EmployeeEventTest extends BaseTest {
	private final int five = 5;

	private LetsKnowLogin objLogin = null;
	private LandingPage objLanding = null;
	private EmployeeEvents objEmpEvent = null;

	/**
	 * 
	 * @param email
	 *            email
	 * @param password
	 *            password
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void verifyEventLink(final String email, final String password) {
		objLogin = new LetsKnowLogin(driver);
		objLanding = new LandingPage(driver);
		objEmpEvent = new EmployeeEvents(driver);
		objLogin.login(email, password);
		objEmpEvent.clickEmployeeEvent();
		driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);
		objLanding.linkForLogoutButton();
	}

	/**
	 * 
	 * @param email
	 *            email
	 * @param password
	 *            password
	 */
	@Parameters({ "email", "password" })
	@Test
	public final void clickEvent(final String email, final String password) throws InterruptedException {
		objLogin = new LetsKnowLogin(driver);
		objLanding = new LandingPage(driver);
		objEmpEvent = new EmployeeEvents(driver);
		objLogin.login(email, password);
		objEmpEvent.clickEmployeeEvent();
		driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);
		objEmpEvent.randomlySelectEvent();
		driver.manage().timeouts().implicitlyWait(five, TimeUnit.SECONDS);
		objLanding.linkForLogoutButton();
	}
}
