package API.RestAssured;

import io.restassured.RestAssured;

public class MethodHelper {

    public void setupEnvDefaults() {
        RestAssured.baseURI = "https://ghibliapi.herokuapp.com";
        // RestAssured.port = 3000
        //RestAssured.basePath = "/"
    }
}
