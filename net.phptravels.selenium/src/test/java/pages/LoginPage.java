package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Log in with valid and invalid credentials.
 */

public class LoginPage {

	private WebDriver driver;
	private String url = "https://www.phptravels.net/login";
	By fieldUsername = By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[1]/input");
	By fieldPassword = By.xpath("//*[@id=\"loginfrm\"]/div[1]/div[5]/div/div[2]/input");
	By buttonSubmit = By.xpath("//button[contains(text(),'Login')]");
	By messageloginerror = By.xpath("//div[@class='alert alert-danger']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public void visita() {
		driver.get(url);
	}

	public void performLogin(String username, String password) {
		driver.findElement(fieldUsername).sendKeys(username);
		driver.findElement(fieldPassword).sendKeys(password);
		driver.findElement(buttonSubmit).click();  
	}
	
	public void performLoginWithFail(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin(username, password);
		WebElement mensagemError = driver.findElement(messageloginerror);
		String mensagem = mensagemError.getText();
		assertEquals("Invalid Email or Password", mensagem);
	}

}
