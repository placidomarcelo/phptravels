package pages;
import static org.testng.Assert.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvoicePage {

		private WebDriver driver;
				
		public InvoicePage(WebDriver driver) {
			this.driver = driver;
		}
		
		public void checkPageTitle() {
			String actualTitle = driver.getTitle();
			String expectedTitle = "Invoice";
			assertEquals(expectedTitle,actualTitle);
		}
		public String HotelName() {
			WebElement hotel = driver.findElement(By.xpath("//td[@align='center']//tbody//table[@cellspacing='0']//tbody//tr[1]//td[1]"));
			System.out.println(hotel.getText());
			return hotel.getText();
						
		}
		public boolean ValidaHotelName(String HotelName) {
			return (HotelName == this.HotelName());
			}
		public String InvoiceDate() {
			WebElement invoice = driver.findElement(By.xpath("//strong[contains(text(),'Invoice Date')]"));
			System.out.println(invoice.getText());
			return invoice.getText();
						
		}
		public boolean ValidaInvoiceDate(String InvoiceDate) {
			return (InvoiceDate == this.InvoiceDate());
			}
		public String InvoiceDueDate() {
			WebElement invoicedue = driver.findElement(By.xpath("//strong[contains(text(),'Due Date')]"));
			System.out.println(invoicedue.getText());
			return invoicedue.getText();
						
		}
		public boolean ValidaInvoiceDueDate(String InvoiceDueDate) {
			return (InvoiceDueDate == this.InvoiceDueDate());
			}
		public String InvoiceNumber() {
			WebElement invoicenumber = driver.findElement(By.xpath("//strong[contains(text(),'Invoice Number')]"));
			System.out.println(invoicenumber.getText());
			return invoicenumber.getText();
						
		}
		public boolean ValidaInvoiceInvoiceNumber(String InvoiceNumber) {
			return (InvoiceNumber == this.InvoiceDueDate());
			}
		
		public String BookingCode() {
			WebElement code = driver.findElement(By.xpath("//strong[contains(text(),'Booking Code')]"));
			System.out.println(code.getText());
			return code.getText();
						
		}
		public boolean ValidaBookingCode(String Booking) {
			return (Booking == this.BookingCode());
			}
		
		public List<WebElement> CustomerDetails() {
			List<WebElement> customerdetails = driver.findElements(By.xpath("//div[contains(text(),'Customer Details')]//following-sibling::div"));
			for ( int i = 0; i < customerdetails.size(); i++) {
				WebElement element = customerdetails.get(i);
				System.out.println(element);
			}
			return customerdetails;
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
	
	
	//Criar metodo room e validar room
	
	
	public String CheckInDate() {
		WebElement checkin = driver.findElement(By.xpath("//strong[contains(text(),'Booking Code')]"));
		System.out.println(checkin.getText());
		return checkin.getText();
					
	}
	public boolean ValidaCheckInDate(String checkin) {
		return (checkin == this.CheckInDate());
		}
	
	public String CheckOutDate() {
		WebElement checkout = driver.findElement(By.xpath("//strong[contains(text(),'Check out')]"));
		System.out.println(checkout.getText());
		return checkout.getText();
					
	}
	public boolean ValidaCheckOutDate(String checkout) {
		return (checkout == this.CheckOutDate());
		}
	
	//Criar metodo Total Stay e validar Total Stay
	
	
	public String DepositNow() {
		WebElement depositnow = driver.findElement(By.xpath("//strong[contains(text(),'Deposit Now')]//../../../../tbody[1]/tr[1]/td[1]"));
		System.out.println(depositnow.getText());
		return depositnow.getText();
					
	}
	public boolean ValidaDepositNow(String depositnow) {
		return (depositnow == this.DepositNow());
		}
	
	public String TaxVat() {
		WebElement taxvat = driver.findElement(By.xpath("//strong[contains(text(),'Deposit Now')]//../../../../tbody[1]/tr[1]/td[2]"));
		System.out.println(taxvat.getText());
		return taxvat.getText();
					
	}
	public boolean ValidaTaxVat(String taxvat) {
		return (taxvat == this.TaxVat());
		}
	
	public String TotalAmount() {
		WebElement totalamount = driver.findElement(By.xpath("//strong[contains(text(),'Deposit Now')]//../../../../tbody[1]/tr[1]/td[3]"));
		System.out.println(totalamount.getText());
		return totalamount.getText();
					
	}
	public boolean ValidaTotalAmount(String totalamount) {
		return (totalamount == this.TotalAmount());
		}
	
}



