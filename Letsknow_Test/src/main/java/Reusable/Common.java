//package
//reusable
package Reusable;


import java.util.concurrent.TimeUnit;
//import 
//org
//openqa
//selenium
import org.openqa.selenium.WebDriver;

/**
 * this is a class.
 * 
 * @author Mittali_Bansal
 */

public class Common {

	private Common objCommon = null;
	static WebDriver driver = null;
	final int twohundred = 200;

	/**
	 * the return.
	 * 
	 * @return objCommon objCommon
	 */
	public final Common getInstance() {
		if (objCommon == null) {
			objCommon = new Common();
		}
		return objCommon;
	}

	/**
	 * the driver.
	 * 
	 * @param driver
	 *            driver
	 * @param url
	 *            the url
	 */

	public final void launchApplication(final WebDriver driver, final String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(twohundred, TimeUnit.SECONDS);

	}
}
