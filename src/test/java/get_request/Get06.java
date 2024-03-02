package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Get06 extends RestfulBaseUrl {

    /*
    Given
      https://restful-booker.herokuapp.com/booking/2476
    When
      User send a GET request to the URL
    Then
      HTTP Status Code should be 200
     And
       Response content type is "application/json"
     And
    Response body should be like;
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
    public void get01() {
        //set the Url
        spec.pathParams("first", "booking", "second", "54");
        //ser The Expected Date(put ,post patch) -->there is any request
        //3.Send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //Do Assert

        //1.yol

        response.then().
                assertThat().statusCode(200).
                contentType(ContentType.JSON).body("firstname", equalTo("John"),
                        "lastname", equalTo("Smith"),
                        "totalprice", equalTo(111),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01"),
                        "additionalneeds", equalTo("Breakfast")
                );


        //2.yol Jsonpath class kullanimi

        JsonPath json=response.jsonPath();
        assertEquals("John",json.getString("firstname"));
        assertEquals("Smith",json.getString("lastname"));
        assertEquals("111",json.getString("totalprice"));
        assertEquals(true,json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("Breakfast",json.getString("additionalneeds"));
        System.out.println("2.yol test gecti");




    }

    @Test
    public void get02(){

        //3.yol-->softAsert Class 3 adimda kullanilir


        //set the Url
        spec.pathParams("first", "booking", "second", "54");
        //set The Expected Date(put ,post patch) -->there is any request
        //3.Send the Request and Get the Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //Do Assert

        JsonPath json=response.jsonPath();

        //i Creat object
        SoftAssert softAssert=new SoftAssert();

        //ii Do Assertion
        softAssert.assertEquals(json.getString("firstname"),"John","Firstname is falsh");
        softAssert.assertEquals(json.getString("lastname"),"Smith","Lastname is falsh");
        softAssert.assertEquals(json.getString("totalpprice"),111,"Totalprice is falsh");
        softAssert.assertEquals(json.getBoolean("depositpaid"),true,"Depositpaid is falsh");
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01","Date of Checkin  is falsh");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01","Date of Checkout is falsh");
        softAssert.assertEquals(json.getString("additionalneeds"),"Breakfast","additionalneeds is falsh");
       //iii softAsert.assertAll() eger kullanmazsak fail olsa bile pass görünür
        softAssert.assertAll();





    }


}
