package runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import conexoes.Drivers;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "src/test/resources/features", glue = "steps", tags = "@todos", monochrome = true, dryRun = false, plugin = {
				"pretty", "html:target/report-cucumber.html" }, snippets = SnippetType.CAMELCASE)

public class Executa extends Drivers {
	
	public static String navegador = "Chrome";
	public static String url = "https://www.correios.com.br/";

	
	public static void abrirNavegador() {
		
		boolean headless = false;
		ChromeOptions chrome = new ChromeOptions();
		if (headless) {
			chrome.addArguments("--headless");
		}
		FirefoxOptions firefox = new FirefoxOptions();
		if (headless) {
			firefox.addArguments("--headless");
		}
		
		if (navegador.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chrome);

		} else if (navegador.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefox);

		} else {
			System.out.println("Navegador inválido");
		}
		
		driver.manage().window().maximize();
		driver.get(url);

	}
	
	
	public static void fecharNavegador () {
		driver.quit();
		
	}

}
