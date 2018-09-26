package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.InvoicePage;
import pages.LoginPage;

public class InvoiceTest {

	@Test
	public void autenticainvoice() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/users/pferreira/drivers/chromedriver");
		driver = new ChromeDriver();

		LoginPage loginPage = new LoginPage(driver);

		loginPage.visita();
		loginPage.autentica("user@phptravels.com", "demouser");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@id='bookings']//div[2]//div[4]//a[1]")).click();
		InvoicePage invoicepage = new InvoicePage(driver);

		// Handle window context by page title
		// String currentPageHandle = driver.getWindowHandle();
		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());

		String pageTitle = "Invoice";
		boolean NewTabFound = false;
		// Go to the page with the right title!
		for (String eachHandle : tabHandles) {
			driver.switchTo().window(eachHandle);
			if (driver.getTitle().equalsIgnoreCase(pageTitle)) {
				driver.switchTo().window(eachHandle);
				NewTabFound = true;
			}
		}
		// Valida Hotel Name
		invoicepage.ValidaHotelName(": Rendezvous Hotel");
		
		//Valida Invoice Date
		invoicepage.ValidaInvoiceDate(": 10/09/2018");
		
		//Valida Invoice Due Date
		invoicepage.ValidaInvoiceDueDate(": 11/09/2018");
		
		//Valida Invoice Number
		invoicepage.ValidaInvoiceInvoiceNumber(": 114");
		
		//Valida Booking Code
		invoicepage.ValidaBookingCode(": 4259");
		
		//Valida Customer Details
		invoicepage.validateCustomerDetails("JOHNY SMITH", "R2, AVENUE DU MAROC", "123456");
		
		//Valida Room
		
		
		//Validar Check In
		invoicepage.ValidaCheckInDate("10/09/2018");
		
		//Validar Check Out
		invoicepage.ValidaCheckOutDate("11/09/2018");
		
		//Validar Total Stay
		
		
		//Validar Deposit Now
		invoicepage.ValidaDepositNow("USD $27.50");
		
		//Valida Tax&Vat
		invoicepage.ValidaTaxVat("USD $25");
		
		//Valida Total Amount
		invoicepage.ValidaTotalAmount("USD $275");
		
		
		
		
	}

}
