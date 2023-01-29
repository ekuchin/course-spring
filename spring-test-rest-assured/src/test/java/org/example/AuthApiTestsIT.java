package org.example;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AuthApiTestsIT
{

 /*
    auth без BasicAuth - 401
    auth с Basic Auth - 200 + token
    Некорректную авторизацию можно не тестировать, потому что это задача Security
 */

    private RequestSpecification authSpecification;

    @BeforeAll
    public void init(){
        authSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8081/auth")
                .build();
    }

    @Test
    @DisplayName("Resource <host>:8081/auth returns 401 without basic auth")
    public void authWithoutBasicAuthReturns401()
    {
        given().spec(authSpecification)
        .when().get()
        .then().statusCode(401);
    }

    @Test
    @DisplayName("Resource <host>:8081/auth returns 401 with incorrect basic auth")
    public void authWithIncorrectBasicAuthReturns401()
    {
        given()
                .spec(authSpecification)
                .auth().preemptive().basic(TestsConfig.adminName, TestsConfig.userName)
        .when().post()
        .then()
                .statusCode(401);
    }

    @Test
    @DisplayName("Resource <host>:8081/auth returns 200 with correct basic auth")
    public void authWithCorrectBasicAuthReturns200()
    {
        given()
                .spec(authSpecification)
                .auth().preemptive().basic(TestsConfig.adminName, TestsConfig.adminPassword)
        .when().post()
        .then()
                .statusCode(200);
    }
}

