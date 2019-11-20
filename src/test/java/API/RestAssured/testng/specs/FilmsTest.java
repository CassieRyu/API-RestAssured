package API.RestAssured.testng.specs;

import API.RestAssured.testng.Env;
import API.RestAssured.testng.Helper;
import io.restassured.RestAssured;
import io.restassured.response.*;
import org.testng.annotations.*;

import java.util.List;

import static io.restassured.RestAssured.given;

public class FilmsTest {

    @BeforeClass
    public void setup() {

       // RestAssured.baseURI = Env.getBaseURL();
        RestAssured.baseURI = "https://ghibliapi.herokuapp.com";
        RestAssured.basePath = "/films";
    }

    @Test(groups = "films")
    public void filmsContainHighScoreItems() {
        Response response = Helper.doGetRequest("");

        List<String> scores = response.jsonPath().getList("rt_score");
        System.out.println("scores: " + scores.get(0));
      //  scores.stream().map(Integer::parseInt).collect(Collectors.toList());
        System.out.println("score2: " + scores.get(0));

    }

    @Test(groups = "films")
    public void findASpecificFilm() {

        String filmId = "58611129-2dbc-4a81-a72f-77ddfc1b1b49";
        given().
                when().
                get("/" + filmId).
                then().
                assertThat()
                .statusCode(200);
    }
}
