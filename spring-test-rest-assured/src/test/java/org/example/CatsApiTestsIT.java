package org.example;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.lessThan;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CatsApiTestsIT
{

 /*
    cats без токена 401
    cats с user token - 403
    cats c admin token - 200 + структура ответа + скорость
 */

    private RequestSpecification resourceSpecification;

    private String userToken;
    private String adminToken;

    @BeforeAll
    public void init(){
        RequestSpecification authSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8081/auth")
                .build();

        resourceSpecification = new RequestSpecBuilder()
                .setBaseUri("http://localhost:8080/cats")
                .build();

        userToken = given()
                .spec(authSpecification).auth().preemptive().basic(TestsConfig.userName, TestsConfig.userPassword)
                .when().post().then().extract().path("token");

        adminToken = given()
                .spec(authSpecification).auth().preemptive().basic(TestsConfig.adminName, TestsConfig.adminPassword)
                .when().post().then().extract().path("token");

    }


    @Test
    @DisplayName("Resource <host>:8080/cats returns 401 without token")
    public void catsWithoutTokenReturns401()
    {
        given()
                .spec(resourceSpecification)
        .when().get()
                .then().statusCode(401);
    }

    @Test
    @DisplayName("Resource <host>:8080/cats returns 403 with user token")
    public void catsUserTokenReturns403()
    {

        given()
                .spec(resourceSpecification)
                .header("Authorization", "Bearer "+userToken)
        .when().get()
        .then()
                .statusCode(403);
    }

    @Test
    @DisplayName("Resource <host>:8080/cats returns 200 with admin token")
    public void catsAdminTokenReturns200()
    {
                given()
                        .spec(resourceSpecification)
                        .header("Authorization", "Bearer "+adminToken)
                        .log().all()
                .when().get()
                .then()
                        .statusCode(200)
                        .time(lessThan(500L), TimeUnit.MILLISECONDS);
    }
}

