package pages;

import static org.testng.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The class contains methods to validate Invoice Page.
 */

public class InvoicePage {

	private WebDriver driver;
	By hotelName = By.xpath("//td[@align='center']//tbody//table[@cellspacing='0']//tbody//tr[1]//td[1]");
	By invoiceDate = By.xpath("//strong[contains(text(),'Invoice Date')]");
	By invoiceDueDate = By.xpath("//strong[contains(text(),'Due Date')]");
	By invoiceNumber = By.xpath("//strong[contains(text(),'Invoice Number')]");
	By bookingCode = By.xpath("//strong[contains(text(),'Booking Code')]");
	By customerDetails = By.xpath("//div[contains(text(),'Customer Details')]//following-sibling::div");
	By checkInDate = By.xpath("//strong[contains(text(),'Booking Code')]");
	By checkOutDate = By.xpath("//strong[contains(text(),'Check out')]");
	By depositNow = By.xpath("//strong[contains(text(),'Deposit Now')]//../../../../tbody[1]/tr[1]/td[1]");
	By taxVat = By.xpath("//strong[contains(text(),'Deposit Now')]//../../../../tbody[1]/tr[1]/td[2]");
	By totalAmount = By.xpath("//strong[contains(text(),'Deposit Now')]//../../../../tbody[1]/tr[1]/td[3]");

	public InvoicePage(WebDriver driver) {
		this.driver = driver;
	}

	public String retrieveWebElementText(By field) {
		WebElement element = driver.findElement(field);
		System.out.println(element.getText());
		return element.getText();
	}
	
	public void checkPageTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Invoice";
		assertEquals(expectedTitle, actualTitle);
	}

	public String hotelName() {
		return retrieveWebElementText(hotelName);
		

	}

	public void validateHotelName(String hotelName) {
		assertEquals (hotelName , this.hotelName());
		
	}

	public String invoiceDate() {
		return retrieveWebElementText(invoiceDate);
		
	}

	public void validateInvoiceDate(String InvoiceDate) {
		assertEquals (InvoiceDate , this.invoiceDate());
	}

	public String invoiceDueDate() {
		return retrieveWebElementText(invoiceDueDate);
	}
	

	public void validaInvoiceDueDate(String InvoiceDueDate) {
		assertEquals (InvoiceDueDate , this.invoiceDueDate());
	}

	public String invoiceNumber() {
		return retrieveWebElementText(invoiceNumber);
	}

	public void validateInvoiceInvoiceNumber(String InvoiceNumber) {
		assertEquals (InvoiceNumber , this.invoiceDueDate());
	}

	public String bookingCode() {
		return retrieveWebElementText(bookingCode);

	}

	public void validateBookingCode(String Booking) {
		assertEquals (Booking , this.bookingCode());
	}

	public List<String> customerDetails() {
		List<WebElement> customerdetails = driver.findElements(customerDetails);
		List<String> list = new ArrayList<String>();
		for (WebElement a : customerdetails) { // percorre elementos adicionando na 'list' o 'text' deles.
			list.add(a.getText());
		}
		return list;
	}

	public void validateCustomerDetails(String name, String address, String number) {
		boolean boolControl;
		boolControl = true;
		for (String stringCustomerDetails : customerDetails()) {
			if (stringCustomerDetails.equals(name) || stringCustomerDetails.equals(address)
					|| stringCustomerDetails.equals(number)) {
				continue;
			} // achou, não faz nada!
			else {
				boolControl = false; // caso não tenha a entrada seta para falso e para a execução, se não e
				break;
			}
		}
		assertEquals(boolControl, "true"); // confirma que achou todos elementos... se estiver 'false' não achou
											// algo....
	}

	// Criar metodo room e validar room

	public String checkInDate() {
		return retrieveWebElementText(checkInDate);

	}

	public void validateCheckInDate(String checkin) {
		assertEquals (checkin , this.checkInDate());
	}

	public String checkOutDate() {
		return retrieveWebElementText(checkOutDate);

	}

	public void validateCheckOutDate(String checkout) {
		assertEquals (checkout , this.checkOutDate());
	}

	// Create method Total Stay and validate Total Stay

	public String depositNow() {
		return retrieveWebElementText(depositNow);

	}

	public void validateDepositNow(String depositnow) {
		assertEquals (depositnow , this.depositNow());
	}

	public String taxVat() {
		return retrieveWebElementText(taxVat);

	}

	public void validateTaxVat(String taxvat) {
		assertEquals (taxvat , this.taxVat());
	}

	public String totalAmount() {
		return retrieveWebElementText(totalAmount);

	}

	public void validateTotalAmount(String totalamount) {
		assertEquals (totalamount , this.totalAmount());
	}

}
