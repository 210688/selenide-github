package homework;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "3840x2160";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";

    }

    @Test
    void dragAndDropCheck() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $(".example").shouldBe(visible);
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
        //$("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
