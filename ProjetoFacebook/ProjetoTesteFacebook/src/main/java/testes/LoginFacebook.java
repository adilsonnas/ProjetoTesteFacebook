package testes;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverFactory;
import dsl.DSL;
import page.LoginPage;

@RunWith(Parameterized.class)
public class LoginFacebook {

	private LoginPage page;
	private WebDriver driver;
	private DSL dsl;
	
	@Parameter
	public String email;
	@Parameter(value=1)
	public String senha;
	@Parameter(value=2)
	public String msg;
//	@Parameter(value=3)
//	public String pais;
	
	@Before
	public void inicializar() {
		DriverFactory.getDriver().get("http://pt-br.facebook.com/");
		page = new LoginPage();
		dsl = new DSL();
	}
	
	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
//			{"","","O email ou o número de celular que você inseriu não está conectado a uma conta."},
//			{"gvbnqzi_romanberg_1629413798@tfbnw.net","","A senha inserida está incorreta."},
//			{"gvbnqzi_romanberg_1629413798@tfbnw.net","123456abc","A senha inserida está incorreta."},
//			{"","lgrwu137331","O email ou o número de celular que você inseriu não está conectado a uma conta."},
//			{"123456abcdefg@tfbnw.net","lgrwu137331","O email que você inseriu não está conectado a uma conta."},
//			{"gvbnqzi_romanberg_1629413798@tfbnw.net","lgrwu13733","A senha inserida está incorreta."},
//			{"gvbnqzi_romanberg_1629413798@tfbnw.net","grwu137331","A senha inserida está incorreta."},
//			{"vbnqzi_romanberg_1629413798@tfbnw.net","lgrwu137331",""},
//			{"bnqzi_romanberg_1629413798@tfbnw.net","lgrwu137331",""},
//			{"nqzi_romanberg_1629413798@tfbnw.net","lgrwu137331",""},
//			{"romanberg_1629413798@tfbnw.net","lgrwu137331","O email que você inseriu não está conectado a uma conta."},
			{"gvbnqzi_romanberg_1629413798@tfbnw.net","lgrwu137331","Compartilhe uma foto ou escreva algo."}
		});
	}
	
	@Test
	public void deveValidarLoginFace() throws IOException {
		page.setEmail(email);
		page.setSenha(senha);
		page.cadastrar();
//		Assert.assertTrue(dsl.obterClasse(msg));
//		Assert.assertTrue(DriverFactory.getDriver().findElement(By.className("_9ay7")).getText().contains(msg));
		Assert.assertTrue(DriverFactory.getDriver().findElement(By.tagName("body")).getText().contains(msg));
		
		@SuppressWarnings("unused")
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 60);
	}


}
	
