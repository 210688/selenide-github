package api;

import models.lombok.*;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;
import static specs.NameSpec.*;


public class ReqresTests {

    @Test
    void getSingleLombokUser() {
        SingleUserResponseLombokModel singleUserResponseLombokModel = step("Make request users2", () ->
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

        NameResponseLombokModel nameResponseLombokModel = step("Make request users", () ->
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
        NameRequestBodyLombokModel nameRequestBodyLombokModel = new NameRequestBodyLombokModel();
        nameRequestBodyLombokModel.setName("morpheus");
        nameRequestBodyLombokModel.setJob("zion resident");
        ResponseUpdateLombokModel responseUpdateLombokModel = step("Make request users2", () ->
        given(requestSpecificationSingle)
                .body(nameRequestBodyLombokModel)
                .when()
                .put()
                .then()
                .spec(responseSpecificationSingle)
                .extract().as(ResponseUpdateLombokModel.class));
        step("Check response", () -> {
            assertEquals("morpheus", responseUpdateLombokModel.getName());
            assertEquals("zion resident", responseUpdateLombokModel.getJob());
            assertNotEquals(null, responseUpdateLombokModel.getUpdatedAt());
        });
    }

    @Test
    void deleteUser() {
        given(requestSpecificationSingle)
                .delete()
                .then()
                .spec(responseSpecificationDeleteSingle);
    }
}
