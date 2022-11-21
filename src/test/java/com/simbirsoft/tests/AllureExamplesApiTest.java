package com.simbirsoft.tests;

import com.simbirsoft.allure.Layer;
import com.simbirsoft.allure.Microservice;
import io.qameta.allure.AllureId;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@Layer("rest")
public class AllureExamplesApiTest {

    @Test
    @AllureId("12892")
    @DisplayName("Проверка метода /octocat")
    @Story("Проверка доступности api")
    @Microservice("Common api")
    @Owner("allure8")
    void checkSimpleRequestApiGithub() {
        given()
                .get("https://api.github.com/octocat")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    @AllureId("12892")
    @DisplayName("Проверка ошибки в методе /octocat при пустом значении токена")
    @Story("Проверка доступности api")
    @Microservice("Common api")
    @Owner("allure8")
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
