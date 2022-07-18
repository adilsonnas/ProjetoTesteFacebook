package testes;

import drivers.DriverFactory;
import dsl.DSL;
import org.junit.Assert;
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

public class PrincipalFacebook extends BaseTest {
    private LoginPage page;
    private PrincipalPage principalPage;
    private WebDriver driver;
    private DSL dsl;

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("https://www.facebook.com/login/");
        page = new LoginPage();
        principalPage = new PrincipalPage();
        dsl = new DSL();
        page.setEmail("gvbnqzi_romanberg_1629413798@tfbnw.net");
        page.setSenha("lgrwu137331");
        page.cadastrar();
    }

    @Test
    public void deveEscreverPublicacao() {
        principalPage.abrirCadastroPublicacao();
        principalPage.clicarTextoCadastroPublicacao();
        principalPage.escreverPublicacao("AB");
        principalPage.clicarPublicarPublicacao();
//        principalPage.clicarAbrirPerfil();
    }

    @Test
    public void deveCurtirPublicacao() {
        principalPage.clicarAbrirPerfil();
        principalPage.curtirPublicacao();
         Assert.assertTrue(principalPage.nomePublicacaoCurtida().contains("Michael Alfbfhiggfhif Romanberg"));
    }

    @Test
    public void deveExcluirPublicacao() {
        principalPage.clicarAbrirPerfil();
        principalPage.clicarReticencias();
        principalPage.clicarMoverLixeira();
        principalPage.clicarBotaoMover();
    }
}
