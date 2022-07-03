package br.ifrs.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exemplo04TesteRegrasNegocio {
	final String GECKO_DRIVER_PATH = System.getProperty("user.dir") + "\\src\\main\\resources\\webdriver\\geckodriver.exe";
	
	@Test
	public void deveValidarEmailEmBranco() {
		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);

		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "\\src\\main\\resources\\html\\signup_form.html");
		
		driver.findElement(By.id("bsignup")).click();
		driver.findElement(By.id("ssignup")).click();
		
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals("Email nao preenchido.", alert.getText());
		
//		driver.quit();
	}
	
	@Test
	public void deveValidarSenhaEmBranco() {
		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);

		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "\\src\\main\\resources\\html\\signup_form.html");
		
		driver.findElement(By.id("bsignup")).click();
		driver.findElement(By.id("email")).sendKeys("tiago.cinto@gmail.com");
		driver.findElement(By.id("ssignup")).click();
		
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals("Senha nao preenchida.", alert.getText());
		
//		driver.quit();
	}
	
	@Test
	public void deveValidarConfirmacaoSenhaEmBranco() {
		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);

		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "\\src\\main\\resources\\html\\signup_form.html");
		
		driver.findElement(By.id("bsignup")).click();
		driver.findElement(By.id("email")).sendKeys("tiago.cinto@gmail.com");
		driver.findElement(By.id("psw")).sendKeys("123");
		driver.findElement(By.id("ssignup")).click();
		
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals("Confirmacao de senha nao preenchida.", alert.getText());
		
//		driver.quit();
	}
	
	@Test
	public void deveValidarSenhaConfirmacaoSenhaDiferentes() {
		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);

		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "\\src\\main\\resources\\html\\signup_form.html");
		
		driver.findElement(By.id("bsignup")).click();
		driver.findElement(By.id("email")).sendKeys("tiago.cinto@gmail.com");
		driver.findElement(By.id("psw")).sendKeys("123");
		driver.findElement(By.id("psw-repeat")).sendKeys("12345");
		driver.findElement(By.id("ssignup")).click();
		
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals("Confirmacao de senha diferente da senha informada.", alert.getText());
		
//		driver.quit();
	}
	
	@Test
	public void deveValidarIdadeMaior18() {
		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);

		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "\\src\\main\\resources\\html\\signup_form.html");
		
		driver.findElement(By.id("bsignup")).click();
		driver.findElement(By.id("email")).sendKeys("tiago.cinto@gmail.com");
		driver.findElement(By.id("psw")).sendKeys("123");
		driver.findElement(By.id("psw-repeat")).sendKeys("123");
		driver.findElement(By.id("age1")).click();
		driver.findElement(By.id("ssignup")).click();
		
		Alert alert = driver.switchTo().alert();
		
		Assert.assertEquals("Cadastro nao permitido para menores de 18 anos.", alert.getText());
		
//		driver.quit();
	}
	
	@Test
	public void deveInteragirComLink() {
		System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);

		WebDriver driver = new FirefoxDriver();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/html/signup_form.html");
		
		driver.findElement(By.id("bsignup")).click();
		
		driver.findElement(By.linkText("Terms and Privacy")).click();
		
		
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Link Terms and Privacy clicado!"));
		
		Assert.assertTrue(driver.findElement(By.className("sterms")).getText().contains("Link Terms and Privacy clicado!"));
	}
}
