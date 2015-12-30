package day7;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsGenerations {
	@Test
	public void reportTest() throws IOException
	{
		ExtentReports reports=new ExtentReports("D:\\Selprograms\\SampleSelenumScripts\\XSLT_Reports\\Reports\\index.html",true);
		ExtentTest test=reports.startTest("Google and Gmail Test");
		FirefoxDriver driver=new FirefoxDriver();
		test.log(LogStatus.INFO, "Launched Firefox");
		driver.get("httP://google.com");
		driver.findElement(By.linkText("Gmail")).click();
		 test.log(LogStatus.INFO, "Clicked on gmail");
		 File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(srcFile,new File("D:\\Selprograms\\SampleSelenumScripts\\src\\com\\qedge\\screenshots\\gmail.png"));
		 test.addScreenCapture("D:\\Selprograms\\SampleSelenumScripts\\src\\com\\qedge\\screenshots\\gmail.png");
		 reports.endTest(test);
		 reports.flush();
		
		
	}

}
