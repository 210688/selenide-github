package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideWiki {
    @BeforeAll
    static void setUp() {
        Configuration.pageLoadStrategy = "eager";
    }
        @Test
        void shouldFindSelenideWiki () {
            open("https://github.com/");
            $("#hero-section-brand-heading").shouldHave(text("Build and ship software on a single, collaborative platform"));
            $("[data-target='qbsearch-input.inputButton']").click();
            $("#query-builder-test").setValue("selenide").pressEnter();
            $(".jJRiHe").shouldHave(text("5.8k results"));
            $$(".search-match").get(0).click();
            $("#repository-container-header").shouldHave(text("selenide / selenide"));
            $("#wiki-tab").click();
            $(".heading-element").shouldHave(text("Welcome to the selenide wiki!"));
            $(".js-wiki-more-pages-link").click();
            $$(".js-wiki-pages-box").find(visible).shouldHave(text("SoftAssertions"));
            $(byLinkText("Soft assertions")).click();
            $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
        }
    }
