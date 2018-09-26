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

	public void checkPageTitle() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Invoice";
		assertEquals(expectedTitle, actualTitle);
	}

	public String HotelName() {
		WebElement hotel = driver.findElement(hotelName);
		System.out.println(hotel.getText());
		return hotel.getText();

	}

	public boolean ValidaHotelName(String HotelName) {
		return (HotelName == this.HotelName());
	}

	public String InvoiceDate() {
		WebElement invoice = driver.findElement(invoiceDate);
		System.out.println(invoice.getText());
		return invoice.getText();

	}

	public boolean ValidaInvoiceDate(String InvoiceDate) {
		return (InvoiceDate == this.InvoiceDate());
	}

	public String InvoiceDueDate() {
		WebElement invoicedue = driver.findElement(invoiceDueDate);
		System.out.println(invoicedue.getText());
		return invoicedue.getText();

	}

	public boolean ValidaInvoiceDueDate(String InvoiceDueDate) {
		return (InvoiceDueDate == this.InvoiceDueDate());
	}

	public String InvoiceNumber() {
		WebElement invoicenumber = driver.findElement(invoiceNumber);
		System.out.println(invoicenumber.getText());
		return invoicenumber.getText();

	}

	public boolean ValidaInvoiceInvoiceNumber(String InvoiceNumber) {
		return (InvoiceNumber == this.InvoiceDueDate());
	}

	public String BookingCode() {
		WebElement code = driver.findElement(bookingCode);
		System.out.println(code.getText());
		return code.getText();

	}

	public boolean ValidaBookingCode(String Booking) {
		return (Booking == this.BookingCode());
	}

	public List<String> CustomerDetails() {
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
		for (String stringCustomerDetails : CustomerDetails()) {
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

	public String CheckInDate() {
		WebElement checkin = driver.findElement(checkInDate);
		System.out.println(checkin.getText());
		return checkin.getText();

	}

	public boolean ValidaCheckInDate(String checkin) {
		return (checkin == this.CheckInDate());
	}

	public String CheckOutDate() {
		WebElement checkout = driver.findElement(checkOutDate);
		System.out.println(checkout.getText());
		return checkout.getText();

	}

	public boolean ValidaCheckOutDate(String checkout) {
		return (checkout == this.CheckOutDate());
	}

	// Criar metodo Total Stay e validar Total Stay

	public String DepositNow() {
		WebElement depositnow = driver.findElement(depositNow);
		System.out.println(depositnow.getText());
		return depositnow.getText();

	}

	public boolean ValidaDepositNow(String depositnow) {
		return (depositnow == this.DepositNow());
	}

	public String TaxVat() {
		WebElement taxvat = driver.findElement(taxVat);
		System.out.println(taxvat.getText());
		return taxvat.getText();

	}

	public boolean ValidaTaxVat(String taxvat) {
		return (taxvat == this.TaxVat());
	}

	public String TotalAmount() {
		WebElement totalamount = driver.findElement(totalAmount);
		System.out.println(totalamount.getText());
		return totalamount.getText();

	}

	public boolean ValidaTotalAmount(String totalamount) {
		return (totalamount == this.TotalAmount());
	}

}
