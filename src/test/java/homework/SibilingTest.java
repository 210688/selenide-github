package homework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SibilingTest {
    @Test
    void sibiltngСhecks() {
        open("https://www.mos.ru/");
        $(byText("Новости")).hover();
        $(".Telly_grid__lXFMU").preceding(0).shouldHave(text("Записаться к врачу"));
        $(".dropdown_dropdown__1Oynj").$(byText("Услуги"))
                .parent().shouldHave(text("Услуги"));
        $(byText("Афиша")).closest("button");

        sleep(5000);
    }
}
