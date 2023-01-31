package br.com.sicreditestingaut.tests.simulacoes.requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class DeleteSimulacaoIdRequest {

    public Response removeUmaSimulacaoPorId(int id) {

        return given()
                    .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("aplication/json", ContentType.TEXT)))
                    .contentType(ContentType.JSON)
                    .pathParam("id", id)
                .when()
                    .delete("/v1/simulacoes/{id}");
    }
}
