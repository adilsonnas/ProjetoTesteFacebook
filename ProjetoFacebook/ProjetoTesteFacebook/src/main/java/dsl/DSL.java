package dsl;

import java.util.ArrayList;
import java.util.List;
import drivers.DriverFactory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

// https://www.selenium.dev/documentation/pt-br/guidelines_and_recommendations/domain_specific_language/

public class DSL {

	private void wait(By by) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), DriverProperty.WAIT_TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	private void waitClickable(By by) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), DriverProperty.WAIT_TIME);
		wait.until((ExpectedConditions.elementToBeClickable(by)));
	}

	// TextFields e TextAreas
	public void escrever(By by, String texto){
		wait(by);
//		DriverFactory.getDriver().findElement(by).clear();
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}
	public void escrever(String idCampo, String texto){
		escrever(By.id(idCampo), texto);
	}
	
	public void escreverXpath(By by, String texto) {
		escrever(By.xpath(texto), texto);
	}
	
	public String obterValorCampo(String idCampo) {
		wait(By.id((idCampo)));
		return DriverFactory.getDriver().findElement(By.id(idCampo)).getAttribute("value");
	}

	// Radio buttons e Checkboxes 
	public void clicarRadio(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}
	public boolean isRadioMarcado(String id){
		return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}
	public void clicarCheck(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}
	public boolean isCheckMarcado(String id){
		return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}
	
	// Combos
	public void selecionarCombo(String id, String valor) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
	}
	public void deselecionarCombo(String id, String valor) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.deselectByVisibleText(valor);
	}
	public String obterValorCombo(String id) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	public List<String> obterValoresCombo(String id) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
		List<String> valores = new ArrayList<String>();
		for(WebElement opcao: allSelectedOptions) {
			valores.add(opcao.getText());
		}
		return valores;
	}
	public int obterQuantidadeOpcoesCombo(String id){
		WebElement element =  DriverFactory.getDriver().findElement(By.id(id));	
		Select combo = new Select(element);
		return combo.getAllSelectedOptions().size();		
	}
	public boolean verificarOpcaoCombo(String id, String opcao){
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		List<WebElement> options = combo.getOptions();
		for(WebElement option: options) {
			if(option.getText().equals(opcao)){
				return true;
			}
		}
		return false;
	}
	
	// Buttons
	public void clicarBotao(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}
	public void clicarBotaoXpath(By by) {
		wait(by);
		DriverFactory.getDriver().findElement(by).click();
	}

	// Links
	public void clicarLink(String link) {
		DriverFactory.getDriver().findElement(By.linkText(link)).click();
	}
	
	// Textos
	public String obterTexto(By by) {
		return DriverFactory.getDriver().findElement(by).getText();
	}
	public String obterTexto(String id) {
		return obterTexto(By.id(id));
	}
	
	// Titulo
	public String obterTitulo() {
		return DriverFactory.getDriver().getTitle();
	}
	
	public String obterClasse(String classe) {
		return DriverFactory.getDriver().findElement(By.tagName(classe)).getText();
	}

	public String obterElemento(By by) {
		return DriverFactory.getDriver().findElement(by).getText();
	}

    // Alertas 
	public String alertaObterTexto(){
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		return alert.getText();
	}
	public String alertaObterTextoEAceita(){
		Alert alert = DriverFactory.getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;
	}

}
