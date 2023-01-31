package br.com.sicreditestingaut.tests.simulacoes.tests;

import br.com.sicreditestingaut.base.BaseTest;
import br.com.sicreditestingaut.suites.AllTests;
import br.com.sicreditestingaut.tests.simulacoes.requests.PutSimulacaoCpfRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.containsString;

public class PutSimulacaoCpfTest extends BaseTest {

    PutSimulacaoCpfRequest putSimulacaoCpfRequest = new PutSimulacaoCpfRequest();

    @Test
    @Category(AllTests.class)
    public void validaAtualizacaoDeSimulacao(){

        putSimulacaoCpfRequest.atualizaSimulacao()
                .then()
                    .statusCode(200)
                    .body(containsString("95310599002"));
    }

    @Test
    @Category(AllTests.class)
    public void validaAtualizacaoDeSimulacaoNaoEncontrada(){

        putSimulacaoCpfRequest.atualizaSimulacaoNaoEncontrada()
                .then()
                .statusCode(404)
                .body(containsString("não encontrado"));
    }

    //FAZER VALIDAÇÃO DO STATUSCODE 409
}
