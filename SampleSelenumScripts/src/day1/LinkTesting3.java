package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LinkTesting3 {
	FirefoxDriver driver;
@Test
public void linktes()
{
	driver=new FirefoxDriver();
	 driver.get("http://axisbank.com");
	 List<WebElement> links=driver.findElements(By.tagName("a"));
	 System.out.println(links.size());
	 for(int i=0;i<links.size();i++)
	 {
		 System.out.println(links.get(i).getText());
	 }
	 
}

}
