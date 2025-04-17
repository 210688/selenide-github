package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class NameSpec {
    public static RequestSpecification requestSpecification = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .baseUri("https://reqres.in")
            .basePath("/api/users");

    public static ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .build();

    public static RequestSpecification requestSpecificationSingle = with()
            .filter(withCustomTemplates())
            .contentType(JSON)
            .baseUri("https://reqres.in")
            .basePath("/api/users/2");

    public static ResponseSpecification responseSpecificationSingle = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification responseSpecificationDeleteSingle = new ResponseSpecBuilder()
            .expectStatusCode(204)
            .build();
}
