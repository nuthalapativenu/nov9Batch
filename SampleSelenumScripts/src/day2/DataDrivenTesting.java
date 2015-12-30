package day2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class DataDrivenTesting {
	FirefoxDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new FirefoxDriver();
		driver.get("http://pvrcinemas.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void Datatest() throws IOException
	{
		FileInputStream f=new FileInputStream("D:\\vwenu123\\SampleSelenumScripts\\src\\com\\qedge\\excelfiles\\cineInfo12.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("Sheet1");
		Iterator<Row> row=ws.iterator();
		row.next();
		while(row.hasNext());
		Row r=row.next();
		String linkname=r.getCell(0).getStringCellValue();
		{
			driver.findElement(By.linkText(linkname)).click();
			String acturl=driver.getCurrentUrl();
			r.createCell(2).setCellValue(acturl);
			String expurl=r.getCell(1).getStringCellValue();
			if(acturl.equals(expurl))
			{
				r.createCell(3).setCellValue("passed");
			}
			else
			{
				r.createCell(3).setCellValue("failed");
			}
			driver.navigate().back();
		}
		FileOutputStream f1=new FileOutputStream("D:\\vwenu123\\SampleSelenumScripts\\src\\com\\qedge\\resultexcelfiles\\cineInfo21.xlsx");
		wb.write(f1);
		f1.close();
			
		}
		
	}
	


