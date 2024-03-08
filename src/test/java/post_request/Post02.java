package post_request;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.ResfullTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post02 extends RestfulBaseUrl {

    /*
    Given
    1) https://restful-booker.herokuapp.com/booking
    2) {
       "firstname"：“John"，
        "Lastname": "Doe"
        "totalprice": 11111,
        "depositpaid": true,
        "bookingdates": {
        "checkin": "2021-09-09",
        "checkout"： "2021-09-21"
         }
      }
      When
       I send POST Request to the Url
     Then
       Status code is 200
       And response body should be like
    {
    "bookingid": 3191,
    "booking": {
        "firstname": "John",
        "lastname": "Doe",
        "totalprice": 11111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2021-09-09",
            "checkout": "2021-09-21"
        }
    }
}
     */

    @Test
    public void post01() {
        //set the Url
        spec.pathParams("first", "booking");

        //set the expected Data
        ResfullTestData obj = new ResfullTestData();
        Map<String, String> bokkingDatesMap = obj.bookingDataMeth("2021-09-09", "2021-09-21");

        Map<String, Object> expectedData = obj.expectedDataMeth("John", "Doe", 11111, true, bokkingDatesMap);
        System.out.println("expectedData: " + expectedData);


        //send teh Request end Get The Response

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do Assert
        Map<String, Object> actualData = response.as(HashMap.class);//De-serialization
        System.out.println("expectedData: " + expectedData + "\n" + "actualData: " + actualData);
        assertEquals(expectedData.get("firstname"), ((Map) actualData.get("booking")).get("firstname"));
        //inner map a ulasmak icin Object data typ Map Casting yaptik
        assertEquals(expectedData.get("lastname"), ((Map) actualData.get("booking")).get("lastname"));
        assertEquals(expectedData.get("totalprice"), ((Double)((Map) actualData.get("booking")).get("totalprice")).intValue());
        assertEquals(expectedData.get("depositpaid"), ((Map) actualData.get("booking")).get("depositpaid"));
        assertEquals(bokkingDatesMap.get("checkin"), ((Map) ((Map) actualData.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(bokkingDatesMap.get("checkout"), ((Map) ((Map) actualData.get("booking")).get("bookingdates")).get("checkout"));

        assertEquals(200, response.statusCode());


    }


}
