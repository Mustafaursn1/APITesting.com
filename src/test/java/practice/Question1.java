package practice;

import base_url.BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.PetRestTestData;
import utilities.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class Question1 extends BaseUrl {
    /*
     https://petstore.swagger.io/documantation adresini
kullanarak 'user' olusturan ve olusan bu user'i silen bir
otomasyon kodu yaziniz.
     */
    /*
     /*
    {
  "id": 0,
  "username": "string",
  "firstName": "string",
  "lastName": "string",
  "email": "string",
  "password": "string",
  "phone": "string",
  "userStatus": 0
}
     */


    @Test
    public void post01() {
        //1 set The url
        spec.pathParams("first", "user");
        PetRestTestData obj = new PetRestTestData();

        //set the expected Data
        String expectedData = obj.expectedDataInString(2, "Tim", "John", "Ceremy",
                "abcd_jkl@gmail.com", "234erdf_jgh", "0978596886", 1);
        Map<String, Object> expectedDataMap =
                ObjectMapperUtils.convertJsonToJava(expectedData, Map.class);
        System.out.println("expectedData: " + expectedDataMap);

        //Send the Post Request and Get the Response
        Response response1 = given().spec(spec).contentType("application/json").body(expectedDataMap).post("/{first}");
        response1.prettyPrint();

        System.out.println("statusCode:" + response1.statusCode());



    }

    @Test
    public void get01(){
        //set the url
        spec.pathParams("first", "user", "second", "Tim");

        //set the expected DATA

        //send the get request and get the responsse

        Response response2 = given().spec(spec).when().get("/{first}/{second}");
        response2.prettyPrint();





    }






}
