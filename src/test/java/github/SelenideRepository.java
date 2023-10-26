package github;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepository {

    @Test
    void shouldFindSelenideRepository() {
        open("https://github.com/");
        $("[data-target='qbsearch-input.inputButton']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$(".Box-sc-g0xbh4-0.kzrAHr").first().$("span").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));





    }

}
