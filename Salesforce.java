package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://login.salesforce.com/");

		driver.manage().window().maximize();	

		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");

		driver.findElement(By.id("password")).sendKeys("Password$123");

		driver.findElement(By.id("Login")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();

		Set<String> Window = driver.getWindowHandles();

		List<String> FirstWindow = new ArrayList<String> (Window);

		driver.switchTo().window(FirstWindow.get(1));

		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		System.out.println(driver.getTitle());

		driver.close();

		driver.switchTo().window(FirstWindow.get(0));

		driver.close();
	}

}
