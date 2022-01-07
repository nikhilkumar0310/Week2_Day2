package assignments.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_TestCase1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Mohan");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Lal");
		driver.findElement(By.xpath("//div[text()='Mobile number or email address']/following-sibling::input")).sendKeys("9090909090");
		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("Andora@786");
		
		WebElement day = driver.findElement(By.id("day"));
		Select bDay = new Select(day);
		bDay.selectByValue("14");
		
		WebElement month = driver.findElement(By.id("month"));
		Select bMonth = new Select(month);
		bMonth.selectByIndex(6);
		
		WebElement year = driver.findElement(By.id("year"));
		Select bYear = new Select(year);
		bYear.selectByVisibleText("1991");
		
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();
		driver.findElement(By.xpath("//button[@name='websubmit']")).click();
		driver.close();

	}

}
