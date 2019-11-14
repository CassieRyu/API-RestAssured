package API.RestAssured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;


import static io.restassured.RestAssured.given;

public class FilmsTest {

    private static String FILM_PATH = "/films";
   // MethodHelper helper = new MethodHelper();

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://ghibliapi.herokuapp.com";
    }
    @Test(groups = "films")
    public void filmsContainHighScoreItems(){
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get(FILM_PATH);
        //ResponseBody body = response.getBody();
        JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println("films response json: " + jsonPathEvaluator);

       /* given().
        when().
            get(FILM_PATH).
        then().
            statusCode(200).
            body("rt_score.collect{it.length()>2}.size", greaterThan(4));*/
    }

    @Test(groups = "films")
    public void findASpecificFilm() {

        String filmId = "58611129-2dbc-4a81-a72f-77ddfc1b1b49";
        given().
        when().
            get(FILM_PATH+"/" + filmId).
        then().
            assertThat()
                .statusCode(200);
    }
}
