package get_request;

import base_url.BaseUrl;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02b extends BaseUrl {

     /*
   Given
       https://reqres.in/api/users/23
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
    And
       Status Line should be HTTP/1.1 404 Not Found
    And
      Server is "cloudflare"
    And
       Response body should be empty
     */
    @Test
    public void get01(){
        //1 Set the url
        spec.pathParams("first","api","second","users","third",23);
        //2 Set the Expected Data (put path post)

        //3 Send The Request and Get the Response

        Response response=given().spec(spec).when().get("/{first}/{second}/{third");
        response.prettyPrint();

        //Do Assertions
        assertEquals(404,response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertEquals("cloudflare", response.getHeader("Server"));
        assertEquals(2,response.asString().replaceAll("\\s","").length());


    }


}
