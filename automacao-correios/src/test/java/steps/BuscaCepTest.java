package steps;


import elementos.Elementos;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metodos.Metodos;
import runner.Executa;

public class BuscaCepTest extends Executa {

	Metodos metodo = new Metodos();
	Elementos el = new Elementos();
	

	@Given("que esteja no site do correios")
	public void queEstejaNoSiteDoCorreios() {
		Executa.abrirNavegador();

	}

	@When("informar cep valido")
	public void informarCepValido() {
		
		metodo.clicar(el.campoBusca);
		metodo.escrever(el.campoBusca, "85935000");
		metodo.print("CT01 - Informando Cep valido");

	}

	@Then("sistema apresenta informacoes")
	public void sistemaApresentaInformacoes() throws InterruptedException {
		metodo.submit(el.campoBusca);
		Thread.sleep(2000);
		metodo.trocarAba(1);
		metodo.validarTexto("Resultado da Busca por Endereço ou CEP", el.buscaOk);
		metodo.print("CT01 - Busca Realizada com sucesso");
	}

	@Given("informar cep inexistente")
	public void informarCepInexistente() {
		
		metodo.clicar(el.campoBusca);
		metodo.escrever(el.campoBusca, "00000000");
		metodo.print("CT02 - Informando cep inexistente");

	}

	@When("realizar busca")
	public void realizarBusca() throws InterruptedException {
		metodo.submit(el.campoBusca);
		Thread.sleep(2000);
		metodo.trocarAba(1);

	}

	@Then("sistema nao encontra informacoes")
	public void sistemaNaoEncontraInformacoes() {
		metodo.print("CT02 - Informações não encontradas");
		metodo.validarTexto("Dados não encontrado", el.dadosNE);
	}

	@After
	public void fechar() {
		Executa.fecharNavegador();
	}

}
