package br.com.sicreditestingaut.tests.simulacoes.tests;

import br.com.sicreditestingaut.base.BaseTest;
import br.com.sicreditestingaut.suites.AllTests;
import br.com.sicreditestingaut.tests.simulacoes.requests.DeleteSimulacaoIdRequest;
import br.com.sicreditestingaut.tests.simulacoes.requests.PostSimulacaoCpfRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.containsString;

public class DeleteSimulacaoIdTest extends BaseTest {

    DeleteSimulacaoIdRequest deleteSimulacaoIdRequest = new DeleteSimulacaoIdRequest();
    PostSimulacaoCpfRequest postSimulacaoCpfRequest = new PostSimulacaoCpfRequest();

    @Test
    @Category(AllTests.class)
    public void validaExclusaoDeUmaSimulacaoPorId(){

        int id = postSimulacaoCpfRequest.getId();

        deleteSimulacaoIdRequest.removeUmaSimulacaoPorId(id)
                .then()
                    .statusCode(200)
                    .body(containsString("OK"));
    }
}
