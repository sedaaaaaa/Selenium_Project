package SeleniumProject;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Selenium {
	
	WebDriver driver;
	@Before
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://techfios.com/billing/?ng=admin/");
		
		
	}
	@Test
	public void Locators() {
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
		Assert.assertEquals("Dashboard page not found!", "Dashboard", driver.findElement(By.xpath("//h2[text()=' Dashboard ']")).getText());
		driver.findElement(By.xpath("//span[text()='Customers']")).click();
		driver.findElement(By.xpath("//a[text()='Add Customer']")).click();
		Random rnd = new Random();
		int generatedrandom = rnd.nextInt(9999);
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Susan" + generatedrandom );
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='cid']")));
		sel.selectByVisibleText("ATT");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("susan999@gmail.com" + generatedrandom);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("8946545555" + generatedrandom);
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("2222 Road");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Carrolton");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Texas");
		driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("546879");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
	}
	@After
	public void TearDown() {
		
		driver.close();
		driver.quit();
		
		
	}
}
