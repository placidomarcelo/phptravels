package net.phptravels.selenium;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class negativeLogin {
	private WebDriver driver;

	
	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/users/pferreira/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		//driver.get("https://www.phptravels.net/login");
		driver.get("http://www.phptravels.net");
		
	
		
	}
	
	@Test(dataProvider = "getData")
	public void login(String username, String password) throws InterruptedException {
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@class='navbar navbar-default']//li[@id='li_myaccount']/a[normalize-space()='My Account']"))).click();
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[1]/input")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[2]/input")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/button")).click();
		
		//Validar mensagem erro
				WebElement mensagemError = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
				String mensagem = mensagemError.getText();
				assertEquals("Invalid Email or Password", mensagem);
				System.out.println(mensagem);
		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] credentials = {
				{"user@phptravels.com", "Demouser"},
				{"user@phptravels.com", "demouser_"},
				{"user@phptravels.com.br", "demouser"},
				{"another_user@phptravels.com", "Demouser"}
		};

		return credentials;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
