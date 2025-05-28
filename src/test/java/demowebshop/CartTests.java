package demowebshop;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CartTests extends TestBase {
    @Test
    void addCartTest() {
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
                .log().all()
                .statusCode(200)
                .body("success", is(true))
                .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"
                ));

    }
}
