package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver=new ChromeDriver();

		driver.get("http://www.leafground.com/pages/Window.html");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();

		String parent = driver.getWindowHandle();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='home']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> lstWin = new ArrayList<String>(windowHandles);

		String secWindow = lstWin.get(1);

		driver.switchTo().window(secWindow);

		driver.close();

		driver.switchTo().window(parent);

		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();

		Set<String> winHandles = driver.getWindowHandles();
		
		List<String> FirstWindow = new ArrayList<String>(winHandles);

		System.out.println(FirstWindow.size());

		for(int i=1; i<FirstWindow.size(); i++)
		{
			driver.switchTo().window(FirstWindow.get(i));
			
			driver.close();
		}

		driver.switchTo().window(parent);

		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();

		Set<String> winHandles1 = driver.getWindowHandles();
		
		List<String> lstWindow1 = new ArrayList<String>(winHandles1);

		for(int i=1; i<lstWindow1.size(); i++)
		{
			driver.switchTo().window(lstWindow1.get(i));
			
			driver.close();
		}

		driver.switchTo().window(parent);

		System.out.println("do not close me");

		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();

		Thread.sleep(5000);

		System.out.println("Wait done!");

		driver.quit();



	}

}
