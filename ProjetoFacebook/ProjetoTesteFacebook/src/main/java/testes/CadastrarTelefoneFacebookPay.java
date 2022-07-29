package testes;

import drivers.DriverFactory;
import drivers.DriverUtils;
import dsl.DSL;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import page.BaseTest;
import page.LoginPage;
import page.PayPage;

import java.io.IOException;

public class CadastrarTelefoneFacebookPay extends BaseTest {

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
    public void deveCadastrarFoneFacebookPay() throws IOException {
        payPage.clicarAdicionarFone();
        payPage.escreverFone("51999998888");
        payPage.clicarSalvarFone();
        String texto = payPage.validarTextoCadastroTelefone(1);
        DriverUtils.takesScreenshot(testName.getMethodName());
        Assert.assertTrue(texto.equals("+51999998888"));
    }
}
