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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverFactory;
import dsl.DSL;
import page.LoginPage;

@RunWith(Parameterized.class)
public class LoginFacebook {

	private LoginPage page;
	private DSL dsl;
	
	@Parameter
	public String email;
	@Parameter(value=1)
	public String senha;
	@Parameter(value=2)
	public String msg;
	
	@Before
	public void inicializar() {
		DriverFactory.getDriver().get("http://pt-br.facebook.com/");
		page = new LoginPage();
		dsl = new DSL();
	}
	
	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
			{"","","Credenciais inválidas"},
			{"gvbnqzi_romanberg_1629413798@tfbnw.net","","Credenciais inválidas"},
			{"gvbnqzi_romanberg_1629413798@tfbnw.net","123456abc","Credenciais inválidas"},
			{"","lgrwu137331","Credenciais inválidas"},
			{"123456abcdefg@tfbnw.net","lgrwu137331","Credenciais inválidas"},
			{"gvbnqzi_romanberg_1629413798@tfbnw.net","lgrwu137331","No que você está pensando, Michael?"}
		});
	}
	
	@Test
	public void deveValidarLoginFace() throws IOException {
		page.setEmail(email);
		page.setSenha(senha);
		page.cadastrar();
		Assert.assertTrue(dsl.obterClasse("body").contains(msg));
		
		@SuppressWarnings("unused")
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 60);
	}


}
	
