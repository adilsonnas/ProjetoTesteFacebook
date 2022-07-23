package testes;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;



import drivers.DriverFactory;
import dsl.DSL;
import page.LoginPage;
import page.PayPage;

@RunWith(Parameterized.class)
public class PayFacebook {
	
    private LoginPage page;
    private PayPage payPage;
    private WebDriver driver;
    private DSL dsl;
    
    @Parameter
	public String nomeEndereço;
	@Parameter(value=1)
	public String nomecompleto;
	@Parameter(value=2)
	public String rua;
	@Parameter(value=3)
	public String tipoEndereço;
	@Parameter(value=4)
	public String cidade;
	@Parameter(value=5)
	public String estado;
	@Parameter(value=6)
	public String cep;
	@Parameter(value=7)
	public String email;
	@Parameter(value=8)
	public String fone;
	@Parameter(value=9)
	public String msgCad;
	@Parameter(value=10)
	public String msgEmail;
	@Parameter(value=11)
	public String msgFone;

	
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
	
	// Rodolfo nï¿½o consegui fazer, mais precisamos fazer a rolagem para clicar no Facebook Pay
	//https://pergunte.org/question/stack/31568035/how-to-read-a-page-with-an-infinite-scroll-bar-using-seleniums-html-unit-driver
	
	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
//				{"","","","","","","","Não é possível verificar endereço"},
//				{"","","","","","",""},
				{"Meu endereco","José da Silva","Rua Primeiro de Abril, 100","Casa","Feliz","RS","95770000","adsads@gmail.com","51999998888","José da Silva","adsads@gmail.com","51999998888"}
		});
	}
	
	@Test
	public void deveCadastrarFacebookPay() {
        payPage.clicarAdicionarEndereco();
        payPage.escreverNomeEndereco(nomeEndereço);
        payPage.escreverNomeCompleto(nomecompleto);
        payPage.escreverNomeRua(rua);
        payPage.escreverTipoEndereco(tipoEndereço);
        payPage.escreverCidade(cidade);
        payPage.escreverEstado(estado);
        payPage.escreverCEP(cep);
        payPage.clicarSalvarEndereco();
        Assert.assertTrue(dsl.obterClasse("body").contains("José da Silva"));
        
	}
	
	@Test
	public void deveCadastrarEmailFacebookPay() {
        payPage.clicarAdicionarEmail();
        payPage.escreverEmail(email);
        payPage.clicarSalvarEmail();
        
        Assert.assertTrue(dsl.obterClasse("body").contains(msgEmail));   

	}

	@Test
	public void deveCadastrarFoneFacebookPay() {
		payPage.clicarAdicionarFone();
		payPage.escreverFone(fone);
		payPage.clicarSalvarFone();
		Assert.assertTrue(dsl.obterClasse("body").contains(msgFone));
	}
	
	
	@Test
	public void deveExcluirCadastroFacebookPay() {
		payPage.clicarEditarCadastro();
		payPage.clicarRemoverCadastro();
		payPage.clicarConfirmaRemoverCadastro();
		Assert.assertFalse(dsl.obterClasse("body").contains("José da Silva"));
		
	}	
			
	@Test
	public void deveExcluirEmailFacebookPay() {
		
		payPage.clicarEditarEmail();
		payPage.clicarRemoverEmail();
		payPage.clicarConfirmaRemoverEmail();
		Assert.assertFalse(dsl.obterClasse("body").contains(msgEmail));
	}	
	
	@Test
	public void deveExcluirFoneFacebookPay() {	
		payPage.clicarEditarFone();
		payPage.clicarRemoverFone();
		payPage.clicarConfirmaRemoverFone();
		Assert.assertFalse(dsl.obterClasse("body").contains(msgFone));
		
	}
}
