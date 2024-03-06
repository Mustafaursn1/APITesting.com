package get_request;

import base_url.RestfulBaseUrl;
import org.junit.Test;

public class Get12 extends RestfulBaseUrl {

    /*
    Given
       https://restful-booker.herokuapp.com/booking/18
   When
      I send GET Request to the URL
   Then
     Status code is 200
   And
     Response body is like:
     {
    "firstname": "John",
    "lastname": "Smith",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
*/


    @Test
    public void get12Pojo(){

        //set the Url
        spec.pathParams("first","booking","second",18);

        //set the expected Data;


        //Send the Request and Get the Response

        //Do Assertions



    }






}