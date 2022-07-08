package testes;

import drivers.DriverFactory;
import dsl.DSL;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
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

    @Parameterized.Parameter
    public String email;
    @Parameterized.Parameter(value=1)
    public String senha;

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("http://pt-br.facebook.com/");
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
                {"gvbnqzi_romanberg_1629413798@tfbnw.net","lgrwu137331"}
        });
    }

    @Test
    public void deveEscreverPublicacao() throws IOException {
        page.setEmail(email);
        page.setSenha(senha);
        page.cadastrar();
        principalPage.abrirCadastroPublicacao();
        principalPage.clicarTextoCadastroPublicacao();
//        principalPage.escreverCadastroPublicacao();
    }
}
