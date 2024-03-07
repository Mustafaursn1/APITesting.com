package get_request;

import base_url.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojo.GoRestDataPojo;
import pojo.GoRestMetaPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get13Pojo extends GoRestBaseUrl {

    /*
   Given
      https://gorest.co.in/public/v1/users/6752501
   When
     User send GET Request to the URL
   Then
      Status Code should be 200
   And
   Response body should be like
    {
    "meta": null,
    "data": {
        "id": 6752501,
        "name": "Fr. Nawal Marar",
        "email": "marar_nawal_fr@altenwerth.example",
        "gender": "male",
        "status": "active"
    }
}

     */

    @Test
    public void get01(){

        //set the url
        spec.pathParams("first","users","second","6752501");


        //set the expected Data
        GoRestDataPojo goRestDataPojo=new GoRestDataPojo(6752501,"Fr. Nawal Marar","marar_nawal_fr@altenwerth.example","male","active");
        GoRestMetaPojo expectedData=new GoRestMetaPojo(null,goRestDataPojo);
        System.out.println("expectedData: "+expectedData);

        //send the Request and Get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        GoRestMetaPojo actualData=response.as(GoRestMetaPojo.class);
        System.out.println("actualData: "+actualData);
        assertEquals(200,response.statusCode());
        assertEquals(goRestDataPojo.getName(),actualData.getData().getName());
        assertEquals(goRestDataPojo.getEmail(),actualData.getData().getEmail());
        assertEquals(goRestDataPojo.getGender(),actualData.getData().getGender());
        assertEquals(goRestDataPojo.getStatus(),actualData.getData().getStatus());
        assertEquals(expectedData.getMeta(),actualData.getMeta());








    }



}
