package pages;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


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

	public void autentica(String usuario, String senha) {
		driver.findElement(fieldUsername).sendKeys(usuario);
		driver.findElement(fieldPassword).sendKeys(senha);
		driver.findElement(buttonSubmit).click();  
	}
	
	public void autenticaComFalha(String usuario, String senha) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.autentica(usuario, senha);
		WebElement mensagemError = driver.findElement(messageloginerror);
		String mensagem = mensagemError.getText();
		assertEquals("Invalid Email or Password", mensagem);
	}

}
