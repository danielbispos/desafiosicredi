package br.com.sicreditestingaut.tests.simulacoes.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetSimulacoesRequest {

    public Response retornaTodasSimulacoes(){

        return given()
                    .header("Content-Type", "aplication/json")
                .when()
                    .get("/v1/simulacoes");
    }

    public Response consultaSemSimulacoes(){

        return given()
                .header("Content-Type", "aplication/json")
                .when()
                .get("/v1/simulacoes");
    }
}
