package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
	 
	 private WebDriver driver;
	 
	 public AccountPage(WebDriver driver) {
	   this.driver = driver;
	 }
	 
	 public boolean isValida() {
	   return (nomeUsuario() !=null) && temListagemInvoices();
	 }
	 
	 public WebElement nomeUsuario() {
		   return driver.findElement(By.xpath("//*[@class='RTL']"));
		 }
	 
	 public boolean temListagemInvoices() {
	   return driver.findElement(By.xpath("//div[@id='bookings']")) !=null;
	 }
	 
	 public void validanomeDoUsuario() {
	String validaNomeUsuario = 	nomeUsuario().getText();
	assertEquals("Hi, Johny Smith", validaNomeUsuario);
	
	
		 
	 }
	 	 
	}
