package br.com.sicreditestingaut.tests.simulacoes.Payloads;

import br.com.sicreditestingaut.tests.simulacoes.requests.GetSimulacoesRequest;
import org.json.JSONObject;

public class SimulacoesPayloads {

    static GetSimulacoesRequest getSimulacoesRequest = new GetSimulacoesRequest();

    public static JSONObject payloadInsereSimulacao(){
        JSONObject payload = new JSONObject();

        payload.put("nome","Denzel Washington");
        payload.put("cpf","54644721697");
        payload.put("email","denzelw@gmail.com");
        payload.put("valor",5000);
        payload.put("parcelas",5);
        payload.put("seguro",true);

        return payload;
    }

    public static JSONObject payloadInsereSimulacaoGetCpf(){
        JSONObject payload = new JSONObject();

        payload.put("nome","Lobão do Amor Divino");
        payload.put("cpf","10330689002");
        payload.put("email","lobaodivino@outlook.com");
        payload.put("valor",20000.00);
        payload.put("parcelas",36);
        payload.put("seguro",false);

        return payload;
    }

    public static JSONObject payloadConsultaSimulacaoCpfSemRestricao(){
        JSONObject payload = new JSONObject();

        payload.put("nome","Terezinha de Jesus");
        payload.put("cpf","91777989027");
        payload.put("email","tecadejesus@bol.com");
        payload.put("valor",9000.99);
        payload.put("parcelas",12);
        payload.put("seguro",true);

        return payload;
    }

    public static JSONObject payloadInsereSimulacaoGetId(){
        JSONObject payload = new JSONObject();

        payload.put("nome","Tagaropoulos Christus");
        payload.put("cpf","70816040052");
        payload.put("email","tchristus@yahoo.com.br");
        payload.put("valor",140000.16);
        payload.put("parcelas",60);
        payload.put("seguro",true);

        return payload;
    }

    public static JSONObject payloadInsereSimulacaoFaltandoInfo(){
        JSONObject payload = new JSONObject();

        payload.put("nome","Joao do Amor Divino");
        payload.put("cpf", "55555555555");
        payload.put("email","joaoadivino@gmail.com");
        payload.put("valor",10000);
        payload.put("parcelas",5);
        payload.put("seguro","CanString");

        return payload;
    }

    public static JSONObject payloadInsereSimulacaoJaExistente(){
        JSONObject payload = new JSONObject();

        String cpfExistente = getSimulacoesRequest.retornaTodasSimulacoes()
                        .then()
                                .statusCode(200)
                                        .extract()
                                                .path("[1].cpf");

        payload.put("nome","Samuel Calisto");
        payload.put("cpf", cpfExistente);
        payload.put("email","samuelcalisto@gmail.com");
        payload.put("valor",6000);
        payload.put("parcelas",12);
        payload.put("seguro",true);

        return payload;
    }

    public static JSONObject payloadInsereSimulacaoVazia(){
        JSONObject payload = new JSONObject();
        String cpfVazio = null;

        payload.put("nome","Denzel Washington");
        payload.put("cpf", cpfVazio);
        payload.put("email","denzelw@gmail.com");
        payload.put("valor",5000);
        payload.put("parcelas",5);
        payload.put("seguro",true);

        return payload;
    }

    public static JSONObject payloadAtualizaSimulacao(){
        JSONObject payload = new JSONObject();

        payload.put("nome","Didi Mocó Sonrisal Colesterol Novalgino Mufumbo");
        payload.put("cpf","95310599002");
        payload.put("email","didimoco@gmail.com");
        payload.put("valor",80000);
        payload.put("parcelas",100);
        payload.put("seguro",true);

        return payload;
    }
}
