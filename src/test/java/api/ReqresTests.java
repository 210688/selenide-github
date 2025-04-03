package api;

import io.restassured.RestAssured;
import models.NameBodyModel;
import models.NameResponseModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReqresTests {

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api";
    }

    @Test
    void getSingleUser() {
        given()
                .get("/users/2")
                .then()
                .statusCode(200)
                .body("data.id", is(2));
    }

    @Test
    void postGreateUser() {
        NameBodyModel nameBodyModel = new NameBodyModel();
        nameBodyModel.setName("morpheus");
        nameBodyModel.setJob("leader");

        NameResponseModel nameResponseModel =  given()
                .body(nameBodyModel)
                .contentType(JSON)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract().as(NameResponseModel.class);

        assertEquals("morpheus", nameResponseModel.getName());
        assertEquals("leader", nameResponseModel.getJob());


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
