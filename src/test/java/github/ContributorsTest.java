package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ContributorsTest {

    @Test
    void andreiSolntcevShouldContributorsTheMost() {

     // Configuration.browserSize = "1600x1080";
        // Configuration.browser = "firefox";
    //  Configuration.timeout = 2000;
 //
        //     Configuration.headless = true;

        open("https://github.com/selenide/selenide");
        $(".Layout-sidebar").$(byText("Contributors"))
                .ancestor(".BorderGrid-cell").$$("ul li").first()
                .hover();

        $$(".Popover").find(visible).shouldHave(text("Andrei Solntsev"));



    }
}
