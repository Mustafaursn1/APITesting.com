package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojo.BookingDatesPojo;
import pojo.BookingPojo;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class OjectMapperPojo extends RestfulBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/1385
    When
        I send Get Request to the URL
    Then
        Status code is 200
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

    @Test
    public void get01() {
        //1 set the URL
        spec.pathParams("first", "booking", "second", 1385);

        //2 set the expected Data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Josh", "Allen", 111, true, bookingDatesPojo, "super bowls");


        //send The Get request and GET the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertions
        BookingPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), BookingPojo.class);
        //Hard Assertions
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBookingdates().getCheckout());

        assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());

        //soft Assertion
        //1 step
        SoftAssert softAssert = new SoftAssert();

        //2 step
        softAssert.assertEquals(actualData.getFirstname(), expectedData.getFirstname(),"firstname is not equal");
        softAssert.assertEquals(actualData.getLastname(), expectedData.getLastname());
        softAssert.assertEquals(actualData.getDepositpaid(), expectedData.getDepositpaid());
        softAssert.assertEquals(actualData.getTotalprice(), expectedData.getTotalprice());
        softAssert.assertEquals(actualData.getAdditionalneeds(), expectedData.getAdditionalneeds());

        softAssert.assertEquals(actualData.getBookingdates().getCheckin(), bookingDatesPojo.getCheckin());
        softAssert.assertEquals(actualData.getBookingdates().getCheckout(), bookingDatesPojo.getCheckout());


        //3 step
        softAssert.assertAll();


    }


}
