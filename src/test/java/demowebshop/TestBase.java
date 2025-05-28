package demowebshop;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    String login = "gordienko210688@gmail.com",
            password = "Nokiac500";

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demowebshop.tricentis.com/";
        RestAssured.baseURI = "https://demowebshop.tricentis.com/";
    }
}
