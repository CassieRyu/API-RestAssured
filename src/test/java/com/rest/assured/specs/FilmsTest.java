package com.rest.assured.specs;

import com.rest.assured.Data;
import com.rest.assured.Env;
import com.rest.assured.Helper;
import io.restassured.RestAssured;
import io.restassured.response.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.stream.Collectors;

public class FilmsTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = Env.getBaseURL();
        RestAssured.basePath = "/films";
    }

    @Test(groups = "films")
    public void find_a_specific_film() {
        String filmId = "58611129-2dbc-4a81-a72f-77ddfc1b1b49";
        String filmTitle = "My Neighbor Totoro";
        Response response = Helper.doGetRequest("/" + filmId);

        String title = response.jsonPath().getString("title");
        Assert.assertEquals(title, filmTitle);
    }

    @Test(groups = "films")
    public void films_contain_high_score_items() {
        Response response = Helper.doGetRequest("");

        List<String> scores = response.jsonPath().getList("rt_score");
        List<String> highScores = scores.stream().filter(score -> Integer.parseInt(score) >= Data.HIGH_SCORE_LIEN).collect(Collectors.toList());

        Assert.assertTrue(highScores.size() > 5, "High score films not more than 5");
    }
}
