//package
//Reusable
package Reusable;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * this is a class.
 * 
 * @author Mittali_Bansal
 */

public class TestNGListener implements ITestListener {
	/**
	 * onFinish method.
	 * 
	 * @param arg0
	 *            arg0
	 */
	public final void onFinish(final ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * onStart method.
	 * 
	 * @param arg0
	 *            arg0
	 */
	public final void onStart(final ITestContext arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * onTestfailedButWithinuccessPercetage method.
	 * 
	 * @param arg0
	 *            arg0
	 */
	public final void onTestFailedButWithinSuccessPercentage(final ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * onTestFailure method.
	 * 
	 * @param arg0
	 *            arg0
	 */
	public final void onTestFailure(final ITestResult arg0) {

		try {
			new Utilities().getInstance().captureScreenshot(arg0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}

	/**
	 * onTestSkipped method.
	 * 
	 * @param arg0
	 *            arg0
	 */
	public final void onTestSkipped(final ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * onTestStart method.
	 * 
	 * @param arg0
	 *            arg0
	 */
	public final void onTestStart(final ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param arg0
	 *            arg0
	 */
	public final void onTestSuccess(final ITestResult arg0) {
		try {
			new Utilities().getInstance().captureScreenshot(arg0);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}

}
