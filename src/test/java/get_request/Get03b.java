package get_request;

import base_url.BaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get03b extends BaseUrl {
    /*

    Given
         https://regres.in/api/users/2
    When
         User send GET Request to the URL
    Then
         HTTP Status Code should be 200
     And

        Response format should be "application/json"
      And

        "email" is "janet.weaver@reqres.in",
      And

        "first_nome" is "Janet"
      And
        "Last_name" is "Weaver"
      And

     "text" is "To keep ReqRes free, contributions towards server costs are apprecioted!"
     */

    @Test
    public void get01(){
        //1 set the Url
       spec.pathParams("first","api","second","users","third",2) ;
       //2 send the expected Data -->put() , path(), post()

        //3 send the request and Get the response
        Response response=given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        //4 do Assertion
        //HTTP Status Code should be 200
        response.then().assertThat().statusCode(200).contentType("application/json");






    }
}
