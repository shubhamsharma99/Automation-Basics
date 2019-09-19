package Reusable;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Utilities {
	
	Utilities objUtil = null;
	public Utilities getInstance(){
		if(objUtil == null){
			objUtil = new Utilities();
		}
		return objUtil;
	}
	
	 public final static  String getDate()  
	    {  
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
	        return df.format(new Date());  
	    }  
	 public final static  String getDateTime()  
	    {  
	        DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");  
	        return dtf.format(new Date());  
	    }  

	public void captureScreenshot(ITestResult result) throws IOException
	 {
		    String methodName=result.getName().toString().trim();
		    String currentDir = new File("Test Screenshots").getAbsolutePath();
		    //System.out.println(currentDir);
		    String folderNameWithTimeStamp=getDate();
		    //System.out.println(folderNameWithTimeStamp);
		    String screenshotNameWithTimeStamp=getDateTime();
		    //System.out.println(screenshotNameWithTimeStamp);
		    String  finalPath=currentDir + "\\" + folderNameWithTimeStamp;
		   // System.out.println(finalPath);
		    
		    
		    
		    
		    File f1=new File(finalPath);
		    f1.mkdir();
		    WebDriver driver = new driverFactory().getInstance().getDriver();
		    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    String screenshotPath=f1+ "\\" + screenshotNameWithTimeStamp +"_"+ methodName+ ".jpeg";
		    String screenshotFileName = screenshotNameWithTimeStamp +"_"+ methodName+ ".jpeg";
	        // FileUtils method to copy  the screenshot to a particular destination  present in selenium-server-standalone2.17.0
		    FileUtils.copyFile(scrFile, new File(screenshotPath));
		    Reporter.log("&lt;a href="+ screenshotFileName +  "&gt;click to open&lt;/a&gt;");
		//    Log4util.logfile("screenshot has been taken and saved");

	 }
	
	
	
	

}
