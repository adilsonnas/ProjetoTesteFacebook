package testes;

import drivers.DriverFactory;
import dsl.DSL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.BaseTest;
import page.LoginPage;
import page.PrincipalPage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PrincipalFacebook extends BaseTest {
    private LoginPage page;
    private PrincipalPage principalPage;
    private WebDriver driver;
    private DSL dsl;

    @Parameter
    public String email;
    @Parameter(value=1)
    public String senha;
    @Parameter(value=2)
    public String msg;

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("https://www.facebook.com/login/");
        page = new LoginPage();
        principalPage = new PrincipalPage();
        dsl = new DSL();
    }

    //ADILSON: acho que para este teste nao vamos usar parameterized, ao menos nao nesta primeira parte
    @Parameterized.Parameters
    public static Collection<Object[]> getCollection() {
        return Arrays.asList(new Object[][] {
//			{"","","","", new String[]{},"","Email nao preenchido."},
//			{"gvbnqzi_romanberg_1629413798@tfbnw.net","","","", new String[]{},"","Senha nao preenchida."},
//			{"gvbnqzi_romanberg_1629413798@tfbnw.net","abc","","", new String[]{},"","Confirmacao de senha nao preenchida."},
//			{"gvbnqzi_romanberg_1629413798@tfbnw.net","abc","abcd","", new String[]{},"","Confirmacao de senha diferente da senha informada."},
                {"gvbnqzi_romanberg_1629413798@tfbnw.net","lgrwu137331", "teste de mensagem"}
        });
    }

    @Test
    public void deveEscreverPublicacao() throws IOException {
        page.setEmail(email);
        page.setSenha(senha);
        page.cadastrar();
        principalPage.abrirCadastroPublicacao();
        principalPage.clicarTextoCadastroPublicacao();
        principalPage.escreverPublicacao("Vou testar a postagem agora!");
//        principalPage.escreverRestoPublicacao("ou testar a postagem agora!");
    }
}
