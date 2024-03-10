package get_request;

import base_url.JsonPlaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.JsonPlaceHolderPojo;
import testData.JsonPlaceholderTestData;
import utilities.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;


public class Get14ObjectMapper_Pojo extends JsonPlaceholderBaseUrl {
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
    public void get01(){
        //1 set the Url
        spec.pathParams("first","todos","second",198);

        //set the expected Data

        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(10,"quis eius est sint explicabo",true,198);
        String expectedDataInString=new JsonPlaceholderTestData().expectedDataInString(10,"quis eius est sint explicabo",true);

        Map<String,Object> expectedDataMap= ObjectMapperUtils.convertJsonToJava(expectedDataInString,Map.class);
        System.out.println("expected DataMap:"+expectedDataMap+"\n"+"expectedData:"+expectedData);

        //send the get Requeest and Get the Response


        Response response=given().spec(spec).when().get("/{first}/{second}");

        //Do Assertion

        Map<String,Object> actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),Map.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedDataMap.get("userId"),actualData.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualData.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualData.get("completed"));




    }



}
