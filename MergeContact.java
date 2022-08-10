package week4.day1.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {


	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");

		driver.manage().window().maximize();


		driver.findElement(By.id("username")).sendKeys("demosalesmanager");


		driver.findElement(By.id("password")).sendKeys("crmsfa");


		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.linkText("CRM/SFA")).click();


		driver.findElement(By.linkText("Contacts")).click();


		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();


		driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following::a/img")).click();


		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> listOfWindows = new ArrayList<String>(windowHandles);


		driver.switchTo().window(listOfWindows.get(1));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]")).click();

		driver.switchTo().window(listOfWindows.get(0));

		driver.findElement(By.xpath("(//table[@id='widget_ComboBox_partyIdFrom']/following::a/img)[2]")).click();

		windowHandles = driver.getWindowHandles();
		
		listOfWindows = new ArrayList<String>(windowHandles);

		driver.switchTo().window(listOfWindows.get(1));

		driver.findElement(By.xpath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first '])[2]//a")).click();
		
		driver.switchTo().window(listOfWindows.get(0));
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		Alert alert = driver.switchTo().alert();

		alert.accept();

		if(driver.getTitle().equals("View Contact | opentaps CRM"))
		{
			System.out.println("Page Title is Verified as : "+driver.getTitle());
		}
		else
		{
			System.out.println("Merge Contact is Unsuccessful");
		}
	}

}
