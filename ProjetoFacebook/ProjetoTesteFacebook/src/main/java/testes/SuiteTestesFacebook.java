package testes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        LoginFacebook.class,
        PrincipalFacebook.class,
        CurtirPublicacaoFacebook.class,
        ExcluirPublicacaoFacebook.class,
        CadastrarEnderecoFacebookPay.class,
        CadastrarEmailFacebookPay.class,
        CadastrarTelefoneFacebookPay.class,
})
public class SuiteTestesFacebook {
}
