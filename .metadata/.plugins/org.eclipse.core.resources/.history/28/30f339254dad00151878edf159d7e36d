package day6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AddEmplyoee extends Constants {
	@Test
	
	public void AddEmp()
	{
		Actions action=new Actions(driver);
		WebElement pim=driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));
		action.moveToElement(pim).build().perform();
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		driver.findElement(By.id("firstName")).sendKeys("Pawanism");
		driver.findElement(By.id("middleName")).sendKeys("Powerstar");
		driver.findElement(By.id("lastName")).sendKeys("GabbarSingh");
		driver.findElement(By.id("employeeId")).sendKeys("222");
		driver.findElement(By.id("btnSave")).click();
		
		
	}

}
