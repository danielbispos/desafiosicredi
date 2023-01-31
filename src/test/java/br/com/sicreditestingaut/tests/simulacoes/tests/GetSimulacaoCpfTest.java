package br.com.sicreditestingaut.tests.simulacoes.tests;

import br.com.sicreditestingaut.base.BaseTest;
import br.com.sicreditestingaut.suites.AllTests;
import br.com.sicreditestingaut.tests.simulacoes.requests.GetSimulacaoCpfRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.equalTo;

public class GetSimulacaoCpfTest extends BaseTest {

    GetSimulacaoCpfRequest getSimulacaoCpfRequest = new GetSimulacaoCpfRequest();

    @Test
    @Category(AllTests.class)
    public void validaRetornoSimulacaoPorCpfSemRestricao(){

        getSimulacaoCpfRequest.retornaSimulacaoPorCpfSemRestricao()
                .then()
                    .statusCode(200)
                    .body("cpf",equalTo("91777989027"));

    }

    @Test
    @Category(AllTests.class)
    public void validaRetornoSimulacaoPorCpfNaoEncontrado(){

        getSimulacaoCpfRequest.retornaSimulacaoPorCpfNaoEncontrado()
                .then()
                .statusCode(404)
                .body("mensagem",equalTo("CPF 46984556007 não encontrado"));

    }
}
