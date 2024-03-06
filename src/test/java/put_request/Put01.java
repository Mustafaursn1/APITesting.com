package put_request;

import base_url.JsonPlaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceholderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;


public class Put01 extends JsonPlaceholderBaseUrl {
    /*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
         "userid": 21,
          "title": "Wash the dishes",
          "completed": false
        }
    When
        I send PUT Request to the Url
    Then
       Status code is 200
    And response body is like
     {
      "userId": 21,
      "title": "Wosh the dishes",
      "completed": false
      }
     */


    @Test
    public void put01() {
        //set the url
        spec.pathParams("first", "todos", "second", 198);

        //send the expected data--
        JsonPlaceholderTestData obj = new JsonPlaceholderTestData();

        Map<String, Object> expectedData = obj.expectedDataMethod(21, "Wash the dishes", false);
        //send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).put("/{first}/{second}");
        response.prettyPrint();

        //do Assert
        Map<String, Object> actualData = response.as(HashMap.class);


        System.out.println("actual data:" + actualData + "\n" + "expectedData: " + expectedData);

        assertEquals(expectedData.get("completed"), actualData.get("completed"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("userId"), ((Double) actualData.get("userId")).intValue());
        assertEquals(200, response.statusCode());


    }


}
