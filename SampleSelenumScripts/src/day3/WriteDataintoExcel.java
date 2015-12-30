package day3;

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

public class WriteDataintoExcel {
	FirefoxDriver driver;
	@BeforeTest
	public void Setup()
	{
		driver=new FirefoxDriver();
		driver.get("https://www.stanford.edu/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test
	public void ExcelOperations() throws IOException
	{
		FileInputStream f=new FileInputStream("C:\\Desktop\\BankInfo.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Row r=null;
		Cell c=null;
		WebElement menu=driver.findElement(By.xpath("//*[@id='mainmenu']"));
		List<WebElement> links=menu.findElements(By.tagName("a"));
		for(int i=0;i<links.size();i++)
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
				menu=driver.findElement(By.xpath("//*[@id='mainmenu']"));
				links=menu.findElements(By.tagName("a"));
						
			}
		}
		FileOutputStream f1=new FileOutputStream("C:\\Desktop\\EduInfo.xlsx");
		
		wb.write(f1);
		f1.close();
		
		
	}

}
