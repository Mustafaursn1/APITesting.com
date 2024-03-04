package post_request;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceholderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post01 extends JsonplaceholderBaseUrl {
    /*
   Given
     1) https://jsonplaceholder.typicode.com/todos
     2)
   When
      I send POST Request to the Url
    Then
       Status code is 201

      {
      "userId":55,
       "title":"Tidy your room",
       "completed": false
       }
    And
   response body is like
      {
     "userId": 55,
     "title": "Tidy your roon",
     "completed": false,
     "id": 201
     }
*/


    @Test
    public void post01() {
        //set the Url
        spec.pathParams("first", "todos");

        //send the expected data--

        JsonPlaceholderTestData obj = new JsonPlaceholderTestData();
        Map<String, Object> expectedData = obj.expectedDataMethod(55, "Tidy your roon", false);

        //send the Request and Get the Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //do Assertion

        Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println("actualData: "+actualData);

        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("userId"),((Double)actualData.get("userId")).intValue());
        assertEquals(201,response.getStatusCode()); n
        //!!!Json dan gelen data double olarak geldigi icin data typini degistirdik





    }


}
