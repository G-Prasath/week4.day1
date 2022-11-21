package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Learn_Alert {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();  
		ChromeDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.get("https://www.leafground.com/alert.xhtml"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("(//div[@class='card']//span[text()='Show'])[1]")).click();
		Alert simple = driver.switchTo().alert();
		System.out.println("The Simple Alert : "+simple.getText());
		simple.accept();
		
		driver.findElement(By.xpath("(//div[@class='card']//span[text()='Show'])[5]")).click();
		Alert promt = driver.switchTo().alert();
		System.out.println("The Simple Alert : "+simple.getText());
		promt.sendKeys("Trestleaf");
		simple.accept();
		String result = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println("Promt alert result : "+result);
		
		driver.findElement(By.xpath("(//div[@class='card']//span[text()='Show'])[2]")).click();
		Alert confirm = driver.switchTo().alert();
		System.out.println("Confirm Alert Box : "+confirm.getText());
		confirm.accept();
		String confirm_result = driver.findElement(By.xpath("//span[@id='result']")).getText();
		System.out.println(confirm_result);
		
		driver.findElement(By.xpath("//div[@class='card']//span[text()='Delete']")).click();
		String Delete = driver.findElement(By.xpath("//span[@class='ui-confirm-dialog-message']")).getText();
		System.out.println("Delete Alert : "+Delete);
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		
		driver.findElement(By.xpath("(//div[@class='card']//span[text()='Show'])[3]")).click();
		String Ss = driver.findElement(By.xpath("//p[contains(text(),'You have clicked')]")).getText();
		System.out.println("Sweet Simple Alert : "+Ss);
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		
		driver.findElement(By.xpath("(//div[@class='card']//span[text()='Show'])[6]")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-extlink']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]")).click();
		
		driver.findElement(By.xpath("(//div[@class='card']//span[text()='Show'])[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
		
		System.out.println("This Title of Page : "+driver.getTitle());
		
		

	}

}
