package get_request;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01b {

    /*
    Given
          https://reqres.in/api/users/3
    When
         user sends a Get Request to the URL
     Then
         HTTP Status Code should be 200

      And
          Content Type should be JSON

      And
         Stotus Line should be HTTP/1:1 200 OK
     */

    @Test
    public void get01(){
        //1 set the URL
        String url="https://reqres.in/api/users/3";
        Response response=given().when().get(url);

        response.prettyPrint();

        //ii) set the expected Data (beklenen datanin olusturulmasi -->post(),put(),patch())
        ////iv)Do Assertion(dogrulama yapmak )+
        response.then().statusCode(200).  //assertThat yazsak da yazmasak da assert yapar then() den dolayi
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");







    }



}
