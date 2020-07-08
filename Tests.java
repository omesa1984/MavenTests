package test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests {
	
	//private static ChromeDriverService service;
	private WebDriver driver;
	
	/*@BeforeClass
	  public static void createAndStartService() throws IOException {
	    service = new ChromeDriverService.Builder()
	        .usingDriverExecutable(new File("Drivers/chromedriver"))
	        .usingAnyFreePort()
	        .build();
	    service.start();
	  }

	  @AfterClass
	  public static void stopService() {
	    service.stop();
	  }*/
	
	@BeforeMethod
	public void setUP() {
		System.out.println("INICIANDO");
		System.out.println(System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		DesiredCapabilities caps = new DesiredCapabilities();		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://newtours.demoaut.com/");
		System.out.println("A ESPERAR");
		try {
			System.out.println("ESPERANDO");
			Thread.sleep(5000);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("DIO MIERDA");
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void pruebaUno() {
		driver.findElement(By.name("userName")).sendKeys("user");
		driver.findElement(By.name("password")).sendKeys("user");
		driver.findElement(By.name("login")).click();
		try {
			Thread.sleep(5000);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/b")).getText().contains("Welcome back to"));
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("TERMINANDO");
		driver.close();
		System.out.println("SE ACABO");
		
	}

}