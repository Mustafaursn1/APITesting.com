package post_request;

import base_url.JsonPlaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.JsonPlacePojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post03Pojo  extends JsonPlaceholderBaseUrl {

    /*
    Given
        https://jsonplaceholder.typicode.com/todos
    {
      "userId": 55,
      "title": "Tidy your room",
      "completed": false
    }
   When
     I send POST Request to the Url
   Then
    Status code is 201
   And
    response body is like {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
   }
*/

    @Test
    public void post01(){
        //set the Url
        spec.pathParams("first","todos");
        //set the expected Datda
        JsonPlacePojo expectedData=new JsonPlacePojo(55,"Tidy your room",false,201);

        System.out.println("expectedData: "+expectedData.toString());//toString() olsa da olmasas da yazdirir.


        //send the request and Get the Response

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do Assertion

        JsonPlacePojo actualData=response.as(JsonPlacePojo.class);
        System.out.println("actualData: "+actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());






    }






}
