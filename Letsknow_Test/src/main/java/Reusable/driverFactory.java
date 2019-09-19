//package
//reusable
package Reusable;

import java.util.logging.Logger;

//import 
//org
//openqa
//selenium
//WebDriver
import org.openqa.selenium.WebDriver;
//import 
//org.
//openqa.
//selenium.
//chrome.
//ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import 
//org.
//openqa.
//selenium.
//firefox.
//FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import
//org.
//openqa.
//selenium.
//ie.
//InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * this is a class.
 * 
 * @author Mittali_Bansal
 */


public class driverFactory {

	private Logger log = Logger.getLogger("");
	WebDriver driver = null;

	static driverFactory obj = null;

	/**
	 * the return.
	 * 
	 * @return obj obj
	 */
	public final driverFactory getInstance() {
		if (obj == null) {
			obj = new driverFactory();
		}
		return obj;
	}

	/**
	 * launch the driver.
	 */
	/**
	 * 
	 * @return driver driver
	 */
	public final WebDriver launchAndReturnDriver() {
		log.info("calling method for driver");
		PropertyReader objPropRead = new PropertyReader().getInstance();

		objPropRead.loadProperties(Constants.CONFIG_FILE_PATH);

		String browserName = objPropRead.getProperty("browser");

		if (browserName.equalsIgnoreCase("CHROME")) {
			log.info("launching Chrome driver ");
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			return driver;
		}

		else if (browserName.equalsIgnoreCase("INTERNET EXPLORER")) { // log.info("launching
																		// Internet
																		// Explorer
																		// driver
																		// ");
			System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_PATH);
			driver = new InternetExplorerDriver();
			return driver;
		}

		else if (browserName.equalsIgnoreCase("FIREFOX")) {
			log.info("launching Firefox driver ");
			driver = new FirefoxDriver();//launch
			return driver;
		} else {
			log.info("No valid driver was found ");
			System.out.println("No Driver Found");
		}
		return driver;

	}

	/**
	 * return driver.
	 * 
	 * @return driver driver
	 */
	public final WebDriver getDriver() {
		return driver;
	}

	/**
	 * destroy the driver.
	 */
	public final void destroyTheDriver() {
		log.info("Driver has been destroyed ");
		driver.quit();
	}
}
