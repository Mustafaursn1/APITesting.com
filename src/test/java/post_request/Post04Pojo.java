package post_request;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.BookingDatesPojo;
import pojo.BookingPojo;
import pojo.BookingResponseBodyPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post04Pojo extends RestfulBaseUrl {

    /*
    GIven
    1) https://restful-booker.herokuapp.com/booking
    2) {
       "firstname": "Ali ",
       "Lastname": "Can",
       "totalprice": 999,
       "depositpaid": true,
       "bookingdates": {
                      "checkin": "2024-09-21",
                       "checkout": "2024-12-21"
                       },
       "additionalneeds": "Breakfast"
       }
   When
      I send POST Request to the URL
   Then
      Status code is 200
   And
      Response body is like {
                           "bookingid": 16,
                            "booking" :{
                                      "firstname": "Ali",
                                       "Lastname": "Can",
                                       "totalprice": 999,
                                       "depositpaid": true,
                                       "bookingdates": {
                                                       "checkin": "2024-09-21",
                                                       "checkout": "2024-12-21"
                                                       },
                                       "additionalneeds": "Breakfast"
     */

    @Test
    public void post01(){

        //1 set the Url
        spec.pathParam("first","booking");
        //2 set the Expected Data;
        BookingDatesPojo bookingDate=new BookingDatesPojo("2024-09-21","2024-12-21");

        BookingPojo expectedData=new BookingPojo("Ali","Can",999,true,bookingDate,"Breakfast");


        System.out.println("expectedData:"+ expectedData);

        //3 send the post Requueust and GET the Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        BookingResponseBodyPojo actualData=response.as(BookingResponseBodyPojo.class);
        System.out.println("actualData: "+actualData);

        //4 Do Assertion
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getBooking().getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getBooking().getAdditionalneeds());

        assertEquals(bookingDate.getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDate.getCheckout(),actualData.getBooking().getBookingdates().getCheckout());





    }




}
