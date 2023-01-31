package br.com.sicreditestingaut.tests.simulacoes.requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetSimulacaoCpfRequest {

    PostSimulacaoCpfRequest postSimulacaoCpfRequest = new PostSimulacaoCpfRequest();

    public Response retornaSimulacaoPorCpfSemRestricao(){

        String cpf = postSimulacaoCpfRequest.insereSimulacaoConsultaCpfSemRestricao(); //"91777989027"

        return given()
                    .header("Content-Type", "aplication/json")
                    .pathParam("cpf", cpf)
                .when()
                    .get("/v1/simulacoes/{cpf}");
    }

    public Response retornaSimulacaoPorCpfNaoEncontrado(){

        String cpf = "46984556007";

        return given()
                .header("Content-Type", "aplication/json")
                .pathParam("cpf", cpf)
                .when()
                .get("/v1/simulacoes/{cpf}");
    }
}
