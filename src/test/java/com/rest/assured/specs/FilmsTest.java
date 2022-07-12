package com.rest.assured.specs;

import static com.rest.assured.configuration.envSpecification.setAdminRole;

import com.rest.assured.configuration.Constants;
import com.rest.assured.configuration.Env;
import com.rest.assured.Helper;
import com.rest.assured.TestData;
import io.restassured.RestAssured;
import io.restassured.response.*;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.List;
import java.util.stream.Collectors;

public class FilmsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = Env.getBaseURL();
        RestAssured.basePath = "/films";
    }

    @Test(groups = "films", dataProvider = "filmsTitle", dataProviderClass = TestData.class,
            description = "Assert if specific film IDs match with film title name.")
    public void find_a_specific_film(String filmId, String filmTitle) {
        Response response = Helper.doGetRequest("/" + filmId);
        String title = response.jsonPath().getString("title");

        Reporter.log("film ID " + filmId + " with film name: " + filmTitle);

        Assert.assertEquals(title, filmTitle);
    }

    @Test(groups = "films", description = "Assert if more than three high score films returned.")
    public void films_contain_high_score_items() {
//        setAdminRole();
        Response response = Helper.doGetRequest("");
        List<String> scores = response.jsonPath().getList("rt_score");
        List<String> highScores = scores.stream().filter(score -> Integer.parseInt(score) >= Constants.HIGH_SCORE_LINE).collect(Collectors.toList());

        Reporter.log("Return more than three high score films.");

        Assert.assertTrue(highScores.size() > 3, "High score films not more than 5");
    }
}
