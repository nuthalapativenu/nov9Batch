package day1;

import java.io.IOException;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LinkTesting2 {
	
	@Test
	public void SetUp() throws IOException
	{
	DesiredCapabilities cap=null;
	cap=DesiredCapabilities.chrome();
	cap.setBrowserName("firefox");
	cap.setPlatform(Platform.WINDOWS);
	RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
	driver.get("http://google.com");
	String expurl="Gmail";
	driver.findElement(By.linkText("Gmail")).click();
	String acturl=driver.getTitle();
	if(expurl.equals(acturl))
	{
		System.out.println("Gmail link Working Correctly");
	}
	else {

		System.out.println("Gmail link Working Correctly");
	}
		
}
}