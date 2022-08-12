package com.hometask.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;

	// Configure browser & maximize
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ashwin_Prasath\\eclipse-workspace\\Maven\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	// Get url
	public void getUrl(String data) {
		driver.get(data);
	}

	// Sendkeys
	public void enterText(WebElement element, String data) {
		element.sendKeys(data);
	}

	// Click
	public void click(WebElement element) {
		element.click();
	}

	// Get Text
	public void getText(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	// Implicit wait
	@SuppressWarnings("deprecation")
	public void implicitWait(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);
	}
	
	//Select from dropdown
	public void selectByText(WebElement element, String text) {
		Select s= new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void selectByValue(WebElement element, String value) {
		Select s= new Select(element);
		s.selectByVisibleText(value);
	}

	// Get data from WorkBook
	public String getDataFromWorkbook(int row, int cell) throws IOException {

		File f = new File("C:\\Users\\Ashwin_Prasath\\eclipse-workspace\\Maven\\Workbooks\\data.xlsx");

		FileInputStream fInput = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fInput);

		Sheet s = w.getSheet("Sheet1");

		Row r = s.getRow(row);

		Cell c = r.getCell(cell);

		int cellType = c.getCellType();
		
		String value = null;
		if (cellType == 1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			java.util.Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/YYYY");
			value = sd.format(dateCellValue);
		} else {
			double ncv = c.getNumericCellValue();
			long l = (long) ncv;
			value = String.valueOf(l);
		}
		return value;
	}

	// Set Cell value
	public String setCellValue(int row, int cell, String customerId) throws IOException {
		String value = null;
		File f = new File("C:\\Users\\Ashwin_Prasath\\eclipse-workspace\\Maven\\Workbooks\\data.xlsx");

		FileInputStream fInput = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(fInput);

		Sheet s = w.getSheet("Sheet1");

		Row r = s.getRow(row);

		Cell c = r.getCell(cell);

		c.setCellValue(customerId);

		FileOutputStream fOut = new FileOutputStream(f);
		w.write(fOut);

		return value;
	}
}
