package demowebshop;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class LoginTests extends TestBase {

    @Test
    void loginWithUITest() {
        step("Open login page", () ->
                open("/login"));
        step("Fill login form", () -> {
            $("#Email").setValue(login);
            $("#Password").setValue(password).pressEnter();
        });
        step("Verify successful autorization", () ->
                $(byText("gordienko210688@gmail.com")).shouldHave(text(login)));
    }

    @Test
    void loginWithApiTest() {
        step("Get authorization cookie by api and set it to browser", () -> {
            String authCookieKey = "NOPCOMMERCE.AUTH";
            String authCookieKeyValue = given()
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("Email", login)
                    .formParam("Password", password)
                    .when()
                    .post("/login")
                    .then()
                    .log().all()
                    .statusCode(302)
                    .extract()
                    .cookie(authCookieKey);

            open("/Content/jquery-ui-themes/smoothness/images/ui-bg_flat_75_ffffff_40x100.png");
            Cookie authCookie = new Cookie(authCookieKey, authCookieKeyValue);
            getWebDriver().manage().addCookie(authCookie);


        });
        step("Verify successful autorization", () ->
                $(byText("gordienko210688@gmail.com")).shouldHave(text(login)));
    }
}
