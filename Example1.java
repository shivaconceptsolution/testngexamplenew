package basicexample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Example1 {
	WebDriver driver;
	
	@BeforeTest
	public void fun()
	{
		  System.out.println("Before Test");
		  System.setProperty("webdriver.chrome.driver","c://chromedriver.exe");
		  driver= new ChromeDriver();
		  driver.manage().window().maximize();
	}
    @BeforeMethod
    public void beforeMethodExample()
    {
    	 System.out.println("Before Method");	
   	   driver.get("https://eroomrent.in/contact.php");
     }
  @Test
  public void ownerLoginTestCase() throws InterruptedException {
	  
		driver.get("https://www.eroomrent.in/ownerlogin.php");
		driver.findElement(By.name("txtEmail")).sendKeys("nitinjatav@gmail.com");
		driver.findElement(By.name("txtPassword")).sendKeys("12345678");
		driver.findElement(By.name("btnsubmit")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();
		
  }
  @Test
  public void verifyDownloadFile() {
	 
	    driver.get("https://www.selenium.dev/downloads");
	    WebElement ele = driver.findElement(By.xpath("//html/body/div/main/div[5]/div[3]/div/div[2]/p[2]/a"));
		String path = ele.getAttribute("href");
		String wget_command = "cmd /c C:\\wget.exe -P D:/mydownload --no-check-certificate " +path;

      try {
      Process exec = Runtime.getRuntime().exec(wget_command);
      //int exitVal = exec.waitFor();
      //System.out.println("Exit value: " + exitVal);
      } catch (IOException ex) {
      System.out.println(ex.toString());
      }
     
  }
    @AfterMethod
    public void AfterMethodExample()
    {
    	 System.out.println("After Method");
    	driver.get("https://eroomrent.in");
    }
    @AfterTest
	public void funAfterTest()
	{
    	driver.close();
		System.out.println("After Test");
	}
}
