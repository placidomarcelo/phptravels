package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
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
		loginPage.autentica("user@phptravels.com", "demouser");
		
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
