package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LinkTesting1 {
	FirefoxDriver driver;
	@BeforeTest
	public void Setup()
	{
		driver=new FirefoxDriver();
		driver.get("http://bing.com");
	}
	@Test
	public void linktest()
	{
		WebElement block=driver.findElement(By.id("sc_hdu" ));
		List<WebElement>  links=block.findElements(By.tagName("a"));
		System.out.println(links.size());
		for(int i=0;i<links.size();i++)
		{
			System.out.println(links.get(i).getText());
			
		}
		
			
		}	
	

}
