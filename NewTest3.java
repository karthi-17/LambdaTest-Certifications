package lambdatest.Test;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;

public class NewTest3 {

	WebDriver driver;
	
	@Test(priority = 1)
	public void step1() {
		driver.findElement(By.linkText("Input Form Submit")).click();
	}
	
	@Test(priority = 2)
	public void step2() {
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	}
	
	@Test(priority = 3)
	public void step3() {
		String expected = "Please fill in this field";
		String actual = driver.switchTo().alert().getText();
		Assert.assertEquals(expected, actual);
	}
	
	@Test(priority = 4)
	public void step4() {
		driver.findElement(By.id("name")).sendKeys("User");
		driver.findElement(By.id("inputEmail4")).sendKeys("test@test.com");
		driver.findElement(By.id("inputPassword4")).sendKeys("password");
		driver.findElement(By.id("company")).sendKeys("Test Company");
		driver.findElement(By.id("websitename")).sendKeys("www.test.com");
		Select select = new Select(driver.findElement(By.xpath("//select[@name='country']")));
//		select.selectByValue("US");
		select.selectByVisibleText("United States");
		driver.findElement(By.id("inputCity")).sendKeys("ABC");
		driver.findElement(By.id("inputAddress1")).sendKeys("123, ABC Street");
		driver.findElement(By.id("inputAddress2")).sendKeys("DEF Colony");
		driver.findElement(By.id("inputState")).sendKeys("KSL");
		driver.findElement(By.id("inputZip")).sendKeys("123456");
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
	}
	
	@Test(priority = 5)
	public void step5() {
		String expected = "Thanks for contacting us, we will get back to you shortly.";
		String actual = driver.findElement(By.xpath("//p[@class='success-msg hidden']")).getText();
		Assert.assertEquals(expected, actual);
	}
	
	@BeforeSuite
	public void beforeSuite() {
		driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground/");
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
