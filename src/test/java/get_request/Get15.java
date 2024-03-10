package get_request;

import base_url.RestfulBaseUrl;
import org.junit.Test;

public class Get15 extends RestfulBaseUrl {
    /*
    Given
        https://restful-booker.herokuaoo.com/booking/22
    When
        I send Get Request to the URL
    Then
        Status code is 200
        {
        "firstname": "Guoqiang",
        "lastname":"Morante Briones",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates" :{
                       "checkin":"2018-01-01"
                       "checkout":"2019-01-01"
                        },
         "additionalneeds": "Breakfast"
         }
         */

    @Test
    public void get01(){
        //1 set the URL
        spec.pathParams("first","booking","second",22);

        //2 set the expected Data


        //send The Get request and GET the response



        //Do Assertions

    }


}
