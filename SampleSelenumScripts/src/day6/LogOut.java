package day6;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LogOut extends Constants {
	@Test
	public void Logout()
	{
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
	}

}
