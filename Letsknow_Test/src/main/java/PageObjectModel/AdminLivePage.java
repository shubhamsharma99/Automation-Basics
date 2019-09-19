//package
//page
//object
//model
package PageObjectModel;

import java.util.logging.Logger;

//import
//org
//openqa
//selenium
//WebDriver
import org.openqa.selenium.WebDriver;
//import 
//org.openqa
//selenium
//WebElement
import org.openqa.selenium.WebElement;
//import 
//org.openqa
//selenium
//support
//FindBy
import org.openqa.selenium.support.FindBy;
//import
//org.openqa
//selenium
//support
//PageFactory
import org.openqa.selenium.support.PageFactory;

import Reusable.Constants;

/**
 * this is a class.
 * 
 * @author Mittali_Bansal
 */

public class AdminLivePage extends Constants {

	private Logger log = Logger.getLogger("");

	WebDriver driver;

	@FindBy(xpath = LIVEBTNXPATH)
	private static WebElement btnLive;

	@FindBy(xpath = ADDNEWXPATH)
	private static WebElement btnAddNew;

	@FindBy(xpath = CLOSEBTNXPATH)
	private static WebElement btnClose;

	@FindBy(xpath = SPORTGRIDXPATH)
	private static WebElement sportsGrid;

	@FindBy(xpath = DELETEBTNXPATH)
	private static WebElement deleteGrid;

	@FindBy(xpath = SPORTHEADXPATH)
	private static WebElement sportsHeading;

	@FindBy(xpath = LIVEPOPUPTEXTXPATH)
	private static WebElement livePopUpTxt;

	/**
	 * driver.
	 * 
	 * @param driver
	 *            driver
	 * 
	 */
	public AdminLivePage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * this is live link function.
	 */
	public final void clickLiveLink() {
		log.info("opening live page...");
		btnLive.click();
	}

	/**
	 * this is click Add New Live PopUp function.
	 */
	public final void clickAddNewLivePopUp() {
		log.info("opening add new live popup..");
		btnAddNew.click();
	}

	/**
	 * this is click Add New Live PopUp function.
	 */
	public final void closeAddNewLivePopUp() {
		log.info("closing add new live pop up ...");
		btnClose.click();
	}

	/**
	 * this is select Sport Grid function.
	 */
	public final void selectSportGrid() {
		log.info("selecting sport");
		sportsGrid.click();

	}

	/**
	 * this is delete Selected Sport Grid function.
	 */
	public final void deleteSelectedSportGrid() {
		log.info("deleting selected sport update");
		deleteGrid.click();
	}

	/**
	 * this is is Sports Label Present.
	 * 
	 * @return sportsHeading
	 */
	public final boolean isSportsLabelPresent() {
		return sportsHeading.isDisplayed();
	}

	/**
	 * this is is Pop Up Visible function.
	 * 
	 * @return LivePopUpTxt LivePopUpTxt
	 */
	public final boolean isPopUpVisible() {
		return livePopUpTxt.isEnabled();
	}

	/**
	 * this is is Grid Selected function.
	 * 
	 * @return sportsGrid sportsGrid
	 */
	public final boolean isGridSelected() {
		return sportsGrid.isEnabled();
	}
}
