package com.simbirsoft.tests;

import com.simbirsoft.allure.Layer;
import com.simbirsoft.allure.Microservice;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Layer("rest")
public class AllureExamplesApiTest {

    @Test
    @AllureId("13122")
    @DisplayName("Проверка метода /octocat")
    @Story("Проверка доступности api")
    @Owner("allure8")
    @Feature("Проверка доступности api.github")
    @Microservice("Common api")
    void checkSimpleRequestApiGithub() {
        given()
                .get("https://api.github.com/octocat")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    @AllureId("13121")
    @DisplayName("Проверка ошибки в методе /octocat при пустом значении токена")
    @Story("Проверка доступности api")
    @Owner("allure8")
    @Feature("Проверка доступности api.github")
    @Microservice("Common api")
    void checkErrorWhenTokenEmpty() {
        given()
                .header("Authorization", "Bearer")
                .when()
                .get("https://api.github.com/octocat")
                .then()
                .log().body()
                .statusCode(401)
                .body("message", is("Bad credentials"));


    }



}
