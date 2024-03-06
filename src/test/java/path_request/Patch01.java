package path_request;

import base_url.JsonPlaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceholderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Patch01  extends JsonPlaceholderBaseUrl {

    /*
    Given
       1) https://jsonplaceholder.tupicode.com/todos/198
       2) {
          "title": "Wash the dishes"
       When
          I send PATCH Request to the Url
       Then
          Status code is 200
          And response body is like {
                                     "userId": 10,
                                     "title": "Wash the dishes",
                                     "completed": true,
                                     "id": 198
         }
     */


    @Test
    public void patch01(){
        //set the Url
        spec.pathParams("first","todos","second",198);

        //set the expected Data

        JsonPlaceholderTestData obj=new JsonPlaceholderTestData();
        Map<String,Object> expectedData=obj.expectedDataMethod(null,"Wash the dishes",null);


        System.out.println("expectedData: "+expectedData);


        //send the Request and Get the Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).patch("/{first}/{second}");
        response.prettyPrint();

        //Do Assertions

        Map<String,Object> actualData=response.as(HashMap.class);
        System.out.println("actualData: "+actualData+"\n"+"actualData: "+actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("title"),actualData.get("title"));



    }


}
