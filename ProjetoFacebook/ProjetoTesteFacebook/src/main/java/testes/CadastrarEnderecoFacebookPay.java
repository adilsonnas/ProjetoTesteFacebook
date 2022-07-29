package testes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import drivers.DriverUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import drivers.DriverFactory;
import dsl.DSL;
import page.BaseTest;
import page.LoginPage;
import page.PayPage;

@RunWith(Parameterized.class)
public class CadastrarEnderecoFacebookPay extends BaseTest {
	
    private LoginPage page;
    private PayPage payPage;
    private DSL dsl;
    
    @Parameter
	public String nomeEndereco;
	@Parameter(value=1)
	public String nomecompleto;
	@Parameter(value=2)
	public String rua;
	@Parameter(value=3)
	public String tipoEndereco;
	@Parameter(value=4)
	public String cidade;
	@Parameter(value=5)
	public String estado;
	@Parameter(value=6)
	public String cep;
	@Parameter(value=7)
	public int codigoTeste;
	@Parameter(value=8)
	public String mensagemTeste;


	@Before
    public void inicializar() {
        DriverFactory.getDriver().get("https://www.facebook.com/login/");
        String teste = DriverFactory.getDriver().getCurrentUrl();
		page = new LoginPage();
		payPage = new PayPage();
		dsl = new DSL();
		if(teste.equalsIgnoreCase("https://www.facebook.com/home.php")) {
			DriverFactory.getDriver().get("https://secure.facebook.com/facebook_pay/settings");
			return;
		}

		page.setEmail("gvbnqzi_romanberg_1629413798@tfbnw.net");
		page.setSenha("lgrwu137331");
		page.cadastrar();
		DriverFactory.getDriver().get("https://secure.facebook.com/facebook_pay/settings");
    }

	@Parameters
	public static Collection<Object[]> getCollection() {
		return Arrays.asList(new Object[][] {
				{"","","","","","","", 2, "Não é possível verificar endereço"},
				{"Meu endereco","","","","","","", 2, "Não é possível verificar endereço"},
				{"Meu endereco","José da Silva","","","","","", 2, "Não é possível verificar endereço"},
				{"Meu endereco","José da Silva","Rua Primeiro de Abril, 100","","","","", 2, "Não é possível verificar endereço"},
				{"Meu endereco","José da Silva","Rua Primeiro de Abril, 100","Casa","","","", 1, "Meu endereco"},
				{"Meu endereco","José da Silva","Rua Primeiro de Abril, 100","Casa","Feliz","","", 1, "Meu endereco"},
				{"Meu endereco","José da Silva","Rua Primeiro de Abril, 100","Casa","Feliz","RS","", 1, "Meu endereco"},
				{"Meu endereco","José da Silva","Rua Primeiro de Abril, 100","Casa","Feliz","RS","95770000", 1, "Meu endereco"},
		});
	}
	
	@Test
	public void deveCadastrarEnderecoFacebookPay() throws IOException {
        payPage.clicarAdicionarEndereco();
        payPage.escreverNomeEndereco(nomeEndereco);
        payPage.escreverNomeCompleto(nomecompleto);
        payPage.escreverNomeRua(rua);
        payPage.escreverTipoEndereco(tipoEndereco);
        payPage.escreverCidade(cidade);
        payPage.escreverEstado(estado);
        payPage.escreverCEP(cep);
        payPage.clicarSalvarEndereco();
        String texto = payPage.validarTextoCadastroEndereco(codigoTeste);
		DriverUtils.takesScreenshot(testName.getMethodName());
		Assert.assertTrue(texto.equals(mensagemTeste));
	}
}
