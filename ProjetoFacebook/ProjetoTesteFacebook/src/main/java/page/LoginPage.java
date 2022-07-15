package page;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	
	// login
	public void setEmail(String email) {
		dsl.escrever("email", email);
	}
	public String getEmail() {
		return dsl.obterValorCampo("email");
	}
	
	// Senha
	public void setSenha(String senha) {
		dsl.escrever("pass", senha);
	}
	public String getSenha() {
		return dsl.obterValorCampo("pass");
	}
	public void cadastrar() {
//		dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button"));
		dsl.clicarBotaoXpath(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div[2]/form/div/div[3]/button"));
	}
	

}
