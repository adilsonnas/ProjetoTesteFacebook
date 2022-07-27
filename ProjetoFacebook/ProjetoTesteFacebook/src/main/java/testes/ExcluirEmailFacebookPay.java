package testes;

import drivers.DriverFactory;
import dsl.DSL;
import org.junit.Before;
import org.junit.Test;
import page.LoginPage;
import page.PayPage;


public class ExcluirEmailFacebookPay {

    private LoginPage page;
    private PayPage payPage;
    private DSL dsl;

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

    @Test
    public void deveExcluirEmailFacebookPay() {
        payPage.clicarEditarEmail();
        payPage.clicarRemoverEmail();
        payPage.clicarConfirmaRemoverEmail();
//        Assert.assertFalse(dsl.obterTextoElemento("body").contains(msgEmail));
    }
}
