package homeWork;
//assignment in wikipedia.org 

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Wikipedia {
	WebDriver driver;

	@Test
	public void searchWikipedia() {

		driver.findElement(By.id("js-link-box-en")).click();
		String expPage = "https://en.wikipedia.org/wiki/Main_Page";
		String actPage = driver.getCurrentUrl();
		assertEquals(actPage, expPage);

		WebElement search = driver.findElement(By.id("searchInput"));
		search.sendKeys("Selenium");
		search.submit();

		chkTitle();
		chkHeading();
		

	}

	public void chkTitle() {
		String expTitle = "Selenium - Wikipedia";
		String actTitle = driver.getTitle();
		assertEquals(actTitle, expTitle);
	}

	public void chkHeading() {

		String expHeading = "Selenium";
		String actHeading = driver.findElement(By.className("mw-page-title-main")).getText();
		assertEquals(actHeading, expHeading);
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

}
