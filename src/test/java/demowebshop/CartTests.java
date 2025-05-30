package demowebshop;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class CartTests extends TestBase {
    @Test
    void checkTheItemInTheCart() {
        open("https://demowebshop.tricentis.com/");
        $(byText("Log in")).click();
        $("#Email").setValue("gordienko210688@gmail.com");
        $("#Password").setValue("Nokiac500");
        $(".login-button").click();
        $(".cart-qty").shouldHave(text("(0)"));

    }

    @Test
    void addToCartTest() {
        String authCookieKey = "NOPCOMMERCE.AUTH";
        String authCookieKeyValue = given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("Email", login)
                .formParam("Password", password)
                .when()
                .post("/login")
                .then()
                .statusCode(302)
                .extract()
                .cookie(authCookieKey);

        String data = "product_attribute_72_5_18=53" +
                "&product_attribute_72_6_19=54" +
                "&product_attribute_72_3_20=57&addtocart_72.EnteredQuantity=1";


        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body(data)
                .cookie(authCookieKey, authCookieKeyValue)
                .when()
                .post("/addproducttocart/details/72/1")
                .then()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"));
    }

    @Test
    void removeItemFromCart() {
        open("https://demowebshop.tricentis.com/");
        $(".cart-qty").shouldHave(text("(1)"));
        $(byText("Shopping cart")).click();
        $("[name='removefromcart']").click();
        $(".update-cart-button").click();
        $(".cart-qty").shouldHave(text("(0)"));
    }
}


