package br.com.sicreditestingaut.base;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTest {

    @BeforeClass
    public static void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = Integer.parseInt("8080");
        RestAssured.basePath = "/api";
    }
}
