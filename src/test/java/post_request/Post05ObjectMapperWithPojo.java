package post_request;

import base_url.JsonPlaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.JsonPlaceHolderPojo;
import utilities.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post05ObjectMapperWithPojo extends JsonPlaceholderBaseUrl {

    /*
     Given
     1) https://isonplaceholder.tupicode.com/todos
     2) {
         "userid": 55,
         "title": "Tidy your room",
         "completed": false
        ｝
        I send POST Request to the Uri
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
    public void post01() {
        //1 set the Url
        spec.pathParam("first", "todos");

        //2 Set the expected Data

        JsonPlaceHolderPojo obj = new JsonPlaceHolderPojo(55, "Tidy your room", false, 201);
        System.out.println(obj);
        // 3 send the post request and Get the Response

        Response response = given().spec(spec).contentType(ContentType.JSON).body(obj).when().post("/{first}");
        response.prettyPrint();

        //Do Assertion
        JsonPlaceHolderPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), JsonPlaceHolderPojo.class);
        System.out.println("actualData: " + actualData);
        assertEquals(201, response.statusCode());
        assertEquals(obj.getUserId(), actualData.getUserId());
        assertEquals(obj.getCompleted(), actualData.getCompleted());
        assertEquals(obj.getTitle(), actualData.getTitle());



    }


}
