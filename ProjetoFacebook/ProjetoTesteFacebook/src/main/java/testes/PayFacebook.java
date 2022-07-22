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
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
        DriverFactory.getDriver().get("https://secure.facebook.com/facebook_pay/settings");
    }
	
	// Rodolfo n�o consegui fazer, mais precisamos fazer a rolagem para clicar no Facebook Pay
	//https://pergunte.org/question/stack/31568035/how-to-read-a-page-with-an-infinite-scroll-bar-using-seleniums-html-unit-driver
	@Test
	public void deveCadastrarFacebookPay() {
        payPage.clicarAdicionarEndereco();
        payPage.escreverNomeEndereco("Meu endereco");
        payPage.escreverNomeCompleto("Rodolfo");
        payPage.escreverNomeRua("Rua voluntarios da patria");
        payPage.escreverTipoEndereco("Cas");
        payPage.escreverCidade("Feliz");
        payPage.escreverEstado("RS");
        payPage.escreverCEP("95770000");
        payPage.clicarSalvarEndereco();
	}
	

}
