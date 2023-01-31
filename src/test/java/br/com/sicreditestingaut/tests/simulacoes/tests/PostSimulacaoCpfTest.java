package br.com.sicreditestingaut.tests.simulacoes.tests;

import br.com.sicreditestingaut.base.BaseTest;
import br.com.sicreditestingaut.suites.AllTests;
import br.com.sicreditestingaut.tests.simulacoes.requests.PostSimulacaoCpfRequest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.hamcrest.Matchers.equalTo;

public class PostSimulacaoCpfTest extends BaseTest {

    PostSimulacaoCpfRequest postSimulacaoCpfRequest = new PostSimulacaoCpfRequest();

    @Test
    @Category(AllTests.class)
    public void validaInsercaoDeNovaSimulacao(){

        postSimulacaoCpfRequest.insereNovaSimulacao()
                .then()
                    .statusCode(201)
                    .body("cpf", equalTo("54644721697"));
    }

    @Test
    @Category(AllTests.class)
    public void validaInsercaoDeSimulacaoFaltandoInfo(){

        postSimulacaoCpfRequest.insereSimulacaoFaltandoInfo()
                .then()
                    .statusCode(400);
    }

    @Test
    @Category(AllTests.class)
    public void validaInsercaoDeSimulacaoJaExistente(){

        postSimulacaoCpfRequest.insereSimulacaoJaExistente()
                .then()
                    .statusCode(400)
                    .body("mensagem", equalTo("CPF duplicado"));
    }
}
