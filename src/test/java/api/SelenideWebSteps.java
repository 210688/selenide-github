package api;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideWebSteps {

    @Step("Открыть главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Поиск репозитория {repo}")
    public void searchForRepository(String repo) {
        $("[data-target='qbsearch-input.inputButton']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $(".Box-sc-g0xbh4-0.JcuiZ").shouldHave(text(repo));
    }

    @Step("Выбрать репозиторий {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText("selenide/selenide")).click();
    }

    @Step("Выбрать вкладку Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверить наличие Issue с номером {issue}")
    public void shouldSeeIssueWithNumber(String issue) {
        $(byText("Add unHighliter() method")).shouldHave(text(issue));
    }
}
