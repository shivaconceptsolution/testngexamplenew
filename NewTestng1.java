package basicexample;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class NewTestng1 {
	WebDriver driver;
	@BeforeTest
	public void Beforetest()
	{
	System.out.println("before");
	}
	@BeforeMethod
	public void beforemethodeexample()
	{
	 
	 System.setProperty("webdriver.chrome.driver","C://chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	}
	  @Test
	  public void f() {
	 
	 
	//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
	 driver.get("https://www.eroomrent.in/ownerreg.php");
	    driver.findElement(By.id("txtfname")).sendKeys("Nimesh");
	    driver.findElement(By.name("txtmobile1")).sendKeys("8989898943");
	    driver.findElement(By.name("txtPassword")).sendKeys("1234567");
	    driver.findElement(By.name("txtConfirmPassword")).sendKeys("1234567");
	    driver.findElement(By.cssSelector("input[ type=email]")).sendKeys("nimeshmehta12@gamil.com");
	    driver.findElement(By.cssSelector("input[ type=submit]")).click();
	    driver.switchTo().alert().accept();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    driver.get("https://www.eroomrent.in/ownerlogin.php");
	    driver.findElement(By.name("txtEmail")).sendKeys("nimeshmehta12@gamil.com");
	    driver.findElement(By.name("txtPassword")).sendKeys("1234567");
	    driver.findElement(By.name("btnsubmit")).click();
	    driver.get("https://www.eroomrent.in/owner/addroom.php");
	    driver.findElement(By.id("ddllocation")).sendKeys("Heera Nagar");
	    driver.findElement(By.id("ddlcat")).sendKeys("Room");
	    driver.findElement(By.id("subcat")).sendKeys("1 RK");
	    driver.findElement(By.name("txtdesc")).sendKeys("Hello Shiva");
	    driver.findElement(By.name("file")).sendKeys("D://Gourav.jpg");    
	    driver.findElement(By.name("txtamount")).sendKeys("1000");
	    driver.findElement(By.name("txtfacility")).sendKeys("wifi");
	    driver.findElement(By.name("btnsubmit")).click();
	  }
	  @Test
	  public void f1() {

	driver.get("https://www.shivaconceptsolution.com/");
	driver.findElement(By.partialLinkText("Register")).click();

	driver.navigate().back();
	driver.navigate().refresh();
	driver.navigate().forward();

	driver.navigate().to ("https://www.shivaconceptsolution.com/");
	}
	 @AfterMethod
	 public void Aftermethod()
	 { driver.close();
	 }
	 @AfterTest
	 public void aftertest()
	{
	System.out.println("after");
	}
}
