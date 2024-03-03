package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get09 extends RestfulBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/1454
    When
        I send GET Request to the url
    Then
        Response body should be like that;
   {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "super bowls"
}

     */

    //1 Set the Url
    //2 Set the expected Data -->put post path
    //3 Send the Request and Get the Response
    //4 Do Assertion

    @Test
    public void get01() {
        //1 Set the Url
        spec.pathParams("first", "booking", "second",1454 );

        //2 Set the expected Data -->put post path
        Map<String, String> bookingDatesMap = new HashMap<>();
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2019-01-01");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Josh");
        expectedData.put("lastname", "Allen");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingDatesMap);
        expectedData.put("additionalneeds", "super bowls");

        System.out.println("expectedData: " + expectedData);


        //3 Send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        HashMap actualData=response.as(HashMap.class);
        System.out.println("actualData: "+actualData);


        assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        //assertEquals(expectedData.get("totalprice"),((Integer)(actualData.get("totalprice"))).intValue());
        assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(bookingDatesMap.get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));
        //Key value iliskis String ,Object oldugundan casting ile obj map e cevirdik
        assertEquals(bookingDatesMap.get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));
        assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));


    }


}
