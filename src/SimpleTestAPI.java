package src.SimpleTestAPI;

import java.util.*;
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

     String payloadTrue = "{\"loanAppUuid\":\"b8096ec7-2150-405f-84f5-ae99864b3e96\",\"skipSideEffects\": \"true\" }";
     String payloadFalse = "{\"loanAppUuid\":\"b8096ec7-2150-405f-84f5-ae99864b3e97\",\"skipSideEffects\": \"true\" }";
     String baseUrl = "https://credapi.credify.tech";
     String endPoint = baseUrl + "/api/brfunnelorch/v2/resume/byLeadSecret";

     public Response doPostRequest(String payload, int statusCode ) {
        RestAssured.defaultParser = Parser.JSON;
        return
            given()
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", "31b98526-7e02-11ec-90d6-0242ac120003")
                .header("Content-Type", "application/json")
                .body(payload)
                     .when().post(endPoint)
                         .then()
                          .statusCode(statusCode)
                          .contentType(ContentType.JSON).extract().response();
    }

	 @Test()
	 public void apiTestloanAppUuidProvided() {
         Response response = doPostRequest(payloadTrue,200);
         Map<String, String>  usernames = response.jsonPath().getMap("loanAppResumptionInfo");
         Assert.assertEquals(usernames.get("productType"), "PERSONAL_LOAN");
      }


     @Test()
	 public void apiTestLoanAppUuidDoesNotExist() {
            Response response = doPostRequest(payloadFalse,404);
      }

     @Test()
	 public void apiTestNegativeScenario() {
            given().header("LOL","Lol").body(payloadTrue).when().post(endPoint).then().statusCode(500);
      }
}
