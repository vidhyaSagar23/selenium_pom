package com.sagar.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sagar.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties props;
	
	public TestBase() {
		try {
			props = new Properties();
			FileInputStream f=new FileInputStream("C:\\Users\\sagar\\Desktop\\Rest Assured\\selenium\\src\\main\\java\\com\\sagar\\qa\\config\\config.properties");
			props.load(f);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public static void initialization() {
		String browserName = props.getProperty("browser"); 
		if(browserName.equals("chrome")) {
			driver=new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(props.getProperty("url"));
	}
}
