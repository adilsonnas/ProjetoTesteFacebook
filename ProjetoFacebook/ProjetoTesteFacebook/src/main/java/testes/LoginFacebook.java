package testes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import drivers.DriverFactory;
import dsl.DSL;
import org.openqa.selenium.WebDriver;
import page.LoginPage;

@RunWith(Parameterized.class)
public class LoginFacebook {

	private LoginPage page;
	private DSL dsl;
	private WebDriver driver;
	
	@Parameter
	public String email;
	@Parameter(value=1)
	public String senha;
	@Parameter(value=2)
	public String msg;
	
	@Before
	public void inicializar() {
		driver = DriverFactory.getDriver();
		DriverFactory.getDriver().get("https://www.facebook.com/login/");
		page = new LoginPage();
		dsl = new DSL();
	}

	@After
	public void finalizar() {
//		driver.quit();
	}
	
	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
				{"","lgrwu137331","O email ou o número de celular que você inseriu não está conectado a uma conta. Encontre sua conta e entre."},
				{"123456abcdefg@tfbnw.net","lgrwu137331","O email que você inseriu não está conectado a uma conta. Encontre sua conta e entre."},
				{"","","O email ou o número de celular que você inseriu não está conectado a uma conta. Encontre sua conta e entre."},
				{"gvbnqzi_romanberg_1629413798@tfbnw.net","","A senha inserida está incorreta. Esqueceu a senha?"},
				{"gvbnqzi_romanberg_1629413798@tfbnw.net","123456abc","A senha inserida está incorreta. Esqueceu a senha?"},
				{"gvbnqzi_romanberg_1629413798@tfbnw.net","lgrwu137331","No que você está pensando, Michael?"}
		});
	}
	
	@Test
	public void deveValidarLoginFace() throws IOException {
		page.setEmail(email);
		page.setSenha(senha);
		page.cadastrar();
		Assert.assertTrue(dsl.obterClasse("body").contains(msg));
	}
}
	
