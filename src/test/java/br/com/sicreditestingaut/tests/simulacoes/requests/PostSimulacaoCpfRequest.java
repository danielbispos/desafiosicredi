package br.com.sicreditestingaut.tests.simulacoes.requests;

import br.com.sicreditestingaut.tests.simulacoes.Payloads.SimulacoesPayloads;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class PostSimulacaoCpfRequest {

    SimulacoesPayloads simulacoesPayloads = new SimulacoesPayloads();
    DeleteSimulacaoIdRequest deleteSimulacaoIdRequest = new DeleteSimulacaoIdRequest();

    public Response insereNovaSimulacao(){

        return given()
                    .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("aplication/json", ContentType.TEXT)))
                    .contentType(ContentType.JSON)
                .when()
                    .body(SimulacoesPayloads.payloadInsereSimulacao().toString())
                    .post("/v1/simulacoes");
    }

    public String insereSimulacaoGetCpf(){

        return given()
                    .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("aplication/json", ContentType.TEXT)))
                    .contentType(ContentType.JSON)
                .when()
                    .body(SimulacoesPayloads.payloadInsereSimulacaoGetCpf().toString())
                    .post("/v1/simulacoes")
                .then()
                    .statusCode(201)
                    .extract()
                    .path("cpf");
    }

    public String insereSimulacaoConsultaCpfSemRestricao() {

        return given()
                    .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("aplication/json", ContentType.TEXT)))
                    .contentType(ContentType.JSON)
                .when()
                    .body(SimulacoesPayloads.payloadConsultaSimulacaoCpfSemRestricao().toString())
                    .post("/v1/simulacoes")
                .then()
                    .statusCode(201)
                    .extract()
                    .path("cpf");
    }

    public String getCpf(){
        return this.insereNovaSimulacao()
                .then()
                    .statusCode(201)
                    .extract()
                    .path("cpf");
    }

    public int insereSimulacaoGetId(){

        return given()
                    .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("aplication/json", ContentType.TEXT)))
                    .contentType(ContentType.JSON)
                .when()
                    .body(SimulacoesPayloads.payloadInsereSimulacaoGetId().toString())
                    .post("/v1/simulacoes")
                .then()
                    .statusCode(201)
                    .extract()
                    .path("id");
    }

    public int getId(){
        return this.insereNovaSimulacao()
                .then()
                    .statusCode(201)
                    .extract()
                    .path("id");
    }

    public Response insereSimulacaoFaltandoInfo(){

        return given()
                    .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("aplication/json", ContentType.TEXT)))
                    .contentType(ContentType.JSON)
                .when()
                    .body(SimulacoesPayloads.payloadInsereSimulacaoFaltandoInfo().toString())
                    .post("/v1/simulacoes");
    }

    public Response insereSimulacaoJaExistente(){

        return given()
                    .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("aplication/json", ContentType.TEXT)))
                    .contentType(ContentType.JSON)
                .when()
                    .body(SimulacoesPayloads.payloadInsereSimulacaoJaExistente().toString())
                    .body(SimulacoesPayloads.payloadInsereSimulacaoJaExistente().toString())
                    .post("/v1/simulacoes");
    }

    public Response insereSimulacaoVazia(){

        return given()
                    .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("aplication/json", ContentType.TEXT)))
                    .contentType(ContentType.JSON)
                .when()
                    .body(SimulacoesPayloads.payloadInsereSimulacaoVazia().toString())
                    .post("/v1/simulacoes");
    }


}
