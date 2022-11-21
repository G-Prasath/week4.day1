package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Learn_Window {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set <String> WindowHandler = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(WindowHandler);
		driver.switchTo().window(lst.get(1));
		driver.close();
		driver.switchTo().window(lst.get(0));
		System.out.println("New Window Open and Close Succes");
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> WH1 = driver.getWindowHandles();
		List<String> lst1 = new ArrayList<String>(WH1);
		System.out.println("--------------------------");
		System.out.println("Number Of Tabs opened : "+lst1.size());
		System.out.println("--------------------------");
		System.out.println(driver.getTitle());
		driver.switchTo().window(lst1.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(lst1.get(2));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(lst1.get(0));
		
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> WH2 = driver.getWindowHandles();
		System.out.println("--------------------------");
		List<String> lst2 = new ArrayList<String>(WH2);
		System.out.println(driver.getTitle());
		driver.switchTo().window(lst2.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(lst2.get(2));
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(lst2.get(0));
		System.out.println("--------------------------");
		
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> WH3 = driver.getWindowHandles();
		List<String> lst3 = new ArrayList<String>(WH3);
		System.out.println(driver.getTitle());
		driver.switchTo().window(lst3.get(1));
		System.out.println(driver.getTitle());
		driver.switchTo().window(lst3.get(2));
		System.out.println(driver.getTitle());
		driver.switchTo().window(lst.get(0));
		driver.quit();
		
		
		
		

	}

}
