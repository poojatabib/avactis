package homeWork;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Gmail {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@Test
	public void gmailClick() throws InterruptedException {
		WebElement gmail = driver.findElement(By.linkText("Gmail"));
		String pWindow = driver.getWindowHandle();
		builder.keyDown(Keys.CONTROL).click(gmail).keyUp(Keys.CONTROL).perform();
		Set<String> handle = driver.getWindowHandles();
		for (String window : handle) {
			if (!pWindow.equals(window)) {
				driver.switchTo().window(window);
				String cWindow = window;
				driver.findElement(By.linkText("Sign in")).click();
				// driver.findElement(By.xpath("//span[text()='Sign in']"));
				/*
				 * String exp=
				 * "https://accounts.google.com/v3/signin/identifier?dsh=S-570105760%3A1678501828659282&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ifkv=AWnogHdPOMM4HmsceGFRpSrKBxRV7LCpx_TZpXYNKFFtXqyqEQwgvhocJNFTyVSvwrEVJFSzwpb2Sw&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
				 * String act=driver.getCurrentUrl(); assertEquals(act, exp);
				 */
				driver.switchTo().window(pWindow);
				WebElement search = driver.findElement(By.className("gLFyf"));
				search.sendKeys("Selenium is Easy");
				search.sendKeys(Keys.ENTER);
				Thread.sleep(4000);
				/*
				 * String act= driver.findElement(By.className("gLFyf")).getAttribute("value");
				 * String exp="Selenium is Easy"; assertEquals(act, exp);
				 */ }
		}
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		builder = new Actions(driver);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
	}

	@AfterClass
	public void afterClass() {
	}

}
