//package
//page
//object
//model
package PageObjectModel;

import java.util.List;
//import 
//java
//util
//Random
import java.util.Random;
//import
//java
//util
//concurrent
//TimeUnit
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

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
//WebDriver
import org.openqa.selenium.WebDriver;
//import 
//org
//openqa
//selenium
//WebElement
import org.openqa.selenium.WebElement;
//import 
//org
//openqa
//selenium
//support
//FindBy
import org.openqa.selenium.support.FindBy;
//import 
//org
//openqa
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

public class AdminNotificationGridPage extends Constants {
	private final int thirty = 30;
	private final int thousand = 1000;
	private final int twothousand = 2000;
	private Logger log = Logger.getLogger("");

	WebDriver driver;

	@FindBy(css = NOTIFICATIONBTNCSS)
	private static WebElement btnNotification;

	@FindBy(xpath = ADDNEWNOTIFICATIONXPATH)
	private static WebElement btnAddNewNotification;

	@FindBy(xpath = CLOSENEWNOTIFICATIONBTNXPATH)
	private static WebElement btnCloseNotification;

	@FindBy(xpath = NOTIFICATIONGRIDXPATH)
	private static WebElement notificationsGrid;

	@FindBy(css = DELETENOTIFICATIONBTNCSS)
	private static WebElement deleteNotificationGrid;

	@FindBy(xpath = NOTIFICATIONIDXPATH)
	private static WebElement notificationId;

	@FindBy(xpath = NOTIFICATIONPOPUPTEXTXPATH)
	private static WebElement notificationPopUpText;

	@FindBy(xpath = NEWDEPARTMENTPOPUPXPATH)
	private static WebElement btnAddNewDepartment;

	@FindBy(xpath = DEPARTMENTPOPUPTEXTXPATH)
	private static WebElement departmentPopUpText;

	@FindBy(xpath = DEPARTMENTVALUEXPATH)
	private static WebElement departmentValue;

	@FindBy(xpath = DEPARTMENTADDBUTTONXPATH)
	private static WebElement btnAddDepartment;

	@FindBy(xpath = CLOSENEWDEPARTMENTPOPUPXPATH)
	private static WebElement btnCloseDepartment;

	@FindBy(xpath = RECIPIENTFIELDXPATH)
	private static WebElement txtRecipientField;

	@FindBy(xpath = RECIPIENTADDBUTTONXPATH)
	private static WebElement btnAddRecipient;

	@FindBy(xpath = SUBJECTTEXTFIELDXPATH)
	private static WebElement subjectTextField;

	@FindBy(xpath = INFOTEXTFIELDXPATH)
	private static WebElement infoTextfield;

	@FindBy(xpath = DEPARTMENTDROPDOWNXPATH)
	private static WebElement departmentListSelection;

	@FindBy(xpath = DEPARTMENTSELECTDROPDOWNXPATH)
	private static WebElement departmentSelectionFromDropdown;

	@FindBy(xpath = PRIORITYDROPDOWNXPATH)
	private static WebElement priorityListSelection;

	@FindBy(xpath = PRIORITYSELECTDROPDOWNXPATH)
	private static WebElement prioritySelectionFromDropdown;

	@FindBy(xpath = SUBMITBTNXPATH)
	private static WebElement submitBtn;

	@FindBy(xpath = DEPARTMENTSELECTDROPDOWNFORMANDATORYXPATH)
	private static WebElement departmentSelectionFromDropdownForMand;

	@FindBy(xpath = PRIORITYSELECTDROPDOWNFORMANDXPATH)
	private static WebElement prioritySelectionFromDropdownForMand;

	/**
	 * 
	 * @param driver
	 *            driver
	 */
	public AdminNotificationGridPage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * this is click notification link function.
	 * 
	 */
	public final void clickNotificationLink() {
		log.info("opening notification page...");
		driver.manage().timeouts().implicitlyWait(thirty, TimeUnit.SECONDS);
		btnNotification.click();
	}

	/**
	 * this is add New Notification Pop Up function.
	 */
	public final void addNewNotificationPopUp() {
		log.info("opening add new Notification popup..");
		driver.manage().timeouts().implicitlyWait(thirty, TimeUnit.SECONDS);
		btnAddNewNotification.click();
	}

	/**
	 * this is close Add New Notification Pop Up function.
	 */

	public final void closeAddNewNotificationPopUp() {
		log.info("closing add new notification pop up ...");
		driver.manage().timeouts().implicitlyWait(thirty, TimeUnit.SECONDS);
		btnCloseNotification.click();
	}

	/**
	 * this is select Notification Grid function.
	 */

	public final void selectNotificationGrid() {
		log.info("selecting Notification");
		Random random = new Random();
		List<WebElement> notificationGrid = driver
				.findElements(By.xpath("//div[@ng-click='selectButtonClick(row, $event)']"));
		notificationGrid.get(random.nextInt(notificationGrid.size())).click();

	}

	/**
	 * this is delete Selected Notification Grid function.
	 */

	public final void deleteSelectedNotificationGrid() {
		log.info("deleting selected Notification update");
		deleteNotificationGrid.click();
	}

	/**
	 * 
	 * @return notificationId notificationId
	 */
	public final boolean isNotificationsFieldLabelVisible() {
		return notificationId.isDisplayed();
	}

	/**
	 * 
	 * @return notificationPopUpText notificationPopUpText
	 */
	public final boolean isNotificationsPopUpVisible() {
		return notificationPopUpText.isEnabled();
	}

	/**
	 * 
	 * @return notificationsGrid notificationsGrid
	 */
	public final boolean isNotificationsGridSelected() {
		return notificationsGrid.isEnabled();
	}

	/**
	 * this is add New Department Pop Up function.
	 * 
	 */
	public final void addNewDepartmentPopUp() {
		log.info("opening add new Department popup..");
		driver.manage().timeouts().implicitlyWait(thirty, TimeUnit.SECONDS);
		btnAddNewDepartment.click();
	}

	/**
	 * this is is Department Pop Up Visible function.
	 * 
	 * @return departmentPopUpText departmentPopUpText
	 */
	public final boolean isDepartmentPopUpVisible() {
		return departmentPopUpText.isEnabled();
	}

	/**
	 * the departmentname.
	 * 
	 * @param DepartmentName
	 *            DepartmentName
	 */
	public final void addNewDepartmentValue(final String DepartmentName) {
		log.info("adding new Department value..");
		driver.manage().timeouts().implicitlyWait(thirty, TimeUnit.SECONDS);
		departmentValue.sendKeys(DepartmentName);
		btnAddDepartment.click();
	}

	/**
	 * this is close Add New Department Pop Up function.
	 * 
	 * @throws InterruptedException
	 *             InterruptedException
	 */
	public final void closeAddNewDepartmentPopUp() throws InterruptedException {
		log.info("closing add new department pop up ...");
		driver.manage().timeouts().implicitlyWait(thirty, TimeUnit.SECONDS);
		btnCloseDepartment.click();
	}

	/**
	 * the recipient name.
	 * 
	 * @param RecipientName
	 *            RecipientName
	 * @throws InterruptedException
	 *             InterruptedException the exception
	 */
	public final void createNotificationValueForGeneral(final String RecipientName) throws InterruptedException {
		log.info("adding new Department value..");
		driver.manage().timeouts().implicitlyWait(thirty, TimeUnit.SECONDS);
		txtRecipientField.sendKeys(RecipientName);
		btnAddRecipient.click();
		subjectTextField.sendKeys("Healthy You!-Mobile App Launched");
		infoTextfield.sendKeys(
				"Begin your wellness journey by completing the HRA (Health Risk Assessment). It is an integral part of your health map and helps you get to know yourself better.");
		departmentListSelection.click();
		departmentSelectionFromDropdown.sendKeys("IT");
		departmentSelectionFromDropdown.click();
		Thread.sleep(thousand);
		priorityListSelection.click();
		prioritySelectionFromDropdown.sendKeys("GENERAL");
		prioritySelectionFromDropdown.click();
		Thread.sleep(twothousand);
		submitBtn.click();

	}

	/**
	 * the recipient name.
	 * 
	 * @param RecipientName
	 *            RecipientName
	 * @throws InterruptedException
	 *             InterruptedException the exception
	 */

	public final void createNotificationValueForMandatory(final String RecipientName) throws InterruptedException {
		log.info("adding new Department value..");
		driver.manage().timeouts().implicitlyWait(thirty, TimeUnit.SECONDS);
		txtRecipientField.sendKeys(RecipientName);
		btnAddRecipient.click();
		subjectTextField.sendKeys("Timesheet gaps");
		infoTextfield.sendKeys(
				"Please find the attached PMC workload report for the period 1st to 30th Sep’16 and fill your timesheet gaps on high priority.");
		departmentListSelection.click();
		departmentSelectionFromDropdownForMand.sendKeys("PMC");
		departmentSelectionFromDropdownForMand.click();
		Thread.sleep(thousand);
		priorityListSelection.click();
		prioritySelectionFromDropdownForMand.sendKeys("MANDATORY");
		prioritySelectionFromDropdownForMand.click();
		Thread.sleep(twothousand);
		submitBtn.click();

	}
}

