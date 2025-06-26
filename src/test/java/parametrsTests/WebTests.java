package parametrsTests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class WebTests {

    @ValueSource(strings = {"Hello", "World"})
    @ParameterizedTest(name = "Результаты перевода не пустые для слова {0}")
    void commonSearchTest(String testData){
        open("https://translate.yandex.ru/");
        $("#fakeArea").setValue(testData);
        $$("#translation").shouldBe(CollectionCondition.sizeGreaterThan(0));

    }

    @CsvSource(value = {
            "Hello, Здравствуйте",
            "World, Мир"
    })
    @ParameterizedTest(name = "Результаты перевода - \"{1}\" для слова: \"{0}\"")
    void commonComplexSearchTest(String testData, String expectedResult){
        open("https://translate.yandex.ru/");
        $("#fakeArea").setValue(testData);
        $$("#translation")
                .first()
                .shouldHave(text(expectedResult));
    }


    static Stream<Arguments> ioStartMenuTest() {
        return Stream.of(
                Arguments.of("EN ", List.of("SERVICES", "Crowdtesting", "COVERAGE", "RESOURCES", "COMPANY")),
                Arguments.of("DE ", List.of("SERVICES", "Crowdtesting", "GERÄTEABDECKUNG", "RESSOURCEN", "COMPANY"))
        );
    }

    @MethodSource
    @ParameterizedTest(name = "Для локали {0} отображаются кнопки {1}")
    void ioStartMenuTest(String lang, List<String> expectedButtons) {
        open("https://test.io/");
        $(".location-selector__button").click();
        $$(".location-selector__list a").find(text(lang)).click();
        $$(".top-navigation__row a")
                .filter(visible)
                .shouldHave(CollectionCondition.texts(expectedButtons));
    }
}