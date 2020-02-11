package com.rest.assured.configuration;

import static com.rest.assured.configuration.Env.getBaseURL;
import static io.restassured.RestAssured.given;

import com.google.common.collect.ImmutableMap;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Objects;

public class envSpecification {

  private static RequestSpecification adminRequestSpecification;

  private static void generateAdminRs() {
    if(Objects.isNull(adminRequestSpecification)) {
      Response adminLoginRes =
          given()
              .formParam("userName", "admin1")
              .formParam("password", "adminPass")
              .contentType("application/x-www-form-urlencoded")
              .when()
              .post(getBaseURL() + "/oauth/token")
              .then()
              .extract()
              .response();
      String adminTokenType = adminLoginRes.path("token_type");
      String adminAccessToken = adminLoginRes.path("access_token");
      String adminToken = adminTokenType + " " + adminAccessToken;
      // build header
      adminRequestSpecification = new RequestSpecBuilder().addHeaders(ImmutableMap.of("Authorization", adminToken)).build();
    }
  }
  public static void setAdminRole() {
    generateAdminRs();
    RestAssured.requestSpecification = adminRequestSpecification;
  }
}
