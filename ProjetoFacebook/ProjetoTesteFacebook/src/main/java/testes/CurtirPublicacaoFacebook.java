package testes;

import drivers.DriverFactory;
import dsl.DSL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.LoginPage;
import page.PrincipalPage;

public class CurtirPublicacaoFacebook {
    private LoginPage page;
    private PrincipalPage principalPage;

    @Before
    public void inicializar() {
        DriverFactory.getDriver().get("https://www.facebook.com/login/");
        String teste = DriverFactory.getDriver().getCurrentUrl();
        page = new LoginPage();
        principalPage = new PrincipalPage();
        if(teste.equalsIgnoreCase("https://www.facebook.com/home.php")) {
            return;
        }
        page.setEmail("gvbnqzi_romanberg_1629413798@tfbnw.net");
        page.setSenha("lgrwu137331");
        page.cadastrar();
    }

    @Test
    public void deveCurtirPublicacao() {
        principalPage.clicarAbrirPerfil();
        principalPage.curtirPublicacao();
        Assert.assertTrue(principalPage.nomePublicacaoCurtida().contains("Michael Alfbfhiggfhif Romanberg"));
    }
}
