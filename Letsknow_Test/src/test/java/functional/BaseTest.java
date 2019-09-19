//package 
//functional
package functional;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

//import 
//org
//openqa
//selenium
//WebDriver
import org.openqa.selenium.WebDriver;
//import 
//org
//testng
//annotations
//AfterTest
import org.testng.annotations.AfterTest;
//import 
//org
//testng
//annotations
//BeforeTest;
import org.testng.annotations.BeforeTest;

import Reusable.Common;
import Reusable.Constants;
import Reusable.PropertyReader;
import Reusable.driverFactory;

/**
 * 
 * @author Mittali_Bansal
 *
 */

public class BaseTest {
	private final int fifty = 50;
	private final int ten = 10;

	private driverFactory objFact = null;
	protected WebDriver driver = null;
	protected Logger objLog = null;
	private Common objCommon = null;
	private PropertyReader objProp = null;

	/**
	 * Before Test setup method.
	 */
	@BeforeTest
	public final void setup() {

		objFact = new driverFactory().getInstance();
		driver = objFact.launchAndReturnDriver();
		driver.manage().timeouts().pageLoadTimeout(fifty, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ten, TimeUnit.SECONDS);
		objLog = Logger.getLogger(" ");
		objProp = new PropertyReader().getInstance();
		objProp.loadProperties(Constants.CONFIG_FILE_PATH);
		objCommon = new Common().getInstance();
		objCommon.launchApplication(driver, objProp.getProperty("url"));
		objLog.info("Setting up objects");
	}

	/**
	 * After test method.
	 */
	@AfterTest
	public final void teardown() {
		objLog.info("Memory is released");
		objFact.destroyTheDriver();
		objLog = null;
		objProp = null;
		objCommon = null;

	}
}
