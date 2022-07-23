package page;

import org.openqa.selenium.By;

public class PayPage extends BasePage {
	
	public void clicarAdicionarEndereco() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div[2]/div"));
    } 
	
	public void escreverNomeEndereco(String texto) {
        dsl.escreverXpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[1]/label/div/div[1]/input", texto);
    }

    public void escreverNomeCompleto(String texto) {
        dsl.escreverXpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[3]/label/div/div/input", texto);
    }

    public void escreverNomeRua(String texto) {
        dsl.escreverXpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[5]/label/div/div/input", texto);
    }

    public void escreverTipoEndereco(String texto) {
        dsl.escreverXpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[7]/label/div/div/input", texto);
    }

    public void escreverCidade(String texto) {
        dsl.escreverXpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[9]/label/div/div/input", texto);
    }

    public void escreverEstado(String texto) {
        dsl.escreverXpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[11]/div[1]/div/label/div/div/input", texto);
    }

    public void escreverCEP(String texto) {
        dsl.escreverXpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[11]/div[2]/div/label/div/div/input", texto);
    }

    public void clicarSalvarEndereco() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[4]/div/div[2]/div[1]"));
	}
    
	public void clicarAdicionarEmail() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]"));
    } 
	
	public void escreverEmail(String texto) {
        dsl.escreverXpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[1]/label/div/div[1]/input", texto);
    }
	
	public void clicarSalvarEmail() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[4]/div/div[2]/div[1]"));
	}
	
	public void clicarAdicionarFone() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[2]/div/div/div[1]/div[3]/div/div/div/div/div/div[2]"));
    } 
	
	public void escreverFone(String texto) {
        dsl.escreverXpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[1]/label/div/div[1]/input", texto);
    }
	
	public void clicarSalvarFone() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[4]/div/div[2]/div[1]"));
	}
	
	public void clicarEditarCadastro() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div[2]/div[1]/div[1]"));
    }
	
	public void clicarRemoverCadastro() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[16]/div[2]"));
    }
	
	public void clicarConfirmaRemoverCadastro() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div[2]/div[1]/div/div[2]/div/div/div/div[4]/div/div[2]/div[1]"));
    }
			
	public void clicarEditarEmail() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div/div/div/div[2]/div[1]/div[1]/div"));
    }
	
	public void clicarRemoverEmail() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[4]"));
    }
	
	public void clicarConfirmaRemoverEmail() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div[2]/div[1]/div/div[2]/div/div/div/div[4]/div/div[2]/div[1]"));
    }
	
	public void clicarEditarFone() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[2]/div/div/div[1]/div[3]/div/div/div/div/div/div[2]/div[1]/div[1]/div"));
    }
	
	public void clicarRemoverFone() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[4]/div[2]"));
    }
	
	public void clicarConfirmaRemoverFone() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div[2]/div[1]/div/div[2]/div/div/div/div[4]/div/div[2]/div[1]"));
    }
	
	public void validaRemover() {
		dsl.obterElemento(By.xpath("/html/body/div[1]/div/div[1]/div/div[4]/div/div/div[1]/div/div[2]/div/div/div/div[3]/div[1]/label/div/div[1]/input"));
	}
    
}
