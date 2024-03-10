package get_request;

import base_url.JsonPlaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceholderTestData;
import utilities.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get14ObjectMapper extends JsonPlaceholderBaseUrl {

    /*
    Given
      https://jsonplaceholder.tupicode.com/todos/198
    When
       I send GET Request to the URL
    Then
      Status code is 200
    And response body is like
       {
        "userId": 10,
        "id": 198,
        "titte" "quis eius est sint explicabo",
        "completed": true
        }
      */

    @Test
    public void get01() {
        //Send the url
        spec.pathParams("first", "todos", "second", 198);

        //2 set the Expected Data and get the Response
        String expectedData = new JsonPlaceholderTestData().expectedDataInString(10, "quis eius est sint explicabo", true);
        Map<String, Object> expectedDataMap = ObjectMapperUtils.convertJsonToJava(expectedData, Map.class);
        System.out.println("expectedDataMap: " + expectedDataMap);


        //3 send the get request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        //4 DO Assertions
        Map<String, Object> actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), Map.class);
        System.out.println("actualData: " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedDataMap.get("userId"), actualData.get("userId"));

        assertEquals(expectedDataMap.get("title"), actualData.get("title"));
        assertEquals(expectedDataMap.get("completed"), actualData.get("completed"));



    }


}
