package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class Get04b extends RestfulBaseUrl {
    /*

    Given
      https://restful-booker.herokuapp.com/booking?firstname=John&lastname=Smith-->bu data sürekli olarak güncellenecegi
        icin calsitirmadan önce postman araciligi ile assertion yapilip öyle Automation yapilmali
    When
     User sends get request to the URL
    Then
     Status code is 200
    And
     Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"

    */
    @Test
    public void get01(){
        //1 set the Url
        spec.pathParam("first","booking").queryParams("firstname","John","lastname","Smith");

        //2 set the expected Data

        // 3 Send the Request and Get the Response

        Response response=given().spec(spec).get("/{first}");
        response.prettyPrint();

        // 4 Do Assertion
        assertEquals(200,response.getStatusCode());
        assertTrue(response.asString().contains("bookingid"));





    }

}
