package page;

import org.openqa.selenium.By;

public class PayPage extends BasePage {
	
	public void clicarPerfil() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[1]/span/div/div[1]"));
    } 
	
	public void clicarConfigPrivacidade() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[1]/div/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]"));
    }
	
	public void clicarConfigurações() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div[4]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div/div/div/div[2]/div/div[2]/div/div[1]/a/div[1]/div[2]/div"));
    }
	
	public void clicarBarra() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[1]/div/div[3]/div[2]"));
    }
	
	public void clicarFacePay() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[1]/div/div[3]/div[1]/div[2]/div/div[18]/a/div[1]/div[2]/div/div"));
    } //html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[1]/div/div[3]/div[1]/div[2]/div/div[18]/a/div[1]/div[2]/div
	
	public void clicarConfigPay() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/div[2]/div[4]/div/a/div[1]/div[2]/div"));
    }
	
	public void clicarEndereço() {
        dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div/div[1]/div/div[3]/div/div/div/div[1]/div[1]/div[2]/div/div/div[1]/div[1]/div/div/div/div/div/div[2]/div/div/div[1]/div/div"));
    }

}
