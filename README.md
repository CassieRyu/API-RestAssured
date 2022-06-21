## API TEST Framework
Combine with rest assured and testNG for simple api tests. 

### Feature
1. Support multi environments
2. Support run in docker
3. Beautiful Reporter
4. Suite, Data provider

### Run from docker
* run from prod env: 
```
docker-compose up test-prod
```
* run from local env: 
```
docker-compose up test-local
```
### Run from local
#### Build
```./gradlew build```

#### Test
* default env - prod: 
```
./gradlew clean test
```
* local env: 
```
./gradlew clean test -Denv=local
```

## Rest assured useful tips:
### Parameters
* Parameter in request URL
```aidl
given()
  .body(request.toString())
  .contentType("application/json")
  .pathParam("personId", id)
.when()
  .post(getEnvSpecificationEndPointsMap() + "/newPerson/{personId}")
.then()
```
* Parameter in finding response body
```aidl
String specificName = 
......
.then()
  .body()
  .extract()
  .jsonPath()
  .param("specificType", typeVariable)
  .getString("results.category.find {it.type == specificType}.name") //JSON
```
### JSON related
There're normally two ways to handle/assert response body:
* Assert in "given()"
```aidl
JSONObject request = new JSONObject();
request.put("name", "Jackson Wang");
given()
  .body(request.toString())
.when()
.then()
  .statusCode(200)
  .body("results.name", hasItem("Jackson Wang"));
```
* Get response and assert outside
Refer to examples in `/specs` file