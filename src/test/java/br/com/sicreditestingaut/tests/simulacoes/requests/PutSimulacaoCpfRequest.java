package br.com.sicreditestingaut.tests.simulacoes.requests;

import br.com.sicreditestingaut.tests.simulacoes.Payloads.SimulacoesPayloads;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class PutSimulacaoCpfRequest {

    SimulacoesPayloads simulacoesPayloads = new SimulacoesPayloads();
    PostSimulacaoCpfRequest postSimulacaoCpfRequest = new PostSimulacaoCpfRequest();

    public Response atualizaSimulacao(){

        String cpfRequerido = postSimulacaoCpfRequest.insereSimulacaoGetCpf();

        return given()
                    .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("aplication/json", ContentType.TEXT)))
                    .contentType(ContentType.JSON)
                    .pathParam("cpf", cpfRequerido)
                .when()
                    .body(SimulacoesPayloads.payloadAtualizaSimulacao().toString())
                    .put("/v1/simulacoes/{cpf}");
    }

    public Response atualizaSimulacaoNaoEncontrada(){

        String cpfRequerido = "88417503080";

        return given()
                    .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("aplication/json", ContentType.TEXT)))
                    .contentType(ContentType.JSON)
                    .pathParam("cpf", cpfRequerido)
                .when()
                    .body(SimulacoesPayloads.payloadAtualizaSimulacao().toString())
                    .put("/v1/simulacoes/{cpf}");
    }

    //FAZER REQUISIÇÃO DO STATUSCODE 409
}
