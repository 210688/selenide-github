package webTests;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
public class WebTests {
    @ValueSource(strings = {"Hello", "World"})
    @ParameterizedTest(name = "Результаты перевода не пустые для слова {0}")
    void commonSearchTest(String testData){
        open("https://translate.google.com/?sl=en&tl=ru&op=translate/");
        $(".er8xn").setValue(testData);
        $$(".ryNqvb").shouldBe(CollectionCondition.sizeGreaterThan(0));

    }
    @CsvSource(value = {
            "Hello, Привет",
            "World, Мир"
    })
    @ParameterizedTest(name = "Результаты перевода - \"{1}\" для слова: \"{0}\"")
    void commonComplexSearchTest(String testData, String expectedResult){
        open("https://translate.google.com/?sl=en&tl=ru&op=translate");
        $(".er8xn").setValue(testData);
        $$(".ryNqvb")
                .first()
                .shouldHave(text(expectedResult));
    }

    static Stream<Arguments> ioStartMenuTest() {
        return Stream.of(
                Arguments.of("EN ", List.of("TESTING EXPERTISE", "FOR YOUR INDUSTRY", "SOLUTIONS", "INSIGHTS & SUCCESS STORIES", "ABOUT US")),
                Arguments.of("DE ", List.of("SERVICES", "CROWDTESTING", "GERÄTEABDECKUNG", "RESSOURCEN", "COMPANY"))
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