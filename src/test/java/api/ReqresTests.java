package api;

import models.lombok.NameBodyLombokModel;
import models.lombok.NameResponseLombokModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.NameSpec.requestSpecification;
import static specs.NameSpec.responseSpecification;

public class ReqresTests {

    @Test
    void getSingleUser() {
        given()
                .get("/users/2")
                .then()
                .statusCode(200)
                .body("data.id", is(2));
    }

    @Test
    void postGreateLombokUser() {
        NameBodyLombokModel nameBodyLombokModel = new NameBodyLombokModel();
        nameBodyLombokModel.setName("morpheus");
        nameBodyLombokModel.setJob("leader");

        NameResponseLombokModel nameResponseLombokModel = step("Make request", () ->
                given(requestSpecification)
                        .body(nameBodyLombokModel)

                        .when()
                        .post()
                        .then()
                        .spec(responseSpecification)
                        .extract().as(NameResponseLombokModel.class));

        step("Check response", () -> {
            assertEquals("morpheus", nameResponseLombokModel.getName());
            assertEquals("leader", nameResponseLombokModel.getJob());
        });
    }

    @Test
    void putUpdateUser() {
        given()
                .body("{\"name\": \"morpheus\",\"job\": \"zion resident\"}")
                .contentType(JSON)
                .put("/users/2")
                .then()
                .statusCode(200)
                .body("name", is("morpheus"))
                .body("job", is("zion resident"));
    }

    @Test
    void deleteUser() {
        given()
                .delete("/users/2")
                .then()
                .statusCode(204);
    }

}
