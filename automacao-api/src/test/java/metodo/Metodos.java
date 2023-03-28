package metodo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Metodos {

	public Response response;
	
	public String consultarId(String posicao) {
		response = RestAssured.get("https://dadosabertos.camara.leg.br/api/v2/deputados?ordem=ASC&ordenarPor=nome");
		String id = response.jsonPath().getString("dados.id["+ posicao +"]").toString();
		System.out.println(id);
		return id;
	
	}
}
