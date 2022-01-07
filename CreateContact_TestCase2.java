package assignments.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact_TestCase2 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.xpath("//a[normalize-space(text()='CRM/SFA')]")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("Arvind");
		driver.findElement(By.id("lastNameField")).sendKeys("Kujariya");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Steve");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Nicole");
		
		driver.findElement(By.xpath("//input[@id='createContactForm_departmentName']")).sendKeys("Sprots Anlysis");
		driver.findElement(By.id("createContactForm_description")).sendKeys("A pundit is a person who offers to mass media opinion or commentary on a particular subject area (most typically politics, the social sciences, technology or sport).");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("abc@gmail.com");
		
		WebElement province = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select ddProvince = new Select(province);
		ddProvince.selectByVisibleText("New York");
	
		
		driver.findElement(By.className("smallSubmit")).click();
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("A pundit is a person who offers to mass media opinion or commentary on a particular subject area (most typically politics, the social sciences, technology or sport).");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		System.out.println(driver.getTitle()); //OUTPUT: View Contact | opentaps CRM
		driver.close();

	}

}
