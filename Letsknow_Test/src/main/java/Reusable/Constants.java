//package
//reusable
package Reusable;

/**
 * this is a class.
 * 
 * @author Mittali_Bansal
 */

public class Constants {

	public static final String PROJECTROOTPATH = System.getProperty("user.dir");

	public static final String CONFIG_FILE_PATH = PROJECTROOTPATH + "/src/main/resources/config.properties";

	public static final String CHROME_DRIVER_PATH = PROJECTROOTPATH
			+ "/src/main/resources/drivers/chromedriver_2.25.exe";

	public static final String IE_DRIVER_PATH = PROJECTROOTPATH + "/src/main/resources/drivers/IEDriverServer.exe";

	public static final String EMAIL = "//input[@name='email' and @placeholder='username@epam.com']";

	public static final String PASSWORD = "//input[@name='password' and @placeholder='password']";

	public static final String SUBMIT = "//button[@type='submit']";

	public static final String RESET = "//button[@class='btn btn-primary col-sm-4' and @type='button']";

	public static final String WARNINGMSG = "//div[@class='help-block ng-scope']";

	public static final String USERNAMEMSG = "//div[@class='help-block ng-scope']";

	public static final String USERNAMEVAL = "//span[@class='glyphicon glyphicon-user ng-binding']";

	public static final String ADDEVENT = "//button[@class='btn btn-success pull-right btn-sharp marRt20']";

	public static final String EVENTSELECT = "//div[@ng-click='selectButtonClick(row, $event)']";

	public static final String ADDEVENTCLOSE = "//button[@data-dismiss='modal']";

	public static final String EVENTDELETE = "//button[@ng-click='deleteSelected()']";

	public static final String SORT = "//i[@class='ui-grid-icon-angle-down']";

	public static final String SORTDESCENDING = ".//*[@id='menuitem-1']/button";

	public static final String LANDINGPAGEVAL = "//a[contains(text(),'Events')]";

	public static final String LIVEBTNXPATH = "//a[@ui-sref='live']";

	public static final String ADDNEWXPATH = "//button[@class='btn btn-success pull-right button marRt20']";

	public static final String CLOSEBTNXPATH = "//*[@id='myModal']/div/div/div[1]/button";

	public static final String SPORTGRIDXPATH = "//div[@ng-click='selectButtonClick(row, $event)']";

	public static final String DELETEBTNXPATH = "//button[@ng-click='deleteSelected()']";

	public static final String SPORTHEADXPATH = "//span[contains(text(),'Sport Name')]";

	public static final String LIVEPOPUPTEXTXPATH = "//h4[contains(text(),'Add New Update')]";

	public static final String NOTIFICATIONBTNCSS = "a[ui-sref='notifications']";

	public static final String ADDNEWNOTIFICATIONXPATH = "//button[@data-target='#myModal']";

	public static final String CLOSENEWNOTIFICATIONBTNXPATH = "//button[@data-dismiss='modal' and @type='reset']";

	public static final String NOTIFICATIONGRIDXPATH = "//div[@ng-click='selectButtonClick(row, $event)']";

	public static final String DELETENOTIFICATIONBTNCSS = "button[ng-click='deleteSelected()']";

	public static final String NOTIFICATIONIDXPATH = "//span[contains(text(),'Notification Id')]";

	public static final String NOTIFICATIONPOPUPTEXTXPATH = "//h4[contains(text(),'Add New Update')]";

	public static final String USERMANDATORYLINK = "//a[contains(text(),'Mandatory')]";

	public static final String EMPLOYEEUSERNAMEVALIDATIONXPATH = "//span[@class='glyphicon glyphicon-user ng-binding']";

	public static final String EMPLANDINGPAGEVALXPATH = "//a[contains(text(),'Home')]";

	public static final String USERNOTICE = "//span[@class='ng-binding ng-scope']";

	public static final String USERGENERALLINK = "//a[contains(text(),'General')]";

	public static final String USERGENERALRADIOSUBMIT = "//button[@class='btn-placement btn btn-success buttonHolder']";

	public static final String EMPLANDINGMANDATORYXPATH = "//a[contains(text(),'Mandatory')]";

	public static final String EMPLANDINGGENERALXPATH = "//a[contains(text(),'General')]";

	public static final String EMPLANDINGEVENTSXPATH = "//a[contains(text(),'Events')]";

	public static final String NEWDEPARTMENTPOPUPXPATH = "//button[@data-target='#myDepartmentModal']";

	public static final String DEPARTMENTPOPUPTEXTXPATH = "//h4[contains(text(),'Add/Delete Department')]";

	public static final String DEPARTMENTVALUEXPATH = "//input[@ng-model='addDepartmentValue']";

	public static final String DEPARTMENTADDBUTTONXPATH = "//button[@ng-disabled='department.Department.$invalid || !department.Department']";

	public static final String CLOSENEWDEPARTMENTPOPUPXPATH = "//button[contains(text(),'×')]";

	public static final String RECIPIENTFIELDXPATH = "//input[@id='listArray']";

	public static final String RECIPIENTADDBUTTONXPATH = "//button[@ng-click='addItem()']";

	public static final String SUBJECTTEXTFIELDXPATH = "//textarea[@name='subject']";

	public static final String INFOTEXTFIELDXPATH = "//textarea[@name='information']";

	public static final String DEPARTMENTDROPDOWNXPATH = "//select[@name='deptName']";

	public static final String DEPARTMENTSELECTDROPDOWNXPATH = "//option[@value='IT']";

	public static final String PRIORITYDROPDOWNXPATH = "//select[@ng-model='Notification.priority']";

	public static final String PRIORITYSELECTDROPDOWNXPATH = "//option[@value='General']";

	public static final String SUBMITBTNXPATH = "//button[@ng-click='passingValue()']";

	public static final String DEPARTMENTSELECTDROPDOWNFORMANDATORYXPATH = "//option[@value='PMC']";

	public static final String PRIORITYSELECTDROPDOWNFORMANDXPATH = "//option[@value='Mandatory']";

}
