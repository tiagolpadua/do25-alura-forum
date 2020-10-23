/*
 * Fazer download do binário do webdriver: https://www.selenium.dev/documentation/en/webdriver/driver_requirements/
 * Descompactar em: C:\WebDriver
 * Ajustar parâmetro de execução do JUNIT ->  -Dwebdriver.chrome.driver="C:\WebDriver\chromedriver.exe"
 */

package br.com.alura.forum;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {
	public static WebDriver browser;

	@BeforeAll
	public static void abrirBrowser() {
		browser = new ChromeDriver();
	}

	@BeforeEach
	public void navegarTelaInicial() {
		browser.navigate().to("http://localhost:8080/alura-forum/topicos");
	}

	@Test
	public void deveriaExibirATelaInicial() {
		WebElement titulo = browser.findElement(By.xpath("/html/body/section/section[1]/div/h1/a"));
		Assertions.assertEquals("Fórum".toUpperCase(), titulo.getText().toUpperCase());
	}
	
	@Test
	public void deveriaExibirATelaDeCadastro() {
		browser.findElement(By.xpath("/html/body/header[2]/div/div/a[2]")).click();
		WebElement titulo = browser.findElement(By.xpath("/html/body/div[2]/section/section/p"));
		Assertions.assertEquals("Cadastre-se gratuitamente!".toUpperCase(), titulo.getText().toUpperCase());
	}

	@AfterAll
	public static void fecharBrowser() {
		browser.close();
	}
}
