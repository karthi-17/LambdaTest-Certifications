package lambdatest.Test;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;

public class NewTest2 {

	WebDriver driver;
	
	@Test(priority = 1)
	public void step1() {
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
	}
	
	@Test(priority = 2)
	public void step2() {
		WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(slider, 215, 240).build().perform();
	}
	
	@Test(priority = 3)
	public void step3() {
		String expected = "95";
		String actual = driver.findElement(By.id("rangeSuccess")).getText();
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
