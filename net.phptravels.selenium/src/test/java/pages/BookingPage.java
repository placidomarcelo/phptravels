package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The class contains methods to select Invoice.
 */

public class BookingPage {
	WebDriver driver;
	
	By selecionaInvoice = By.xpath("//div[@id='bookings']//div[2]//div[4]//a[1]");
	
	public BookingPage(WebDriver driver) {
		this.driver = driver;
}
	public void selecionaInvoice() {
		driver.findElement(selecionaInvoice).click();
	}
	
}

	

	
	
