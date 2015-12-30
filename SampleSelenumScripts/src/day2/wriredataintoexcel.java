package day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class wriredataintoexcel {
	FirefoxDriver driver;
	@BeforeTest
	public void Setup()
	{
		driver=new FirefoxDriver();
		driver.get("http://pvrcinemas.com");
		driver.findElement(By.className("modal-skip")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void linkTesting() throws IOException
	{
		FileInputStream f=new FileInputStream("C:\\Desktop\\cineInfo.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Row r=null;
		Cell c=null;
		WebElement block=driver.findElement(By.xpath("html/body/div[6]/div[1]/div[2]"));
		List<WebElement> links=block.findElements(By.tagName("a"));
		for (int i = 0; i < links.size(); i++) 
		{
			r=ws.createRow(i);
			if(links.get(i).isDisplayed())
			{
				c=r.createCell(0);
				c.setCellValue(links.get(i).getText());
				links.get(i).click();
				c=r.createCell(1);
				c.setCellValue(driver.getCurrentUrl());
				driver.navigate().back();
				block=driver.findElement(By.xpath("html/body/div[6]/div[1]/div[2]"));
				links=block.findElements(By.tagName("a"));
			}
		}
			FileOutputStream f1=new FileOutputStream("C:\\Desktop\\cineInfo12.xlsx");
		
			wb.write(f1);
			f1.close();
	}

}
