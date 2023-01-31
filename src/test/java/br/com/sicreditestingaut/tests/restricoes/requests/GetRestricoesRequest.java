package br.com.sicreditestingaut.tests.restricoes.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetRestricoesRequest {

    public Response retornaCpfComRestricao(String cpf){

        //String cpf = "97093236014";

        return
                given()
                    .header("Content-Type", "aplication/json")
                    .pathParam("cpf", cpf)
                .when()
                    .get("/v1/restricoes/{cpf}");
    }

    public Response retornaCpfSemRestricao(){

        String cpf = "19052831050";

        return given()
                    .header("Content-Type", "aplication/json")
                    .pathParam("cpf", cpf)
                .when()
                    .get("/v1/restricoes/{cpf}");
    }
}
