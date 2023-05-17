package orangehrmtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Orangehrm {
	public WebDriver driver;
	String url="http://localhost/orangehrm/orangehrm-5.4/web/index.php/auth/login";
	String driverpath="D:\\Software testing\\Automation Testing\\Selenium\\Web driver\\geckodriver-v0.26.0-win64\\geckodriver.exe";
	String username="admin";
	String password="Nipin@12345";
	@BeforeTest
	public void launch_browser()
	{
		System.setProperty("webdriver.gecko.driver", driverpath);
		driver=new FirefoxDriver();
	}
	@Test(priority=1)
	public void launch_website()
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
	@Test(priority=2)
	public void enter_username_and_password()throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys(username);
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys(password);
		Thread.sleep(5000);
	}
	@Test(priority=3)
	public void click_loginbutton()
	{
		driver.findElement(By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}
	@Test(priority=4)
	public void navigating_to_PIM()throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();
		Thread.sleep(5000);
	}
	@Test(priority=5)
	public void navigating_to_Add_Employee()throws InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a")).click();
		Thread.sleep(5000);
	}
	@Test(priority=6)
	public void entering_employee_details()throws InterruptedException
	{
		String first_name="George";
		String middle_name="William";
		String last_name="Jacob";
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")).sendKeys(first_name);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input")).sendKeys(middle_name);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")).sendKeys(last_name);
		Thread.sleep(5000);
	}
	@Test(priority=7)
	public void clicking_save_button()
	{
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")).click();
	}
}
