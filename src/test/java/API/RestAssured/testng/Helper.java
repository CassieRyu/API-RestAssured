package API.RestAssured.testng;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Helper {

    public static Response doGetRequest(String endpoint) {
        return
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                .when()
                        .get(endpoint)
                .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract()
                        .response();
    }

    public static Response doPostRequest(String endpoint, Map<String, String> payload) {
        return
                given()
                        .contentType(ContentType.JSON)
                        .body(payload)
                .when()
                        .post(endpoint)
                .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract()
                        .response();
    }
}
