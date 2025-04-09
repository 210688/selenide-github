package api;

import models.lombok.NameBodyLombokModel;
import models.lombok.NameResponseLombokModel;
import models.lombok.SingleUserResponseLombokModel;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.NameSpec.*;


public class ReqresTests {

    @Test
    void getSingleLombokUser() {
        SingleUserResponseLombokModel singleUserResponseLombokModel = step("Make request", () ->
                given(requestSpecificationSingle)
                        .when()
                        .get()
                        .then()
                        .spec(responseSpecificationSingle)
                        .extract().as(SingleUserResponseLombokModel.class));
        step("Check response", () -> {
            assertEquals(2, singleUserResponseLombokModel.getData().getId());
            assertEquals("janet.weaver@reqres.in", singleUserResponseLombokModel.getData().getEmail());
            assertEquals("Janet", singleUserResponseLombokModel.getData().getFirst_name());
            assertEquals("Weaver", singleUserResponseLombokModel.getData().getLast_name());
            assertEquals("https://reqres.in/img/faces/2-image.jpg", singleUserResponseLombokModel.getData().getAvatar());
        });
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
        given(requestSpecification)
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
        given(requestSpecification)
                .delete("/users/2")
                .then()
                .statusCode(204);
    }

}
