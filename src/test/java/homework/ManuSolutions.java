package homework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ManuSolutions {
//    @BeforeAll
//   void all() {
//     Configuration.baseUrl = "https://github.com";
//    }

    @Test
    void searchTest() {
        baseUrl = "https://github.com";
        SelenideElement page =  $(".enterprise-hero");
        open(baseUrl);
        $(byText("Solutions")).hover();
        $(byText("Enterprise")).parent().click();
        $(byText("Enterprise")).closest("li");
        $(".enterprise-hero").shouldHave(text("The AI-powered"));
        page.click();
    }
}
