package testes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
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
//	@Parameter(value=2)
//	public String logar;
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
//			{"","","","", new String[]{},"","Email nao preenchido."},
//			{"gvbnqzi_romanberg_1629413798@tfbnw.net","","","", new String[]{},"","Senha nao preenchida."},
//			{"gvbnqzi_romanberg_1629413798@tfbnw.net","abc","","", new String[]{},"","Confirmacao de senha nao preenchida."},
//			{"gvbnqzi_romanberg_1629413798@tfbnw.net","abc","abcd","", new String[]{},"","Confirmacao de senha diferente da senha informada."},
			{"gvbnqzi_romanberg_1629413798@tfbnw.net","lgrwu137331"}
		});
	}
	
	@Test
	public void deveValidarLoginFace() throws IOException {
		page.setEmail(email);
		page.setSenha(senha);
		page.cadastrar();
		
		@SuppressWarnings("unused")
		WebDriverWait wait = new WebDriverWait(driver, 60);
	}
}
	
