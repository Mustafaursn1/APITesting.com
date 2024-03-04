package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import testData.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get10 extends GoRestBaseUrl {

    /*
    Given
       https://gorest.co.in/public/v1/users/6752692
    When
       User send GET Request to the URL
    Then
       Status Code should be 200
    And
     Response body should be like
   {
    "meta": null,
    "data": {
        "id": 6752675,
        "name": "Bhudev Patel",
        "email": "bhudev_patel@treutel-bailey.example",
        "gender": "male",
        "status": "inactive"
    }
}
     */

    //1 Set the Url
    //2 Set the expected Data -->put post path
    //3 Send the Request and Get the Response
    //4 Do Assertion

    @Test
    public void get01() {

        //1 Set the Url

        spec.pathParams("first", "users", "second", 6752675);

        //set The expected Data

        GoRestTestData goRestTestData = new GoRestTestData();
        Map<String, String> dataKeyMap = goRestTestData.dataKeyMap("Bhudev Patel", "bhudev_patel@treutel-bailey.example", "male", "inactive");
        Map<String, Object> expectedDataMap = goRestTestData.expectedDataMeth(null, dataKeyMap);

        System.out.println("expected Data: " + expectedDataMap);


        //3 Send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do Assertion
        Map<String, Object> actualData = response.as(HashMap.class);


        assertEquals(expectedDataMap.get("meta"), actualData.get("meta"));
        assertEquals(dataKeyMap.get("name"), ((Map) actualData.get("data")).get("name"));
        assertEquals(dataKeyMap.get("email"), ((Map) actualData.get("data")).get("email"));
        assertEquals(dataKeyMap.get("gender"), ((Map) actualData.get("data")).get("gender"));
        assertEquals(dataKeyMap.get("status"), ((Map) actualData.get("data")).get("status"));
        assertEquals(200,response.getStatusCode());


    }

}
