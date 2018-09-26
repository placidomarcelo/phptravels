package net.phptravels.selenium;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class invoice {
	private WebDriver driver;

	
	@BeforeTest
	public void setUp() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/users/pferreira/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.get("https://www.phptravels.net/login");
				
	
		
	}
	
	@Test(dataProvider = "getData")
	public void login(String username, String password, String name) throws InterruptedException {
		
		new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//nav[@class='navbar navbar-default']//li[@id='li_myaccount']/a[normalize-space()='My Account']"))).click();
		//driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right']//ul[@class='nav navbar-nav navbar-side navbar-right sidebar go-left']//li[@id='li_myaccount']//ul[@class='dropdown-menu']//li//a[@class='go-text-right'][contains(text(),'Login')]")).click();
		//driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
		driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[1]/input")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[2]/input")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
				
		
		
		//Validar nome do user
		WebElement mensagemPop = driver.findElement(By.xpath("//div[@class='col-md-6 go-right RTL']"));
		String mensagem = mensagemPop.getText();
		assertEquals("Hi, "+ name, mensagem);
		System.out.println(mensagem);
		
		
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] credentials = {
				{"user@phptravels.com", "demouser", "Johny Smith"}
		};

		return credentials;
	}
	
	
	@Test
	public void validaInvoice() {
		
		driver.findElement(By.xpath("//div[@id='bookings']//div[2]//div[4]//a[1]")).click();
		driver.switchTo();
		//driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	
		
			
				//Validar Hotel Name - Xpath nao funciona*******
				WebElement hotel = driver.findElement(By.xpath("//td[@align='center']//tbody//table[@cellspacing='0']//tbody//tr[1]//td[1]"));
				String hotelname = hotel.getText();
				assertEquals( ": Rendezvous Hotel", hotelname);
				System.out.println(hotelname);
		
				//Validar Invoice Date
				WebElement invoice = driver.findElement(By.xpath("//strong[contains(text(),'Invoice Date')]"));
				String invoiceDate = invoice.getText();
				assertEquals( ": 10/09/2018", invoiceDate);
				System.out.println(invoiceDate);
				
				//Validar Due Date
				WebElement duedate = driver.findElement(By.xpath("//strong[contains(text(),'Due Date')]"));
				String invoiceduedate = duedate.getText();
				assertEquals( ": 11/09/2018", invoiceduedate);
				System.out.println(invoiceduedate);
				
				//Validar Invoice Number
				WebElement invoiceN = driver.findElement(By.xpath("//strong[contains(text(),'Invoice Number')]"));
				String invoicenumber = invoiceN.getText();
				assertEquals( ": 114", invoicenumber);
				System.out.println(invoicenumber);
				
				//Validar Booking Code
				WebElement booking = driver.findElement(By.xpath("//strong[contains(text(),'Booking Code')]"));
				String bookingcode = booking.getText();
				assertEquals( ": 4259", bookingcode);
				System.out.println(bookingcode);
				
				//Validar Customer Details - Ver como localizar os dados do cliente *******
				List<WebElement> customerdetails = driver.findElements(By.xpath("//td[@align='right']//node()"));
//				String customer = customerdetails.getText();
//				assertEquals( ": xxxx", customer);
				System.out.println(customerdetails.size());
				
				//Validar Room - Ver como localizar do room *******
//				WebElement roomname = driver.findElement(By.xpath("//div[contains(text(),'Room')]"));
//				String room = roomname.getText();
//				assertEquals( ": Junior Suites", room);
//				System.out.println(room);
				
				//Validar Check in Date
				WebElement checkindate = driver.findElement(By.xpath("//td[contains(text(),'Check in')]"));
				String checkin = checkindate.getText();
				assertEquals( "10/09/2018", checkin);
				System.out.println(checkin);
				
				//Validar Check out Date
				WebElement checkoutdate = driver.findElement(By.xpath("//strong[contains(text(),'Check out')]"));
				String checkout = checkoutdate.getText();
				assertEquals( "11/09/2018", checkout);
				System.out.println(checkout);
				
				//Validar Total Stay *****
				WebElement totalstay = driver.findElement(By.xpath("//span[contains(text(),'Total Stay')]"));
				String stay = totalstay.getText();
				assertEquals( "1", stay);
				System.out.println(stay);
				
				//Validar Total Stay value ****
				WebElement totalstayvalue = driver.findElement(By.xpath("//span[contains(text(),'Total Stay')]"));
				String stayvalue = totalstayvalue.getText();
				assertEquals( "$250", stayvalue);
				System.out.println(stayvalue);
				
				//Validar Deposit
				WebElement depositnow = driver.findElement(By.xpath("//strong[contains(text(),'Deposit Now')]"));
				String deposit = depositnow.getText();
				assertEquals( "USD $27.50", deposit);
				System.out.println(deposit);
				
				//Validar Tax&VAT
				WebElement taxvat = driver.findElement(By.xpath("//strong[contains(text(),'Tax & VAT')]"));
				String tax = taxvat.getText();
				assertEquals( "USD $25", tax);
				System.out.println(tax);
				
				//Validar Tax&VAT
				WebElement totalamount = driver.findElement(By.xpath("//strong[contains(text(),'Total Amount')]"));
				String total = totalamount.getText();
				assertEquals( "USD $275", total);
				System.out.println(total);
				
				
			
				
				
		
		
	}

}
