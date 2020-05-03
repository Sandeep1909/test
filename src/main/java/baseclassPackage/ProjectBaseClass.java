package baseclassPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ProjectBaseClass 

{
	
public static WebDriver driver;	
public static Properties property;
public static Actions a;
public 	ProjectBaseClass() throws IOException

{
	
	try {
		
		
		 property=new Properties();
		 FileInputStream file = new FileInputStream("C:\\Users\\Sandeep\\Study material\\eclipse-workspace\\Way2Automation.com\\src\\main\\java\\configurationPackage\\GernnricValues");
		 property.load(file);
		
		
		
	}
	catch (FileNotFoundException e  )
	
	{
		
		e.printStackTrace();
		
	}
	
	catch(IOException e)
	
	{
		
		e.printStackTrace();
	}
	
	}


public  static void intialization()

{
	
	String browsername=property.getProperty("browser");
	
	if(browsername.equals("chrome"))
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sandeep\\ChromeDRIVERversion81\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	else if (browsername.equals("firefox"))
	{
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sandeep\\ChromeDRIVERversion81\\Firefoxdriver.exe");
		
		driver = new FirefoxDriver();
		
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
	
	driver.get(property.getProperty("projecturl"));

	driver.findElement(By.xpath("//a[text()='Signin']")).click();

	WebElement loginpopup = driver.findElement(By.xpath("//div[@class='fancybox-inner']"));

	loginpopup.findElement(By.name("username")).sendKeys("sandeep");
	loginpopup.findElement(By.name("password")).sendKeys("way2automation");

	driver.findElements(By.xpath("//div[@class='span_1_of_4']/input")).get(1).click();
	
	a=new Actions(driver);
	
	
	
	
	
	
}

}






	
	
	
	
	
	
	
	