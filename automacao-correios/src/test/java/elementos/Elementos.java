package elementos;

import org.openqa.selenium.By;

public class Elementos {
	
	public By campoBusca = By.xpath("//input[@id='relaxation']");
	public By btnLupa = By.xpath("//form[@action='https://buscacepinter.correios.com.br/app/endereco/index.php?t']//i[@class='ic-busca-out']");
	
	
	//Mensagens 

	public By buscaOk = By.xpath("//h5[text()='Resultado da Busca por Endereço ou CEP']");
	public By dadosNE = By.xpath("//h6[text()='Dados não encontrado']");
}
