package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWiki {

    @Test
    void shouldFindSelenideWiki() {
        open("https://github.com/");
        $(".search-input-container").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$(".kzrAHr").first().$("span").click();
        $(".application-main").shouldHave(text("selenide / selenide"));
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $$(".Layout-sidebar").find(visible).shouldHave(text("SoftAssertions"));
        $(byLinkText("Soft assertions")).click();
        $("#wiki-content").shouldHave(text("Using JUnit5 extend test class"));

    }
}
