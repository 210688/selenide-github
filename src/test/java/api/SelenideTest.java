package api;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.Matchers.containsString;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    @Test
    @Owner("Gordienko")
    @Feature("Issue в репозитории")
    @Story("Проверка Issue")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Проверка Issue (Allure c Listener)")
    void testIssueSearch(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $("[data-target='qbsearch-input.inputButton']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $(".Box-sc-g0xbh4-0.JcuiZ").shouldHave(text("selenide/selenide"));
        $(linkText("selenide/selenide")).click();
        $("#issues-tab").click();
        $(byText("Add unHighliter() method")).shouldHave(text("Add unHighliter() method"));
    }
}

