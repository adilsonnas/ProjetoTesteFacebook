package page;

import org.openqa.selenium.By;

public class PrincipalPage extends BasePage {
    // cadastrar publicacao
//    public void abrirCadastroPublicacao() {
//        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/div/div/div[1]/div[1]/div/div[2]/div/div/div/div[3]/div/div[2]/div/div/div/div[1]/div"));
//    }
    public void abrirCadastroPublicacao() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div/div[3]/div/div[2]/div/div/div/div[1]/div/div[1]/span"));
    }
    
    public void escreverPublicacao() {
    	dsl.escrever(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/p/span"), "msg");
    }
    
    public void clicarTextoCadastroPublicacao() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[3]/div[2]/div/div/div[1]/div/span/span"));
    }
}
