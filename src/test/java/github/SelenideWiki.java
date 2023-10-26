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
        $("[data-target='qbsearch-input.inputButton']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$(".Box-sc-g0xbh4-0.kzrAHr").first().$("span").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $$(".js-wiki-pages-box").find(visible).shouldHave(text("SoftAssertions"));
        $(byLinkText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));

    }
}
// to do