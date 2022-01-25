package src.SimpleTestAPI;

import java.util.*;
//import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import org.testng.annotations.*;
import org.testng.Assert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.core.CombinableMatcher;

public class SimpleTestAPI {

	 String payload = "{\"loanAppUuid\":\"b8096ec7-2150-405f-84f5-ae99864b3e96\",\"skipSideEffects\": \"true\" }";
     String payloadTwo = "{\"loanAppUuid\":\"b8096ec7-2150-405f-84f5-ae99864b3e97\",\"skipSideEffects\": \"true\" }";

	 public static Response doPostRequest() {
        RestAssured.defaultParser = Parser.JSON;
        String payload = "{\"loanAppUuid\":\"b8096ec7-2150-405f-84f5-ae99864b3e96\",\"skipSideEffects\": \"true\" }";
        return
            given()
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", "31b98526-7e02-11ec-90d6-0242ac120003")
                .header("Content-Type", "application/json")
                .body(payload)
                     .when().post("https://credapi.credify.tech/api/brfunnelorch/v2/resume/byLeadSecret")
                         .then()
                          .statusCode(200)
                          .contentType(ContentType.JSON).extract().response();
    }

	 @Test()
	 public void aFastTestOne() {
        Response response = doPostRequest();
        Map<String, String>  usernames = response.jsonPath().getMap("loanAppResumptionInfo");
         Assert.assertEquals(usernames.get("productType"), "PERSONAL_LOAN");
         }



    @Test()

	 public void aFastTestTwo() {
            given()
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", "31b98526-7e02-11ec-90d6-0242ac120003")
                .header("Content-Type:", "application/json")  // Placed error here Content-Type:
                    .body(payload)
                     .when().post("https://credapi.credify.tech/api/brfunnelorch/v2/resume/byLeadSecret")
                         .then()
                          .statusCode(500);
      }



     @Test()
	 public void aFastTestThree() {
            given()
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", "31b98526-7e02-11ec-90d6-0242ac120003")
                .header("Content-Type", "application/json")
                .body(payloadTwo)
                     .when().post("https://credapi.credify.tech/api/brfunnelorch/v2/resume/byLeadSecret")
                         .then()
                          .statusCode(404);
      }
}
