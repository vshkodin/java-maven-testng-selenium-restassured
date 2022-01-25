package src.SimpleTestAPI;
//import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import org.testng.annotations.*;
import org.testng.Assert;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.core.CombinableMatcher;

public class SimpleTestAPI {
	 String payload = "{\"loanAppUuid\":\"b8096ec7-2150-405f-84f5-ae99864b3e96\",\"skipSideEffects\": \"true\" }";

	 @Test()
	 public void aFastTestOne() {

	 //RestAssured.baseURI ="https://credapi.credify.tech";
            //given().when().get("http://www.google.com").then().statusCode(200);
            given()
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", "31b98526-7e02-11ec-90d6-0242ac120003")
                .header("Content-Type", "application/json")
                    .body(payload)
                     .when().post("https://credapi.credify.tech/api/brfunnelorch/v2/resume/byLeadSecret")
                         .then()
                          .statusCode(200)
                          .body(
                                "loanAppUuid", Matchers.notNullValue()
            );
      }

      	 @Test()
	 public void aFastTestTwo() {
	 //RestAssured.baseURI ="https://credapi.credify.tech";
            //given().when().get("http://www.google.com").then().statusCode(200);
            given()
                .header("x-cf-source-id", "coding-challenge")
                .header("x-cf-corr-id", "31b98526-7e02-11ec-90d6-0242ac120003")
                .header("Content-Type:", "application/json")
                    .body(payload)
                     .when().post("https://credapi.credify.tech/api/brfunnelorch/v2/resume/byLeadSecret")
                         .then()
                          .statusCode(500);
      }
}
