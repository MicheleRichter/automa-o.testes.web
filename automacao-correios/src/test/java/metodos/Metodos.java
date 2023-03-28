package metodos;

import java.io.File;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import conexoes.Drivers;

public class Metodos extends Drivers{

	
	public void escrever(By elemento, String texto) {
		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			System.out.println("Erro ao tentar escrever " + e.getCause());
		}
			
	}
	public void clicar (By elemento) {
		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			System.out.println("Erro ao tentar escrever " + e.getCause());
		}
		
	}
	public void submit(By elemento) {
		try {
			driver.findElement(elemento).submit();
		} catch (Exception e) {
			System.out.println("Erro ao tentar dar enter " + e.getCause());
		}
	}
	public void print (String nomeEvidencia) {
		TakesScreenshot foto = ((TakesScreenshot) driver);
		try {
			File srcFile = foto.getScreenshotAs(OutputType.FILE);
			File destFile = new File("./src/test/resources/evidencias/" + nomeEvidencia + ".png");
			FileUtils.copyFile(srcFile, destFile);
		} catch (Exception e) {
			System.out.println("Erro ao tentar dar tirar print " + e.getCause());
		}
		
	}
	public void validarTexto(String textoEsperado, By elemento) {
		
		String textoExibido = driver.findElement(elemento).getText();
		try {
		textoEsperado.contains(textoExibido);
		} catch (Exception e) {
			System.out.println("Erro ao tentar dar tirar validar texto " + e.getCause());
		}
		
	}

	public void trocarAba (int aba) {
		
		String windowHandle = driver.getWindowHandle();
		ArrayList tabs = new ArrayList (driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window((String) tabs.get(aba));
	}
}
