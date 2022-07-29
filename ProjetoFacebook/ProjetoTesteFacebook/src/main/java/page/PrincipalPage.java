package page;

import org.openqa.selenium.By;

public class PrincipalPage extends BasePage {
    // cadastrar publicacao
    public void abrirCadastroPublicacao() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div[2]/div/div/div/div[3]/div/div[2]/div/div/div/div[1]/div"));
    }                                  
    
    public void escreverPublicacao(String texto) {
        dsl.escrever(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div"), texto);
    }

    public void clicarTextoCadastroPublicacao() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[2]/div[1]/div[1]"));
    }

    public void clicarPublicarPublicacao() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/form/div/div[1]/div/div/div/div[3]/div[2]/div"));
    }

    public void clicarAbrirPerfil() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div[1]/div/div/div[1]/div/div/div[1]/ul/li/div/a"));
    }
    
    public String excluiPublicacao() {
        return dsl.obterElemento(By.xpath("/html/body/div[6]/ul"));
    }
    
    public void clicarAtualizarPagina() {
        dsl.clicarBotaoXpath1(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[3]/div/div[1]/div[1]/ul/li[1]/span/div/a"));
    } 								
   
    public void curtirPublicacao() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[4]/div/div/div[1]/div/div/div/div[1]/div[1]/div[1]"));
    }

    public String nomePublicacaoCurtida() {
        return dsl.obterElemento(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[4]/div/div/div[1]/div/div[1]/div/div[1]/span[2]/div/span[2]/span/span"));
    }
    public String textoPublicado() {
    	return dsl.obterElemento(By.xpath("/html/body/"));
    }

    public void clicarReticencias() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div/div/div[4]/div[2]/div/div[2]/div[3]/div[1]/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/div[3]"));
    }

    public void clicarMoverLixeira() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[3]/div/div/div/div[2]/div/div/div[1]/div[1]/div/div/div[1]/div/div/div/div[1]/div/div[9]"));
    }

    public void clicarBotaoMover() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div/div/div/div[3]/div/div/div/div[1]/div"));
    }
}
