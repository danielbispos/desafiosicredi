package br.com.sicreditestingaut.tests.simulacoes.tests;

import br.com.sicreditestingaut.base.BaseTest;
import br.com.sicreditestingaut.suites.AllTests;
import br.com.sicreditestingaut.tests.simulacoes.requests.GetSimulacoesRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.greaterThan;

public class GetSimulacoesTest extends BaseTest {

    GetSimulacoesRequest getSimulacoesRequest = new GetSimulacoesRequest();

    @Test
    @Category(AllTests.class)
    public void validaRetornoSimulacoes(){

        getSimulacoesRequest.retornaTodasSimulacoes()
                .then()
                    .statusCode(200)
                    .body("size()",greaterThan(0));
    }

    @Test
    @Category(AllTests.class)
    public void validaConsultaSemSimulacoes(){

        getSimulacoesRequest.retornaTodasSimulacoes()
                .then()
                .statusCode(204);
    }
}
