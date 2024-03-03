package lambdatest.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NewTest1 {

	WebDriver driver;
	
	String enterMessageTextBox;
	
	@Test(priority = 1)
	public void step1() {
		driver.findElement(By.linkText("Simple Form Demo")).click();
	}
	
	@Test(priority = 2)
	public void step2() {
		String url = driver.getCurrentUrl();
		boolean actual = url.contains("simple-form-demo");
		boolean expected = true;
		Assert.assertEquals(expected, actual);
	}
	
	@Test(priority = 3)
	public void step3() {
		enterMessageTextBox = "Welcome to LambdaTest";
		driver.findElement(By.id("user-message")).sendKeys(enterMessageTextBox);
	}
	
	@Test(priority = 4)
	public void step4() {
		driver.findElement(By.id("showInput")).click();
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority = 5)
	public void step5() {
		String expected = enterMessageTextBox;
		String actual = driver.findElement(By.id("message")).getText();
		Assert.assertEquals(expected, actual);
	}

	@BeforeSuite
	public void beforeSuite() {
		driver = new ChromeDriver();
		driver.get("https://www.lambdatest.com/selenium-playground");
	}

	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}

}
