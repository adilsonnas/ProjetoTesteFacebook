package testes;

import drivers.DriverFactory;
import drivers.DriverUtils;
import dsl.DSL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.BaseTest;
import page.LoginPage;
import page.PrincipalPage;

import java.io.IOException;

public class ExcluirPublicacaoFacebook extends BaseTest {
    private LoginPage page;
    private PrincipalPage principalPage;
    private DSL dsl;

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("https://www.facebook.com/login/");
        String teste = DriverFactory.getDriver().getCurrentUrl();
        page = new LoginPage();
        principalPage = new PrincipalPage();
        dsl = new DSL();
        if(teste.equalsIgnoreCase("https://www.facebook.com/home.php")) {
            return;
        }
        page.setEmail("gvbnqzi_romanberg_1629413798@tfbnw.net");
        page.setSenha("lgrwu137331");
        page.cadastrar();
    }

    @Test
    public void deveExcluirPublicacao() throws IOException {
        principalPage.clicarReticencias();
        principalPage.clicarMoverLixeira();
        principalPage.clicarBotaoMover();
        DriverUtils.takesScreenshot(testName.getMethodName());
        Assert.assertTrue(dsl.obterTextoElemento("body").contains("@"));
    }
}
