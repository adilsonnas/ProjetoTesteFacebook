package testes;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import drivers.DriverFactory;
import dsl.DSL;
import page.LoginPage;
import page.PayPage;

public class PayFacebook {
	
    private LoginPage page;
    private PayPage payPage;
    private WebDriver driver;
    private DSL dsl;
    
	
	@Before
    public void inicializar() {
        DriverFactory.getDriver().get("https://www.facebook.com/login/");
        page = new LoginPage();
        payPage = new PayPage();
        dsl = new DSL();
        page.setEmail("gvbnqzi_romanberg_1629413798@tfbnw.net");
        page.setSenha("lgrwu137331");
        page.cadastrar();
	}
	
	// Rodolfo não consegui fazer, mais precisamos fazer a rolagem para clicar no Facebook Pay
	//https://pergunte.org/question/stack/31568035/how-to-read-a-page-with-an-infinite-scroll-bar-using-seleniums-html-unit-driver
	@Test
	public void deveCadastrarFacebookPay() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		payPage.clicarPerfil();
		payPage.clicarConfigPrivacidade();
		payPage.clicarConfigurações();
		WebElement flag=driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[1]/div/div[3]/div[2]"));
		js.executeScript("arguments[0].scrollIntoView();",flag);
//		payPage.clicarFacePay();
//		payPage.clicarConfigPay();
//		payPage.clicarEndereço();
	}
	

}
