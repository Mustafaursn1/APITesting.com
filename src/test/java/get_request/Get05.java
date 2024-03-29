package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get05 extends RestfulBaseUrl {

    /*
    Given  https://restful-booker.herokuapp.com/booking
    When User sends get request to the URL

    Then Status code is 200
    And  Among the data there should be someone whose firstnome is "Johhny" and lastname is "Dear"
     */


    @Test
    public void get01() {
        //https://restful-booker.herokuapp.com/booking?firstname=Josh&lastname=Allen   bu bilgi aktuelde degisiklik gösterebilir

        //1.Set the url
        spec.pathParam("first", "booking").queryParams("firstname", "Josh", "lastname", "Allen");

        //2.Set the expected data-

        //3.Send the Request AND Get the Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4 Do Assertion

        assertEquals(200, response.getStatusCode());
        assertTrue(response.asString().contains("bookingid"));


    }
}
