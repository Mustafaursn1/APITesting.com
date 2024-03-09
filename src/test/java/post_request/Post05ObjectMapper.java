package post_request;

import base_url.JsonPlaceholderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;


import com.fasterxml.jackson.databind.ObjectMapper;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Post05ObjectMapper extends JsonPlaceholderBaseUrl {

    /*
     Given
     1) https://isonplaceholder.tupicode.com/todos
     2) {
        "userId": 55,
         "title": "Tidy your room",
          "completed": false
       I send POST Request to the Url
     Then
     Status code is 201
     And
     response body is like
            {
            "userid": 55,
            "title": "Tidy your room",
            "completed": false,
            "id": 201
            ｝
*/
    @Test
    public void post01() throws JsonProcessingException {
        //1 set the url
        spec.pathParam("first", "todos");
        //2 set the expected Data

        //3 send the psot request and get the Response
        String jsonInString = "{\n" +
                "            \"userid\": 55,\n" +
                "            \"title\": \"Tidy your room\",\n" +
                "            \"completed\": false,\n" +
                "            \"id\": 201\n" +
                "            }";

        Map<String, Object> expectedData = new ObjectMapper().readValue(jsonInString, HashMap.class);
        System.out.println("expectedData: " + expectedData);


        //Response response=given().spec(spec).contentType(ContentType.JSON).body().when().post();
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();


        //4 do Assertions

        HashMap actualData=new ObjectMapper().readValue(response.asString(),HashMap.class);
        System.out.println("actualData: "+actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.get("userid"),actualData.get("userid"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));



    }


}
