package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages.BookingPage;
import pages.InvoicePage;
import pages.LoginPage;

/**
 * Validate invoice page.
 */

public class InvoiceTest {

	@Test
	public void autenticainvoice() {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/users/pferreira/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		LoginPage loginPage = new LoginPage(driver);
		BookingPage bookingPage = new BookingPage(driver);

		loginPage.visita();
		loginPage.performLogin("user@phptravels.com", "demouser");
		
		bookingPage.selecionaInvoice();
		InvoicePage invoicepage = new InvoicePage(driver);

		ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());

		String pageTitle = "Invoice";
		
		// Go to the page with the right title!
		for (String eachHandle : tabHandles) {
			driver.switchTo().window(eachHandle);
			if (driver.getTitle().equalsIgnoreCase(pageTitle)) {
				driver.switchTo().window(eachHandle);
			
			}
		}
		// Validate Hotel Name
		invoicepage.validateHotelName(": Rendezvous Hotel");
						
		//Validate Invoice Date
		invoicepage.validateInvoiceDate(": 10/09/2018");
		
		//Validate Invoice Due Date
		invoicepage.validaInvoiceDueDate(": 11/09/2018");
		
		//Validate Invoice Number
		invoicepage.validateInvoiceInvoiceNumber(": 114");
		
		//Validate Booking Code
		invoicepage.validateBookingCode(": 4259");
		
		//Validate Customer Details
		invoicepage.validateCustomerDetails("JOHNY SMITH", "R2, AVENUE DU MAROC", "123456");
		
		//Validate Room
		
		//Validate Check In
		invoicepage.validateCheckInDate("10/09/2018");
		
		//Validate Check Out
		invoicepage.validateCheckOutDate("11/09/2018");
		
		//Validate Total Stay

		//Validate Deposit Now
		invoicepage.validateDepositNow("USD $27.50");
		
		//Validate Tax&Vat
		invoicepage.validateTaxVat("USD $25");
		
		//Validate Total Amount
		invoicepage.validateTotalAmount("USD $275");
			
	}

}
