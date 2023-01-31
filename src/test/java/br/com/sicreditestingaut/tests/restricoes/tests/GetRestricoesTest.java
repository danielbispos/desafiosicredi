package br.com.sicreditestingaut.tests.restricoes.tests;

import br.com.sicreditestingaut.base.BaseTest;
import br.com.sicreditestingaut.suites.AllTests;
import br.com.sicreditestingaut.tests.restricoes.requests.GetRestricoesRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.*;

public class GetRestricoesTest extends BaseTest {

    GetRestricoesRequest getRestricoesRequest = new GetRestricoesRequest();

    @Test
    @Category(AllTests.class)
    public void validaCpfComRestricao(){

        String cpfComRestricao = "97093236014";

        getRestricoesRequest.retornaCpfComRestricao(cpfComRestricao)
                .then()
                        .statusCode(200)
                        .body("mensagem", equalTo("O CPF 97093236014 tem problema"));
    }

    @Test
    @Category(AllTests.class)
    public void validaCpfSemRestricao(){

        getRestricoesRequest.retornaCpfSemRestricao()
                .then()
                .statusCode(204);
    }

}
