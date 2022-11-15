package com.simbirsoft.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class AllureExamplesTest extends TestBase {

    @Test
    @AllureId("12892")
    @DisplayName("Успешный поиск репозитория Allure Examples")
    @Story("Поиск репозитория")
    @Owner("allure8")
    @Feature("Поиск репозитория")
    void repoSearchTest() {
        step("Открыть страницу https://github.com/", ()-> {
            open("https://github.com");
        });
        step("В поле поиска Ввести Allure Examples", ()-> {
            $("input[data-test-selector=nav-search-input]").setValue("Allure Examples");
        });
        step("Нажать на Enter", ()-> {
            $("input[data-test-selector=nav-search-input]").pressEnter();
        });
        step("Проверить, что результат поисковой выдачи включает репозиторий Allure Examples", ()-> {
            $$(".repo-list-item a").shouldHave(CollectionCondition.itemWithText("allure-examples/allure-examples"));
        });
    }

    @Test
    @AllureId("12894")
    @DisplayName("Поиск задачи №26 в репозитории Allure Examples")
    @Story("Поиск задач")
    @Owner("allure8")
    @Feature("Поиск репозитория")
    void issueSearchTest() {
        step("Открыть репозиторий Allure Examples https://github.com/allure-examples/allure-examples", ()-> {
            open("https://github.com/allure-examples/allure-examples");
        });
        step("Перейти во вкладку Issues", ()-> {
            $("#issues-tab").click();
        });
        step("Проверить, что в списке задач есть задача с номером 26", ()-> {
            $$(".text-small .opened-by").shouldHave(CollectionCondition.sizeGreaterThan(0));
            $$(".text-small .opened-by").shouldHave(CollectionCondition.itemWithText("#26 opened on Mar 15, 2021Mar 14, 2021 by svasenkov"));
        });
    }

    @Test
    @AllureId("12895")
    @DisplayName("Поиск ветки allure-testops-integration в репозитории Allure Examples")
    @Story("Просмотр веток в репозитории")
    @Owner("allure8")
    @Feature("Ветки")
    void checkBranchInRepo() {
        step("Открыть репозиторий Allure Examples https://github.com/allure-examples/allure-examples", ()-> {
            open("https://github.com/allure-examples/allure-examples");
        });
        step("Перейти во вкладку branches", ()-> {
            $$(".Link--primary").findBy(Condition.text("branches")).click();
        });
        step("Проверить, что в списке веток есть ветка allure-testops-integration", ()-> {
            $$(".branch-name").shouldHave(CollectionCondition.sizeGreaterThan(0));
            $$(".branch-name").shouldHave(CollectionCondition.itemWithText("allure-testops-integration"));
        });
    }

    @Test
    @AllureId("12896")
    @DisplayName("Поиск открытого пулл-реквеста dotnet - NUnit в репозитории Allure Examples")
    @Story("Просмотр пулл-реквестов репозитория")
    @Owner("allure8")
    @Feature("Ветки")
    void checkPullRequestInRepo() {
        step("Открыть репозиторий Allure Examples https://github.com/allure-examples/allure-examples", ()-> {
            open("https://github.com/allure-examples/allure-examples");
        });
        step("Перейти во вкладку Pull requests", ()-> {
            $("#pull-requests-tab").click();
        });
        step("Проверить, что в списке есть открытый пулл-реквест dotnet - NUnit", ()-> {
            $$("div[aria-label=Issues] .markdown-title").shouldHave(CollectionCondition.sizeGreaterThan(0));
            $$("div[aria-label=Issues] .markdown-title").shouldHave(CollectionCondition.itemWithText("dotnet - NUnit #28"));
        });
    }
}
