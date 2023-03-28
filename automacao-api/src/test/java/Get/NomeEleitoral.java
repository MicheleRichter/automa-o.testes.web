package Get;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import metodo.Metodos;

public class NomeEleitoral extends Metodos {
	
	@Test
	public void validarNomeEleitoral () {
		
		String idRetornado = consultarId("100");
		String nomeEsperado = "Clodoaldo Magalhães";
		Response response = RestAssured.get("https://dadosabertos.camara.leg.br/api/v2/deputados/"+idRetornado);
		
		String nomeCapturado = response.jsonPath().getString("dados.ultimoStatus.nomeEleitoral").toString();
		System.out.println(nomeCapturado);
		assertEquals(nomeEsperado, nomeCapturado);
	}
	
	

}
