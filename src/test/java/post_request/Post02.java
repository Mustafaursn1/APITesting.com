package post_request;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.ResfullTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Post02  extends RestfulBaseUrl {

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
   public void post01(){
        //set the Url
        spec.pathParams("first","booking");

        //set the expected Data
        ResfullTestData obj=new ResfullTestData();
        Map<String,String> checkinData= obj.innerData("2021-09-09","2021-09-21");

        Map<String,Object> expectedData=obj.expectedDataMeth("John","Doe",11111,true,checkinData);
        System.out.println("expectedData: "+expectedData);


        //send teh Request end Get The Response

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{first}");
        response.prettyPrint();

        //Do Assert
        Map<String,Object> actualData=response.as(HashMap.class);

        System.out.println("expectedData: "+expectedData+"\n"+"actualData: "+actualData);




    }



}
